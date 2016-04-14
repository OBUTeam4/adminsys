/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uk.ac.brookes.mscprojectadmin.beans.Event;

/**
 *
 * @author oussamak
 */
public class DashboardDAO extends ClassDAO{
    
    /**
     *
     * @param semesterId
     * @return
     */
    public List<Event> getDissSemesterEvents(int semesterId){
        ArrayList<Event> events = new ArrayList<>();
        try{
            stmt = con.createStatement();
            String query = "SELECT * FROM `event` WHERE `semesterId` = "+semesterId;
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Event event = new Event();
                event.setEventId(rs.getInt("eventId"));
                event.setEventDesc(rs.getString("event"));
                event.setStartDate(parstDateToString(rs.getDate("startDate")));
                event.setDueDate(parstDateToString(rs.getDate("dueDate")));
                event.setRecipient(rs.getString("recipient"));
                event.setFlag(rs.getString("flag"));
                
                events.add(event);
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            stmt = null;
            rs = null;
        }
        
        return events;
    }
}
