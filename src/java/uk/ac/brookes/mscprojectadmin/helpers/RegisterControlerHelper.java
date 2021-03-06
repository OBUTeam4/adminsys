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
public class RegisterControlerHelper {

    UserDAO userdao;
    String[] dashboardURLs = {"/studdash.jsp", "/supdash.jsp", "/assedash.jsp", "/admindash.jsp", "/mldash.jsp", "/eedash.jsp"};
    Map<String, String> registerErrors;

    /**
     *
     */
    public RegisterControlerHelper() {
        userdao = new UserDAO();
    }

    /**
     *
     * @param u
     * @throws SQLException
     */
    public void addUser(User u) throws SQLException {
        //boolean added = false;
        userdao.addUser(u);

        //return added;
    }

    /**
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean isRegistered(User user) throws SQLException {
        boolean userExist = false;
        userExist = userdao.findUserByID(user);
        return userExist;
    }

    /**
     *
     * @param userId
     * @param emailAddress
     * @param firstname
     * @param lastname
     * @param courseTitle
     * @param courseCode
     * @param courseMode
     * @param password
     * @param confirm
     * @return
     */
    public Map validateRegisterDetails(String userId, String emailAddress, String firstname, String lastname, String courseTitle, String courseCode, String courseMode, String password, String confirm) {
        registerErrors = new HashMap<String, String>();
        try {
            checkEmail(emailAddress);
        } catch (Exception e) {
            registerErrors.put("email", e.getMessage());
        }

        try {
            checkPassword(password);
            checkPasswordAndConfirm(password, confirm);
        } catch (Exception e) {
            registerErrors.put("password", e.getMessage());
        }

        try {
            checkCTitle(courseTitle);
        } catch (Exception e) {
            registerErrors.put("courseTitle", e.getMessage());
        }

        try {
            checkCourseCode(courseCode);
        } catch (Exception e) {
            registerErrors.put("courseCode", e.getMessage());
        }

        try {
            checkFname(firstname);
        } catch (Exception e) {
            registerErrors.put("fname", e.getMessage());
        }

        try {
            checkLname(lastname);
        } catch (Exception e) {
            registerErrors.put("lname", e.getMessage());
        }

        try {
            checkUserId(userId);
        } catch (Exception e) {
            registerErrors.put("userId", e.getMessage());
        }

        try {
            checkCourseCode(courseCode);
        } catch (Exception e) {
            registerErrors.put("courseCode", e.getMessage());
        }

        return registerErrors;
    }

    private void checkUserId(String userId) throws Exception {
        if (userId != null) {
            // regex digits
            if (!userId.matches("-?\\d+(\\.\\d+)?") || userId.length() < 8) {
                // {
                throw new Exception("Invalid User ID.");
            }
        } else {
            throw new Exception("User ID required.");
        }
    }

    private void checkPassword(String password) throws Exception {
        if (password == "") {
            throw new Exception("Password is required.");
        } else if (password.length() < 8) {
            throw new Exception("Password need to be 8 characters long");
        }
    }

    private void checkEmail(String email) throws Exception {
        if (email != null && email.trim().length() != 0) {
            if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Enter a valid email!");
            }
        } else {
            throw new Exception("Enter an email address.");
        }
    }

    private void checkPasswordAndConfirm(String password, String confirm) throws Exception {
        if (confirm == "") {
            throw new Exception("Enter your password again.");
        } else if (!password.equals(confirm)) {
            throw new Exception("Password and confirm are differ.");
        }
    }

    private void checkFname(String fname) throws Exception {

        if (fname == "") {
            throw new Exception("First name is required.");
        } else if (!fname.matches("([a-zA-Z])+")) {
            throw new Exception("Invalid first name.");
        } else if (fname.length() < 2) {
            throw new Exception("Invalid first name.");
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

    private void checkLname(String lname) throws Exception {
        if (lname == "") {
            throw new Exception("Last name is required.");
        } else if (!lname.matches("([a-zA-Z])+")) {
            throw new Exception("Invalid last name.");
        } else if (lname.length() < 2) {
            throw new Exception("Invalid last name.");
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

}
