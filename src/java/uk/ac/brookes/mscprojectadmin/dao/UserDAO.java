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
    
    public UserDAO(){
        createConnection();
                       // System.out.println(con);
    }
    /*
    * This method will look for a user by his login details, ID number and password. 
    * Once the user is found setUserData will be called to set the user data
    */
    
    public boolean findUserByLoginDetails(User user) throws SQLException{
        boolean found = false;
        query = "select * from supervisor where staffNo = '"+user.getIdNumber()+"'";
                        System.out.println("begining");
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
                                System.out.println("111");

            if(rs.next()){
                System.out.println("Next OK");
                if(user.getPassword().equals(rs.getString("pw"))){
                    found = true;
                    setUserData(user, rs.getString("fName"), rs.getString("lName"), rs.getString("email"), rs.getString("occupation"));
                                    System.out.println("after ");

                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            if (stmt != null){
                stmt.close();
            } 
        }
        
        return found;
    }
    
    private void setUserData(User user, String fName, String lName, String email, String occupation){
        user.setFirstName(fName);
        user.setLastName(lName);
        user.setEmail(email);
        user.setOccupation(occupation);
    }
    
    public User addUser(User user){
        
        return user;
    }
    
    private void createConnection(){
        connect = DBConnection.getInstance();
        con = connect.getConnection();
    }
    
}
