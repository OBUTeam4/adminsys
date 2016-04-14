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

    /**
     *
     */
    public Event() {
    }

    /**
     *
     * @param eventId
     * @param eventDesc
     * @param startDate
     * @param dueDate
     * @param recipient
     * @param semester
     * @param flag
     */
    public Event(int eventId, String eventDesc, String startDate, String dueDate, String recipient, Semester semester, String flag) {
        this.eventId = eventId;
        this.eventDesc = eventDesc;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.recipient = recipient;
        this.semester = semester;
        this.flag = flag;
    }

    /**
     *
     * @return
     */
    public int getEventId() {
        return eventId;
    }

    /**
     *
     * @param eventId
     */
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    /**
     *
     * @return
     */
    public String getEventDesc() {
        return eventDesc;
    }

    /**
     *
     * @param eventDesc
     */
    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    /**
     *
     * @return
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     *
     * @param dueDate
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     *
     * @return
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     *
     * @param recipient
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     *
     * @return
     */
    public Semester getSemester() {
        return semester;
    }

    /**
     *
     * @param semester
     */
    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    /**
     *
     * @return
     */
    public String getFlag() {
        return flag;
    }

    /**
     *
     * @param flag
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }
    
    
    
    
}
