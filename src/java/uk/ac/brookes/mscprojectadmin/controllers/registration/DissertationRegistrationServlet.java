/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers.registration;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.brookes.mscprojectadmin.beans.Event;
import uk.ac.brookes.mscprojectadmin.beans.Project;
import uk.ac.brookes.mscprojectadmin.beans.RegistrationForm;
import uk.ac.brookes.mscprojectadmin.beans.Semester;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.helpers.FormsControlerHelper;

/**
 *
 * @author Quentin
 */
@WebServlet(name = "DissertationRegistrationServlet", urlPatterns = {"/auth/dissertationRegistration"})
public class DissertationRegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FormsControlerHelper formsControlerHelper = new FormsControlerHelper();
        HttpSession session = request.getSession();
        User student = (User)session.getAttribute("user");
        String message = null;
        try {     
           String reg = request.getParameter("reg"); 
        if(reg != null  && reg.equals("1")){
           message = formsControlerHelper.canSubmit(student);
           
           if (message == null){
               String flag = "registration";
               
               session.setAttribute("supervisors", formsControlerHelper.getSupervisors());
               session.setAttribute("assessors", formsControlerHelper.getAssessors());
               session.setAttribute("semester", formsControlerHelper.getDissSemester(3));
               session.setAttribute("codes", formsControlerHelper.getModuleCodes());
               session.setAttribute("event", formsControlerHelper.getRegistrationEvent(3,flag));
               
               this.getServletContext().getRequestDispatcher("/auth/forms/AddRegistrationForm.jsp").forward(request, response);
           }
           else{
               request.setAttribute("message", message);
              this.getServletContext().getRequestDispatcher("/auth/dashboard").forward(request, response);
           }
            
        }
        else if(request.getParameter("submit") != null){
            try {
                 message = formsControlerHelper.canSubmit(student);
                if (message == null){
                    Project project = (Project)session.getAttribute("project");
                    String supervisorName = (String)session.getAttribute("supervisor");
                    String assessorName = (String)session.getAttribute("assessor");
                    String moduleCode = (String)session.getAttribute("moduleCode");
                    
                    int result = formsControlerHelper.addNewProjectRegistration(student,project,supervisorName,assessorName,moduleCode);
                    if(result == 1){
                        request.setAttribute("success", "Congratulation, your registration now is submitted and waiting decision.");
                        this.getServletContext().getRequestDispatcher("/auth/forms/processRegistrationPage.jsp").forward(request, response);
                        
                        //Clean objects from session
                        session.setAttribute("project", null);
                        session.setAttribute("supervisor", null);
                        session.setAttribute("assessor", null);
                        session.setAttribute("moduleCode", null);
                    }
                }
                else{
                    request.setAttribute("message", message);
                    this.getServletContext().getRequestDispatcher("/auth/forms/confirmRegistrationPage.jsp").forward(request, response);
                }
            } catch (ParseException ex) {
                Logger.getLogger(DissertationRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(request.getParameter("edit") != null){
            this.getServletContext().getRequestDispatcher("/auth/forms/AddRegistrationForm.jsp").forward(request, response);
        }
    
            //request.setAttribute("registrationDeadline", formsControlerHelper.getRegistrationDeadline());
        } catch (SQLException ex) {
            Logger.getLogger(DissertationRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ParseException ex) {
                Logger.getLogger(DissertationRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        
        String dissertationCode = request.getParameter("diss_mod_code");
        String dissertationTitle = request.getParameter("diss_title").trim();
        String supervisor = request.getParameter("supervisor").trim();
        String assessor = request.getParameter("assessor").trim();
        String relatedParties = request.getParameter("diss_parties").trim();
        String subjectArea =  request.getParameter("subjectArea").trim();
        String projectAim =  request.getParameter("projectAim").trim();
        String literature = request.getParameter("literature").trim();
        String hypothesis = request.getParameter("diss_hypothesis").trim();
        String deliverables = request.getParameter("diss_deliverables").trim();

        FormsControlerHelper formsControlerHelper = new FormsControlerHelper();
        Map errors = formsControlerHelper.validateRegInputs(dissertationCode, dissertationTitle, supervisor, assessor, relatedParties,
                                    subjectArea, projectAim, literature, hypothesis, deliverables);
        
        Project p = new Project();
        p.setDeliverables(deliverables);
        p.setDissertationTitle(dissertationTitle);
        p.setHypothesis(hypothesis);
        p.setLiterature(literature);
        p.setProjectAim(projectAim);
        p.setRelatedParties(relatedParties);
        p.setSubjectArea(subjectArea);
        
        HttpSession session = request.getSession();
        session.setAttribute("project", p);
        session.setAttribute("supervisor", supervisor);
        session.setAttribute("assessor", assessor);
        session.setAttribute("moduleCode", dissertationCode);
        
        
        if (!errors.isEmpty()){
            request.setAttribute("errors", errors);
            doGet(request, response);
        }
        else{
            this.getServletContext().getRequestDispatcher("/auth/forms/confirmRegistrationPage.jsp").forward(request, response);
        }
        

    }
    

}
