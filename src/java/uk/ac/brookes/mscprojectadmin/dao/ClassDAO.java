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
import java.text.SimpleDateFormat;
import java.util.Date;
import uk.ac.brookes.mscprojectadmin.tools.DBConnection;

/**
 *
 * @author oussamak
 */
public class ClassDAO {
    protected DBConnection connect;
    protected Connection con;
    protected Statement stmt;
    protected ResultSet rs;
    protected String query;
    
    protected ClassDAO(){
        createConnection();
    }
    
    private void createConnection() {
        connect = DBConnection.getInstance();
        con = connect.getConnection();
    }
    
    protected String parstDateToString(Date date){
        String formattedDate = new SimpleDateFormat("EEEE dd MMMM YYYY").format(date);
        return formattedDate;
    }
    
    protected String parseDateToYYYYMMDD(Date date){
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return formattedDate; 
    }
    
    protected int getLastRecordFormTable(String table, String column){
        
        int id=0;
        try{
            stmt = con.createStatement();
            String query = "select `"+column+"` from `"+table+"` order by `"+column+"` desc limit 1";
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                id = rs.getInt(column);
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            stmt = null;
            rs = null;
        }
        return id;
    }
    
}
