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
public class Criteria {

    private int criteriaId;
    private String description;
    private String marks;
    private String comments;
    private String agreedComments;

    public Criteria() {

    }

    public Criteria(int id) {
        this.criteriaId = id;
    }

    public Criteria(int criteriaId, String description, String marks, String comments, String agreedComments) {
        this.criteriaId = criteriaId;
        this.description = description;
        this.marks = marks;
        this.comments = comments;
        this.agreedComments = agreedComments;
    }

    public int getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(int criteriaId) {
        this.criteriaId = criteriaId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAgreedComments() {
        return agreedComments;
    }

    public void setAgreedComments(String agreedComments) {
        this.agreedComments = agreedComments;
    }

}
