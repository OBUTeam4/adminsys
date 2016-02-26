/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.dao;
import uk.ac.brookes.mscprojectadmin.beans.User;
/**
 *
 * @author oussamak
 */
public class UserDAO {
    
    
    /*
    * This method will look for a user by his login details, username and password. 
    * Once the user is found setUserData will be called to set the user data
    */
    public boolean findUserByLoginDetails(User user){
        boolean found = false;
        return found;
    }
    
    private void setUserData(User user, String fName, String lName, String email, String occupation, String idNumber){
        user.setFirstName(fName);
        user.setLastName(lName);
        user.setEmail(email);
        user.setIdNumber(idNumber);
        user.setOccupation(occupation);
    }
}
