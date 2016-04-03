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
public class Project {

    private int projectId;
    private String studentId;
    private RegistrationForm registrationForm;
    private String dissertationTitle;
    private String relatedParties;
    private String deliverables;
    private String hypothesis;
    private String literature;
    private String projectAim;
    private String subjectArea;
    

    public Project() {
    }

    public Project(int projectId, String studentId, RegistrationForm registrationForm, String dissertationTitle, String relatedParties, String deliverables, String hypothesis, String literature, String projectAim, String subjectArea) {
        this.projectId = projectId;
        this.studentId = studentId;
        this.registrationForm = registrationForm;
        this.dissertationTitle = dissertationTitle;
        this.relatedParties = relatedParties;
        this.deliverables = deliverables;
        this.hypothesis = hypothesis;
        this.literature = literature;
        this.projectAim = projectAim;
        this.subjectArea = subjectArea;
    }

    

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public RegistrationForm getRegistrationForm() {
        return registrationForm;
    }

    public void setRegistrationForm(RegistrationForm registrationForm) {
        this.registrationForm = registrationForm;
    }


    public String getDissertationTitle() {
        return dissertationTitle;
    }

    public void setDissertationTitle(String dissertationTitle) {
        this.dissertationTitle = dissertationTitle;
    }

    public String getRelatedParties() {
        return relatedParties;
    }

    public void setRelatedParties(String relatedParties) {
        this.relatedParties = relatedParties;
    }

    public String getDeliverables() {
        return deliverables;
    }

    public void setDeliverables(String deliverables) {
        this.deliverables = deliverables;
    }

    public String getHypothesis() {
        return hypothesis;
    }

    public void setHypothesis(String hypothesis) {
        this.hypothesis = hypothesis;
    }

    public String getLiterature() {
        return literature;
    }

    public void setLiterature(String literature) {
        this.literature = literature;
    }

    public String getProjectAim() {
        return projectAim;
    }

    public void setProjectAim(String projectAim) {
        this.projectAim = projectAim;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }

    

   

    

    /**
     * @return the projectId
     */
    

}
