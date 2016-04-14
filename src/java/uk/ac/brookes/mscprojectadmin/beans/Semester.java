/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.beans;

import java.util.Date;
import java.util.List;

/**
 *
 * @author oussamak
 */
public class Semester {
    private int semesterId;
    private Date startDate;
    private Date completionDate;
    private String moduleCode;
    private List<Event> events;

    /**
     *
     * @param semesterId
     */
    public Semester(int semesterId){
        this.semesterId = semesterId;
    }

    /**
     *
     * @param semesterId
     * @param moduleCode
     * @param startDate
     * @param completionDate
     * @param events
     */
    public Semester(int semesterId, String moduleCode, Date startDate, Date completionDate, List<Event> events) {
        this.semesterId = semesterId;
        this.moduleCode = moduleCode;
        this.startDate = startDate;
        this.completionDate = completionDate;
        this.events = events;
    }

    /**
     *
     * @param semesterId
     * @param startDate
     * @param completionDate
     * @param moduleCode
     */
    public Semester(int semesterId, Date startDate, Date completionDate, String moduleCode) {
        this.semesterId = semesterId;
        this.startDate = startDate;
        this.completionDate = completionDate;
        this.moduleCode = moduleCode;
    }

    /**
     *
     */
    public Semester() {
    }

    /**
     *
     * @return
     */
    public int getSemesterId() {
        return semesterId;
    }

    /**
     *
     * @param semesterId
     */
    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    /**
     *
     * @return
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     *
     * @param moduleCode
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     *
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     */
    public Date getCompletionDate() {
        return completionDate;
    }

    /**
     *
     * @param completionDate
     */
    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    /**
     *
     * @return
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     *
     * @param events
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
    
    
    
}
