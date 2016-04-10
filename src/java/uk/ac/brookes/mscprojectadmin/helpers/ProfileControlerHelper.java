/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.helpers;

import java.sql.SQLException;
import java.util.HashMap;
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
    Map<String, String> profileErrors;

    public ProfileControlerHelper() {
        userdao = new UserDAO();
    }

    public String getProfilePageFromUserOccupation(User u) throws SQLException {
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
            case "module leader":
                profileUrl = "/auth/profile/leaderProfile.jsp";
                break;
            case "examiner":
                profileUrl = "/auth/profile/examinerProfile.jsp";
                break;
        }
        return profileUrl;
    }

    // 
    public boolean updateUser(User u, String currentOccupation) throws SQLException {
       return userdao.updateUser(u, currentOccupation);
    }
    
    
    public Map validateProfileDetailsStaff(String currentOccupation, String occupation, String password, String confirm) {
        profileErrors = new HashMap<String, String>();

        try {
            checkOccupation(currentOccupation, occupation);
        } catch (Exception e) {
            profileErrors.put("occupation", e.getMessage());
        }
        
        try {
            checkPassword(password);
            checkPasswordAndConfirm(password, confirm);
        } catch (Exception e) {
            profileErrors.put("password", e.getMessage());
        }
        return profileErrors;
    }

    
    public Map validateProfileDetailsStudent(String currentOccupation, String occupation, String courseTitle, String courseCode, String courseMode, String password, String confirm) {
        profileErrors = new HashMap<String, String>();

        try {
            checkOccupation(currentOccupation, occupation);
        } catch (Exception e) {
            profileErrors.put("occupation", e.getMessage());
        }
        
        try {
            checkPassword(password);
            checkPasswordAndConfirm(password, confirm);
        } catch (Exception e) {
            profileErrors.put("password", e.getMessage());
        }

        try {
            checkCTitle(courseTitle);
        } catch (Exception e) {
            profileErrors.put("courseTitle", e.getMessage());
        }

        try {
            checkCourseCode(courseCode);
        } catch (Exception e) {
            profileErrors.put("courseCode", e.getMessage());
        }

        return profileErrors;
    }

    private void checkPassword(String password) throws Exception {
        if (password == "") {
            throw new Exception("Password is required.");
        } else if (password.length() < 8) {
            throw new Exception("Password need to be 8 characters long");
        }
    }

    private void checkPasswordAndConfirm(String password, String confirm) throws Exception {
        if (confirm == "") {
            throw new Exception("Enter your password again.");
        } else if (!password.equals(confirm)) {
            throw new Exception("Password and confirm are differ.");
        }
    }

    private void checkCTitle(String ctitle) throws Exception {
        if (ctitle == "") {
            throw new Exception("Title is required.");
        } else if (!ctitle.matches("([a-zA-Z\\s])+")) {
            throw new Exception("Invalid title.");
        } else if (ctitle.length() < 2) {
            throw new Exception("Invalid title.");
        }
    }

    private void checkCourseCode(String courseCode) throws Exception {
        if (courseCode != null && courseCode.trim().length() != 0) {
            if (!courseCode.matches("^[a-zA-Z][a-zA-Z0-9_]+$")) {
                throw new Exception("Invalid Course Code.");
            }
        } else {
            throw new Exception("Enter a course code.");
        }
    }
    
    private void checkOccupation(String currentOccupation, String occupation) throws Exception{
        if(currentOccupation.equals(occupation))
            throw new Exception("Same occupation");
    }
}
