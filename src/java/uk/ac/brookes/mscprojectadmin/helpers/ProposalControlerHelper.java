/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.helpers;

import java.sql.SQLException;
import uk.ac.brookes.mscprojectadmin.beans.Approval;
import uk.ac.brookes.mscprojectadmin.beans.Criteria;
import uk.ac.brookes.mscprojectadmin.beans.Proposal;
import uk.ac.brookes.mscprojectadmin.dao.DissProposalDAO;

/**
 *
 * @author Quentin
 */
public class ProposalControlerHelper {

    private final DissProposalDAO proposalDAO;

    /**
     *
     */
    public ProposalControlerHelper() {
        this.proposalDAO = new DissProposalDAO();
    }
    
    /**
     *
     * @param proposalID
     * @param projectID
     * @return
     * @throws SQLException
     */
    public boolean addProposalAssessmentIdToProject(int proposalID, int projectID) throws SQLException {
        return proposalDAO.addProposalAssessmentIdToProject(proposalID, projectID);
    }
    
    /**
     *
     * @param proposal
     * @param intro
     * @param methodology
     * @param progress
     * @param writtenPresentation
     * @param projectPlan
     * @param supervisorApproval
     * @return
     * @throws SQLException
     */
    public int addProposal(Proposal proposal, Criteria intro, Criteria methodology, Criteria progress, Criteria writtenPresentation, Criteria projectPlan, Approval supervisorApproval) throws SQLException {
        return proposalDAO.addProposal(proposal, intro, methodology, progress, writtenPresentation, projectPlan, supervisorApproval);
    }
    
    
    
}
