<%-- 
    Document   : ethicsFormOnev2
    Created on : 26-Mar-2016, 17:18:09
    Author     : Roger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Ethics Review Form E1 </title>
        <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"> -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/css/header.css">
        <link rel="stylesheet" href="<%=application.getContextPath()%>/includes/css/default.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>        
    </head>

    <body>
        <%@ include file="/includes/menu.jsp" %>  

        <div class="container">
            <h4> Faculty of Technology, Design and Environment </h4>
            <h4> Ethics Review Form E1 </h4>
            <p> This form should be completed by the Principal Investigator / Supervisor / 
                Student undertaking a research project which involves human participants. 
                The form will identify whether a more detailed E2 form needs to be submitted
                to the Faculty Research Ethics Officer.
            </p>
            <p> Before completing this form, please refer to the University 
                <b> Code of Practice for the Ethical Standards for Research 
                    involving Human Participants</b>, available at 
                    <a href="http://www.brookes.ac.uk/Research/Research-ethics/">
                        http://www.brookes.ac.uk/Research/Research-ethics/
                    </a>, and to any guidelines provided by relevant academic 
                    or professional associations.  
            </p>
            <p>
                It is the Principal Investigator / Supervisor who is responsible for
                exercising appropriate professional judgement in this review. Note
                that all necessary forms should be fully completed and signed before
                fieldwork commences.
            </p>
            
            <form method="POST"  action="ethicsRegister" role="form">                
                <div class="form-group">
                    <%-- Title of the current project registered by student displayed in the readonly input text box --%>
                    <label for="diss_title" > Project Title: </label>
                    <input type="text" class="form-control" name="diss_title" value="<c:out value="${diss_title}" />" readonly />
                    <span class="error"> ${errors['diss_title']} </span>
                </div>
                <%-- Principal Investigator / Supervisor of student for this project, load in drop-down list --%>
                <div class="form-group">                    
                    <label for="supervisor"> Principal Investigator / Supervisor:  <span class="required">*</span> </label>
                    <c:out value="${supervisor}" />
                    <select name="supervisor" class="form-control">
                        <c:forEach items="${supervisors}" var="supervisorList">
                            <option value="<c:out value="${supervisorList.idNumber}" />"><c:out value="${supervisorList.firstName} ${supervisorList.lastName}" /></option>
                        </c:forEach>
                    </select>
                    <span class="error"> ${errors['supervisor']} </span>
                </div>
                <%-- Student Fullname on this project displayed in the readonly input text box --%>
                <div class="form-group">                    
                    <label for="fullname" > Student Investigator: </label>
                    <input type="text" class="form-control" name="fullname" value="<c:out value="${firstname} ${lastname}" />" readonly />
                    <span class="error"> ${errors['fname' + 'lname']} </span>
                </div>
                
                <%-- Tables for Ethics E1 questionnaire --%>         
                <table border="1">
                    <thead>
                        <tr align="center">
                            <th></th>
                            <th></th>
                            <th> Yes </th>
                            <th> No </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td width="20" align="center">1</td>
                            <td width="800"> Does the study involve participants who are unable to give informed consent? 
                                 (e.g. children, people with learning disabilities, unconscious patients) </td>
                            <td width="20" align="center"><input type="radio" name="question1_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question1_tick" value="No" /></td>
                        </tr>
                        <tr>
                            <td width="20" align="center">2</td>
                            <td width="800"> If the study will involve participants who are unable to give informed consent 
                                (e.g. children under the age of 16, people with learning disabilities), will you be unable 
                                to obtain permission from their parents or guardians (as appropriate)? </td>                                 
                            <td width="20" align="center"><input type="radio" name="question2_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question2_tick" value="No" /></td>
                        </tr>
                        <tr>
                            <td width="20" align="center">3</td>
                            <td width="800"> Will the study require the cooperation of a gatekeeper for initial access to
                                 groups or individuals to be recruited? (e.g. students, members of a self-help group, 
                                 employees of a company, residents of a nursing home) </td> 
                            <td width="20" align="center"><input type="radio" name="question3_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question3_tick" value="No" /></td>
                        </tr>
                        <tr>
                            <td width="20" align="center">4</td>
                            <td width="800"> Are there any problems with the participants' right to remain anonymous, or 
                                to have the information they give not identifiable as theirs? </td> 
                            <td width="20" align="center"><input type="radio" name="question4_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question4_tick" value="No" /></td>
                        </tr>
                        <tr>
                            <td width="20" align="center">5</td>
                            <td width="800"> Will it be necessary for the participants to take part in the study without 
                                their knowledge/consent at the time? (e.g. covert observation of people in non-public 
                                places?) </td> 
                            <td width="20" align="center"><input type="radio" name="question5_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question5_tick" value="No" /></td>
                        </tr>
                        <tr>
                            <td width="20" align="center">6</td>
                            <td width="800"> Will the study involve discussion of or responses to questions the 
                                participants might find sensitive? (e.g. own drug use, own traumatic experiences) </td> 
                            <td width="20" align="center"><input type="radio" name="question6_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question6_tick" value="No" /></td>
                        </tr>                        
                        <tr>
                            <td width="20" align="center">7</td>
                            <td width="800"> Are drugs, placebos or other substances (e.g. food substances, vitamins) 
                                to be administered to the study participants? </td> 
                            <td width="20" align="center"><input type="radio" name="question7_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question7_tick" value="No" /></td>
                        </tr>  
                        <tr>
                            <td width="20" align="center">8</td>
                            <td width="800"> Will blood or tissue samples be obtained from participants? </td> 
                            <td width="20" align="center"><input type="radio" name="question8_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question8_tick" value="No" /></td>
                        </tr>
                        <tr>
                            <td width="20" align="center">9</td>
                            <td width="800"> Is pain or more than mild discomfort likely to result from the study? </td> 
                            <td width="20" align="center"><input type="radio" name="question9_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question9_tick" value="No" /></td>
                        </tr>
                        <tr>
                            <td width="20" align="center">10</td>
                            <td width="800"> Could the study induce psychological stress or anxiety? </td> 
                            <td width="20" align="center"><input type="radio" name="question10_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question10_tick" value="No" /></td>
                        </tr>
                        <tr>
                            <td width="20" align="center">11</td>
                            <td width="800"> Will the study involve prolonged or repetitive testing ? </td> 
                            <td width="20" align="center"><input type="radio" name="question11_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question11_tick" value="No" /></td>
                        </tr>
                        <tr>
                            <td width="20" align="center">12</td>
                            <td width="800"> Will financial inducements (other than reasonable expenses and
                                compensation for time) be offered to participants? </td> 
                            <td width="20" align="center"><input type="radio" name="question12_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question12_tick" value="No" /></td>
                        </tr>
                        <tr>
                        <td width="20" align="center">13</td>
                            <td width="800"> Will deception of participants be necessary during the study? </td> 
                            <td width="20" align="center"><input type="radio" name="question13_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question13_tick" value="No" /></td>
                        </tr>
                        <td width="20" align="center">14</td>
                            <td width="800"> Will the study involve NHS patients, staff, carers or premises? </td> 
                            <td width="20" align="center"><input type="radio" name="question14_tick" value="Yes" /></td>
                            <td width="20" align="center"><input type="radio" name="question14_tick" value="No" /></td>
                        </tr>  
                        
                    </tbody>
                </table>  
                <br>
                <p> If you answered 'no' to all the above questions, send the completed form to your 
                    Module Leader and keep the original in case you need to submit it with your work.
                </p>
                <p> If you have answered 'yes' to any of the above questions, you should complete the 
                    Form E2 available on the menu and, together with this E1 Form, email it to the 
                    Faculty Research Ethics Officer, whose name can be found at 
                    <a href="http://www.brookes.ac.uk/Research/Research-ethics/Research-ethics-officers/">
                        http://www.brookes.ac.uk/Research/Research-ethics/Research-ethics-officers/
                    </a> 
                </p>
                <p> If you answered 'yes' to any questions 1-13 and 'yes' to question 14, an application 
                    must be submitted to the appropriate NHS research ethics committee. 
                </p>
                
                <%-- Button to submit students' Ethics E1 form application --%>
                <input type="submit" value="Submit" class="btn btn-default"  />
                    <br/>
                    <br/>
                    <br/> 
            </form>
        </div>
    </body>
</html>