package uk.ac.brookes.mscprojectadmin.controllers;

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
import uk.ac.brookes.mscprojectadmin.helpers.ProfileControlerHelper;

@WebServlet(name = "EditViewProfileServlet", urlPatterns = {"/auth/profile"})
public class EditViewProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String profileURL = "";
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
        request.setAttribute("lastname", u.getLastName());
        request.setAttribute("firstname", u.getFirstName());
        request.setAttribute("email", u.getEmail());
        request.setAttribute("IdNumber", u.getIdNumber());
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

        this.getServletContext().getRequestDispatcher("/jsp/auth/profile.jsp").forward(request, response);
    }

}
