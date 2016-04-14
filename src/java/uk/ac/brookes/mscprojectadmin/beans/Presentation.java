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
public class Presentation {

    private int presentationId;

    private String mark;
    private String total;
    private String comments;
    private User studentId;
    private Criteria presentationQuality;
    private Criteria scholarlyContent;
    private Criteria progress;
    private Criteria questions;
    private Approval approval;
    private AgreedNotation agreedMark;

    /**
     *
     */
    public Presentation() {
    }

    /**
     *
     * @return
     */
    public int getPresentationId() {
        return presentationId;
    }

    /**
     *
     * @param presentationId
     */
    public void setPresentationId(int presentationId) {
        this.presentationId = presentationId;
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
    public User getStudentId() {
        return studentId;
    }

    /**
     *
     * @param studentId
     */
    public void setStudentId(User studentId) {
        this.studentId = studentId;
    }

    /**
     *
     * @return
     */
    public Criteria getPresentationQuality() {
        return presentationQuality;
    }

    /**
     *
     * @param presentationQuality
     */
    public void setPresentationQuality(Criteria presentationQuality) {
        this.presentationQuality = presentationQuality;
    }

    /**
     *
     * @return
     */
    public Criteria getScholarlyContent() {
        return scholarlyContent;
    }

    /**
     *
     * @param scholarlyContent
     */
    public void setScholarlyContent(Criteria scholarlyContent) {
        this.scholarlyContent = scholarlyContent;
    }

    /**
     *
     * @return
     */
    public Criteria getProgress() {
        return progress;
    }

    /**
     *
     * @param progress
     */
    public void setProgress(Criteria progress) {
        this.progress = progress;
    }

    /**
     *
     * @return
     */
    public Criteria getQuestions() {
        return questions;
    }

    /**
     *
     * @param questions
     */
    public void setQuestions(Criteria questions) {
        this.questions = questions;
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
