/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.helpers.LoginControlerHelper;
import uk.ac.brookes.mscprojectadmin.helpers.RegisterControlerHelper;

/**
 *
 * @author Quentin
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private User user;
    private LoginControlerHelper lch;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/common/register.jsp").forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String result, nextPage;
        nextPage = null;
        String alert;
        Map<String, String> errors = new HashMap<>();
        RegisterControlerHelper registerControlerHelper = new RegisterControlerHelper();

        // retrieve all inputs from register.jsp
        String firstname = request.getParameter("firstname").trim();
        String lastname = request.getParameter("lastname").trim();
        String emailAddress = request.getParameter("email").trim();
        String userId = request.getParameter("userId").trim();
        String password = request.getParameter("password").trim();
        String confirm = request.getParameter("confirm").trim();
        String courseCode = request.getParameter("courseCode").trim();
        String courseTitle = request.getParameter("courseTitle").trim();
        String courseMode = request.getParameter("courseMode").trim();

        // inputs validation 
        errors = registerControlerHelper.validateRegisterDetails(userId, emailAddress, firstname, lastname, courseTitle, courseCode, courseMode, password, confirm);
     
        // inputs are all correct
        if (errors.isEmpty()) {
            try {
                User user = new User();
                user.setfName(firstname);
                user.setlName(lastname);
                user.setEmail(emailAddress);
                user.setPassword(password);
                user.setUserId(userId);
                user.setOccupation("student");
                user.setCourseCode(courseCode);
                user.setCourseMode(courseMode);
                user.setCourseTitle(courseTitle);

                // searching existing ID number in DB
                if (registerControlerHelper.isRegistered(user)) {
                    System.out.println("Here");
                    errors.put("userId", "User ID already in use!");
                    request.setAttribute("errors", errors);
                    this.getServletContext().getRequestDispatcher("/common/register.jsp").forward(request, response);
                } else {
                    // add user to DB
                    registerControlerHelper.addUser(user);

                    // session storage
                    request.getSession().setAttribute("user", user);

                    // redirection
                    response.sendRedirect(request.getContextPath() + "/auth/dashboard");
                    //this.getServletContext().getRequestDispatcher("/auth/dashboard/").forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            //request.setAttribute("firstname", firstname);
            //request.setAttribute("lastname", lastname);
            //request.setAttribute("email", emailAddress);
            //request.setAttribute("idNumber", idNumber);

            result = "Registering fail...";

            // show errors
            request.setAttribute("errors", errors);
            request.setAttribute("result", result);

            // stay on same page
            this.getServletContext().getRequestDispatcher("/common/register.jsp").forward(request, response);
        }
    }
}
