/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.dao.UserDAO;
import uk.ac.brookes.mscprojectadmin.helpers.LoginControlerHelper;

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
        request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // inputs validation 
        String result;
        String alert;
        Map<String, String> errors = new HashMap<>();

        String firstname = request.getParameter("firstname").trim();
        String lastname = request.getParameter("lastname").trim();
        String emailAddress = request.getParameter("email").trim();
        String idNumber = request.getParameter("idNumber").trim();
        String password = request.getParameter("password").trim();
        String confirm = request.getParameter("confirm").trim();

        try {
            checkEmail(emailAddress);
        } catch (Exception e) {
            errors.put("email", e.getMessage());
        }

        try {
            checkPasswordAndConfirm(password, confirm);
        } catch (Exception e) {
            errors.put("password", e.getMessage());
        }

        try {
            checkFname(firstname);
        } catch (Exception e) {
            errors.put("fname", e.getMessage());
        }

        try {
            checkLname(lastname);
        } catch (Exception e) {
            errors.put("lname", e.getMessage());
        }

        try {
            checkIDNumber(idNumber);
        } catch (Exception e) {
            errors.put("idNumber", e.getMessage());
        }

        // inputs are all correct
        if (errors.isEmpty()) {

                user.setFirstName(firstname);
                user.setLastName(lastname);
                user.setEmail(emailAddress);
                user.setPassword(password);
                user.setIdNumber(idNumber);
                
            // searching existing ID number in DB
            if ((lch.isRegistered(user)) == true) {

                alert = "ID number already in use!";
                request.setAttribute("alert", alert);

                this.getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(request, response);
            } else {
                //User user = new User();
               // UserDAO.addUser(user);
                
                // session storage
                HttpSession session = request.getSession();
                session.setAttribute("idNumber", idNumber);
                //session.setAttribute("isAdmin", "false");

                response.sendRedirect(request.getContextPath() + "/index");
                //response.sendRedirect(request.getContextPath() + "/auth/contact");
            }

        } else {
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);
            request.setAttribute("email", emailAddress);
            request.setAttribute("idNumber", idNumber);

            result = "Registering fail...";

            // on stocke les messages d'erreurs et leur resultats dans l'obj req
            request.setAttribute("errors", errors);
            request.setAttribute("result", result);

            this.getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(request, response);
        }

    }

    private void checkEmail(String email) throws Exception {
        if (email != null && email.trim().length() != 0) {
            if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Enter a valid email!");
            }
        } else {
            throw new Exception("Enter an email address.");
        }
    }

    private void checkPasswordAndConfirm(String password, String confirm) throws Exception {
        if (password != null && password.trim().length() != 0 && confirm != null && confirm.trim().length() != 0) {
            if (!password.equals(confirm)) {
                throw new Exception("Password and confirm are differ!");
            } else if (password.trim().length() < 3) {
                throw new Exception("Password cannot be inferior to 3 chars.");
            }
        } else {
            throw new Exception("Enter a password and a confirm.");
        }
    }
    
    private void checkFname(String fname) throws Exception {
        if (fname != null && fname.trim().length() != 0) {
            if (fname.trim().length() < 3) {
                throw new Exception("Firstname cannot be inferior to 3 chars.");
            }
        } else {
            throw new Exception("Enter a firstname.");
        }
    }

    private void checkLname(String lname) throws Exception {
        if (lname != null && lname.trim().length() != 0) {
            if (lname.trim().length() < 3) {
                throw new Exception("Lastname cannot be inferior to 3 chars.");
            }
        } else {
            throw new Exception("Enter a lastname.");
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


}
