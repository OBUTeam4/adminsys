/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.helpers.LoginControlerHelper;

/**
 *
 * @author oussamak
 */
public class LoginServlet extends HttpServlet {

    LoginControlerHelper lch;
    User user;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Boolean valid = false; // Flag for data validation, false means username or passowrd or both of them is empty
        Boolean registered = false; // Flag for user existence, false means user dosen't exist in the system
        String nextPage = "/Login.jsp"; //Url of next page to be displayed 
        lch = new LoginControlerHelper();
        user = new User(request.getParameter("username"),request.getParameter("password"));
        valid = lch.validateLoginDetails(user);
        if(valid){
            registered = lch.isRegistered(user);
            
            if(registered){ // Login successful
                nextPage = lch.dashboardURL(user);
                request.getSession().setAttribute("user", user);
            }
            else {
                request.setAttribute("notRegistered", "Your login details are both incorrect or you're not registered yet");
            }
        }
        else{
            request.setAttribute("notValid", "Your username or password is incorrect.");
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
