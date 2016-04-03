/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.beans;

import java.util.Date;

/**
 *
 * @author oussamak
 */
public class Event {
    private int eventId;
    private String eventDesc;
    private String startDate;
    private String dueDate;
    private String recipient;
    private Semester semester;
    private String flag;

    public Event() {
    }

    
    public Event(int eventId, String eventDesc, String startDate, String dueDate, String recipient, Semester semester, String flag) {
        this.eventId = eventId;
        this.eventDesc = eventDesc;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.recipient = recipient;
        this.semester = semester;
        this.flag = flag;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    
    
    
    
}
