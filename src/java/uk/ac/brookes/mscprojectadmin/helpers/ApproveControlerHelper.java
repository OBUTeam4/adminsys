/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.helpers;

import java.sql.SQLException;
import java.util.Map;
import uk.ac.brookes.mscprojectadmin.beans.Approval;
import uk.ac.brookes.mscprojectadmin.beans.User;
import uk.ac.brookes.mscprojectadmin.dao.ApprovalDAO;
import uk.ac.brookes.mscprojectadmin.dao.DissRegistrationDAO;
import uk.ac.brookes.mscprojectadmin.dao.UserDAO;

/**
 *
 * @author Quentin
 */
public class ApproveControlerHelper {

    UserDAO userdao;
    DissRegistrationDAO diss;
    Map<String, String> formErrors;
    ApprovalDAO approvalDao;

    /**
     *
     */
    public ApproveControlerHelper() {
        userdao = new UserDAO();
        diss = new DissRegistrationDAO();
        approvalDao = new ApprovalDAO();
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public User getStudentInfosFromId(String id) throws SQLException {
        return userdao.getUserbyId(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public Approval getApprovalFromId(int id) {
        return approvalDao.getApprovalFromId(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean findRegistrationByID(int id) throws SQLException {
        return diss.findRegistrationByID(id);
    }

    /**
     *
     * @param registrationId
     * @param approval
     * @return
     * @throws SQLException
     */
    public boolean addSupervisorApprovalToRegistrationForm(int registrationId, Approval approval) throws SQLException {
        return approvalDao.addSupervisorApprovalToRegistrationForm(registrationId, approval);
    }

    /**
     *
     * @param registrationId
     * @param approval
     * @return
     * @throws SQLException
     */
    public boolean addModuleLeaderApprovalToRegistrationForm(int registrationId, Approval approval) throws SQLException {
        return approvalDao.addModuleLeaderApprovalToRegistrationForm(registrationId, approval);
    }

    /**
     *
     * @param approval
     * @return
     * @throws SQLException
     */
    public int addApproval(Approval approval) throws SQLException {
        return approvalDao.addApproval(approval);
    }
}
