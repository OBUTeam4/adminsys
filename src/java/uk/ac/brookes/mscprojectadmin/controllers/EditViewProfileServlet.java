/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import uk.ac.brookes.mscprojectadmin.helpers.ProfileControlerHelper;
import uk.ac.brookes.mscprojectadmin.helpers.RegisterControlerHelper;

/**
 *
 * @author Quentin
 */
@WebServlet(name = "EditViewProfileServlet", urlPatterns = {"/auth/profile/"})
public class EditViewProfileServlet extends HttpServlet {
    
    private String profileURL = "";

    //private ProfileControlerHelper profileControlerHelper;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // recuperation phone Number depuis la session
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        
        ProfileControlerHelper profilControlerHelper = new ProfileControlerHelper();
        try {
            profileURL = profilControlerHelper.getProfilePageFromUserOccupation(u);
        } catch (SQLException ex) {
            Logger.getLogger(EditViewProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // display infos
        request.setAttribute("lastname", u.getlName());
        request.setAttribute("firstname", u.getfName());
        request.setAttribute("email", u.getEmail());
        request.setAttribute("IdNumber", u.getUserId());
        request.setAttribute("occupation", u.getOccupation());

        // display courseCode/Mode/title if user is a student
        if (u.getOccupation().equals("student")) {
            request.setAttribute("courseCode", u.getCourseCode());
            request.setAttribute("courseMode", u.getCourseMode());
            request.setAttribute("courseTitle", u.getCourseTitle());
        }

        // frwd req and resp
        request.getRequestDispatcher(profileURL).forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String result;
        Boolean updateResult = false;
        Map<String, String> errors = new HashMap<>();

        // retrieve user session
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        String currentOccupation = u.getOccupation();

        // retrieve all inputs
        String occupation = request.getParameter("occupationChange").trim();
        String password = request.getParameter("password").trim();
        String confirm = request.getParameter("confirm").trim();
        
        String courseCode = "";
        String courseTitle = "";
        String courseMode = "";

        // inputs validations
        ProfileControlerHelper profilControlerHelper = new ProfileControlerHelper();
        
        if (u.getOccupation().equals("student")) {
            courseCode = request.getParameter("courseCode").trim();
            courseTitle = request.getParameter("courseTitle").trim();
            courseMode = request.getParameter("courseMode").trim();
            
            errors = profilControlerHelper.validateProfileDetailsStudent(currentOccupation, occupation, courseTitle, courseCode, courseMode, password, confirm);
        } else {
            errors = profilControlerHelper.validateProfileDetailsStaff(currentOccupation, occupation, password, confirm);
        }

        // no errors
        if (errors.isEmpty()) {
            try {

                // update user
                u.setPassword(password);
                u.setCourseMode(courseMode);
                u.setCourseCode(courseCode);
                u.setCourseTitle(courseTitle);
                u.setOccupation(occupation);

                // update db
                updateResult = profilControlerHelper.updateUser(u, currentOccupation);

                // update session
                request.getSession().setAttribute("user", u);
                System.out.println("Update status : " + updateResult);
                
                response.sendRedirect(request.getContextPath() + "/auth/dashboard");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            result = "Update fail...";

            // show errors
            request.setAttribute("errors", errors);
            request.setAttribute("result", result);

            // stay on same page
            // this.getServletContext().getRequestDispatcher("/auth/profile/").forward(request, response);
            // redirection
            try {
                profileURL = profilControlerHelper.getProfilePageFromUserOccupation(u);
            } catch (SQLException ex) {
                Logger.getLogger(EditViewProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            // frwd req and resp
            //request.getRequestDispatcher(profileURL).forward(request, response);
            doGet(request, response);
        }
        
    }
    
}
