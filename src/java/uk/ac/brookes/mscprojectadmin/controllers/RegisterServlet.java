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
import javax.servlet.http.HttpSession;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.dao.UserDAO;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/common/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // inputs validation 
        String result, nextPage;
        nextPage = null;
        String alert;
        Map<String, String> errors = new HashMap<>();
        RegisterControlerHelper registerControlerHelper = new RegisterControlerHelper();

        String firstname = request.getParameter("firstname").trim();
        String lastname = request.getParameter("lastname").trim();
        String emailAddress = request.getParameter("email").trim();
        String idNumber = request.getParameter("idNumber").trim();
        String password = request.getParameter("password").trim();
        String confirm = request.getParameter("confirm").trim();
        String courseCode = request.getParameter("courseCode").trim();
        String courseTitle = request.getParameter("courseTitle").trim();
        String courseMode = request.getParameter("courseMode").trim();

        errors = registerControlerHelper.validateRegisterDetails(idNumber, emailAddress, firstname, lastname, password, confirm);
        // inputs are all correct
        if (errors.isEmpty()) {
            try {
                User user = new User();
                user.setFirstName(firstname);
                user.setLastName(lastname);
                user.setEmail(emailAddress);
                user.setPassword(password);
                user.setIdNumber(idNumber);
                user.setOccupation("student");
                user.setCourseCode(courseCode);
                user.setCourseMode(courseMode);
                user.setCourseTitle(courseTitle);

                // searching existing ID number in DB
                if (registerControlerHelper.isRegistered(user)) {
                    System.out.println("Here");
                    alert = "ID number already in use!";
                    request.setAttribute("alert", alert);
                    this.getServletContext().getRequestDispatcher("/common/register.jsp").forward(request, response);
                } else {
                    // add user to DB
                    registerControlerHelper.addUser(user);

                    // session storage
                    request.getSession().setAttribute("user", user);

                    // redirection
                    //nextPage = "/dashboards" + lch.dashboardURL(user);
                    this.getServletContext().getRequestDispatcher("/dashboards/studdash.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);
            request.setAttribute("email", emailAddress);
            request.setAttribute("idNumber", idNumber);

            result = "Registering fail...";

            request.setAttribute("errors", errors);
            request.setAttribute("result", result);

            this.getServletContext().getRequestDispatcher("/common/register.jsp").forward(request, response);
        }
    }
}
