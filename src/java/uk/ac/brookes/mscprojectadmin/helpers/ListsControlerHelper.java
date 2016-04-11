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
import uk.ac.brookes.mscprojectadmin.dao.DissRegistrationDAO;

/**
 *
 * @author Quentin
 */
public class ListsControlerHelper {

    DissRegistrationDAO diss;

    public ListsControlerHelper() {
        diss = new DissRegistrationDAO();
    }

    public List<Project> getSubmittedRegistrationForms() {
        return diss.getSubmittedRegistrationForms();
    }

    public List<Project> getSubmittedRegFormsForSupervisor(String supervisorId) {
        return diss.getSubmittedRegFormsForSupervisor(supervisorId);
    }

    public List<Project> getReviewedRegFormsForSupervisor(String supervisorId) {
        return diss.getReviewedRegFormsForSupervisor(supervisorId);
    }

    public List<Project> getSubmittedRegFormsForML(String moduleLeaderId) {
        return diss.getSubmittedRegFormsForML(moduleLeaderId);
    }

    public List<Project> getReviewedRegFormsForML(String moduleLeaderId) {
        return diss.getReviewedRegFormsForML(moduleLeaderId);
    }

    
    
}
