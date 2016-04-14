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

    /**
     *
     */
    public Criteria() {

    }

    /**
     *
     * @param id
     */
    public Criteria(int id) {
        this.criteriaId = id;
    }

    /**
     *
     * @param marks
     * @param comments
     */
    public Criteria(String marks, String comments) {
        this.marks = marks;
        this.comments = comments;
    }

    /**
     *
     * @param criteriaId
     * @param description
     * @param marks
     * @param comments
     * @param agreedComments
     */
    public Criteria(int criteriaId, String description, String marks, String comments, String agreedComments) {
        this.criteriaId = criteriaId;
        this.description = description;
        this.marks = marks;
        this.comments = comments;
        this.agreedComments = agreedComments;
    }

    /**
     *
     * @return
     */
    public int getCriteriaId() {
        return criteriaId;
    }

    /**
     *
     * @param criteriaId
     */
    public void setCriteriaId(int criteriaId) {
        this.criteriaId = criteriaId;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getMarks() {
        return marks;
    }

    /**
     *
     * @param marks
     */
    public void setMarks(String marks) {
        this.marks = marks;
    }

    /**
     *
     * @return
     */
    public String getComments() {
        return comments;
    }

    /**
     *
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     *
     * @return
     */
    public String getAgreedComments() {
        return agreedComments;
    }

    /**
     *
     * @param agreedComments
     */
    public void setAgreedComments(String agreedComments) {
        this.agreedComments = agreedComments;
    }

}
