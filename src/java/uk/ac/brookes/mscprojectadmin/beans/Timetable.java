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
public class Timetable {
    private int timetableId;
    private String event;
    private Date dueDate;
    private String recipient;

    public Timetable(int timetableId, String event, Date dueDate, String recipient) {
        this.timetableId = timetableId;
        this.event = event;
        this.dueDate = dueDate;
        this.recipient = recipient;
    }

    public Timetable() {
    }

    public int getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    
    
}
