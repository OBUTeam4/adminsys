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

    /**
     *
     */
    public Ethics2() {
    }

    /**
     *
     * @param ethics2Id
     * @param rf
     * @param submissionDate
     * @param ptype
     * @param funded
     * @param summary
     * @param participants
     * @param estimate
     * @param details
     * @param plan
     * @param steps
     */
    public Ethics2(int ethics2Id, RegistrationForm rf, String submissionDate, String ptype, String funded, String summary, String participants, String estimate, String details, String plan, String steps) {
        this.ethics2Id = ethics2Id;
        this.rf = rf;
        this.submissionDate = submissionDate;
        this.ptype = ptype;
        this.funded = funded;
        this.summary = summary;
        this.participants = participants;
        this.estimate = estimate;
        this.details = details;
        this.plan = plan;
        this.steps = steps;
    }

    /**
     *
     * @return
     */
    public int getEthics2Id() {
        return ethics2Id;
    }

    /**
     *
     * @param ethics2Id
     */
    public void setEthics2Id(int ethics2Id) {
        this.ethics2Id = ethics2Id;
    }

    /**
     *
     * @return
     */
    public RegistrationForm getRf() {
        return rf;
    }

    /**
     *
     * @param rf
     */
    public void setRf(RegistrationForm rf) {
        this.rf = rf;
    }

    /**
     *
     * @return
     */
    public String getSubmissionDate() {
        return submissionDate;
    }

    /**
     *
     * @param submissionDate
     */
    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    /**
     *
     * @return
     */
    public String getPtype() {
        return ptype;
    }

    /**
     *
     * @param ptype
     */
    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    /**
     *
     * @return
     */
    public String getFunded() {
        return funded;
    }

    /**
     *
     * @param funded
     */
    public void setFunded(String funded) {
        this.funded = funded;
    }

    /**
     *
     * @return
     */
    public String getSummary() {
        return summary;
    }

    /**
     *
     * @param summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     *
     * @return
     */
    public String getParticipants() {
        return participants;
    }

    /**
     *
     * @param participants
     */
    public void setParticipants(String participants) {
        this.participants = participants;
    }

    /**
     *
     * @return
     */
    public String getEstimate() {
        return estimate;
    }

    /**
     *
     * @param estimate
     */
    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    /**
     *
     * @return
     */
    public String getDetails() {
        return details;
    }

    /**
     *
     * @param details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     *
     * @return
     */
    public String getPlan() {
        return plan;
    }

    /**
     *
     * @param plan
     */
    public void setPlan(String plan) {
        this.plan = plan;
    }

    /**
     *
     * @return
     */
    public String getSteps() {
        return steps;
    }

    /**
     *
     * @param steps
     */
    public void setSteps(String steps) {
        this.steps = steps;
    }

}
