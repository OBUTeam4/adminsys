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
    private int supervisorId;
    private Criteria projectPlan;
    private Criteria introId;
    private Criteria methodolohyId;
    private Criteria progressId;
    private Criteria writtenPresentationId;
    private Approval approvalId;
    private Semester semesterId;

    public Proposal() {
    }

    public Proposal(int proposalId, String mark, String total, String comments, int supervisorId, Criteria projectPlan, Criteria introId, Criteria methodolohyId, Criteria progressId, Criteria writtenPresentationId, Approval approvalId, Semester semesterId) {
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

    
    public int getProposalId() {
        return proposalId;
    }

    public void setProposalId(int proposalId) {
        this.proposalId = proposalId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Criteria getProjectPlan() {
        return projectPlan;
    }

    public void setProjectPlan(Criteria projectPlan) {
        this.projectPlan = projectPlan;
    }

    public Criteria getIntroId() {
        return introId;
    }

    public void setIntroId(Criteria introId) {
        this.introId = introId;
    }

    public Criteria getMethodolohyId() {
        return methodolohyId;
    }

    public void setMethodolohyId(Criteria methodolohyId) {
        this.methodolohyId = methodolohyId;
    }

    public Criteria getProgressId() {
        return progressId;
    }

    public void setProgressId(Criteria progressId) {
        this.progressId = progressId;
    }

    public Criteria getWrittenPresentationId() {
        return writtenPresentationId;
    }

    public void setWrittenPresentationId(Criteria writtenPresentationId) {
        this.writtenPresentationId = writtenPresentationId;
    }

    public Approval getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Approval approvalId) {
        this.approvalId = approvalId;
    }

    public Semester getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Semester semesterId) {
        this.semesterId = semesterId;
    }
    
    
    
    
}
