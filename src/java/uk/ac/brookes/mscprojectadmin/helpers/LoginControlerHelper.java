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
 * @author oussamak
 */
public class LoginControlerHelper {
    UserDAO userdao;
    String[] dashboardURLs = {"/studdash.jsp", "/supdash.jsp", "/assdash.jsp", "/admindash.jsp", "/mldash.jsp", "/eedash.jsp"};
    Map<String, String> loginErrors;
    
    public LoginControlerHelper() {
        userdao = new UserDAO();
    }
    //This method checks username and password are not empty
    public Map validateLoginDetails(String idNumber, String password) {
        loginErrors = new HashMap<String, String>();
        try {
            checkIDNumber(idNumber);
            System.out.println("Check1 OK");

        } catch (Exception e) {
            loginErrors.put("userId", e.getMessage());
        }

        try {
            checkPassword(password);
            System.out.println("Check2 OK");
        } catch (Exception e) {
            loginErrors.put("password", e.getMessage());
        }

        return loginErrors;
    }
    
    //This method checks if the user recognised by the system
    public boolean isRegistered(User user) throws SQLException {
        boolean userExist = false;
        System.out.println("LCH:11");

        userExist = userdao.findUserByLoginDetails(user);
        return userExist;
    }

    public String dashboardURL(User user) {
        String url = null;
        System.out.println("here");

        System.out.println(user.getOccupation());
        switch (user.getOccupation().toLowerCase()) {
            case "student":
                url = dashboardURLs[0];
                break;
            case "supervisor":
                url = dashboardURLs[1];
                break;
            case "assessor":
                url = dashboardURLs[2];
                break;
            case "administrator":
                url = dashboardURLs[3];
                break;
            case "leader":
                url = dashboardURLs[4];
                break;
            case "examiner":
                url = dashboardURLs[5];
                break;

        }
        return url;
    }

    private void checkIDNumber(String userId) throws Exception {
        if (userId != null) {
            // regex digits
            if (!userId.matches("[a-zA-Z]?-?\\d+(\\.\\d+)?") || userId.length() < 8) {
                // {
                throw new Exception("User ID error.");
            }
        } else {
            throw new Exception("User ID required.");
        }
    }

    private void checkPassword(String password) throws Exception {
        if (password != null) {
            if (password.trim().length() < 8) {
                throw new Exception("Incorrect password");
            }
        } else {
            throw new Exception("Enter the password");
        }
    }

}
