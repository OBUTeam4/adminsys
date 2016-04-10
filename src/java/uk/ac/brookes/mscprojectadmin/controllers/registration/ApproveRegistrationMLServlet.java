/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.controllers.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.brookes.mscprojectadmin.beans.Approval;
import uk.ac.brookes.mscprojectadmin.beans.Ethics1;
import uk.ac.brookes.mscprojectadmin.beans.Ethics2;
import uk.ac.brookes.mscprojectadmin.beans.Project;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.helpers.ApproveControlerHelper;
import uk.ac.brookes.mscprojectadmin.helpers.EthicsFormControllerHelper;
import uk.ac.brookes.mscprojectadmin.helpers.FormsControlerHelper;

/**
 *
 * @author Quentin
 */
@WebServlet(name = "EditApproveRegistrationMLServlet", urlPatterns = {"/auth/approveRegistrationModuleLeader"})
public class ApproveRegistrationMLServlet extends HttpServlet {

    private int id;
    private ApproveControlerHelper approveControlerHelper;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
         =================================================
         ============== EDIT / APPROVE ===================
         =================================================
         */
        EthicsFormControllerHelper ethicsFormControllerHelper = new EthicsFormControllerHelper();
        FormsControlerHelper formsControlerHelper = new FormsControlerHelper();
        this.approveControlerHelper = new ApproveControlerHelper();

        // retrieve registration form id from URL.
        this.id = Integer.parseInt(request.getParameter("id"));

        // retrieve registration form 
        Project p = new Project();
        p = formsControlerHelper.getProjectRegistrationFromId(id);

        // retrieve ethics 1 & 2 data
        Ethics1 e1 = new Ethics1();
        Ethics2 e2 = new Ethics2();
        e1 = ethicsFormControllerHelper.getEthics1Form(id);
        e2 = ethicsFormControllerHelper.getEthics2Form(id);

        // retrieve and display student data 
        User student = new User();
        try {
            student = approveControlerHelper.getStudentInfosFromId(p.getStudentId());
        } catch (SQLException ex) {
            Logger.getLogger(ApproveRegistrationMLServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("s", student);

        // display registration DATA
        request.setAttribute("project", p);

        // System.out.println("Supervisor status: " + p.getRegistrationForm().getSupervisorApproval().getApprovalStatus());
        // display ethics 1 DATA
        if (e1 != null) {
            request.setAttribute("e1", e1);
        }

        // display ethics 2 DATA
        if (e2 != null) {
            request.setAttribute("ptype", e2.getPtype());
            request.setAttribute("funded", e2.getFunded());
            request.setAttribute("summary", e2.getSummary());
            request.setAttribute("participants", e2.getParticipants());
            request.setAttribute("details", e2.getDetails());
            request.setAttribute("estimate", e2.getEstimate());
            request.setAttribute("plan", e2.getPlan());
            request.setAttribute("steps", e2.getSteps());

            System.out.println("print e2");
        }

        // populate assessor and supervisor listbox 
        // retrieve assessor ID and supervisor ID from reg form
        String selectedAssessorId = p.getRegistrationForm().getSupervisor().getUserId();
        String selectedSupervisorId = p.getRegistrationForm().getAssessor().getUserId();
        try {
            request.setAttribute("assessors", formsControlerHelper.getAssessors());
            request.setAttribute("supervisors", formsControlerHelper.getSupervisors());
            request.setAttribute("selectedAssessor", selectedAssessorId);
            request.setAttribute("selectedSupervisor", selectedSupervisorId);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/auth/approve/approveRegistrationML.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String act = "";
        Boolean registrationExist = false;
        String message = "";
        this.approveControlerHelper = new ApproveControlerHelper();

        // retrieve button action 
        act = request.getParameter("act");

        // retrieve user occupation from session:
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");

        try {
            // check existence of registrationID 
            if (approveControlerHelper.findRegistrationByID(id)) {
                registrationExist = true;
            } else { // else redirect to previous list
                response.sendRedirect(request.getContextPath() + "/auth/listRegistrationForms");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApproveRegistrationSupervisorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // case for supervisor
        if (u.getOccupation().equals("module leader") && registrationExist == true) {
            System.out.println("You are a module leader on Approval registration page");

            String feedback = request.getParameter("comment").trim();

            Approval approval = new Approval();
            approval.setUserId(u.getUserId());
            approval.setFeedbacks(feedback);

            Date today = new Date();
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(today);
            approval.setApprovalDate(formattedDate);

            // retrieve button action: approve or disapprove. 
            if (act.equals("Disapprove")) {
                System.out.println("Disapprove");

                approval.setApprovalStatus("disapproved");
            } else if (act.equals("Approve")) {
                System.out.println("Approve");

                approval.setApprovalStatus("approved");
                //approveControlerHelper.addApproval(approval);
            } else {  // case act is null or HTML was modified
                response.sendRedirect(request.getContextPath() + "/auth/listRegistrationForms");
            }

            try {
                boolean addModuleLeaderApprovalToRegistrationForm = approveControlerHelper.addModuleLeaderApprovalToRegistrationForm(id, approval);
                message = "Registration form " + act + "d";
                //approveControlerHelper.addApproval(approval);
            } catch (SQLException ex) {
                Logger.getLogger(ApproveRegistrationSupervisorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        // allow to edit supervisor
        // allow to edit supervisor 
        // stay on same page
        // show message
        //request.setAttribute("message", message);
        //request.setAttribute("id", id);
        //this.getServletContext().getRequestDispatcher("/auth/approve/approveRegistrationSupervisor.jsp").forward(request, response);
        // redirect to list. 
        response.sendRedirect(request.getContextPath() + "/auth/listRegistrationForms");

    }

}
