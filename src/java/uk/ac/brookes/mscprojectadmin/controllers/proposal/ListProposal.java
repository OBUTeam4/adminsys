/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers.proposal;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "listProposal", urlPatterns = {"/auth/listProposal"})
public class ListProposal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ListsControlerHelper listsControlerHelper = new ListsControlerHelper();
        String supervisorId = "";
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        supervisorId = u.getUserId();
        String waitingStatus = "Pending...";
        String waitingFeedbacks = "/";

        request.setAttribute("waitings", listsControlerHelper.getProposalForSupervisor(supervisorId));
        request.setAttribute("reviewed", listsControlerHelper.getProposalReviewedBySupervisor(supervisorId));

        this.getServletContext().getRequestDispatcher("/auth/lists/proposalList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
