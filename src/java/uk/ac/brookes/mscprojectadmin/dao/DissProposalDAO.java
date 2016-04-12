/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uk.ac.brookes.mscprojectadmin.beans.Approval;
import uk.ac.brookes.mscprojectadmin.beans.Criteria;
import uk.ac.brookes.mscprojectadmin.beans.Project;
import uk.ac.brookes.mscprojectadmin.beans.Proposal;
import uk.ac.brookes.mscprojectadmin.beans.RegistrationForm;
import uk.ac.brookes.mscprojectadmin.beans.User;

/**
 *
 * @author Quentin
 */
public class DissProposalDAO extends ClassDAO {

    private CriteriaDAO criteriaDao;
    private ApprovalDAO approvalDAO;

    public DissProposalDAO() {
        super();
    }

    // add the proposal assessment to the DB. 
    public int addProposal(Proposal proposal, Criteria intro, Criteria methodology, Criteria progress, Criteria writtenPresentation, Criteria projectPlan, Approval supervisorApproval) throws SQLException {
        int proposalID = 0;

        int introCriteriaID = 0;
        int methodologyID = 0;
        int progressID = 0;
        int writtenPresentationID = 0;
        int projectPlanID = 0;

        int approvalID = 0;
        String query = "INSERT INTO `proposalassessment`(`mark`, `total`, `comments`, `supervisorId`, `introId`, `methodologyId`, `progressId`, `writtenPresentationId`, "
                + "`projectPlanId, "
                + "`approvalId`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        //System.out.println("add approval query: " + query);
        try {
            // add intro criteria
            introCriteriaID = criteriaDao.addCriteria(intro);

            // add methodology criteria
            methodologyID = criteriaDao.addCriteria(methodology);

            // add progress criteria
            progressID = criteriaDao.addCriteria(progress);

            // add written presentation criteria
            writtenPresentationID = criteriaDao.addCriteria(writtenPresentation);

            // add project plan criteria
            projectPlanID = criteriaDao.addCriteria(projectPlan);

            // add approval 
            approvalID = approvalDAO.addApproval(supervisorApproval);

            // prepared statement to avoid SQL injection
            preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, proposal.getMark());
            preparedStatement.setString(2, proposal.getTotal());
            preparedStatement.setString(3, proposal.getComments());
            preparedStatement.setInt(4, proposal.getSupervisorId());
            preparedStatement.setInt(5, introCriteriaID);
            preparedStatement.setInt(6, methodologyID);
            preparedStatement.setInt(7, progressID);
            preparedStatement.setInt(8, writtenPresentationID);
            preparedStatement.setInt(9, projectPlanID);
            preparedStatement.setInt(10, approvalID);

            // execute insert
            preparedStatement.executeUpdate();
            rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                // return generated key
                proposalID = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (con != null) {
                con.close();
            }

        }
        System.out.println("Returned proposalID : " + proposalID);
        return proposalID;
    }
    
     // add the ID of the proposal Assessment to the project table
    public boolean addProposalAssessmentIdToProject(int proposalID, int projectID) throws SQLException {
        boolean updated = false;
        int addedProposalId = 0;
        String updateProject = "UPDATE project SET proposalAssessmentId = ? "
                + " WHERE projectId = ?";

        try {
            // update registration form with added approval ID
            preparedStatement = con.prepareStatement(updateProject);
            preparedStatement.setInt(1, proposalID);
            preparedStatement.setInt(2, projectID);

            preparedStatement.executeUpdate();
            updated = true;
            System.out.println("Record updated into project table ");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return updated;
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
    /**
     *
     * @param supervisorId
     * @return
     */
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
