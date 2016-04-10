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

    public RegistrationForm(int registrationFormId) {
        this.registrationFormId = registrationFormId;
    }

    public RegistrationForm() {

    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public int getRegistrationFormId() {
        return registrationFormId;
    }

    public void setRegistrationFormId(int registrationFormId) {
        this.registrationFormId = registrationFormId;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public User getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }

    public User getAssessor() {
        return assessor;
    }

    public void setAssessor(User assessor) {
        this.assessor = assessor;
    }

    public Approval getSupervisorApproval() {
        return supervisorApproval;
    }

    public void setSupervisorApproval(Approval supervisorApproval) {
        this.supervisorApproval = supervisorApproval;
    }

    public Approval getModuleLeaderApproval() {
        return moduleLeaderApproval;
    }

    public void setModuleLeaderApproval(Approval moduleLeaderApproval) {
        this.moduleLeaderApproval = moduleLeaderApproval;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * @return the registrationId
     */
}
