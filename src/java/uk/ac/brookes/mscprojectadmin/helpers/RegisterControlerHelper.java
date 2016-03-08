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
    
    public void addUser(User u) throws SQLException{
        //boolean added = false;
        userdao.addUser(u);
        
        //return added;
    }
    
    public boolean isRegistered(User user) throws SQLException {
        boolean userExist = false;
        userExist = userdao.findUserByID(user);
        return userExist;
    }

    public Map validateRegisterDetails(String idNumber, String emailAddress, String firstname, String lastname, String cTitle, String cCode, String cMode, String password, String confirm) {
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
            checkCTitle(cTitle);
        } catch (Exception e) {
            registerErrors.put("courseTitle", e.getMessage());
        }
        
        try {
            checkCCode(cCode);
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
            checkIDNumber(idNumber);
        } catch (Exception e) {
            registerErrors.put("idNumber", e.getMessage());
        }

        return registerErrors;
    }

    private void checkIDNumber(String idNumber) throws Exception {
        if (idNumber != null) {
            // regex digits
            if (!idNumber.matches("-?\\d+(\\.\\d+)?") || idNumber.length() < 8) {
                // {
                throw new Exception("Invalid ID number.");
            }
        } else {
            throw new Exception("ID number required.");
        }
    }

    private void checkPassword(String password) throws Exception {
        if (password == ""){
            throw new Exception("Password is required.");
        }
        else if (password.length() < 8){
            throw new Exception("Invalid password.");
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
        if (confirm == ""){
            throw new Exception("Enter your password again.");
        }
        else if (!password.equals(confirm)){
            throw new Exception("Password and confirm are differ.");
        }
    }

    private void checkFname(String fname) throws Exception {
        if (fname == "") {
            throw new Exception("First name is required.");
        }
        else if (!fname.matches("([a-zA-Z])+")){
            throw new Exception("Invalid first name.");
        }
        else if (fname.length() < 2){
            throw new Exception("Invalid first name.");
        }
    }
    
    private void checkCTitle(String ctitle) throws Exception {
        if (ctitle == "") {
            throw new Exception("Title is required.");
        }
        else if (!ctitle.matches("([a-zA-Z\\s])+")){
            throw new Exception("Invalid title.");
        }
        else if (ctitle.length() < 2){
            throw new Exception("Invalid title.");
        }
    }
    
    private void checkCCode(String ccode) throws Exception {
        if (ccode == "") {
            
            throw new Exception("Enter a course code.");
        }
    }
    

    private void checkLname(String lname) throws Exception {
        if (lname == "") {
            throw new Exception("Last name is required.");
        }
        else if (!lname.matches("([a-zA-Z])+")){
            throw new Exception("Invalid last name.");
        }
        else if (lname.length() < 2){
            throw new Exception("Invalid last name.");
        }
    }


}
