/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.helpers;

import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.dao.UserDAO;

/**
 *
 * @author oussamak
 */
public class LoginControlerHelper {
    UserDAO userdao;  
    String[] dashboardURLs = {"/StudDash","/SupDash","/AsseDash","/AdminDash","/MLDash","/EEDash"};
    
    //This method checks username and password are not empty
    public boolean validateLoginDetails(User user){
        boolean valid = false;
        if(user.getUsername() != "" && user.getPassword() != ""){
            valid = true; //Means username and password are provided
        }
        return valid;
    }
    
    //This method checks if the user recognised by the system
    public boolean isRegistered(User user){
        boolean userExist = false;
        if (userdao != null){
            userdao = new UserDAO();
        }
        userExist = userdao.findUserByLoginDetails(user);
        return userExist;
    }
    
    public String dashboardURL(User user){
        String url = "";
        switch(user.getOccupation().toLowerCase()){
            case "student": 
                url = dashboardURLs[0];
            case "supervisor":
                url = dashboardURLs[1];
            case "assessor":
                url = dashboardURLs[2];
            case "administrator":
                url = dashboardURLs[3];
            case "moduleleader":
                url = dashboardURLs[4];
            case "examiner":
                url = dashboardURLs[5];
                
        }
        return url;
    }
}
