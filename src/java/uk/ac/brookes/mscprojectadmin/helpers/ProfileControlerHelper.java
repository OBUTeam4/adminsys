/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.helpers;

import java.sql.SQLException;
import java.util.Map;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.dao.UserDAO;

/**
 *
 * @author Quentin
 */
public class ProfileControlerHelper {
    
       UserDAO userdao;
    String[] dashboardURLs = {"/studdash.jsp", "/supdash.jsp", "/assedash.jsp", "/admindash.jsp", "/mldash.jsp", "/eedash.jsp"};
    Map<String, String> loginErrors;
    
    public ProfileControlerHelper() {
        userdao = new UserDAO();
    }
    
    
    public String getProfilePageFromUserOccupation(User u) throws SQLException{
        String userOccupation;
        String profileUrl = "";
        
        userdao.findUserByLoginDetails(u);
        userOccupation = u.getOccupation();
        
        switch (userOccupation) {
            case "student":
                profileUrl = "/auth/profile/studentProfile.jsp";
                break;
            case "supervisor":
                profileUrl = "/auth/profile/supervisorProfile.jsp";
                break;
            case "assessor":
                profileUrl = "/auth/profile/assesorProfile.jsp";
                break;
            case "administrator":
                profileUrl = "/auth/profile/administratorProfile.jsp";
                break;
            case "moduleleader":
                profileUrl = "/auth/profile/moduleleaderProfile.jsp";
                break;
            case "examiner":
                profileUrl = "/auth/profile/examinerProfile.jsp";
                break;
        }
        return profileUrl;
    }
}
