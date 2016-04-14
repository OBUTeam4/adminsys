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
public class AgreedNotation {
    
    private int agreedNotationId;
    private double markPercent;
    private double mark;

    /**
     *
     */
    public AgreedNotation(){
        
    }
    
    /**
     *
     * @param agreedNotationId
     * @param markPercent
     * @param mark
     */
    public AgreedNotation(int agreedNotationId, double markPercent, double mark) {
        this.agreedNotationId = agreedNotationId;
        this.markPercent = markPercent;
        this.mark = mark;
    }

    /**
     *
     * @return
     */
    public int getAgreedNotationId() {
        return agreedNotationId;
    }

    /**
     *
     * @param agreedNotationId
     */
    public void setAgreedNotationId(int agreedNotationId) {
        this.agreedNotationId = agreedNotationId;
    }

    /**
     *
     * @return
     */
    public double getMarkPercent() {
        return markPercent;
    }

    /**
     *
     * @param markPercent
     */
    public void setMarkPercent(double markPercent) {
        this.markPercent = markPercent;
    }

    /**
     *
     * @return
     */
    public double getMark() {
        return mark;
    }

    /**
     *
     * @param mark
     */
    public void setMark(double mark) {
        this.mark = mark;
    }
    
    
    
}
