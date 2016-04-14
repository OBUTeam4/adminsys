/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.helpers;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import uk.ac.brookes.mscprojectadmin.beans.Event;
import uk.ac.brookes.mscprojectadmin.beans.Project;
import uk.ac.brookes.mscprojectadmin.beans.Semester;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.dao.DissRegistrationDAO;
import uk.ac.brookes.mscprojectadmin.dao.UserDAO;

/**
 *
 * @author Quentin
 */
public class FormsControlerHelper {

    UserDAO userdao;
    DissRegistrationDAO diss;
    Map<String, String> formErrors;

    /**
     *
     */
    public FormsControlerHelper() {
        userdao = new UserDAO();
        diss = new DissRegistrationDAO();

    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<User> getSupervisors() throws SQLException {
        return userdao.getSupervisors();
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<User> getAssessors() throws SQLException {
        return userdao.getAssessors();
    }

    /**
     *
     * @param semesterId
     * @return
     * @throws SQLException
     */
    public Semester getDissSemester(int semesterId) throws SQLException {
        return diss.getDissSemester(semesterId);
    }

    /**
     *
     * @param semesterId
     * @param flag
     * @return
     */
    public Event getRegistrationEvent(int semesterId, String flag) {
        return diss.getRegistrationEvent(semesterId, flag);
    }

    /**
     *
     * @return
     */
    public List<Semester> getModuleCodes() {
        return diss.getModuleCodes();
    }

    /**
     *
     * @param moduleCode
     * @param dissertationTitle
     * @param supervisorName
     * @param assessorName
     * @param parties
     * @param subjectArea
     * @param aim
     * @param literature
     * @param hypothesis
     * @param deliverables
     * @return
     */
    public Map validateRegInputs(String moduleCode, String dissertationTitle, String supervisorName, String assessorName, String parties,
            String subjectArea, String aim, String literature, String hypothesis, String deliverables) {

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

        try {
            checkSupervisor(supervisorName);
        } catch (Exception e) {
            formErrors.put("supervisor", e.getMessage());
        }
        try {
            checkAssessor(assessorName);
        } catch (Exception e) {
            formErrors.put("assessor", e.getMessage());
        }

        try {
            compareSupervisorAssessor(supervisorName, assessorName);
        } catch (Exception e) {
            formErrors.put("same", e.getMessage());
        }

        return formErrors;
    }

    boolean checkRegSubmissionDeadline() throws ParseException {
        Date deadline = parseStringToDate(diss.getRegistrationEvent(3, "registration").getDueDate());
        Date today = getTodayDate();

        if (deadline.after(today)) {
            return true;
        } else {
            return false;
        }
    }

    private Date getTodayDate() {
        return new Date();
    }

    private Date parseStringToDate(String date) throws ParseException {
        DateFormat originalFormat = new SimpleDateFormat("EEEE dd MMMM yyyy", Locale.ENGLISH);
        Date newDate = originalFormat.parse(date);
        return newDate;
    }

    private void checkModuleCode(String courseCode) throws Exception {
        if (courseCode.equals("0")) {
            throw new Exception("Choose a dissertation module code.");
        }
    }

    private void checkDissertationTitle(String dissertationTitle) throws Exception {
        if (dissertationTitle != null && dissertationTitle.trim().length() != 0) {
            if (!dissertationTitle.matches("^[a-zA-Z0-9][A-Za-z\\s]+$")) {
                throw new Exception("Invalid dissertation title.");
            }
        } else {
            throw new Exception("Enter a dissertation title.");
        }
    }

    private void checkParties(String relatedParties) throws Exception {
        if (relatedParties.trim().length() > 0) {
            if (!relatedParties.matches("^[a-zA-Z][a-zA-Z0-9\\s]+$")) {
                throw new Exception("Invalid related parties.");
            }
        }
    }

    private void checkSubjectArea(String subjectArea) throws Exception {
        if (subjectArea != null && subjectArea.trim().length() != 0) {
            if (!subjectArea.matches("^[a-zA-Z][a-zA-Z0-9\\s]+$")) {
                throw new Exception("Invalid subject area.");
            }
        } else {
            throw new Exception("Enter a subject area.");
        }
    }

    private void checkObjectives(String objectives) throws Exception {
        if (objectives != null && objectives.trim().length() != 0) {
            if (!objectives.matches("^[a-zA-Z][a-zA-Z0-9\\s]+$")) {
                throw new Exception("Invalid objectives");
            }
        } else {
            throw new Exception("Enter objectives.");
        }
    }

    private void checkLiterature(String literature) throws Exception {
        if (literature != null && literature.trim().length() != 0) {
            if (!literature.matches("^[a-zA-Z][a-zA-Z0-9\\s]+$")) {
                throw new Exception("Invalid literature");
            }
        } else {
            throw new Exception("Enter a literature influencing work.");
        }
    }

    private void checkHypothesis(String hypothesis) throws Exception {
        if (hypothesis != null && hypothesis.trim().length() != 0) {
            if (!hypothesis.matches("^[a-zA-Z][a-zA-Z0-9\\s]+$")) {
                throw new Exception("Invalid hypothesis");
            }
        } else {
            throw new Exception("Enter hypothesis.");
        }
    }

    private void checkDeliverables(String deliverables) throws Exception {
        if (deliverables != null && deliverables.trim().length() != 0) {
            if (!deliverables.matches("^[a-zA-Z][a-zA-Z0-9\\s]+$")) {
                throw new Exception("Invalid deliverables");
            }
        } else {
            throw new Exception("Enter deliverables.");
        }
    }

    private void checkSupervisor(String supervisorName) throws Exception {
        if (supervisorName.equals("0")) {
            throw new Exception("Choose your supervisor.");
        }
    }

    private void checkAssessor(String assessorName) throws Exception {
        if (assessorName.equals("0")) {
            throw new Exception("Choose your assessor.");
        }
    }

    private void compareSupervisorAssessor(String supervisorName, String assessorName) throws Exception {

        if (supervisorName.equals(assessorName)) {
            if (!supervisorName.equals("0") && !assessorName.equals("0")) {
                throw new Exception("Your Supervisor must not be your second assessor.");
            }
        }

    }

    //This function will check three things : First, compare the deadline with the submission date.
    //Seconde, check if the student already submitted a registration form.
    //Third, if yes it then checks the status of the approval.
    //Two cases when the student can submit: First, when he first time register his dissertation before the deadline.
    //Second, when his first registration has a disaproval. 

    /**
     *
     * @param user
     * @return
     * @throws ParseException
     */
    public String canSubmit(User user) throws ParseException {
        String message = null;
        if (checkRegSubmissionDeadline()) { //True means submission date is valid. 
            Project p = diss.getStudentProject(user.getUserId());

            if (p != null) {
                System.out.println("has project");
                String decision = diss.getRegistrationApproval(p.getRegistrationForm().getRegistrationFormId());
                if (decision.equals("approved")) {
                    message = "You can't submit another registration as you "
                            + "already submitted a registration form and your project is approved by the supervisor.";
                } else if (decision.equals("")) {
                    message = "You can't submit another resgistration as you already submitted your project and is waiting decision.";
                }

            }

        } else {
            message = "You can't submit, deadline is now passed.";
        }
        System.out.println(message);
        return message;
    }

    /**
     *
     * @param studentId
     * @return
     */
    public Project getDissProject(String studentId) {
        if (studentId != null) {
            return diss.getStudentProject(studentId);
        } else {
            return null;
        }

    }

    /**
     *
     * @param student
     * @param p
     * @param supervisorName
     * @param assessorName
     * @param moduleCode
     * @return
     */
    public int addNewProjectRegistration(User student, Project p, String supervisorName, String assessorName, String moduleCode) {
        int success = diss.addProjectRegistration(student, p, supervisorName, assessorName, moduleCode);

        if (success == 1) {
            System.out.println("You have done it man!!!");
            return 1;
        } else {
            return 0;
        }

    }

    /**
     *
     * @param id
     * @return
     */
    public Project getProjectRegistrationFromId(int id){
        return diss.getProjectRegistrationFromId(id);
    }
    
    /**
     *
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        /*Date date = new Date();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");*/
 /*FormsControlerHelper forms = new FormsControlerHelper();
        DissRegistrationDAO diss = new DissRegistrationDAO();
        Event event = diss.getEvent(3, 2);
        System.out.println(event.getDueDate());
        System.out.println(forms.checkRegSubmissionDeadline(event));*/
    }
}
