/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.helpers;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import uk.ac.brookes.mscprojectadmin.beans.Event;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.dao.DashboardDAO;
import uk.ac.brookes.mscprojectadmin.dao.UserDAO;

/**
 *
 * @author Quentin
 */
public class DashboardControlerHelper {
    
    UserDAO userdao;
    String[] dashboardURLs = {"/studdash.jsp", "/supdash.jsp", "/assedash.jsp", "/admindash.jsp", "/mldash.jsp", "/eedash.jsp"};
    Map<String, String> loginErrors;
    DashboardDAO ddao;
    List<Event> events;

    public DashboardControlerHelper() {
        userdao = new UserDAO();
        ddao = new DashboardDAO();
        events = getUpcomingEvent(3);
    }

    public String getDashboardFromUserOccupation(User u) throws SQLException {
        String userOccupation;
        String profileUrl = "";

        userdao.findUserByLoginDetails(u);
        userOccupation = u.getOccupation();

        switch (userOccupation) {
            case "student":
                profileUrl = "/auth/dashboards/studdash.jsp";
                break;
            case "supervisor":
                profileUrl = "/auth/dashboards/supdash.jsp";
                break;
            case "assessor":
                profileUrl = "/auth/dashboards/assdash.jsp";
                break;
            case "administrator":
                profileUrl = "/auth/dashboards/admindash.jsp";
                break;
            case "module leader":
                profileUrl = "/auth/dashboards/mldash.jsp";
                break;
            case "examiner":
                profileUrl = "/auth/dashboards/eedash.jsp";
                break;
        }
        return profileUrl;
    }
    private List<Event> getUpcomingEvent(int semId){
        events = ddao.getDissSemesterEvents(3);
        return events;
    }
    
    public Event getAnEvent(String flag){
        Event e = null;
        for (int i=0; i<events.size(); i++){
            e = events.get(i);
            if (e.getFlag().equals(flag)){
                return e;
                
            }
        }
        return e;
    }
    
    
    
    
    
}
