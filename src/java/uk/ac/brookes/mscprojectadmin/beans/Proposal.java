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
public class Proposal {
    
    private int proposalId;
    private String mark;
    private String total;
    private String comments;
    private String supervisorId;
    private Criteria projectPlan;
    private Criteria introId;
    private Criteria methodolohyId;
    private Criteria progressId;
    private Criteria writtenPresentationId;
    private Approval approvalId;
    private Semester semesterId;

    /**
     *
     */
    public Proposal() {
    }

    /**
     *
     * @param proposalId
     * @param mark
     * @param total
     * @param comments
     * @param supervisorId
     * @param projectPlan
     * @param introId
     * @param methodolohyId
     * @param progressId
     * @param writtenPresentationId
     * @param approvalId
     * @param semesterId
     */
    public Proposal(int proposalId, String mark, String total, String comments, String supervisorId, Criteria projectPlan, Criteria introId, Criteria methodolohyId, Criteria progressId, Criteria writtenPresentationId, Approval approvalId, Semester semesterId) {
        this.proposalId = proposalId;
        this.mark = mark;
        this.total = total;
        this.comments = comments;
        this.supervisorId = supervisorId;
        this.projectPlan = projectPlan;
        this.introId = introId;
        this.methodolohyId = methodolohyId;
        this.progressId = progressId;
        this.writtenPresentationId = writtenPresentationId;
        this.approvalId = approvalId;
        this.semesterId = semesterId;
    }

    /**
     *
     * @return
     */
    public int getProposalId() {
        return proposalId;
    }

    /**
     *
     * @param proposalId
     */
    public void setProposalId(int proposalId) {
        this.proposalId = proposalId;
    }

    /**
     *
     * @return
     */
    public String getMark() {
        return mark;
    }

    /**
     *
     * @param mark
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     *
     * @return
     */
    public String getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     *
     * @return
     */
    public String getComments() {
        return comments;
    }

    /**
     *
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     *
     * @return
     */
    public String getSupervisorId() {
        return supervisorId;
    }

    /**
     *
     * @param supervisorId
     */
    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    /**
     *
     * @return
     */
    public Criteria getProjectPlan() {
        return projectPlan;
    }

    /**
     *
     * @param projectPlan
     */
    public void setProjectPlan(Criteria projectPlan) {
        this.projectPlan = projectPlan;
    }

    /**
     *
     * @return
     */
    public Criteria getIntroId() {
        return introId;
    }

    /**
     *
     * @param introId
     */
    public void setIntroId(Criteria introId) {
        this.introId = introId;
    }

    /**
     *
     * @return
     */
    public Criteria getMethodolohyId() {
        return methodolohyId;
    }

    /**
     *
     * @param methodolohyId
     */
    public void setMethodolohyId(Criteria methodolohyId) {
        this.methodolohyId = methodolohyId;
    }

    /**
     *
     * @return
     */
    public Criteria getProgressId() {
        return progressId;
    }

    /**
     *
     * @param progressId
     */
    public void setProgressId(Criteria progressId) {
        this.progressId = progressId;
    }

    /**
     *
     * @return
     */
    public Criteria getWrittenPresentationId() {
        return writtenPresentationId;
    }

    /**
     *
     * @param writtenPresentationId
     */
    public void setWrittenPresentationId(Criteria writtenPresentationId) {
        this.writtenPresentationId = writtenPresentationId;
    }

    /**
     *
     * @return
     */
    public Approval getApprovalId() {
        return approvalId;
    }

    /**
     *
     * @param approvalId
     */
    public void setApprovalId(Approval approvalId) {
        this.approvalId = approvalId;
    }

    /**
     *
     * @return
     */
    public Semester getSemesterId() {
        return semesterId;
    }

    /**
     *
     * @param semesterId
     */
    public void setSemesterId(Semester semesterId) {
        this.semesterId = semesterId;
    }
    
    
    
    
}
