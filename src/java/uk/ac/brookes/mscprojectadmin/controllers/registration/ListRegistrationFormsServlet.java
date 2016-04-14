/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.helpers.ListsControlerHelper;

/**
 *
 * @author Quentin
 */
@WebServlet(name = "ListRegistrationFormsServlet", urlPatterns = {"/auth/listRegistrationForms"})
public class ListRegistrationFormsServlet extends HttpServlet {

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
        ListsControlerHelper listsControlerHelper = new ListsControlerHelper();
        String userId = "";
        String nextPage = "";
        // retrieve user ID from session
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        userId = u.getUserId();
        String waitingStatus = "Pending...";
        String waitingFeedbacks = "/";

        // manage display function of user occupation
        if (u.getOccupation().equals("supervisor")) {
            // retrieve and display projects + student infos + registration forms + approval status
            request.setAttribute("waitings", listsControlerHelper.getSubmittedRegFormsForSupervisor(userId));
            request.setAttribute("reviewed", listsControlerHelper.getReviewedRegFormsForSupervisor(userId));
            request.setAttribute("waitingStatus", waitingStatus);
            request.setAttribute("waitingFeedbacks", waitingFeedbacks);
            // System.out.println(listsControlerHelper.getSubmittedRegistrationForms());

            nextPage = "/auth/lists/registrationFormsListSupervisor.jsp";

        } else if (u.getOccupation().equals("module leader")) {
            request.setAttribute("waitings", listsControlerHelper.getSubmittedRegFormsForML(userId));
            request.setAttribute("reviewed", listsControlerHelper.getReviewedRegFormsForML(userId));
            request.setAttribute("waitingStatus", waitingStatus);
            request.setAttribute("waitingFeedbacks", waitingFeedbacks);
            // TO DO 
            nextPage = "/auth/lists/registrationFormsListML.jsp";
        } else {

            response.sendRedirect(request.getContextPath() + "/auth/dashboard");
        }

        // Module leader and Supervisor does not see the same page:
        this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
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

    }

}
