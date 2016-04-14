/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers.proposal;

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
import uk.ac.brookes.mscprojectadmin.beans.Approval;
import uk.ac.brookes.mscprojectadmin.beans.Criteria;
import uk.ac.brookes.mscprojectadmin.beans.Proposal;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.helpers.ProposalControlerHelper;

/**
 *
 * @author Quentin
 */
@WebServlet(name = "AddProposalServlet", urlPatterns = {"/auth/addProposalServlet"})
public class AddProposalServlet extends HttpServlet {

    private int projectId;

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

        // retrieve registration form id from URL.
        this.projectId = Integer.parseInt(request.getParameter("id"));

        this.getServletContext().getRequestDispatcher("/auth/forms/proposalAssessment.jsp").forward(request, response);
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

        ProposalControlerHelper proposalControlerHelper = new ProposalControlerHelper();

        String supervisorId = "";
        // retrieve user session
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");

        if (u.getOccupation().equals("supervisor")) {
            supervisorId = u.getUserId();

            String introMarks = request.getParameter("intro_marks").trim();
            String introComments = request.getParameter("intro_comments").trim();

            String methodologyMarks = request.getParameter("methodology_marks").trim();
            String methodologyComments = request.getParameter("methodology_comments").trim();

            String projectMarks = request.getParameter("project_marks").trim();
            String projectComments = request.getParameter("project_comments").trim();

            String progressMarks = request.getParameter("progress_marks").trim();
            String progressComments = request.getParameter("progress_comments").trim();

            String writtenMarks = request.getParameter("written_marks").trim();
            String writtenComments = request.getParameter("written_comments").trim();

            String proposalTotal = request.getParameter("proposalTotal").trim();
            String proposalComments = request.getParameter("proposalComments").trim();

            Proposal proposal = new Proposal();
            proposal.setComments(proposalComments);
            proposal.setMark(proposalTotal);
            proposal.setTotal(proposalTotal);
            proposal.setSupervisorId(supervisorId);
            //proposal.setApprovalId(approvalId);

            Approval supervisorApproval = new Approval();
            supervisorApproval.setUserId(supervisorId);

            Criteria introCriteria = new Criteria();
            Criteria methodologyCriteria = new Criteria();
            Criteria progressCriteria = new Criteria();
            Criteria writtenCriteria = new Criteria();
            Criteria projectCriteria = new Criteria();

            introCriteria.setComments(introComments);
            introCriteria.setMarks(introMarks);
            introCriteria.setDescription("");
            introCriteria.setAgreedComments("");

            methodologyCriteria.setComments(methodologyComments);
            methodologyCriteria.setMarks(methodologyMarks);
            methodologyCriteria.setAgreedComments("");
            methodologyCriteria.setDescription("");

            writtenCriteria.setComments(writtenComments);
            writtenCriteria.setMarks(writtenMarks);
            writtenCriteria.setAgreedComments("");
            writtenCriteria.setDescription("");

            projectCriteria.setComments(projectComments);
            projectCriteria.setMarks(projectMarks);
            projectCriteria.setAgreedComments("");
            projectCriteria.setDescription("");

            progressCriteria.setComments(progressComments);
            progressCriteria.setMarks(progressMarks);
            progressCriteria.setAgreedComments("");
            progressCriteria.setDescription("");

            try {
                int proposalId = proposalControlerHelper.addProposal(proposal, introCriteria, methodologyCriteria, progressCriteria, writtenCriteria, projectCriteria, supervisorApproval);
                proposalControlerHelper.addProposalAssessmentIdToProject(proposalId, this.projectId);

            } catch (SQLException ex) {
                Logger.getLogger(AddProposalServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect(request.getContextPath() + "/auth/listProposal");
        }

    }

}
