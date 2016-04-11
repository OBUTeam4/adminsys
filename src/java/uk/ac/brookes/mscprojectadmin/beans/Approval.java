/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author oussamak
 */
public class Approval {
    private int approvalId;
    private String userId;
    private String approvalDate;
    private String approvalStatus;
    private String feedbacks;

    /**
     *
     */
    public Approval() {
    }
    
    /**
     *
     * @param id
     */
    public Approval(int id){
        this.approvalId = id;
    }
    
    /**
     *
     * @param approvalId
     * @param userId
     * @param approvalDate
     * @param approvalStatus
     * @param feedback
     */
    public Approval(int approvalId, String userId, String approvalDate, String approvalStatus, String feedback) {
        this.approvalId = approvalId;
        this.userId = userId;
        this.approvalDate = approvalDate;
        this.approvalStatus = approvalStatus;
        this.feedbacks = feedback;
    }

    /**
     *
     * @return
     */
    public int getApprovalId() {
        return approvalId;
    }

    /**
     *
     * @param approvalId
     */
    public void setApprovalId(int approvalId) {
        this.approvalId = approvalId;
    }

    /**
     *
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
    public String getApprovalDate() {
        return approvalDate;
    }

    /**
     *
     * @param approvalDate
     */
    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    /**
     *
     * @return
     */
    public String getApprovalStatus() {
        return approvalStatus;
    }

    /**
     *
     * @param approvalStatus
     */
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    /**
     *
     * @return
     */
    public String getFeedbacks() {
        return feedbacks;
    }

    /**
     *
     * @param feedbacks
     */
    public void setFeedbacks(String feedbacks) {
        this.feedbacks = feedbacks;
    }
    
    
}
