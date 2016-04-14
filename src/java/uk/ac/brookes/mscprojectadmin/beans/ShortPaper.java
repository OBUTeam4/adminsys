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
public class ShortPaper {

    private int shortPaperId;
    private String mark;
    private String total;
    private String comments;
    // can be supervisor or assessor
    private User userId;
    private Criteria background;
    private Criteria development;
    private Criteria result;
    private Criteria discussion;
    private Criteria writtenPresentation;
    private Approval approval;
    private AgreedNotation agreedMark;

    /**
     *
     */
    public ShortPaper() {
    }

    /**
     *
     * @return
     */
    public int getShortPaperId() {
        return shortPaperId;
    }

    /**
     *
     * @param shortPaperId
     */
    public void setShortPaperId(int shortPaperId) {
        this.shortPaperId = shortPaperId;
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
    public Criteria getDevelopment() {
        return development;
    }

    /**
     *
     * @param development
     */
    public void setDevelopment(Criteria development) {
        this.development = development;
    }

    /**
     *
     * @return
     */
    public Criteria getResult() {
        return result;
    }

    /**
     *
     * @param result
     */
    public void setResult(Criteria result) {
        this.result = result;
    }

    /**
     *
     * @return
     */
    public Criteria getDiscussion() {
        return discussion;
    }

    /**
     *
     * @param discussion
     */
    public void setDiscussion(Criteria discussion) {
        this.discussion = discussion;
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
