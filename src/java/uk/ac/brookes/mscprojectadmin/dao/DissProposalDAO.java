/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uk.ac.brookes.mscprojectadmin.beans.Approval;
import uk.ac.brookes.mscprojectadmin.beans.Project;
import uk.ac.brookes.mscprojectadmin.beans.RegistrationForm;
import uk.ac.brookes.mscprojectadmin.beans.User;

/**
 *
 * @author Quentin
 */
public class DissProposalDAO extends ClassDAO {

    public DissProposalDAO() {
        super();
    }
    
    // retrieve list of project waiting for proposal
    public List<Project> getProposalForSupervisor(String supervisorId) {
        List<Project> list = new ArrayList<Project>();
        try {
            stmt = con.createStatement();
            String query = "SELECT u.fName, u.lName, u.userId as studentId, p.dissertationTitle, p.projectId, rf.registrationFormId, rf.supervisorId from project p "
                    + "INNER JOIN user u ON p.studentId = u.userId "
                    + "INNER JOIN registrationform rf ON rf.registrationFormId = p.registrationFormId "
                    + "WHERE p.proposalAssessmentId IS NULL"
                    + " AND rf.status = 'approved' "
                    + "AND rf.supervisorId = '" + supervisorId + "'";

            System.out.println(query);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Project p = new Project();
                RegistrationForm rf = new RegistrationForm(rs.getInt("registrationFormId"));
                User student = new User(rs.getString("studentId"));
                User supervisor = new User(rs.getString("supervisorId"));

                p.setDissertationTitle(rs.getString("dissertationTitle"));
                p.setStudentId(rs.getString("studentId"));
                
                student.setfName(rs.getString("fName"));
                student.setlName(rs.getString("lName"));

                rf.setSupervisor(supervisor);
                rf.setProject(p);
                rf.setStudent(student);

                p.setRegistrationForm(rf);
                p.setProjectId(rs.getInt("projectId"));

                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }
        return list;
    }

    // retrieve proposal REVIEWED BY supervisor 
    public List<Project> getProposalReviewedBySupervisor(String supervisorId) {
        List<Project> list = new ArrayList<Project>();
        try {
            stmt = con.createStatement();
            String query = "SELECT u.fName, u.lName, u.userId as studentId, p.dissertationTitle, p.projectId, rf.registrationFormId, rf.supervisorId from project p"
                    + " INNER JOIN user u ON p.studentId = u.userId "
                    + "INNER JOIN registrationform rf ON rf.registrationFormId = p.registrationFormId "
                    + "WHERE p.proposalAssessmentId IS NOT NULL "
                    + "AND rf.status = 'approved' "
                    + "AND rf.supervisorId = '" + supervisorId + "'";

            //System.out.println(query);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Project p = new Project();
                RegistrationForm rf = new RegistrationForm(rs.getInt("registrationFormId"));
                User student = new User(rs.getString("studentId"));
                User assessor = new User(rs.getString("assessorId"));
                User supervisor = new User(rs.getString("supervisorId"));
               // Approval moduleLeaderApproval = new Approval(rs.getInt("moduleLeaderApprovalID"));
               // Approval supervisorApproval = new Approval(rs.getInt("supervisorApprovalID"));

                // approval infos
              //  supervisorApproval.setApprovalStatus(rs.getString("status"));
              //  supervisorApproval.setFeedbacks(rs.getString("feedbacks"));
             //   supervisorApproval.setApprovalDate(rs.getString("date"));

                p.setDissertationTitle(rs.getString("dissertationTitle"));
                p.setStudentId(rs.getString("studentId"));

                student.setfName(rs.getString("fName"));
                student.setlName(rs.getString("lName"));

                rf.setAssessor(assessor);
                rf.setSupervisor(supervisor);
                rf.setProject(p);
                rf.setStudent(student);
              //  rf.setModuleLeaderApproval(moduleLeaderApproval);
             //   rf.setSupervisorApproval(supervisorApproval);

                p.setRegistrationForm(rf);
                //System.out.println("moduleLeaderApproval " +moduleLeaderApproval);
                //System.out.println("moduleLeaderApproval " + supervisorApproval);

                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }
        return list;
    }
    
    
    
}
