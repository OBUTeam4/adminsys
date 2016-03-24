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
    private int studentId;
    private String dissertationTitle;
    private String relatedParties;
    private String deliverables;
    private String hypothesis;
    private String literature;
    private String projectAim;
    private String subjectArea;
    private int registrationId;
    private int proposalAssessmentId;
    private int finalReportAssessmentId;
    private int presentationAssessmentId;
    private int shortPaperAssessmentId;

    public Project() {
    }

    public Project(int projectId, int studentId, String dissertationTitle, String relatedParties, String deliverables, String hypothesis, String literature, String projectAim, String subjectId, int registrationId, int proposalAssessmentId, int finalReportAssessmentId, int presentationAssessmentId, int shortPaperAssessmentId) {
        this.projectId = projectId;
        this.studentId = studentId;
        this.dissertationTitle = dissertationTitle;
        this.relatedParties = relatedParties;
        this.deliverables = deliverables;
        this.hypothesis = hypothesis;
        this.literature = literature;
        this.projectAim = projectAim;
        this.subjectArea = subjectId;
        this.registrationId = registrationId;
        this.proposalAssessmentId = proposalAssessmentId;
        this.finalReportAssessmentId = finalReportAssessmentId;
        this.presentationAssessmentId = presentationAssessmentId;
        this.shortPaperAssessmentId = shortPaperAssessmentId;
    }

    /**
     * @return the projectId
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    /**
     * @return the studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the dissertationTitle
     */
    public String getDissertationTitle() {
        return dissertationTitle;
    }

    /**
     * @param dissertationTitle the dissertationTitle to set
     */
    public void setDissertationTitle(String dissertationTitle) {
        this.dissertationTitle = dissertationTitle;
    }

    /**
     * @return the relatedParties
     */
    public String getRelatedParties() {
        return relatedParties;
    }

    /**
     * @param relatedParties the relatedParties to set
     */
    public void setRelatedParties(String relatedParties) {
        this.relatedParties = relatedParties;
    }

    /**
     * @return the deliverables
     */
    public String getDeliverables() {
        return deliverables;
    }

    /**
     * @param deliverables the deliverables to set
     */
    public void setDeliverables(String deliverables) {
        this.deliverables = deliverables;
    }

    /**
     * @return the hypothesis
     */
    public String getHypothesis() {
        return hypothesis;
    }

    /**
     * @param hypothesis the hypothesis to set
     */
    public void setHypothesis(String hypothesis) {
        this.hypothesis = hypothesis;
    }

    /**
     * @return the literature
     */
    public String getLiterature() {
        return literature;
    }

    /**
     * @param literature the literature to set
     */
    public void setLiterature(String literature) {
        this.literature = literature;
    }

    /**
     * @return the projectAim
     */
    public String getProjectAim() {
        return projectAim;
    }

    /**
     * @param projectAim the projectAim to set
     */
    public void setProjectAim(String projectAim) {
        this.projectAim = projectAim;
    }

    /**
     * @return the subjectArea
     */
    public String getSubjectId() {
        return subjectArea;
    }

    /**
     * @param subjectArea the subjectArea to set
     */
    public void setSubjectId(String subjectArea) {
        this.subjectArea = subjectArea;
    }

    /**
     * @return the proposalAssessmentId
     */
    public int getProposalAssessmentId() {
        return proposalAssessmentId;
    }

    /**
     * @param proposalAssessmentId the proposalAssessmentId to set
     */
    public void setProposalAssessmentId(int proposalAssessmentId) {
        this.proposalAssessmentId = proposalAssessmentId;
    }

    /**
     * @return the finalReportAssessmentId
     */
    public int getFinalReportAssessmentId() {
        return finalReportAssessmentId;
    }

    /**
     * @param finalReportAssessmentId the finalReportAssessmentId to set
     */
    public void setFinalReportAssessmentId(int finalReportAssessmentId) {
        this.finalReportAssessmentId = finalReportAssessmentId;
    }

    /**
     * @return the presentationAssessmentId
     */
    public int getPresentationAssessmentId() {
        return presentationAssessmentId;
    }

    /**
     * @param presentationAssessmentId the presentationAssessmentId to set
     */
    public void setPresentationAssessmentId(int presentationAssessmentId) {
        this.presentationAssessmentId = presentationAssessmentId;
    }

    /**
     * @return the shortPaperAssessmentId
     */
    public int getShortPaperAssessmentId() {
        return shortPaperAssessmentId;
    }

    /**
     * @param shortPaperAssessmentId the shortPaperAssessmentId to set
     */
    public void setShortPaperAssessmentId(int shortPaperAssessmentId) {
        this.shortPaperAssessmentId = shortPaperAssessmentId;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

}
