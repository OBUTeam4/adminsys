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
public class RegistrationForm {

    private int registrationId;
    private String registrationDate;
    private int supervisorId;
    private int assessorId;
    private int moduleLeaderId;
    private int approvalId;
    private int ethicsFormE1Id;
    private int ethicsFormE2Id;
    private int SemesterId;

    
    public RegistrationForm(int registrationId, String registrationDate, int supervisorId, int assessorId, int moduleLeaderId, int approvalId, int ethicsFormE1Id, int ethicsFormE2Id, int SemesterId) {
        this.registrationId = registrationId;
        this.registrationDate = registrationDate;
        this.supervisorId = supervisorId;
        this.assessorId = assessorId;
        this.moduleLeaderId = moduleLeaderId;
        this.approvalId = approvalId;
        this.ethicsFormE1Id = ethicsFormE1Id;
        this.ethicsFormE2Id = ethicsFormE2Id;
        this.SemesterId = SemesterId;
    }

    /**
     * @return the registrationId
     */
    public int getRegistrationId() {
        return registrationId;
    }

    /**
     * @param registrationId the registrationId to set
     */
    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    /**
     * @return the registrationDate
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param registrationDate the registrationDate to set
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * @return the supervisorId
     */
    public int getSupervisorId() {
        return supervisorId;
    }

    /**
     * @param supervisorId the supervisorId to set
     */
    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    /**
     * @return the assessorId
     */
    public int getAssessorId() {
        return assessorId;
    }

    /**
     * @param assessorId the assessorId to set
     */
    public void setAssessorId(int assessorId) {
        this.assessorId = assessorId;
    }

    /**
     * @return the moduleLeaderId
     */
    public int getModuleLeaderId() {
        return moduleLeaderId;
    }

    /**
     * @param moduleLeaderId the moduleLeaderId to set
     */
    public void setModuleLeaderId(int moduleLeaderId) {
        this.moduleLeaderId = moduleLeaderId;
    }

    /**
     * @return the approvalId
     */
    public int getApprovalId() {
        return approvalId;
    }

    /**
     * @param approvalId the approvalId to set
     */
    public void setApprovalId(int approvalId) {
        this.approvalId = approvalId;
    }

    /**
     * @return the ethicsFormE1Id
     */
    public int getEthicsFormE1Id() {
        return ethicsFormE1Id;
    }

    /**
     * @param ethicsFormE1Id the ethicsFormE1Id to set
     */
    public void setEthicsFormE1Id(int ethicsFormE1Id) {
        this.ethicsFormE1Id = ethicsFormE1Id;
    }

    /**
     * @return the ethicsFormE2Id
     */
    public int getEthicsFormE2Id() {
        return ethicsFormE2Id;
    }

    /**
     * @param ethicsFormE2Id the ethicsFormE2Id to set
     */
    public void setEthicsFormE2Id(int ethicsFormE2Id) {
        this.ethicsFormE2Id = ethicsFormE2Id;
    }

    /**
     * @return the SemesterId
     */
    public int getSemesterId() {
        return SemesterId;
    }

    /**
     * @param SemesterId the SemesterId to set
     */
    public void setSemesterId(int SemesterId) {
        this.SemesterId = SemesterId;
    }

}
