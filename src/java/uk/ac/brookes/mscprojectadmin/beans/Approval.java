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

    public Approval() {
    }
    
    public Approval(int id){
        this.approvalId = id;
    }
    
    public Approval(int approvalId, String userId, String approvalDate, String approvalStatus, String feedback) {
        this.approvalId = approvalId;
        this.userId = userId;
        this.approvalDate = approvalDate;
        this.approvalStatus = approvalStatus;
        this.feedbacks = feedback;
    }

    public int getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(int approvalId) {
        this.approvalId = approvalId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(String feedbacks) {
        this.feedbacks = feedbacks;
    }
    
    
}
