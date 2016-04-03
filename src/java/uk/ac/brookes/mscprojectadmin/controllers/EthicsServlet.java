/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import uk.ac.brookes.mscprojectadmin.beans.Ethics1;
import uk.ac.brookes.mscprojectadmin.beans.Ethics2;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.helpers.EthicsFormControllerHelper;
import uk.ac.brookes.mscprojectadmin.helpers.FormsControlerHelper;

/**
 *
 * @author oussamak
 */
@WebServlet(name = "EthicsServlet", urlPatterns = {"/EthicsServlet"})
public class EthicsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User student = (User)session.getAttribute("user");
        EthicsFormControllerHelper eform = new EthicsFormControllerHelper();
        String message = null;
        
        //************************Ethics Form 1********************
        if(request.getParameter("ethics").equals("1")){
            try {
                message = eform.canSubmitEthics1(student.getUserId());
                if (message == null){
                    this.getServletContext().getRequestDispatcher("/auth/forms/EthicsForm1.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("message", message);
                    this.getServletContext().getRequestDispatcher("/auth/dashboards/studdash.jsp").forward(request, response);
                }
            } //*********************Ethics Form 2********************************
            catch (ParseException ex) {
                Logger.getLogger(EthicsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(request.getParameter("ethics").equals("2")){
            try {
                message = eform.canSubmitEthics2(student.getUserId());
                if (message == null){
                    this.getServletContext().getRequestDispatcher("/auth/forms/EthicsForm2.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("message", message);
                    this.getServletContext().getRequestDispatcher("/auth/dashboards/studdash.jsp").forward(request, response);
                }
            } catch (ParseException ex) {
                Logger.getLogger(EthicsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EthicsFormControllerHelper eForm = new EthicsFormControllerHelper();
        User student = (User)request.getSession().getAttribute("user");
        Map<String,String> errors = null;
        
        if(request.getParameter("ethics").equals("1")){//***************Ethics Form 1
            Ethics1 e1 = getEthics1(request);
            int result = eForm.addNewEthicsForm1(student.getUserId(), e1);
            if(result == 1){
                        request.setAttribute("success", "Congratulation, you have submitted your Ethics Form 1.");
                        this.getServletContext().getRequestDispatcher("/auth/forms/processRegistrationPage.jsp").forward(request, response);
            }
            
        }
        else if(request.getParameter("ethics").equals("2")){
            Ethics2 e2 = getEthics2(request);
            errors = eForm.validateInputs(e2);
            
            if(errors.size() == 0){
                int result = eForm.addNewEthicsForm2(student.getUserId(), e2);
                if(result == 1){
                    request.setAttribute("success", "Congratulation, you have submitted your Ethics Form 2.");
                    this.getServletContext().getRequestDispatcher("/auth/forms/processRegistrationPage.jsp").forward(request, response);
                }
            }
            else{
                request.setAttribute("ethics2", e2);
                request.setAttribute("errors", errors);
                this.getServletContext().getRequestDispatcher("/auth/forms/EthicsForm2.jsp").forward(request, response);
            }
        }

    }
    
    private Ethics2 getEthics2(HttpServletRequest request){
        Ethics2 e2 = new Ethics2();
        e2.setPtype(request.getParameter("ptype"));
        e2.setFunded(request.getParameter("funded"));
        e2.setEstimate(request.getParameter("estimate"));
        e2.setSteps(request.getParameter("steps"));
        e2.setSummary(request.getParameter("summary"));
        e2.setParticipants(request.getParameter("participants"));
        e2.setDetails(request.getParameter("details"));
        e2.setPlan(request.getParameter("plan"));
        return e2;
    }
    private Ethics1 getEthics1(HttpServletRequest request){
        Ethics1 e1 = new Ethics1();
        e1.setAnswer1(request.getParameter("answer1"));
        e1.setAnswer2(request.getParameter("answer2"));
        e1.setAnswer3(request.getParameter("answer3"));
        e1.setAnswer4(request.getParameter("answer4"));
        e1.setAnswer5(request.getParameter("answer5"));
        e1.setAnswer6(request.getParameter("answer6"));
        e1.setAnswer7(request.getParameter("answer7"));
        e1.setAnswer8(request.getParameter("answer8"));
        e1.setAnswer9(request.getParameter("answer9"));
        e1.setAnswer10(request.getParameter("answer10"));
        e1.setAnswer11(request.getParameter("answer11"));
        e1.setAnswer12(request.getParameter("answer12"));
        e1.setAnswer13(request.getParameter("answer13"));
        e1.setAnswer14(request.getParameter("answer14"));
        
        return e1;
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
