/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers.dashboards;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.helpers.DashboardControlerHelper;

/**
 *
 * @author Quentin
 */
@WebServlet(name = "DashboardServlet", urlPatterns = {"/auth/dashboard"})
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dashboardURL = "";
        // retrieve user session
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");

        DashboardControlerHelper dashControlerHelper = new DashboardControlerHelper();
        try {
            dashboardURL = dashControlerHelper.getDashboardFromUserOccupation(u);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(u.getOccupation().equals("student")){
            
            // check if existing registration in db
            String addRegistrationFormURL = "/auth/addRegistrationForm";
            String addRegistrationFormText= "Registration Form not submitted yet!";
            request.setAttribute("studentRegistrationFormURL", addRegistrationFormURL);
            request.setAttribute("studentRegistrationFormText", addRegistrationFormText);
            // else display link
            
        }
        
        request.getRequestDispatcher(dashboardURL).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("").forward(request, response);
        
        
        
    }

}
