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

    public Semester(int semesterId){
        this.semesterId = semesterId;
    }
    public Semester(int semesterId, String moduleCode, Date startDate, Date completionDate, List<Event> events) {
        this.semesterId = semesterId;
        this.moduleCode = moduleCode;
        this.startDate = startDate;
        this.completionDate = completionDate;
        this.events = events;
    }

    public Semester(int semesterId, Date startDate, Date completionDate, String moduleCode) {
        this.semesterId = semesterId;
        this.startDate = startDate;
        this.completionDate = completionDate;
        this.moduleCode = moduleCode;
    }

    
    public Semester() {
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
    
    
    
}
