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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.helpers.LoginControlerHelper;

/**
 *
 * @author oussamak
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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

        request.getRequestDispatcher("/common/login.jsp").forward(request, response);
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

        //System.out.println("1");
        Boolean registered = false; // Flag for user existence, false means user dosen't exist in the system
        String nextPage = null; //Url of next page to be displayed 
        LoginControlerHelper lch = new LoginControlerHelper();
        Map<String, String> errors = new HashMap<String, String>();
        //System.out.println("2");

        String userId = request.getParameter("userId").trim();
        String password = request.getParameter("password").trim();
        //user = new User(request.getParameter("username"),request.getParameter("password"));
        errors = lch.validateLoginDetails(userId, password);
        //System.out.println("3");
        if (errors.isEmpty()) {
            try {
                User user = new User();
                user.setUserId(userId);
                user.setPassword(password);
                registered = lch.isRegistered(user);
                //System.out.println("3");
                if (registered) { // Login successful
                    //nextPage = "/auth/dashboards" + lch.dashboardURL(user);
                    
                    // nextPage is dashboard servlet
                    nextPage = "/auth/dashboard";
                    request.getSession().setAttribute("user", user);
                    System.out.println("Login Successful");
                } else {
                    errors.put("result", "Your User ID or password is incorrect, or you're not registered yet, please try again.");
                    request.setAttribute("errors", errors);
                    //nextPage = "/common/login.jsp";
                    // nextPage is login servlet
                    nextPage = "/common/login.jsp";
                    System.out.println("5");
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        } else {
            //result = "Your username or password is not valid.";
            //request.setAttribute("result", result);
            request.setAttribute("errors", errors);
            nextPage = "/common/login.jsp";
            System.out.println("6");
        }
        

        this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
       //RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
       //dispatcher.forward(request, response);
    }

}
