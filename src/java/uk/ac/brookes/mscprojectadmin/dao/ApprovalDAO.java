/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import uk.ac.brookes.mscprojectadmin.beans.Approval;
import uk.ac.brookes.mscprojectadmin.beans.User;

/**
 *
 * @author Quentin
 */
public class ApprovalDAO extends ClassDAO {

    /**
     *
     */
    public ApprovalDAO() {
        super();
    }

    // add a new approval and return id 

    /**
     *
     * @param approval
     * @return
     * @throws SQLException
     */
    public int addApproval(Approval approval) throws SQLException {
        int approvalId = 0;
        String query = "INSERT INTO approval(userId, date, status, feedbacks) VALUES (?,?,?,?)";
        //System.out.println("add approval query: " + query);
        try {
            // prepared statement to avoid SQL injection
            preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, approval.getUserId());
            preparedStatement.setString(2, approval.getApprovalDate());
            preparedStatement.setString(3, approval.getApprovalStatus());
            preparedStatement.setString(4, approval.getFeedbacks());

            // execute insert
            preparedStatement.executeUpdate();
            rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                // return generated key
                approvalId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }
        System.out.println("Returned approval ID: " + approvalId);
        return approvalId;
    }
    // check existing registration
    // add Module Leader approval for a Registration Form

    /**
     *
     * @param registrationId
     * @param approval
     * @return
     * @throws SQLException
     */
    public boolean addModuleLeaderApprovalToRegistrationForm(int registrationId, Approval approval) throws SQLException {
        boolean updated = false;
        int addedApprovalId = 0;
        String supervisorStatus = "";
        String registrationStatus = "";
        String updateRegistrationFormApproval = "UPDATE registrationform SET moduleLeaderApprovalID = ?, status = ? "
                + " WHERE registrationFormId = ?";

        String retrieveSupervisorApproval = "SELECT a.status FROM registrationform rf "
                + "INNER JOIN approval a ON rf.supervisorApprovalID = a.approvalID "
                + "WHERE rf.registrationFormId = ?";
        try {
            // add approval and retrieve added ID.
            addedApprovalId = addApproval(approval);

            System.out.println("approval.getApprovalStatus() " + approval.getApprovalStatus());

            // retrieve supervisor status 
            preparedStatement = con.prepareStatement(retrieveSupervisorApproval);
            preparedStatement.setInt(1, registrationId);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                supervisorStatus = rs.getString("status");
            }

            if (supervisorStatus.equals(approval.getApprovalStatus())) {
                registrationStatus = supervisorStatus;
            } else {
                registrationStatus = "disapproved";
            }

            // update registration form with added approval ID
            preparedStatement = con.prepareStatement(updateRegistrationFormApproval);
            preparedStatement.setInt(1, addedApprovalId);
            preparedStatement.setString(2, registrationStatus);
            preparedStatement.setInt(3, registrationId);

            preparedStatement.executeUpdate();
            updated = true;
            System.out.println("Record updated into registrationForm table ");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return updated;
    }

    // add Supervisor approval for a Registration Form

    /**
     *
     * @param registrationId
     * @param approval
     * @return
     * @throws SQLException
     */
    public boolean addSupervisorApprovalToRegistrationForm(int registrationId, Approval approval) throws SQLException {
        boolean updated = false;
        int addedApprovalId = 0;
        String updateRegistrationFormApproval = "UPDATE registrationform SET supervisorApprovalID = ? "
                + " WHERE registrationFormId = ?";

        try {
            // add approval and retrieve added ID.
            addedApprovalId = addApproval(approval);

            // update registration form with added approval ID
            preparedStatement = con.prepareStatement(updateRegistrationFormApproval);
            preparedStatement.setInt(1, addedApprovalId);
            preparedStatement.setInt(2, registrationId);

            preparedStatement.executeUpdate();
            updated = true;
            System.out.println("Record updated into registrationForm table ");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return updated;
    }

    // get an approval by ID 

    /**
     *
     * @param id
     * @return
     */
    public Approval getApprovalFromId(int id) {
        Approval approval = null;
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM `approval` WHERE `approvalId` = " + id;
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                // User user = new User();
                approval = new Approval();
                approval.setApprovalId(id);
                approval.setUserId(rs.getString("userId"));
                approval.setApprovalStatus(rs.getString("status"));
                approval.setApprovalDate(rs.getString("date"));
                approval.setFeedbacks(rs.getString("feedbacks"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }
        return approval;
    }

    // get all approval
    // update approval
    // get all approval by status 
}
