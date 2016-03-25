/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers.forms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        try {
            request.setAttribute("supervisors", formsControlerHelper.getSupervisors());
            request.setAttribute("assessors", formsControlerHelper.getAssessors());
        } catch (SQLException ex) {
            Logger.getLogger(DissertationRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.getServletContext().getRequestDispatcher("/auth/forms/AddRegistrationForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        
        String dissertationCode = request.getParameter("diss_mod_code").trim();
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
        formsControlerHelper.validateForm(literature, dissertationTitle, supervisor, assessor, hypothesis, subjectArea, projectAim, literature, hypothesis, deliverables);
        
        if(assessor != supervisor){
            
        } else {
            
        }
    }

}
