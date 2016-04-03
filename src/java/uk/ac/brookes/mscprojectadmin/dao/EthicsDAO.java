/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.dao;

import java.sql.SQLException;
import java.util.Date;
import uk.ac.brookes.mscprojectadmin.beans.Ethics1;
import uk.ac.brookes.mscprojectadmin.beans.Ethics2;
import uk.ac.brookes.mscprojectadmin.beans.RegistrationForm;

/**
 *
 * @author oussamak
 */
public class EthicsDAO extends ClassDAO{
    DissRegistrationDAO diss;
    public EthicsDAO(){
        super();
    }
    
    public int addNewEthicsForm1(String userId, Ethics1 e1){
        diss = new DissRegistrationDAO();
        int regfId = diss.getRegistrationFormIdByStudent(userId);
        String submissionDate = parseDateToYYYYMMDD(new Date());
        int eId = getLastRecordFormTable("ethicsform1","ethicsFormId1")+1;
        
        String query = "INSERT INTO `mscprojectadmin`.`ethicsform1` (`ethicsFormId1`,`registrationFormId`,`answer1`,"
                + "`answer2`,`answer3`,`answer4`,`answer5`,`answer6`,`answer7`,`answer8`,`answer9`,`answer10`,`answer11`,`answer12`,"
                + "`answer13`,`answer14`,`submissionDate`) VALUES ("+eId+","+regfId+",'"+e1.getAnswer1()+"',"
                + "'"+e1.getAnswer2()+"','"+e1.getAnswer3()+"','"+e1.getAnswer4()+"','"+e1.getAnswer5()+"','"+e1.getAnswer6()+"',"
                + "'"+e1.getAnswer7()+"','"+e1.getAnswer8()+"','"+e1.getAnswer9()+"','"+e1.getAnswer10()+"','"+e1.getAnswer11()+"',"
                + "'"+e1.getAnswer12()+"','"+e1.getAnswer13()+"','"+e1.getAnswer14()+"','"+submissionDate+"')";
        int result = 0;
        try{
            stmt = con.createStatement();
            result = stmt.executeUpdate(query);
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            stmt = null;
            rs = null;
        }
        return result;
    }
    
    public int addNewEthicsForm2(String userId, Ethics2 e2){
        diss = new DissRegistrationDAO();
        int regfId = diss.getRegistrationFormIdByStudent(userId);
        String submissionDate = parseDateToYYYYMMDD(new Date());
        int eId = getLastRecordFormTable("ethicsform2","ethicsFormId2")+1;
        
        String query = "INSERT INTO `mscprojectadmin`.`ethicsform2` (`ethicsFormId2`,`registrationFormId`,`projectType`,"
                + "`projectFundedBy`,`sumPropResearch`,`participants`,`drugsSubstances`,`risksAndBenefits`,`consent`,`confidentiality`,`submissionDate`) VALUES "
                + "("+eId+","+regfId+",'"+e2.getPtype()+"',"+ "'"+e2.getFunded()+"','"
                +e2.getSummary()+"','"+e2.getParticipants()+"','"+e2.getDetails()+"','"+e2.getEstimate()+"',"
                + "'"+e2.getPlan()+"','"+e2.getSteps()+"','"+submissionDate+"')";
        int result = 0;
        try{
            stmt = con.createStatement();
            result = stmt.executeUpdate(query);
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            stmt = null;
            rs = null;
        }
        return result;
    }
    
    public Ethics1 getEthics1(int registrationId){
        System.out.println("regID = "+registrationId);
        Ethics1 e1 = null;
        try{
            stmt = con.createStatement();
            String query = "select * from `ethicsform1` where `registrationFormId` ="+registrationId;
            rs = stmt.executeQuery(query);
            
            if (rs.next()) {
                e1 = new Ethics1();
                e1.setRf(new RegistrationForm(registrationId));
                e1.setEthics1Id(rs.getInt("ethicsformId1"));
                e1.setAnswer1(rs.getString("answer1"));
                e1.setAnswer1(rs.getString("answer2"));
                e1.setAnswer1(rs.getString("answer3"));
                e1.setAnswer1(rs.getString("answer4"));
                e1.setAnswer1(rs.getString("answer5"));
                e1.setAnswer1(rs.getString("answer6"));
                e1.setAnswer1(rs.getString("answer7"));
                e1.setAnswer1(rs.getString("answer8"));
                e1.setAnswer1(rs.getString("answer9"));
                e1.setAnswer1(rs.getString("answer10"));
                e1.setAnswer1(rs.getString("answer11"));
                e1.setAnswer1(rs.getString("answer12"));
                e1.setAnswer1(rs.getString("answer13"));
                e1.setAnswer1(rs.getString("answer14"));
                e1.setSubmissionDate(parstDateToString(rs.getDate("submissionDate")));
                
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            stmt = null;
            rs = null;
        }
        return e1;
    }
    
    public Ethics2 getEthics2(int registrationId){
        Ethics2 e2 = null;
        try{
            stmt = con.createStatement();
            String query = "select * from `ethicsform2` where `registrationFormId` ="+registrationId;
            rs = stmt.executeQuery(query);
            
            if (rs.next()) {
                e2 = new Ethics2();
                e2.setEthics2Id(rs.getInt("ethicsFormId2"));
                e2.setRf(new RegistrationForm(registrationId));
                e2.setSteps(rs.getString("confidentiality"));
                e2.setPlan(rs.getString("consent"));
                e2.setDetails(rs.getString("drugsSubstances"));
                e2.setParticipants(rs.getString("participants"));
                e2.setFunded(rs.getString("projectFundedBy"));
                e2.setPtype(rs.getString("projectType"));
                e2.setEstimate(rs.getString("risksAndBenefits"));
                e2.setSummary(rs.getString("sumPropResearch"));
                e2.setSubmissionDate(parstDateToString(rs.getDate("submissionDate")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            stmt = null;
            rs = null;
        }
        return e2;
    }
    
    public static void main(String[] args){
        EthicsDAO edao = new EthicsDAO();
        System.out.println(edao.getLastRecordFormTable("ethicsform2", "ethicsformId2"));
    }
    
}
