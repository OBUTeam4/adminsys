/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.beans;

import java.util.Date;

/**
 *
 * @author Quentin
 */
public class TurnitinChecks {

    private int turnitinId;
    private Project projectId;
    private String document;
    private Double turnitinPercent;

    private String outcome;
    private Date dataChecked;
    private User supervisor;

    /**
     *
     */
    public TurnitinChecks() {
    }

    /**
     *
     * @return
     */
    public int getTurnitinId() {
        return turnitinId;
    }

    /**
     *
     * @param turnitinId
     */
    public void setTurnitinId(int turnitinId) {
        this.turnitinId = turnitinId;
    }

    /**
     *
     * @return
     */
    public Project getProjectId() {
        return projectId;
    }

    /**
     *
     * @param projectId
     */
    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    /**
     *
     * @return
     */
    public String getDocument() {
        return document;
    }

    /**
     *
     * @param document
     */
    public void setDocument(String document) {
        this.document = document;
    }

    /**
     *
     * @return
     */
    public Double getTurnitinPercent() {
        return turnitinPercent;
    }

    /**
     *
     * @param turnitinPercent
     */
    public void setTurnitinPercent(Double turnitinPercent) {
        this.turnitinPercent = turnitinPercent;
    }

    /**
     *
     * @return
     */
    public String getOutcome() {
        return outcome;
    }

    /**
     *
     * @param outcome
     */
    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    /**
     *
     * @return
     */
    public Date getDataChecked() {
        return dataChecked;
    }

    /**
     *
     * @param dataChecked
     */
    public void setDataChecked(Date dataChecked) {
        this.dataChecked = dataChecked;
    }

    /**
     *
     * @return
     */
    public User getSupervisor() {
        return supervisor;
    }

    /**
     *
     * @param supervisor
     */
    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }
    
    
}
