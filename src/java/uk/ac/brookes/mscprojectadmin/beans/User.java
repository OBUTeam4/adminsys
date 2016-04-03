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

    public User() {

    }
    
    public User(String userId){
        this.userId = userId;
    }

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

    public String getUserId() {
        return userId;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getInitial() {
        return initial;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseMode() {
        return courseMode;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setCourseMode(String courseMode) {
        this.courseMode = courseMode;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    

    

    
}
