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

    public RegisterControlerHelper() {
        userdao = new UserDAO();
    }

    public void addUser(User u) throws SQLException {
        //boolean added = false;
        userdao.addUser(u);

        //return added;
    }

    public boolean isRegistered(User user) throws SQLException {
        boolean userExist = false;
        userExist = userdao.findUserByID(user);
        return userExist;
    }

    public Map validateRegisterDetails(String idNumber, String emailAddress, String firstname, String lastname, String password, String confirm, String courseCode, String courseTitle) {
        registerErrors = new HashMap<String, String>();
        try {
            checkEmail(emailAddress);
        } catch (Exception e) {
            registerErrors.put("email", e.getMessage());
        }

        try {
            checkPasswordAndConfirm(password, confirm);
        } catch (Exception e) {
            registerErrors.put("password", e.getMessage());
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
            checkIDNumber(idNumber);
        } catch (Exception e) {
            registerErrors.put("idNumber", e.getMessage());
        }

        try {
            checkCourseCode(courseCode);
        } catch (Exception e) {
            registerErrors.put("courseCode", e.getMessage());
        }

        try {
            checkCourseTitle(courseTitle);
        } catch (Exception e) {
            registerErrors.put("courseTitle", e.getMessage());
        }

        return registerErrors;
    }

    private void checkIDNumber(String idNumber) throws Exception {
        if (idNumber != null && idNumber.trim().length() != 0) {
            // regex digits
            if (idNumber.trim().length() < 3) {
                //!idNumber.matches("-?\\d+(\\.\\d+)?")) {
                throw new Exception("ID number error.");
            }
        } else {
            throw new Exception("ID number required.");
        }
    }

    private void checkPassword(String password) throws Exception {
        if (password != null && password.trim().length() != 0) {
            if (password.trim().length() < 3) {
                throw new Exception("The password need to have at least 3 characters");
            }
        } else {
            throw new Exception("Enter the password");
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
        if (password != null && password.trim().length() != 0 && confirm != null && confirm.trim().length() != 0) {
            if (!password.equals(confirm)) {
                throw new Exception("Password and confirm are differ!");
            } else if (password.trim().length() < 3) {
                throw new Exception("Password cannot be inferior to 3 chars.");
            }
        } else {
            throw new Exception("Enter a password and a confirm.");
        }
    }

    private void checkFname(String fname) throws Exception {
        if (fname != null && fname.trim().length() != 0) {
            if (!fname.matches("[A-Z][a-zA-Z]*")) {
                throw new Exception("Invalid Firstname.");
            }

            if (fname.trim().length() < 3) {
                throw new Exception("Firstname cannot be inferior to 3 chars.");
            }
        } else {
            throw new Exception("Enter a firstname.");
        }
    }

    private void checkLname(String lname) throws Exception {
        if (lname != null && lname.trim().length() != 0) {
            if (!lname.matches("[a-zA-z]+([ '-][a-zA-Z]+)*")) {
                throw new Exception("Invalid lastname.");
            }

            if (lname.trim().length() < 3) {
                throw new Exception("Lastname cannot be inferior to 3 chars.");
            }

        } else {
            throw new Exception("Enter a lastname.");
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

    private void checkCourseTitle(String courseTitle) throws Exception {
        if (courseTitle != null && courseTitle.trim().length() != 0) {
            if (!courseTitle.matches("(^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$)")) {
                throw new Exception("Invalid Course Title.");
            }
        } else {
            throw new Exception("Enter a course title.");
        }
    }
}
