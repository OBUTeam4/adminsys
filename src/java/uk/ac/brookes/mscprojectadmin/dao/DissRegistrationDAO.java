/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import uk.ac.brookes.mscprojectadmin.beans.Semester;
import uk.ac.brookes.mscprojectadmin.beans.User;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import uk.ac.brookes.mscprojectadmin.beans.Approval;
import uk.ac.brookes.mscprojectadmin.beans.Ethics1;
import uk.ac.brookes.mscprojectadmin.beans.Ethics2;
import uk.ac.brookes.mscprojectadmin.beans.Event;
import uk.ac.brookes.mscprojectadmin.beans.Project;
import uk.ac.brookes.mscprojectadmin.beans.RegistrationForm;

/**
 *
 * @author oussamak
 */
public class DissRegistrationDAO extends ClassDAO {

    public DissRegistrationDAO() {
        super();
    }

    public Semester getDissSemester(int semesterId) {
        Semester semester = null;
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM `semester` WHERE `semesterId`= " + semesterId;
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                semester = new Semester(rs.getInt("semesterId"),
                        rs.getDate("startDate"),
                        rs.getDate("completionDate"),
                        rs.getString("moduleCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }

        return semester;
    }

    public Event getRegistrationEvent(int semesterId, String flag) {
        Event event = null;
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM `event` WHERE `semesterId` = " + semesterId + " AND `flag` = '" + flag + "'";
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                event = new Event();
                event.setEventId(rs.getInt("eventId"));
                event.setEventDesc(rs.getString("event"));
                event.setStartDate(parstDateToString(rs.getDate("startDate")));
                event.setDueDate(parstDateToString(rs.getDate("dueDate")));
                event.setRecipient(rs.getString("recipient"));
                event.setFlag(rs.getString("flag"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }

        return event;
    }

    public List<Semester> getModuleCodes() {
        ArrayList<Semester> codes = new ArrayList<>();
        try {
            stmt = con.createStatement();
            String query = "SELECT `semesterId`,`moduleCode` FROM `semester`";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Semester s = new Semester();
                s.setSemesterId(rs.getInt("semesterId"));
                s.setModuleCode(rs.getString("moduleCode"));

                codes.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }

        return codes;

    }

    public Project getStudentProject(String studentId) {
        Project project = null;

        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM `project` p inner join `registrationform` rf"
                    + " on p.`registrationformId` = rf.`registrationformId`"
                    + " and `studentId`='" + studentId + "' order by p.`registrationformId` desc limit 1";
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                project = new Project();
                RegistrationForm rf = new RegistrationForm();
                User assessor = new User(rs.getString("assessorId"));
                User supervisor = new User(rs.getString("supervisorId"));
                Approval supApproval = new Approval(rs.getInt("supervisorApprovalId"));
                Approval mlApproval = new Approval(rs.getInt("moduleLeaderApprovalId"));
                Semester sem = new Semester(rs.getInt("semesterId"));

                project.setProjectId(rs.getInt("projectId"));
                project.setDeliverables(rs.getString("deliverables"));
                project.setDissertationTitle(rs.getString("dissertationTitle"));
                project.setHypothesis(rs.getString("hypothesis"));
                project.setLiterature(rs.getString("literature"));
                project.setProjectAim(rs.getString("projectAim"));
                project.setRelatedParties(rs.getString("relatedParties"));
                project.setSubjectArea(rs.getString("subjectArea"));

                rf.setRegistrationFormId(rs.getInt("registrationFormId"));
                rf.setAssessor(assessor);
                rf.setSupervisor(supervisor);
                rf.setSupervisorApproval(supApproval);
                rf.setModuleLeaderApproval(mlApproval);
                rf.setStatus(rs.getString("status"));
                rf.setRegistrationDate(parstDateToString(rs.getDate("registrationDate")));
                rf.setSemester(sem);

                project.setRegistrationForm(rf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }

        return project;

    }

    public int getRegistrationFormIdByStudent(String studentId) {
        int regfId = 0;
        System.out.println("studentId = " + studentId);
        try {
            stmt = con.createStatement();
            String query = "select `registrationformId` from `project` where `studentId` ='" + studentId + "' "
                    + "order by `registrationFormId` desc limit 1";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                regfId = rs.getInt("registrationFormId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }
        return regfId;
    }

    public String getRegistrationApproval(int registrationId) {
        String status = "";

        try {
            stmt = con.createStatement();
            String query = "select ap.`status` from `registrationform` rf "
                    + "inner join approval ap on rf.`supervisorApprovalId` = ap.`approvalId`"
                    + "AND rf.`supervisorId` = ap.`userId` AND rf.`registrationFormId` =" + registrationId;
            rs = stmt.executeQuery(query);

            if (rs.next()) {

                status = rs.getString("status");
                System.out.println(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }
        System.out.println(status);
        return status;
    }

    public int addProjectRegistration(User student, Project p, String supervisorName, String assessorName, String moduleCode) {

        //Registration insert
        int regId = getLastRecordFormTable("registrationForm", "registrationformId") + 1;
        String status = "submitted";

        int resultReg = addRegistrationRecord(regId, getUserId(supervisorName), getUserId(assessorName), parseDateToYYYYMMDD(new Date()), status,
                getSemesterId(moduleCode));
        int resultPro = 0;
        if (resultReg != 0) {
            resultPro = addProjectRecord(student, p);
            if (resultPro != 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    private int addProjectRecord(User student, Project p) {
        int projId = getLastRecordFormTable("project", "projectId") + 1;
        int regId = getLastRecordFormTable("registrationForm", "registrationformId");

        String query = "INSERT INTO `mscprojectadmin`.`project` (`projectId`,`studentId`,`registrationFormId`, "
                + "`dissertationTitle`,`relatedParties`,`deliverables`,`hypothesis`,`literature`,`projectAim`,"
                + "`subjectArea`) VALUES (" + projId + ",'" + student.getUserId() + "'," + regId + ",'" + p.getDissertationTitle() + "',"
                + "'" + p.getRelatedParties() + "','" + p.getDeliverables() + "','" + p.getHypothesis() + "','" + p.getLiterature() + "',"
                + "'" + p.getProjectAim() + "','" + p.getSubjectArea() + "')";
        System.out.println(query);
        int result = 0;
        try {
            stmt = con.createStatement();
            result = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }

        return result;
    }

    private int addRegistrationRecord(int regId, String supId, String assId, String regDate, String status, int semId) {
        String query = "INSERT INTO `mscprojectadmin`.`registrationform` "
                + "(`registrationFormId`,`registrationDate`,`status`,`supervisorId`,"
                + "`assessorId`,`semesterId`) VALUES "
                + "(" + regId + ",'" + regDate + "','" + status + "','" + supId + "','" + assId
                + "'," + semId + ")";

        int result = 0;
        try {
            stmt = con.createStatement();
            result = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }

        return result;

    }

    private int getSemesterId(String moduleCode) {
        int semesterId = 0;
        try {
            stmt = con.createStatement();
            String query = "Select `semesterId` from `semester` where `moduleCode`='" + moduleCode + "'";
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                semesterId = rs.getInt("semesterId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }
        return semesterId;
    }

    private String getUserId(String name) {
        String userId = null;
        try {
            stmt = con.createStatement();
            String query = "select `userId` from `user` where concat_ws(' ',`fName`,`lName`)='" + name + "'";
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                userId = rs.getString("userId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }
        return userId;
    }

    // retrieve dissertation registration forms WAITING for module leader approval 
    public List<Project> getSubmittedRegFormsForML(String moduleLeaderId) {
        List<Project> list = new ArrayList<Project>();
        try {
            stmt = con.createStatement();

            String query = "SELECT u.fName, u.lName, u.userId as studentId, p.dissertationTitle, rf.registrationFormId, rf.assessorId, rf.supervisorId, rf.supervisorApprovalID, "
                    + "rf.moduleLeaderApprovalID, aSup.userId as SUP_ApprovingID, aSup.status as SUP_status, aSup.feedbacks as SUP_feedbacks, aSup.date as SUP_date"
                    + " FROM registrationform rf"
                    + " LEFT JOIN project p ON p.registrationFormId = rf.registrationFormId"
                    + " LEFT JOIN User u on p.studentId = u.userId"
                    + " LEFT JOIN Approval aSup on aSup.approvalId = rf.supervisorApprovalID"
                    + " WHERE rf.moduleLeaderApprovalID IS NULL"
                    + " GROUP BY rf.registrationFormId";

            /*
             String query = "SELECT u.fName, u.lName, u.userId as studentId, p.dissertationTitle, rf.registrationFormId, rf.assessorId, rf.supervisorId, rf.supervisorApprovalID,"
                    + " rf.moduleLeaderApprovalID "
                    + "FROM registrationform rf "
                    + "INNER JOIN project p ON p.registrationFormId = rf.registrationFormId "
                    + "INNER JOIN User u on p.studentId = u.userId "
                    + "WHERE rf.supervisorApprovalID IS NOT NULL "
                    + "AND rf.moduleLeaderApprovalID IS NULL ";
             */
            System.out.println(query);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Project p = new Project();
                RegistrationForm rf = new RegistrationForm(rs.getInt("registrationFormId"));
                User student = new User(rs.getString("studentId"));
                User assessor = new User(rs.getString("assessorId"));
                User supervisor = new User(rs.getString("supervisorId"));
                Approval moduleLeaderApproval = new Approval(rs.getInt("moduleLeaderApprovalID"));
                Approval supervisorApproval = new Approval(rs.getInt("supervisorApprovalID"));

                // approval infos
                supervisorApproval.setApprovalId(rs.getInt("supervisorApprovalID"));
                supervisorApproval.setApprovalStatus(rs.getString("SUP_status"));
                supervisorApproval.setFeedbacks(rs.getString("SUP_feedbacks"));
                supervisorApproval.setApprovalDate(rs.getString("SUP_date"));

                p.setDissertationTitle(rs.getString("dissertationTitle"));
                p.setStudentId(rs.getString("studentId"));

                student.setfName(rs.getString("fName"));
                student.setlName(rs.getString("lName"));

                rf.setAssessor(assessor);
                rf.setSupervisor(supervisor);
                rf.setProject(p);
                rf.setStudent(student);
                rf.setModuleLeaderApproval(moduleLeaderApproval);
                rf.setSupervisorApproval(supervisorApproval);

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

    // retrieve dissertation registration REVIEWED BY ML 
    public List<Project> getReviewedRegFormsForML(String moduleLeaderId) {
        List<Project> list = new ArrayList<Project>();
        try {
            stmt = con.createStatement();
            String query = "SELECT u.fName, u.lName, u.userId as studentId, p.dissertationTitle, rf.registrationFormId, rf.assessorId, rf.supervisorId, rf.supervisorApprovalID, rf.status as rfStatus, "
                    + " rf.moduleLeaderApprovalID, aSup.userId as SUP_ApprovingID, aSup.status as SUP_status, aSup.feedbacks as SUP_feedbacks, aSup.date as SUP_date, "
                    + " aML.userId as ML_ApprovingID, aML.status as ML_status, aML.feedbacks as ML_feedbacks, aML.date as ML_date "
                    + " FROM registrationform rf "
                    + "LEFT JOIN project p ON p.registrationFormId = rf.registrationFormId "
                    + "LEFT JOIN User u on p.studentId = u.userId "
                    + "LEFT JOIN Approval aSup on aSup.approvalId = rf.supervisorApprovalID LEFT JOIN Approval aML on aML.approvalId = rf.moduleLeaderApprovalID "
                    + "WHERE rf.moduleLeaderApprovalID IS NOT NULL GROUP BY rf.registrationFormId";

            System.out.println(query);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Project p = new Project();
                RegistrationForm rf = new RegistrationForm(rs.getInt("registrationFormId"));
                User student = new User(rs.getString("studentId"));
                User assessor = new User(rs.getString("assessorId"));
                User supervisor = new User(rs.getString("supervisorId"));
                Approval moduleLeaderApproval = new Approval(rs.getInt("moduleLeaderApprovalID"));
                Approval supervisorApproval = new Approval(rs.getInt("supervisorApprovalID"));

                // approval infos
                //supervisorApproval.setApprovalId(rs.getInt("supervisorApprovalID"));
                supervisorApproval.setApprovalStatus(rs.getString("SUP_status"));
                supervisorApproval.setFeedbacks(rs.getString("SUP_feedbacks"));
                supervisorApproval.setApprovalDate(rs.getString("SUP_date"));

                moduleLeaderApproval.setApprovalStatus(rs.getString("ML_status"));
                moduleLeaderApproval.setFeedbacks(rs.getString("ML_feedbacks"));
                moduleLeaderApproval.setApprovalDate(rs.getString("ML_date"));

                moduleLeaderApproval.setApprovalId(rs.getInt("moduleLeaderApprovalID"));
                moduleLeaderApproval.setApprovalStatus(rs.getString("ML_status"));
                moduleLeaderApproval.setFeedbacks(rs.getString("ML_feedbacks"));
                moduleLeaderApproval.setApprovalDate(rs.getString("ML_date"));

                p.setDissertationTitle(rs.getString("dissertationTitle"));
                p.setStudentId(rs.getString("studentId"));

                student.setfName(rs.getString("fName"));
                student.setlName(rs.getString("lName"));

                rf.setAssessor(assessor);
                rf.setSupervisor(supervisor);
                rf.setProject(p);
                rf.setStudent(student);
                rf.setModuleLeaderApproval(moduleLeaderApproval);
                rf.setSupervisorApproval(supervisorApproval);
                rf.setStatus(rs.getString("rfStatus"));

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

    // retrieve dissertation registration forms WAITING for supervisor approval 
    // a registration form waiting for supervisor approvation got a NULL ID for column supervisorApprovalID
    public List<Project> getSubmittedRegFormsForSupervisor(String supervisorId) {
        List<Project> list = new ArrayList<Project>();
        try {
            stmt = con.createStatement();
            String query = "SELECT u.fName, u.lName, u.userId as studentId, p.dissertationTitle, rf.registrationFormId, rf.assessorId, rf.supervisorId, rf.supervisorApprovalID, rf.moduleLeaderApprovalID FROM registrationform rf "
                    + "INNER JOIN project p ON p.registrationFormId = rf.registrationFormId "
                    + "INNER JOIN User u on p.studentId = u.userId "
                    + "WHERE rf.supervisorApprovalID IS NULL AND rf.supervisorId = '" + supervisorId + "'";

            System.out.println(query);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Project p = new Project();
                RegistrationForm rf = new RegistrationForm(rs.getInt("registrationFormId"));
                User student = new User(rs.getString("studentId"));
                User assessor = new User(rs.getString("assessorId"));
                User supervisor = new User(rs.getString("supervisorId"));
                //Approval moduleLeaderApproval = new Approval(rs.getInt("moduleLeaderApprovalID"));
                //Approval supervisorApproval = new Approval(rs.getInt("supervisorApprovalID"));

                // approval infos
                //supervisorApproval.setApprovalStatus(rs.getString("status"));
                //supervisorApproval.setFeedbacks(rs.getString("feedbacks"));
                //supervisorApproval.setApprovalDate(rs.getString("date"));
                p.setDissertationTitle(rs.getString("dissertationTitle"));
                p.setStudentId(rs.getString("studentId"));

                student.setfName(rs.getString("fName"));
                student.setlName(rs.getString("lName"));

                rf.setAssessor(assessor);
                rf.setSupervisor(supervisor);
                rf.setProject(p);
                rf.setStudent(student);
                //rf.setModuleLeaderApproval(moduleLeaderApproval);
                //rf.setSupervisorApproval(supervisorApproval);

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

    // retrieve dissertation registration REVIEWED BY supervisor 
    public List<Project> getReviewedRegFormsForSupervisor(String supervisorId) {
        List<Project> list = new ArrayList<Project>();
        try {
            stmt = con.createStatement();
            String query = "SELECT u.fName, u.lName, u.userId as studentId, p.dissertationTitle, rf.registrationFormId, rf.assessorId, rf.supervisorId, rf.supervisorApprovalID, rf.moduleLeaderApprovalID, a.userId as userApproving, a.status, a.feedbacks, a.date "
                    + "FROM registrationform rf  "
                    + "LEFT JOIN project p ON p.registrationFormId = rf.registrationFormId  "
                    + "LEFT JOIN User u on p.studentId = u.userId "
                    + "LEFT JOIN Approval a on a.userId = rf.supervisorId "
                    + "WHERE a.approvalId = rf.supervisorApprovalID AND rf.supervisorId = '" + supervisorId + "'";

            //System.out.println(query);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Project p = new Project();
                RegistrationForm rf = new RegistrationForm(rs.getInt("registrationFormId"));
                User student = new User(rs.getString("studentId"));
                User assessor = new User(rs.getString("assessorId"));
                User supervisor = new User(rs.getString("supervisorId"));
                Approval moduleLeaderApproval = new Approval(rs.getInt("moduleLeaderApprovalID"));
                Approval supervisorApproval = new Approval(rs.getInt("supervisorApprovalID"));

                // approval infos
                supervisorApproval.setApprovalStatus(rs.getString("status"));
                supervisorApproval.setFeedbacks(rs.getString("feedbacks"));
                supervisorApproval.setApprovalDate(rs.getString("date"));

                p.setDissertationTitle(rs.getString("dissertationTitle"));
                p.setStudentId(rs.getString("studentId"));

                student.setfName(rs.getString("fName"));
                student.setlName(rs.getString("lName"));

                rf.setAssessor(assessor);
                rf.setSupervisor(supervisor);
                rf.setProject(p);
                rf.setStudent(student);
                rf.setModuleLeaderApproval(moduleLeaderApproval);
                rf.setSupervisorApproval(supervisorApproval);

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

    // retrive all submitted dissertation registration forms
    public List<Project> getSubmittedRegistrationForms() {
        List<Project> list = new ArrayList<Project>();
        try {
            stmt = con.createStatement();
            String query = "SELECT u.fName, u.lName, u.userId as studentId, p.dissertationTitle, rf.registrationFormId, rf.supervisorId, rf.assessorId, rf.status, rf.moduleLeaderApprovalID, rf.supervisorApprovalID "
                    + "FROM project p INNER JOIN registrationform rf ON p.registrationFormId = rf.registrationFormId"
                    + " INNER JOIN User u on p.studentId = u.userId";
            System.out.println(query);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Project p = new Project();
                RegistrationForm rf = new RegistrationForm(rs.getInt("registrationFormId"));
                User student = new User(rs.getString("studentId"));
                User assessor = new User(rs.getString("assessorId"));
                User supervisor = new User(rs.getString("supervisorId"));
                Approval moduleLeaderApproval = new Approval(rs.getInt("moduleLeaderApprovalID"));
                Approval supervisorApproval = new Approval(rs.getInt("supervisorApprovalID"));

                p.setDissertationTitle(rs.getString("dissertationTitle"));
                p.setStudentId(rs.getString("studentId"));

                student.setfName(rs.getString("fName"));
                student.setlName(rs.getString("lName"));

                rf.setAssessor(assessor);
                rf.setSupervisor(supervisor);
                rf.setStatus(rs.getString("status"));
                rf.setProject(p);
                rf.setStudent(student);
                rf.setModuleLeaderApproval(moduleLeaderApproval);
                rf.setSupervisorApproval(supervisorApproval);

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

    // get project + registration form from ID
    public Project getProjectRegistrationFromId(int id) {
        Project project = null;

        try {
            stmt = con.createStatement();
            String query = "SELECT u.fName, u.lName, u.userId as studentId, u.email, u.courseCode, u.courseMode, u.courseTitle, p.projectId, p.projectAim, p.dissertationTitle, p.relatedParties, p.deliverables, p.hypothesis, p.literature, p.subjectArea, rf.registrationFormId, rf.registrationDate, rf.assessorId, rf.supervisorId, rf.supervisorApprovalID, rf.status as rfStatus, rf.moduleLeaderApprovalID, aSup.userId as SUP_ApprovingID, aSup.status as SUP_status, aSup.feedbacks as SUP_feedbacks, aSup.date as SUP_date, aML.userId as ML_ApprovingID, aML.status as ML_status, aML.feedbacks as ML_feedbacks, aML.date as ML_date FROM registrationform rf LEFT JOIN project p ON p.registrationFormId = rf.registrationFormId LEFT JOIN User u on p.studentId = u.userId LEFT JOIN Approval aSup on aSup.approvalId = rf.supervisorApprovalID LEFT JOIN Approval aML on aML.approvalId = rf.moduleLeaderApprovalID WHERE rf.registrationFormId = " + id;
            
            //String query = "SELECT * FROM project p INNER JOIN registrationform rf ON p.registrationFormId = rf.registrationFormId INNER JOIN User u on p.studentId = u.userId WHERE rf.registrationFormId = " + id;
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                project = new Project();
                RegistrationForm rf = new RegistrationForm();
                User assessor = new User(rs.getString("assessorId"));
                User supervisor = new User(rs.getString("supervisorId"));
                User student = new User(rs.getString("studentId"));
                Approval supervisorApproval = new Approval(rs.getInt("supervisorApprovalId"));
                Approval moduleLeaderApproval = new Approval(rs.getInt("moduleLeaderApprovalId"));

                //Semester sem = new Semester(rs.getInt("semesterId"));

                 // approval infos
                supervisorApproval.setApprovalId(rs.getInt("supervisorApprovalID"));
                supervisorApproval.setUserId(rs.getString("SUP_ApprovingID"));
                supervisorApproval.setApprovalStatus(rs.getString("SUP_status"));
                supervisorApproval.setFeedbacks(rs.getString("SUP_feedbacks"));
                supervisorApproval.setApprovalDate(rs.getString("SUP_date"));

                
                
                moduleLeaderApproval.setApprovalId(rs.getInt("moduleLeaderApprovalID"));
                moduleLeaderApproval.setUserId(rs.getString("ML_ApprovingID"));
                moduleLeaderApproval.setApprovalStatus(rs.getString("ML_status"));
                moduleLeaderApproval.setFeedbacks(rs.getString("ML_feedbacks"));
                moduleLeaderApproval.setApprovalDate(rs.getString("ML_date"));
                
                student.setfName(rs.getString("fName"));
                student.setlName(rs.getString("lName"));
                student.setCourseCode(rs.getString("courseCode"));
                student.setCourseMode(rs.getString("courseMode"));
                student.setCourseTitle(rs.getString("courseTitle"));
                student.setEmail(rs.getString("email"));

                project.setProjectId(rs.getInt("projectId"));
                project.setStudentId(rs.getString("studentId"));
                project.setDeliverables(rs.getString("deliverables"));
                project.setDissertationTitle(rs.getString("dissertationTitle"));
                project.setHypothesis(rs.getString("hypothesis"));
                project.setLiterature(rs.getString("literature"));
                project.setProjectAim(rs.getString("projectAim"));
                project.setRelatedParties(rs.getString("relatedParties"));
                project.setSubjectArea(rs.getString("subjectArea"));

                rf.setRegistrationFormId(id);
                rf.setAssessor(assessor);
                rf.setSupervisor(supervisor);
                rf.setSupervisorApproval(supervisorApproval);
                rf.setModuleLeaderApproval(moduleLeaderApproval);
                rf.setStatus(rs.getString("rfStatus"));
                rf.setRegistrationDate(parstDateToString(rs.getDate("registrationDate")));
                //rf.setSemester(sem);
                rf.setStudent(student);

                project.setRegistrationForm(rf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }

        return project;
    }

    public boolean findRegistrationByID(int registrationFormId) throws SQLException {
        boolean found = false;
        query = "SELECT * FROM `registrationform` WHERE `registrationFormId` = " + registrationFormId;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                found = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            rs = null;
        }
        return found;
    }

    public static void main(String[] args) throws SQLException {
        DissRegistrationDAO ds = new DissRegistrationDAO();
        /*List<Semester> semesters = ds.getDissSemesters();
        
        for (int i = 0; i<semesters.size(); i++){
            Semester s = semesters.get(i);
            System.out.println(s.getModuleCode()+" "+ds.getDDMMYYYYDate(s.getStartDate())+" "+
                    ds.getDDMMYYYYDate(s.getCompletionDate()));
        }*/

 /*List<Event> events = ds.getDissSemesterEvents(1);
        
        for (int i = 0; i< events.size(); i++){
            Event e = events.get(i);
            System.out.println(e.getEventId()+" "+ds.getDDMMYYYYDate(e.getStartDate())+" "+
                    ds.getDDMMYYYYDate(e.getDueDate()));
        }*/
        //Event event = ds.getEvent(1, 2);
        //System.out.println(ds.getUserId("Oussama Kaoui"));
        //System.out.println(ds.getLastRecordFormTable("project", "projectId"));
        /*Project p = new Project();
                p.setDeliverables("sdcscsdcsdc");
                p.setSubjectArea("sdcasdasc");
                p.setLiterature("asdadas");
                p.setDissertationTitle("afqwfaff");
                p.setProjectAim("asfdafafa");
                p.setHypothesis("asdadacd");
                p.setRelatedParties("hjbjhbvjbjb");
        User u = new User();
        u.setUserId("15025017");
        ds.addProjectRecord(u, p);*/
        Project p = ds.getStudentProject("15025017");
        System.out.println(p.getRegistrationForm().getRegistrationFormId());
        System.out.println(p.getRegistrationForm().getAssessor().getUserId());
        System.out.println(p.getRegistrationForm().getSemester().getSemesterId());
        System.out.println(p.getRegistrationForm().getStatus());

    }
}
