/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.helpers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.dao.UserDAO;

/**
 *
 * @author Quentin
 */
public class FormsControlerHelper {

    UserDAO userdao;
    Map<String, String> formErrors;

    public FormsControlerHelper() {
        userdao = new UserDAO();
    }

    public List<User> getSupervisors() throws SQLException {
        return userdao.getSupervisors();
    }

    public List<User> getAssessors() throws SQLException {
        return userdao.getAssessors();
    }

    public Map validateForm(String moduleCode, String dissertationTitle, String supervisor, String assessor, String parties, String subjectArea, String aim, String literature, String hypothesis, String deliverables) {
        formErrors = new HashMap<String, String>();

        try {
            checkModuleCode(moduleCode);
        } catch (Exception e) {
            formErrors.put("diss_mod_code", e.getMessage());
        }
        
        //String supervisor = request.getParameter("supervisor").trim();
        // String assessor = request.getParameter("assessor").trim();
        // TO DO test if supervisor is != assessor

        try {
            checkDissertationTitle(dissertationTitle);
        } catch (Exception e) {
            formErrors.put("diss_title", e.getMessage());
        }
        
        try {
            checkParties(parties);
        } catch (Exception e) {
            formErrors.put("diss_parties", e.getMessage());
        }

        try {
            checkSubjectArea(subjectArea);
        } catch (Exception e) {
            formErrors.put("subjectArea", e.getMessage());
        }

        try {
            checkObjectives(aim);
        } catch (Exception e) {
            formErrors.put("projectAim", e.getMessage());
        }
        
        try {
            checkLiterature(literature);
        } catch (Exception e) {
            formErrors.put("literature", e.getMessage());
        }

        try {
            checkHypothesis(hypothesis);
        } catch (Exception e) {
            formErrors.put("diss_hypothesis", e.getMessage());
        }

        try {
            checkDeliverables(deliverables);
        } catch (Exception e) {
            formErrors.put("diss_deliverables", e.getMessage());
        }

        return formErrors;
    }

    private void checkModuleCode(String courseCode) throws Exception {
        if (courseCode != null && courseCode.trim().length() != 0) {
            if (!courseCode.matches("^[a-zA-Z][a-zA-Z0-9_]+$")) {
                throw new Exception("Invalid dissertation module code.");
            }
        } else {
            throw new Exception("Enter a dissertation module code.");
        }
    }

    private void checkDissertationTitle(String dissertationTitle) throws Exception {
        if (dissertationTitle != null && dissertationTitle.trim().length() != 0) {
            if (!dissertationTitle.matches("^[a-zA-Z][a-zA-Z0-9_]+$")) {
                throw new Exception("Invalid dissertation title.");
            }
        } else {
            throw new Exception("Enter a dissertation title.");
        }
    }

    private void checkParties(String relatedParties) throws Exception {
        if (relatedParties.trim().length() > 0) {
            if (!relatedParties.matches("^[a-zA-Z][a-zA-Z0-9_]+$")) {
                throw new Exception("Invalid related parties.");
            }
        }
    }

    private void checkSubjectArea(String subjectArea) throws Exception {
        if (subjectArea != null && subjectArea.trim().length() != 0) {
            if (!subjectArea.matches("^[a-zA-Z][a-zA-Z0-9_]+$")) {
                throw new Exception("Invalid subject area.");
            }
        } else {
            throw new Exception("Enter a subject area.");
        }
    }

    private void checkObjectives(String objectives) throws Exception {
        if (objectives != null && objectives.trim().length() != 0) {
            if (!objectives.matches("^[a-zA-Z][a-zA-Z0-9_]+$")) {
                throw new Exception("Invalid objectives");
            }
        } else {
            throw new Exception("Enter objectives.");
        }
    }

    private void checkLiterature(String literature) throws Exception {
        if (literature != null && literature.trim().length() != 0) {
            if (!literature.matches("^[a-zA-Z][a-zA-Z0-9_]+$")) {
                throw new Exception("Invalid literature");
            }
        } else {
            throw new Exception("Enter a literature influencing work.");
        }
    }

    private void checkHypothesis(String hypothesis) throws Exception {
        if (hypothesis != null && hypothesis.trim().length() != 0) {
            if (!hypothesis.matches("^[a-zA-Z][a-zA-Z0-9_]+$")) {
                throw new Exception("Invalid hypothesis");
            }
        } else {
            throw new Exception("Enter hypothesis.");
        }
    }

    private void checkDeliverables(String deliverables) throws Exception {
        if (deliverables != null && deliverables.trim().length() != 0) {
            if (!deliverables.matches("^[a-zA-Z][a-zA-Z0-9_]+$")) {
                throw new Exception("Invalid deliverables");
            }
        } else {
            throw new Exception("Enter deliverables.");
        }
    }
}
