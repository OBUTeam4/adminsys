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
import uk.ac.brookes.mscprojectadmin.helpers.ProposalControlerHelper;

/**
 *
 * @author Quentin
 */
@WebServlet(name = "ViewProposalServlet", urlPatterns = {"/auth/ViewProposal"})
public class ViewProposalServlet extends HttpServlet {

    private int projectId;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // retrieve registration form id from URL.
        this.projectId = Integer.parseInt(request.getParameter("id"));

        ProposalControlerHelper proposalControlerHelper = new ProposalControlerHelper();
        //proposalControlerHelper.
        
        this.getServletContext().getRequestDispatcher("/auth/forms/proposalAssessment.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
