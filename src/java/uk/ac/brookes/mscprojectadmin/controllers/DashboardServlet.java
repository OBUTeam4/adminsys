/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.brookes.mscprojectadmin.beans.Ethics1;
import uk.ac.brookes.mscprojectadmin.beans.Ethics2;
import uk.ac.brookes.mscprojectadmin.beans.Event;
import uk.ac.brookes.mscprojectadmin.beans.Project;
import uk.ac.brookes.mscprojectadmin.beans.RegistrationForm;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.dao.DissRegistrationDAO;
import uk.ac.brookes.mscprojectadmin.helpers.DashboardControlerHelper;
import uk.ac.brookes.mscprojectadmin.helpers.EthicsFormControllerHelper;
import uk.ac.brookes.mscprojectadmin.helpers.FormsControlerHelper;

/**
 *
 * @author Quentin
 */
@WebServlet(name = "DashboardServlet", urlPatterns = {"/auth/dashboard"})
public class DashboardServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dashboardURL = "";
        // retrieve user session
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        FormsControlerHelper forms = new FormsControlerHelper();
        EthicsFormControllerHelper eforms = new EthicsFormControllerHelper();
        

        DashboardControlerHelper dashControlerHelper = new DashboardControlerHelper();
        try {
            dashboardURL = dashControlerHelper.getDashboardFromUserOccupation(u);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(u.getOccupation().equals("student")){
            
            // check if existing registration in db
            String addRegistrationFormURL = "/auth/dissertationRegistration?reg=1";
            String addRegistrationFormText= "Registration Form not submitted yet!";
            request.setAttribute("studentRegistrationFormURL", addRegistrationFormURL);
            request.setAttribute("studentRegistrationFormText", addRegistrationFormText);
            // else display link
            
            //Retrieve any submission student has made
            Project p = forms.getDissProject(u.getUserId());
            if(p!=null){
                String pStatus = new DissRegistrationDAO().getRegistrationApproval(p.getRegistrationForm().getRegistrationFormId());
                if(!pStatus.equals("disapproved")){
                    Ethics1 e1 = eforms.getEthics1Form(p.getRegistrationForm().getRegistrationFormId());
                    Ethics2 e2 = eforms.getEthics2Form(p.getRegistrationForm().getRegistrationFormId());
                    
                    session.setAttribute("registration", p.getRegistrationForm());
                    session.setAttribute("project", p);
                    
                    if(e1 != null){
                        session.setAttribute("ethics1", e1);
                    }
            
                    if(e2 != null){
                        session.setAttribute("ethics2", e2);
                    }
                }
                else{
                    request.setAttribute("disapproval", "(NOTE: Your last registration has been disapproved. See feedback for more details)");
                }
                
                
                
                
            }
            
            //Retrieve Upcoming events
            
            session.setAttribute("regevent", dashControlerHelper.getAnEvent("registration"));
            session.setAttribute("finalevent", dashControlerHelper.getAnEvent("final"));
            session.setAttribute("demoevent", dashControlerHelper.getAnEvent("demo"));
            session.setAttribute("paperevent", dashControlerHelper.getAnEvent("paper"));
            session.setAttribute("propevent", dashControlerHelper.getAnEvent("proposal"));
        }
        
        request.getRequestDispatcher(dashboardURL).forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
        
        
    }

    
}
