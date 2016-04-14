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
    private Proposal proposalId;
    private Presentation presentation;
    private FinalReport finalReport;
    private ShortPaper shortPaper;

    /**
     *
     */
    public Project() {
    }

    /**
     *
     * @param projectId
     * @param studentId
     * @param registrationForm
     * @param dissertationTitle
     * @param relatedParties
     * @param deliverables
     * @param hypothesis
     * @param literature
     * @param projectAim
     * @param subjectArea
     * @param proposal
     */
    public Project(int projectId, String studentId, RegistrationForm registrationForm, String dissertationTitle, String relatedParties, String deliverables, String hypothesis, String literature, String projectAim, String subjectArea, Proposal proposal) {
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
        this.proposalId = proposal;
    }

    /**
     *
     * @return
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     *
     * @param projectId
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    /**
     *
     * @return
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     *
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     *
     * @return
     */
    public RegistrationForm getRegistrationForm() {
        return registrationForm;
    }

    /**
     *
     * @param registrationForm
     */
    public void setRegistrationForm(RegistrationForm registrationForm) {
        this.registrationForm = registrationForm;
    }

    /**
     *
     * @return
     */
    public String getDissertationTitle() {
        return dissertationTitle;
    }

    /**
     *
     * @param dissertationTitle
     */
    public void setDissertationTitle(String dissertationTitle) {
        this.dissertationTitle = dissertationTitle;
    }

    /**
     *
     * @return
     */
    public String getRelatedParties() {
        return relatedParties;
    }

    /**
     *
     * @param relatedParties
     */
    public void setRelatedParties(String relatedParties) {
        this.relatedParties = relatedParties;
    }

    /**
     *
     * @return
     */
    public String getDeliverables() {
        return deliverables;
    }

    /**
     *
     * @param deliverables
     */
    public void setDeliverables(String deliverables) {
        this.deliverables = deliverables;
    }

    /**
     *
     * @return
     */
    public String getHypothesis() {
        return hypothesis;
    }

    /**
     *
     * @param hypothesis
     */
    public void setHypothesis(String hypothesis) {
        this.hypothesis = hypothesis;
    }

    /**
     *
     * @return
     */
    public String getLiterature() {
        return literature;
    }

    /**
     *
     * @param literature
     */
    public void setLiterature(String literature) {
        this.literature = literature;
    }

    /**
     *
     * @return
     */
    public String getProjectAim() {
        return projectAim;
    }

    /**
     *
     * @param projectAim
     */
    public void setProjectAim(String projectAim) {
        this.projectAim = projectAim;
    }

    /**
     *
     * @return
     */
    public String getSubjectArea() {
        return subjectArea;
    }

    /**
     *
     * @param subjectArea
     */
    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }

    /**
     *
     * @return
     */
    public Proposal getProposalId() {
        return proposalId;
    }

    /**
     *
     * @param proposalId
     */
    public void setProposalId(Proposal proposalId) {
        this.proposalId = proposalId;
    }

    /**
     *
     * @return
     */
    public Presentation getPresentation() {
        return presentation;
    }

    /**
     *
     * @param presentation
     */
    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    /**
     *
     * @return
     */
    public FinalReport getFinalReport() {
        return finalReport;
    }

    /**
     *
     * @param finalReport
     */
    public void setFinalReport(FinalReport finalReport) {
        this.finalReport = finalReport;
    }

    /**
     *
     * @return
     */
    public ShortPaper getShortPaper() {
        return shortPaper;
    }

    /**
     *
     * @param shortPaper
     */
    public void setShortPaper(ShortPaper shortPaper) {
        this.shortPaper = shortPaper;
    }

    

   

    


}
