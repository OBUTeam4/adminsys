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
    
    private String username;
    private String password;
    private String email;
    private String occupation;
    private String firstName;
    private String lastName;
    private String idNumber;
    
    public User(String idNumber, String password){
        this.idNumber = idNumber;
        this.password = password;
        //this.email = email;
        
    }
    public User(){
        
    }

    public String getUsername() {
        return username;
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    
    
    
}
