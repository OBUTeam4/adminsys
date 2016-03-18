/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.tools.DBConnection;

/**
 *
 * @author oussamak
 */
public class UserDAO {

    DBConnection connect;
    Connection con;
    Statement stmt;
    ResultSet rs;
    String query;

    public UserDAO() {
        createConnection();
        // System.out.println(con);
    }

    /*
    * This method will look for a user by his login details, ID number and password. 
    * Once the user is found setUserData will be called to set the user data
     */
    public boolean findUserByLoginDetails(User user) throws SQLException {
        boolean found = false;
        query = "select * from user where idNumber = '" + user.getIdNumber() + "' and pw = '" + user.getPassword() + "'";
        System.out.println("begining");
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("111");

            if (rs.next()) {
                System.out.println("Next OK");
                found = true;
                setUserData(user, rs.getString("fName"), rs.getString("lName"), rs.getString("email"), rs.getString("occupation"), rs.getString("courseCode"),
                        rs.getString("courseMode"),
                        rs.getString("courseTitle"));
                System.out.println("after ");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return found;
    }

    public boolean findUserByID(User user) throws SQLException {
        boolean found = false;
        query = "select * from user where idNumber = '" + user.getIdNumber() + "'";
        System.out.println("begining");
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("111");

            if (rs.next()) {
                System.out.println("Next OK");
                found = true;
                setUserData(user, rs.getString("fName"), rs.getString("lName"), rs.getString("email"), rs.getString("occupation"), rs.getString("courseCode"),
                        rs.getString("courseMode"),
                        rs.getString("courseTitle"));
                System.out.println("after ");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return found;
    }

    private void setUserData(User user, String fName, String lName, String email, String occupation, String courseCode, String courseMode, String courseTitle) {
        user.setFirstName(fName);
        user.setLastName(lName);
        user.setEmail(email);
        user.setOccupation(occupation);
        user.setCourseCode(courseCode);
        user.setCourseTitle(courseTitle);
        user.setCourseMode(courseMode);
    }

    // add USER
    public boolean addUser(User user) throws SQLException {
        boolean added = false;
        String insertQuery = "INSERT INTO `User`(`IdNumber`, `fName`, `lName`, `courseCode`, `courseTitle`, `courseMode`, `email`, `pw`, `occupation`) "
                + "VALUES ( '" + user.getIdNumber() + "', "
                + "'" + user.getFirstName() + "', "
                + "'" + user.getLastName() + "', "
                + "'" + user.getCourseCode() + "', "
                + "'" + user.getCourseTitle() + "', "
                + "'" + user.getCourseMode() + "', "
                + "'" + user.getEmail() + "', "
                + "'" + user.getPassword() + "', "
                + "'" + user.getOccupation() + "'"
                + ")";
        System.out.println("Inserting a new user");
        System.out.println(insertQuery);

        try {
            stmt = con.createStatement();
            stmt.executeUpdate(insertQuery);
            added = true;

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return added;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean updated = false;

        String updateQuery = "UPDATE user SET occupation = " + user.getOccupation() + " WHERE `idNumber` = " + user.getIdNumber() ;
        System.out.println("Updating user");
        System.out.println(updateQuery);

        try {
            stmt = con.createStatement();
            stmt.executeUpdate(updateQuery);
            updated = true;

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return updated;

        /*
          // create update
            CriteriaUpdate update = cb.createCriteriaUpdate(User.class);

            // set the root class
            Root e = update.from(User.class);

            // set update and where clause
            update.set("firstname", user.getFirstname());
            update.set("lastName", user.getLastname());
            update.set("creditCardNumber", user.getCreditCardNumber());
            update.set("emailAddress", user.getEmailAddress());
            update.set("address", user.getAddress());
            update.set("Md5Password", user.getMd5Password());

            update.where(cb.equal(e.get("id"), user.getId()));

            em.createQuery(update).executeUpdate();

            return true;
        } catch (NoResultException e) {
            System.out.println("Update failed... ");
            return false;
        }
         */
    }

    private void createConnection() {
        connect = DBConnection.getInstance();
        con = connect.getConnection();
    }

}
