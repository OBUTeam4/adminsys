/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.helpers;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import uk.ac.brookes.mscprojectadmin.beans.Ethics1;
import uk.ac.brookes.mscprojectadmin.beans.Ethics2;
import uk.ac.brookes.mscprojectadmin.beans.RegistrationForm;
import uk.ac.brookes.mscprojectadmin.dao.DissRegistrationDAO;
import uk.ac.brookes.mscprojectadmin.dao.EthicsDAO;

/**
 *
 * @author oussamak
 */
public class EthicsFormControllerHelper {
    
    private EthicsDAO edao;
    private DissRegistrationDAO diss;
    private FormsControlerHelper regf;
    Map<String, String> errors;
    public EthicsFormControllerHelper(){
        edao = new EthicsDAO();
        diss = new DissRegistrationDAO();
        regf = new FormsControlerHelper();
    }
    
    public int addNewEthicsForm1(String userId, Ethics1 e1){
        int success = edao.addNewEthicsForm1(userId, e1);
        if(success == 1){
            System.out.println("You have done ethics1 man!!!");
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public int addNewEthicsForm2(String userId, Ethics2 e2){
        int success = edao.addNewEthicsForm2(userId, e2);
        if(success == 1){
            System.out.println("You have done ethics2 man!!!");
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public String canSubmitEthics1(String studentId) throws ParseException{
        boolean dateValid = regf.checkRegSubmissionDeadline();
        String message = null;
        if(dateValid){
            int rfId = diss.getRegistrationFormIdByStudent(studentId);
            
            Ethics1 e1 = null;
            if (rfId != 0){
                e1 = edao.getEthics1(diss.getRegistrationFormIdByStudent(studentId));
            }
            else{
                message = "You didn't submit the registration form. Submit it first then submit ethics.";
            }
        
            if (e1 != null){
                message = "You can't submit another Ethics form 1.";
            }
        }
        else{
            message = "You can't submit now, deadline passed";
        }
        
        return message;
                
        
    }
    
    public String canSubmitEthics2(String studentId) throws ParseException{
        boolean dateValid = regf.checkRegSubmissionDeadline();
        String message = null;
        
        if(dateValid){
            int rfId = diss.getRegistrationFormIdByStudent(studentId);
            Ethics1 e1 = null;
            Ethics2 e2 = null;
    
            if(rfId != 0){
                e1 = edao.getEthics1(rfId);
            }
            else{
                message = "You didn't submit the registration form. Submit it first then submit ethics.";
            }
                
            if(e1 != null){
                 e2 = edao.getEthics2(rfId);
            }
            else if(e1 != null && rfId != 0){
                message = "Submit Ethics Form 1 before Ethics Form 2.";
            }
        
            if (e2 != null){
                message = "You can't submit another Ethics form 2.";
            }
        
        }
        else{
            message = "You can't submit now, deadline passed";
        }
        
        return message;   
    }
    
    
    public Ethics1 getEthics1Form(int registrationId){
        if(registrationId != 0){
            return edao.getEthics1(registrationId);
        }
        else{
            return null;
        }
    }
    
    public Ethics2 getEthics2Form(int registrationId){
        if(registrationId != 0){
            return edao.getEthics2(registrationId);
        }
        else {
            return null;
        }
    }
    
    public Map<String,String> validateInputs(Ethics2 e2){
        errors = new HashMap<String, String>();
        
        try {
            checkInput(e2.getFunded());
        } catch (Exception e) {
            errors.put("funded", e.getMessage());
        }
        
        
        try {
            checkInput(e2.getSummary());
        } catch (Exception e) {
            errors.put("summary", e.getMessage());
        }
        
        try {
            checkInput(e2.getParticipants());
        } catch (Exception e) {
            errors.put("participants", e.getMessage());
        }

        try {
            checkInput(e2.getSteps());
        } catch (Exception e) {
            errors.put("steps", e.getMessage());
        }

        try {
            checkInput(e2.getPlan());
        } catch (Exception e) {
            errors.put("plan", e.getMessage());
        }
        
        try {
            checkInput(e2.getDetails());
        } catch (Exception e) {
            errors.put("details", e.getMessage());
        }
        
        try {
            checkInput(e2.getEstimate());
        } catch (Exception e) {
            errors.put("estimate", e.getMessage());
        }

        
        return errors;
    }
    
    private void checkInput(String input) throws Exception{
        if(!input.matches("^[a-zA-Z][a-zA-Z0-9\\s]+$")){
           throw new Exception("Invalid data");
        }
    }
    
    
}
