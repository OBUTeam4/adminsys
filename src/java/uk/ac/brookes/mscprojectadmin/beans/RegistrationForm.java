/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.beans;

/**
 *
 * @author Quentin
 */
public class RegistrationForm {

    private int registrationFormId;
    private String registrationDate;
    private User student;
    private User supervisor;
    private User assessor;
    private Approval supervisorApproval;
    private Approval moduleLeaderApproval;
    private String status;
    private Semester semester;
    private Project project;

    /**
     *
     * @param registrationFormId
     * @param registrationDate
     * @param supervisor
     * @param assessor
     * @param supervisorApproval
     * @param moduleLeaderApproval
     * @param status
     * @param semester
     * @param student
     */
    public RegistrationForm(int registrationFormId, String registrationDate, User supervisor, User assessor,
            Approval supervisorApproval, Approval moduleLeaderApproval, String status, Semester semester, User student) {
        this.registrationFormId = registrationFormId;
        this.registrationDate = registrationDate;
        this.supervisor = supervisor;
        this.assessor = assessor;
        this.supervisorApproval = supervisorApproval;
        this.moduleLeaderApproval = moduleLeaderApproval;
        this.status = status;
        this.semester = semester;
    }

    /**
     *
     * @param registrationFormId
     */
    public RegistrationForm(int registrationFormId) {
        this.registrationFormId = registrationFormId;
    }

    /**
     *
     */
    public RegistrationForm() {

    }

    /**
     *
     * @return
     */
    public User getStudent() {
        return student;
    }

    /**
     *
     * @param student
     */
    public void setStudent(User student) {
        this.student = student;
    }

    /**
     *
     * @return
     */
    public int getRegistrationFormId() {
        return registrationFormId;
    }

    /**
     *
     * @param registrationFormId
     */
    public void setRegistrationFormId(int registrationFormId) {
        this.registrationFormId = registrationFormId;
    }

    /**
     *
     * @return
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     *
     * @param registrationDate
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     *
     * @return
     */
    public User getSupervisor() {
        return supervisor;
    }

    /**
     *
     * @param supervisor
     */
    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }

    /**
     *
     * @return
     */
    public User getAssessor() {
        return assessor;
    }

    /**
     *
     * @param assessor
     */
    public void setAssessor(User assessor) {
        this.assessor = assessor;
    }

    /**
     *
     * @return
     */
    public Approval getSupervisorApproval() {
        return supervisorApproval;
    }

    /**
     *
     * @param supervisorApproval
     */
    public void setSupervisorApproval(Approval supervisorApproval) {
        this.supervisorApproval = supervisorApproval;
    }

    /**
     *
     * @return
     */
    public Approval getModuleLeaderApproval() {
        return moduleLeaderApproval;
    }

    /**
     *
     * @param moduleLeaderApproval
     */
    public void setModuleLeaderApproval(Approval moduleLeaderApproval) {
        this.moduleLeaderApproval = moduleLeaderApproval;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public Semester getSemester() {
        return semester;
    }

    /**
     *
     * @param semester
     */
    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    /**
     *
     * @return
     */
    public Project getProject() {
        return project;
    }

    /**
     *
     * @param project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * @return the registrationId
     */
}
