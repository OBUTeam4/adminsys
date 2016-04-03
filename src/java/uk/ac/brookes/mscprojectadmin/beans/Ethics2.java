/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.beans;

/**
 *
 * @author oussamak
 */
public class Ethics2 {
    
    private int ethics2Id;
    private RegistrationForm rf;
    private String submissionDate;
    private String ptype;
    private String funded;
    private String summary;
    private String participants;
    private String estimate;
    private String details;
    private String plan;
    private String steps;

    public Ethics2(int ethics2Id) {
        this.ethics2Id = ethics2Id;
    }

    public Ethics2() {
    }

    public int getEthics2Id() {
        return ethics2Id;
    }

    public void setEthics2Id(int ethics2Id) {
        this.ethics2Id = ethics2Id;
    }

    public RegistrationForm getRf() {
        return rf;
    }

    public void setRf(RegistrationForm rf) {
        this.rf = rf;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getFunded() {
        return funded;
    }

    public void setFunded(String funded) {
        this.funded = funded;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    
    
}
