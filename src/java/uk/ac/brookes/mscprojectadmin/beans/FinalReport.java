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
public class FinalReport {

    private int finalReportId;
    private String mark;
    private String total;
    private String comments;
    // can be supervisor or assessor
    private User userId;
    private Criteria background;
    private Criteria technical;
    private Criteria critical;
    private Criteria writtenPresentation;
    private Approval approval;
    private AgreedNotation agreedMark;

    /**
     *
     */
    public FinalReport() {
    }

    /**
     *
     * @return
     */
    public int getFinalReportId() {
        return finalReportId;
    }

    /**
     *
     * @param finalReportId
     */
    public void setFinalReportId(int finalReportId) {
        this.finalReportId = finalReportId;
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
    public User getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(User userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
    public Criteria getBackground() {
        return background;
    }

    /**
     *
     * @param background
     */
    public void setBackground(Criteria background) {
        this.background = background;
    }

    /**
     *
     * @return
     */
    public Criteria getTechnical() {
        return technical;
    }

    /**
     *
     * @param technical
     */
    public void setTechnical(Criteria technical) {
        this.technical = technical;
    }

    /**
     *
     * @return
     */
    public Criteria getCritical() {
        return critical;
    }

    /**
     *
     * @param critical
     */
    public void setCritical(Criteria critical) {
        this.critical = critical;
    }

    /**
     *
     * @return
     */
    public Criteria getWrittenPresentation() {
        return writtenPresentation;
    }

    /**
     *
     * @param writtenPresentation
     */
    public void setWrittenPresentation(Criteria writtenPresentation) {
        this.writtenPresentation = writtenPresentation;
    }

    /**
     *
     * @return
     */
    public Approval getApproval() {
        return approval;
    }

    /**
     *
     * @param approval
     */
    public void setApproval(Approval approval) {
        this.approval = approval;
    }

    /**
     *
     * @return
     */
    public AgreedNotation getAgreedMark() {
        return agreedMark;
    }

    /**
     *
     * @param agreedMark
     */
    public void setAgreedMark(AgreedNotation agreedMark) {
        this.agreedMark = agreedMark;
    }
    
    
    
}
