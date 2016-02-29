
package uk.ac.brookes.mscprojectadmin.tools;

import java.sql.*;
public class DBConnection {
    
    private static DBConnection instance = null;
    private static Connection conn;
    
    private DBConnection(){
        // JDBC driver name and database URL
        String dbDriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mscproject_adminsys_db";
        //  Database credentials
        String username= "root";
        String password = "";
        
        try{
            Class.forName( dbDriver);
            conn = DriverManager.getConnection(url,username, password);
        }
        catch(ClassNotFoundException cnfErr){
            cnfErr.printStackTrace();
        }
        catch(SQLException err){
            err.printStackTrace();
        }
    }
    
    public static DBConnection getInstance(){
        if(instance == null)
            return new DBConnection();
        else
            return instance;
    }
    public static Connection getConnection(){
        return conn;
    }
    
   
   public static void main(String[] args) {
       DBConnection connect = DBConnection.getInstance();
       System.out.println(connect.getConnection());
       
   }
}
