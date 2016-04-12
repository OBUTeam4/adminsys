/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.helpers;

import java.util.List;
import java.util.Map;
import uk.ac.brookes.mscprojectadmin.beans.Project;
import uk.ac.brookes.mscprojectadmin.beans.RegistrationForm;
import uk.ac.brookes.mscprojectadmin.dao.DissProposalDAO;
import uk.ac.brookes.mscprojectadmin.dao.DissRegistrationDAO;

/**
 *
 * @author Quentin
 */
public class ListsControlerHelper {

    DissRegistrationDAO dissRegistrationDAO;
    DissProposalDAO dissProposalDAO;

    public ListsControlerHelper() {
        dissRegistrationDAO = new DissRegistrationDAO();
        dissProposalDAO = new DissProposalDAO();
    }

    public List<Project> getSubmittedRegistrationForms() {
        return dissRegistrationDAO.getSubmittedRegistrationForms();
    }

    // 
    /*
        ================================
        ====== REGISTRATION FORMS ======
        ================================
     */
    public List<Project> getSubmittedRegFormsForSupervisor(String supervisorId) {
        return dissRegistrationDAO.getSubmittedRegFormsForSupervisor(supervisorId);
    }

    public List<Project> getReviewedRegFormsForSupervisor(String supervisorId) {
        return dissRegistrationDAO.getReviewedRegFormsForSupervisor(supervisorId);
    }

    public List<Project> getSubmittedRegFormsForML(String moduleLeaderId) {
        return dissRegistrationDAO.getSubmittedRegFormsForML(moduleLeaderId);
    }

    public List<Project> getReviewedRegFormsForML(String moduleLeaderId) {
        return dissRegistrationDAO.getReviewedRegFormsForML(moduleLeaderId);
    }

    /*
        ================================
        ==== END REGISTRATION FORMS ====
        ================================
     */
 /*
        =============================
        ====== PROPOSAL FORMS ======
        ============================
     */
    public List<Project> getProposalForSupervisor(String supervisorId) {
        return dissProposalDAO.getProposalForSupervisor(supervisorId);
    }

    public List<Project> getProposalReviewedBySupervisor(String supervisorId) {
        return dissProposalDAO.getProposalReviewedBySupervisor(supervisorId);
    }

    /*
        ============================
        ==== END PROPOSAL FORMS ====
        ============================
     */
}
