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
import java.util.ArrayList;
import java.util.List;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.tools.DBConnection;

/**
 *
 * @author oussamak
 */
public class UserDAO extends ClassDAO {

    public UserDAO() {
        // System.out.println(con);
        super();
    }

    /*
    * This method will look for a user by his login details, ID number and password. 
    * Once the user is found setUserData will be called to set the user data
     */
    public boolean findUserByLoginDetails(User user) throws SQLException {
        boolean found = false;
        query = "select * from user where userId = '" + user.getUserId() + "' and password = '" + user.getPassword() + "'";
        System.out.println("begining");
        try {
            System.out.println(con);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("111");

            if (rs.next()) {
                System.out.println("Next OK");
                found = true;
                String occupation = setUserOccupation(rs.getInt("isSupervisor"),
                        rs.getInt("isModuleLeader"), rs.getInt("isExaminer"),
                        rs.getInt("isAdministrator"), rs.getInt("isAssessor"),
                        rs.getInt("isStudent"));

                setUserData(user, rs.getString("fName"), rs.getString("lName"),
                        rs.getString("initial"), rs.getString("email"),
                        rs.getString("courseCode"), rs.getString("courseMode"),
                        rs.getString("courseTitle"), occupation);
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
        query = "select * from user where userId = '" + user.getUserId() + "'";
        System.out.println("begining");
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("111");

            if (rs.next()) {
                System.out.println("Next OK");
                found = true;
                String occupation = setUserOccupation(rs.getInt("isSupervisor"),
                        rs.getInt("isModuleLeader"), rs.getInt("isExaminer"),
                        rs.getInt("isAdministrator"), rs.getInt("isAssessor"),
                        rs.getInt("isStudent"));

                setUserData(user, rs.getString("fName"), rs.getString("lName"),
                        rs.getString("initial"), rs.getString("email"),
                        rs.getString("courseCode"), rs.getString("courseMode"),
                        rs.getString("courseTitle"), occupation);
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

    private String setUserOccupation(int a, int b, int c, int d, int e, int f) {
        String occupation = null;
        if (a == 1) { // User is a supervisor
            occupation = "supervisor";
        } else if (b == 1) { // User is module leader
            occupation = "module leader";
        } else if (c == 1) { //User is an examiner
            occupation = "examiner";
        } else if (d == 1) { //User is an administrator
            occupation = "administrator";
        } else if (e == 1) { // User is an assessor
            occupation = "assessor";
        } else if (f == 1) {
            occupation = "student";
        }
        return occupation;
    }

    private String getUserOccupationColumn(String occupation) {
        String column = null;
        if (occupation.equals("student")) {
            column = "isStudent";
        } else if (occupation.equals("supervisor")) {
            column = "isSupervisor";
        } else if (occupation.equals("assessor")) {
            column = "isAssessor";
        } else if (occupation.equals("administrator")) {
            column = "isAdministrator";
        } else if (occupation.equals("module leader")) {
            column = "isModuleLeader";
        } else if (occupation.equals("examiner")) {
            column = "isExaminer";
        }
        return column;
    }

    private void setUserData(User user, String fName, String lName, String initial,
            String email, String courseCode, String courseMode, String courseTitle,
            String occupation) {
        user.setfName(fName);
        user.setlName(lName);
        user.setInitial(initial);
        user.setEmail(email);
        user.setOccupation(occupation);
        user.setCourseCode(courseCode);
        user.setCourseTitle(courseTitle);
        user.setCourseMode(courseMode);
    }

    // add USER
    public boolean addUser(User user) throws SQLException {
        boolean added = false;
        String insertQuery = "INSERT INTO `user`(`userId`, `fName`, `lName`, `initial`, `email`, `password`, `courseCode`, `courseTitle`, `courseMode`, `" + getUserOccupationColumn(user.getOccupation()) + "`)"
                + "VALUES ( '" + user.getUserId() + "', "
                + "'" + user.getfName() + "', "
                + "'" + user.getlName() + "', "
                + "'" + user.getInitial() + "', "
                + "'" + user.getEmail() + "', "
                + "'" + user.getPassword() + "', "
                + "'" + user.getCourseCode() + "', "
                + "'" + user.getCourseTitle() + "', "
                + "'" + user.getCourseMode() + "', "
                + "'1'"
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

    /**
     * update user informations
     *
     * @param user
     * @param currentOccupation
     * @return
     * @throws SQLException
     */
    public boolean updateUser(User user, String currentOccupation) throws SQLException {
        boolean updated = false;

        String updateQuery = "";
        if (user.getOccupation().equals("student")) {
            // updateQuery = "UPDATE user SET courseCode = '" + user.getCourseCode() + "', courseMode = '" + user.getCourseMode()
            //         + "', courseTitle = '" + user.getCourseTitle() + "', " + getUserOccupationColumn(currentOccupation) + " = 0, " + getUserOccupationColumn(user.getOccupation()) + " = 1 WHERE `userId` = '" + user.getUserId() + "'";
            updateQuery = "UPDATE user SET password = '" + user.getPassword() + "', courseCode = '" + user.getCourseCode() + "', courseMode = '" + user.getCourseMode()
                    + "', courseTitle = '" + user.getCourseTitle() + "' WHERE `userId` = '" + user.getUserId() + "'";

        } else {
            //updateQuery = "UPDATE user SET " + getUserOccupationColumn(currentOccupation) + " = 0, " + getUserOccupationColumn(user.getOccupation()) + " = 1 WHERE `userId` = '" + user.getUserId() + "'";
            updateQuery = "UPDATE user SET password = '" + user.getPassword() + "' WHERE `userId` = '" + user.getUserId() + "'";
        }

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
    }

    // OLD QUERY! 
    // return assesors, supervisor, leader
    public List<User> getStaffMembersWithoutAdmin() throws SQLException {
        List<User> listing = new ArrayList<User>();
        Statement statement = con.createStatement();
        final String query = "SELECT `idNumber`, `fName`,`lName`,`occupation` FROM `user` WHERE `occupation` != 'student' AND `occupation` != 'administrator' ";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            User u = new User();
            u.setUserId(rs.getString("userId"));
            u.setfName(rs.getString("fName"));
            u.setlName(rs.getString("lName"));
            u.setOccupation(rs.getString("occupation"));
            listing.add(u);
        }
        return listing;
    }

    // get supervisors users
    public List<User> getSupervisors() throws SQLException {
        List<User> listing = new ArrayList<User>();
        Statement statement = con.createStatement();
        final String query = "SELECT * FROM `user` WHERE `isSupervisor` = 1 ";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            User u = new User();
            u.setUserId(rs.getString("userId"));
            u.setfName(rs.getString("fName"));
            u.setlName(rs.getString("lName"));
            u.setOccupation("supervisor");
            listing.add(u);
        }
        return listing;
    }

    // get assessors users
    public List<User> getAssessors() throws SQLException {
        List<User> listing = new ArrayList<User>();
        Statement statement = con.createStatement();
        final String query = "SELECT * FROM `user` WHERE `isAssessor` = 1 ";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            User u = new User();
            u.setUserId(rs.getString("userId"));
            u.setfName(rs.getString("fName"));
            u.setlName(rs.getString("lName"));
            u.setOccupation("assessor");
            listing.add(u);
        }
        return listing;
    }

    public User getUserbyId(String userId) throws SQLException {
        User u = null;
        query = "select * from user where userId = '" + userId + "'";
        System.out.println(query);
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                u = new User();
                u.setUserId(userId);
                u.setEmail(rs.getString("email"));
                u.setfName(rs.getString("fName"));
                u.setlName(rs.getString("lName"));
                u.setCourseCode(rs.getString("courseCode"));
                u.setCourseMode(rs.getString("courseMode"));
                u.setCourseTitle(rs.getString("courseTitle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }

        }
        return u;
    }

    public static void main(String[] args) throws SQLException {
        User user = new User("15005017", "Ayoub", "Kaoui", "", "TDI", "Development Informatique", "FULL", "ak123981", "k.ayoub@ntic.com", "student");
        UserDAO udao = new UserDAO();
        //udao.addUser(user);
        user = new User();
        user.setUserId("15025017");
        user.setPassword("123.@pol");
        //udao.findUserByID(user);
        udao.findUserByLoginDetails(user);
        System.out.println(user.getOccupation());
    }

}
