/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.brookes.mscprojectadmin.helpers.LoginControlerHelper;

/**
 *
 * @author Quentin
 */
@WebServlet(name = "LoginServletQ", urlPatterns = {"/login"})
public class LoginServletQ extends HttpServlet {

    private LoginControlerHelper lch;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // inputs validation
        Map<String, String> errors = new HashMap<String, String>();
        String result;

        String idNumber = request.getParameter("idNumber").trim();
        String password = request.getParameter("password").trim();

        try {
            checkIDNumber(idNumber);
        } catch (Exception e) {
            errors.put("idNumber", e.getMessage());
        }

        try {
            checkPassword(password);
        } catch (Exception e) {
            errors.put("password", e.getMessage());
        }

        if (errors.isEmpty()) {
            // verification of existing user
            if (true == true) {
                // put IDNumber into session
                HttpSession session = request.getSession();
                session.setAttribute("idNumber", idNumber);
                
                // admin
                //User u = userService.findUserByPhoneNumber(phone);
                //session.setAttribute("isAdmin", u.getIsAdmin());

                // redir home
                response.sendRedirect(request.getContextPath() + "/");
            } else {
                result = "Log in error: ID number or password invalid!";
                request.setAttribute("errors", errors);
                request.setAttribute("result", result);

                request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("idNumber", idNumber);
            
            result = "Log in failure";

            request.setAttribute("errors", errors);
            request.setAttribute("result", result);

            this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
    
    private void checkIDNumber(String IDnumber) throws Exception {
        if (IDnumber != null && IDnumber.trim().length() != 0) {
            // regex digits
            if (!IDnumber.matches("-?\\d+(\\.\\d+)?")) {
                throw new Exception("ID number error.");
            }
        } else {
            throw new Exception("ID number required.");
        }
    }

    private void checkPassword(String password) throws Exception {
        if (password != null && password.trim().length() != 0) {
            if (password.trim().length() < 3) {
                throw new Exception("The password need to have at least 3 characters");
            }
        } else {
            throw new Exception("Enter the password");
        }
    }

    

}
