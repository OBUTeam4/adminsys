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

public class User {

    private String userId;
    private String fName;
    private String lName;
    private String initial;
    private String courseCode;
    private String courseTitle;
    private String courseMode;
    private String password;
    private String email;
    private String occupation;

    /**
     *
     */
    public User() {

    }
    
    /**
     *
     * @param userId
     */
    public User(String userId){
        this.userId = userId;
    }

    /**
     *
     * @param userId
     * @param fName
     * @param lName
     * @param initial
     * @param courseCode
     * @param courseTitle
     * @param courseMode
     * @param password
     * @param email
     * @param occupation
     */
    public User(String userId, String fName, String lName, String initial, String courseCode, String courseTitle, String courseMode, String password, String email, String occupation) {
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.initial = initial;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.courseMode = courseMode;
        this.password = password;
        this.email = email;
        this.occupation = occupation;
    }

    /**
     *
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @return
     */
    public String getfName() {
        return fName;
    }

    /**
     *
     * @return
     */
    public String getlName() {
        return lName;
    }

    /**
     *
     * @return
     */
    public String getInitial() {
        return initial;
    }

    /**
     *
     * @return
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     *
     * @return
     */
    public String getCourseTitle() {
        return courseTitle;
    }

    /**
     *
     * @return
     */
    public String getCourseMode() {
        return courseMode;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     * @param fName
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     *
     * @param lName
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     *
     * @param initial
     */
    public void setInitial(String initial) {
        this.initial = initial;
    }

    /**
     *
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     *
     * @param courseTitle
     */
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    /**
     *
     * @param courseMode
     */
    public void setCourseMode(String courseMode) {
        this.courseMode = courseMode;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param occupation
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    

    

    
}
