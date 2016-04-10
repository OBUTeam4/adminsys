<%-- 
    Document   : ApproveRegistrationForm
    Created on : 25 mars 2016, 12:27:20
    Author     : Quentin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Approve Registration Form</title>
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
            <h1>Dissertation Reg Approval </h1>

            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home"> Registration Form </a></li>
                <li><a data-toggle="tab" href="#menu1"> Ethics #1  </a></li>
                <li><a data-toggle="tab" href="#menu2"> Ethics #2 </a></li>
            </ul>

            <form method="POST">
                <div class="tab-content">
                    <div id="home" class="tab-pane fade in active">

                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-12 ">
                                    <h4> Student Infos </h4>
                                    <ul>
                                        <li>  Student Id: <c:out value="${s.userId}" />  </li>
                                        <li>  Name :<c:out value="${project.registrationForm.student.fName} ${project.registrationForm.student.lName}" /> </li>
                                        <li>  Email: <c:out value="${project.registrationForm.student.email}" /> </li>
                                        <li>  Course Code: <c:out value="${s.courseCode}" /> </li>
                                        <li>  Course Title: <c:out value="${s.courseTitle}" /> </li>
                                        <li>  Course Mode: <c:out value="${s.courseMode}" /> </li>
                                    </ul>

                                    <hr>

                                    <h4> Registration  </h4>

                                    <div class="row">
                                        <div class="col-sm-4"> <b>Submitted date:</b> </div>
                                        <div class="col-sm-8"> <c:out value="${project.registrationForm.registrationDate}" /> </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-sm-4"> <b>Dissertation Module Code:</b> </div>
                                        <div class="col-sm-8"> <c:out value="${moduleCode}" /> </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-3"> <b>Dissertation Title: </b> </div>
                                        <div class="col-sm-8"> <c:out value="${project.dissertationTitle}" /> </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-3"> </div>
                                        <div class="col-sm-8">  <c:out value="${supervisor}" />  </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-3">  </div>
                                        <div class="col-sm-8"> <c:out value="${assessor}" />  </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-3">  <b>Related Parties:</b> </div>
                                        <div class="col-sm-8">  <c:out value="${project.relatedParties}" />  </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-3"> <b>Subject area and relationship to course:</b> </div>
                                        <div class="col-sm-8"> <c:out value="${project.subjectArea}" />  </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-3"> <b>Project aim and objectives:</b> </div>
                                        <div class="col-sm-8"> <c:out value="${project.projectAim}" />  </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-3">   <b>Literature influencing work:</b> </div>
                                        <div class="col-sm-8">   <c:out value="${project.literature}" />  </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-3"> <b>Hypothesis, proposition, research question or outline specification:</b> </div>
                                        <div class="col-sm-8">  <c:out value="${project.hypothesis}" /> </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-3"> <b>Proposed Deliverables:</b> </div>
                                        <div class="col-sm-8">  <c:out value="${project.deliverables}" /> </div>
                                    </div>

                                    <div class="row">
                                        <br/> 
                                        <p> You can edit Supervisor and Assessor only. </p>  
                                    </div>

                                    <div class="form-group">
                                        <label for="supervisor"> <b>Supervisor:  </b> </label>
                                        <select name="supervisor" class=""   ${project.registrationForm.moduleLeaderApproval.approvalStatus == 'approved' || project.registrationForm.moduleLeaderApproval.approvalStatus == 'disapproved' ? 'disabled' : ''} >
                                            <c:forEach items="${supervisors}" var="supervisorList">
                                                <option value="<c:out value="${supervisorList.userId}" />" selected=${supervisorList.userId == selectedSupervisor ? 'selected' : ''} ><c:out value="${supervisorList.fName} ${supervisorList.lName}" /></option>
                                            </c:forEach>
                                        </select>
                                        <span class="error"> ${errors['supervisor']} </span><span class="error"> ${errors['same']} </span>
                                    </div>
                                    <div class="form-group">
                                        <label for="assessor"> <b>Second Assessor:</b>  </label>
                                        <select name="assessor" class="" ${project.registrationForm.moduleLeaderApproval.approvalStatus == 'approved' || project.registrationForm.moduleLeaderApproval.approvalStatus == 'disapproved' ? 'disabled' : ''}>
                                            <c:forEach items="${assessors}" var="assessorList">
                                                <option value="<c:out value="${assessorList.userId}" />"  selected=${assessorList.userId == selectedAssessor ? 'selected' : ''} ><c:out value="${assessorList.fName} ${assessorList.lName}" /></option>
                                            </c:forEach>
                                        </select>
                                        <span class="error"> ${errors['assessor']} </span>
                                    </div>
                                    <hr>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!-- ETHICS 1 --> 
                    <div id="menu1" class="tab-pane fade">

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
                                        <td width="20" align="center"><input type="radio" name="question1_tick" value="Yes"  ${e1.answer1 == 'yes' ? 'checked' : ''} disabled /></td>
                                        <td width="20" align="center"><input type="radio" name="question1_tick" value="No" ${e1.answer1 == 'no' ? 'checked' : ''}  disabled /></td>
                                    </tr>
                                    <tr>
                                        <td width="20" align="center">2</td>
                                        <td width="800"> If the study will involve participants who are unable to give informed consent 
                                            (e.g. children under the age of 16, people with learning disabilities), will you be unable 
                                            to obtain permission from their parents or guardians (as appropriate)? </td>                                 
                                        <td width="20" align="center"><input type="radio" name="question2_tick" value="Yes"  ${e1.answer2 == 'yes' ? 'checked' : ''} disabled /></td>
                                        <td width="20" align="center"><input type="radio" name="question2_tick" value="No" ${e1.answer2 == 'no' ? 'checked' : ''} disabled /></td>
                                    </tr>
                                    <tr>
                                        <td width="20" align="center">3</td>
                                        <td width="800"> Will the study require the cooperation of a gatekeeper for initial access to
                                            groups or individuals to be recruited? (e.g. students, members of a self-help group, 
                                            employees of a company, residents of a nursing home) </td> 
                                        <td width="20" align="center"><input type="radio" name="question3_tick" value="Yes"  ${e1.answer3 == 'yes' ? 'checked' : ''} disabled /></td>
                                        <td width="20" align="center"><input type="radio" name="question3_tick" value="No" ${e1.answer3 == 'no' ? 'checked' : ''} disabled  /></td>
                                    </tr>
                                    <tr>
                                        <td width="20" align="center">4</td>
                                        <td width="800"> Are there any problems with the participants' right to remain anonymous, or 
                                            to have the information they give not identifiable as theirs? </td> 
                                        <td width="20" align="center"><input type="radio" name="question4_tick" value="Yes" ${e1.answer4 == 'yes' ? 'checked' : ''} disabled /></td>
                                        <td width="20" align="center"><input type="radio" name="question4_tick" value="No" ${e1.answer4 == 'no' ? 'checked' : ''} disabled /></td>
                                    </tr>
                                    <tr>
                                        <td width="20" align="center">5</td>
                                        <td width="800"> Will it be necessary for the participants to take part in the study without 
                                            their knowledge/consent at the time? (e.g. covert observation of people in non-public 
                                            places?) </td> 
                                        <td width="20" align="center"><input type="radio" name="question5_tick" value="Yes" ${e1.answer5 == 'yes' ? 'checked' : ''} disabled /></td>
                                        <td width="20" align="center"><input type="radio" name="question5_tick" value="No" ${e1.answer5 == 'no' ? 'checked' : ''} disabled /></td>
                                    </tr>
                                    <tr>
                                        <td width="20" align="center">6</td>
                                        <td width="800"> Will the study involve discussion of or responses to questions the 
                                            participants might find sensitive? (e.g. own drug use, own traumatic experiences) </td> 
                                        <td width="20" align="center"><input type="radio" name="question6_tick" value="Yes" ${e1.answer6 == 'yes' ? 'checked' : ''} disabled /></td>
                                        <td width="20" align="center"><input type="radio" name="question6_tick" value="No" ${e1.answer6 == 'no' ? 'checked' : ''} disabled /></td>
                                    </tr>                        
                                    <tr>
                                        <td width="20" align="center">7</td>
                                        <td width="800"> Are drugs, placebos or other substances (e.g. food substances, vitamins) 
                                            to be administered to the study participants? </td> 
                                        <td width="20" align="center"><input type="radio" name="question7_tick" value="Yes" ${e1.answer7 == 'yes' ? 'checked' : ''} disabled /></td>
                                        <td width="20" align="center"><input type="radio" name="question7_tick" value="No" ${e1.answer7 == 'no' ? 'checked' : ''} disabled /></td>
                                    </tr>  
                                    <tr>
                                        <td width="20" align="center">8</td>
                                        <td width="800"> Will blood or tissue samples be obtained from participants? </td> 
                                        <td width="20" align="center"><input type="radio" name="question8_tick" value="Yes"${e1.answer8 == 'yes' ? 'checked' : ''} disabled /></td>
                                        <td width="20" align="center"><input type="radio" name="question8_tick" value="No" ${e1.answer8 == 'no' ? 'checked' : ''} disabled/></td>
                                    </tr>
                                    <tr>
                                        <td width="20" align="center">9</td>
                                        <td width="800"> Is pain or more than mild discomfort likely to result from the study? </td> 
                                        <td width="20" align="center"><input type="radio" name="question9_tick" value="Yes" ${e1.answer9 == 'yes' ? 'checked' : ''} disabled/></td>
                                        <td width="20" align="center"><input type="radio" name="question9_tick" value="No" ${e1.answer9 == 'no' ? 'checked' : ''} disabled/></td>
                                    </tr>
                                    <tr>
                                        <td width="20" align="center">10</td>
                                        <td width="800"> Could the study induce psychological stress or anxiety? </td> 
                                        <td width="20" align="center"><input type="radio" name="question10_tick" value="Yes" ${e1.answer10 == 'yes' ? 'checked' : ''} disabled/></td>
                                        <td width="20" align="center"><input type="radio" name="question10_tick" value="No" ${e1.answer10 == 'no' ? 'checked' : ''} disabled/></td>
                                    </tr>
                                    <tr>
                                        <td width="20" align="center">11</td>
                                        <td width="800"> Will the study involve prolonged or repetitive testing ? </td> 
                                        <td width="20" align="center"><input type="radio" name="question11_tick" value="Yes" ${e1.answer11 == 'yes' ? 'checked' : ''} disabled/></td>
                                        <td width="20" align="center"><input type="radio" name="question11_tick" value="No" ${e1.answer11 == 'no' ? 'checked' : ''} disabled/></td>
                                    </tr>
                                    <tr>
                                        <td width="20" align="center">12</td>
                                        <td width="800"> Will financial inducements (other than reasonable expenses and
                                            compensation for time) be offered to participants? </td> 
                                        <td width="20" align="center"><input type="radio" name="question12_tick" value="Yes" ${e1.answer12 == 'yes' ? 'checked' : ''} disabled/></td>
                                        <td width="20" align="center"><input type="radio" name="question12_tick" value="No" ${e1.answer12 == 'no' ? 'checked' : ''} disabled/></td>
                                    </tr>
                                    <tr>
                                        <td width="20" align="center">13</td>
                                        <td width="800"> Will deception of participants be necessary during the study? </td> 
                                        <td width="20" align="center"><input type="radio" name="question13_tick" value="Yes" ${e1.answer13 == 'yes' ? 'checked' : ''} disabled/></td>
                                        <td width="20" align="center"><input type="radio" name="question13_tick" value="No" ${e1.answer13 == 'no' ? 'checked' : ''} disabled/></td>
                                    </tr>
                                <td width="20" align="center">14</td>
                                <td width="800"> Will the study involve NHS patients, staff, carers or premises? </td> 
                                <td width="20" align="center"><input type="radio" name="question14_tick" value="Yes" ${e1.answer14 == 'yes' ? 'checked' : ''} disabled /> </td>
                                <td width="20" align="center"><input type="radio" name="question14_tick" value="No" ${e1.answer14 == 'no' ? 'checked' : ''} disabled /></td>
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
                            <hr>
                            <br/>
                            <br/>
                            <br/> 

                        </div>

                    </div>

                    <!-- ETHICS 2 --> 
                    <div id="menu2" class="tab-pane fade">

                        <h3>Ethics Review Form E2</h3>
                        <div class="form-group">
                            <p>This form is only for graduate (MSc) and undergraduate students on taught programmes. Before completing this form, 
                                Form E1 should have been completed to establish whether a Form E2 is required. </p>
                            <p>The E2 Form should be completed by the Principal Investigator / Student undertaking the research.<br />
                                Reference should be made to the University Code of Practice for the Ethical Standards for Research involving Human Participants, available at http://www.brookes.ac.uk/Research/Research-ethics/, 
                                and to any guidelines provided by relevant academic or professional associations.</p>
                        </div>
                        <hr>

                        <div class="row">
                            <div class="col-sm-4">
                                Project Type: 
                            </div>
                            <div class="col-sm-4">
                                ${ptype}
                            </div>
                        </div>
                        <br />
                        <div class="row">
                            <div class="col-sm-4">
                                Project funded by (if applicable):
                            </div>
                            <div class="col-sm-4">
                                ${funded}
                            </div>
                        </div>

                        <br />

                        <div class="row">
                            <div class="col-sm-4">
                                Summary of proposed research: 
                            </div>
                            <div class="col-sm-4">
                                ${summary}
                            </div>
                        </div>
                        <br />

                        <div class="row">
                            <div class="col-sm-4">
                                Participants involved in the research:
                            </div>
                            <div class="col-sm-4">
                                ${participants}
                            </div>
                        </div> <br />
                        <div class="row">
                            <div class="col-sm-4">
                                Details of drugs or other substances used:
                            </div>
                            <div class="col-sm-4">
                                ${details}
                            </div>
                        </div> <br />

                        <div class="row">
                            <div class="col-sm-6">
                                Estimate of the risks and benefits of the proposed research: 
                            </div>
                            <div class="col-sm-4">
                                ${estimate}
                            </div>
                        </div><br/>
                        <div class="row">
                            <div class="col-sm-6">
                                Plan for obtaining informed consent: (please attach copy of information sheet and consent form to application): 
                            </div>
                            <div class="col-sm-4">
                                ${plan}
                            </div>
                        </div><br />
                        <div class="row">
                            <div class="col-sm-6">
                                Steps to be taken to ensure confidentiality of data:
                            </div>
                            <div class="col-sm-4">
                                ${steps}
                            </div>
                        </div>
                        <hr>
                        <br />
                        <br /><br />


                    </div>

                </div>

                <c:choose>
                    <c:when test="${project.registrationForm.moduleLeaderApproval.approvalStatus == 'approved' || project.registrationForm.moduleLeaderApproval.approvalStatus == 'disapproved' }">
                        <!-- CASE VIEW -->
                        <h4> Status </h4>
                        <ul>
                            <li> Registration Form Status: <strong> <c:out value="${project.registrationForm.moduleLeaderApproval.approvalStatus}" /> </strong> </li>
                            <li> Feedbacks: <strong> <c:out value="${project.registrationForm.moduleLeaderApproval.feedbacks}" /> </strong> </li>
                            <li> Published date: <strong> <c:out value="${project.registrationForm.moduleLeaderApproval.approvalDate}" /> </strong> </li>
                            <li> Module Leader ID: <strong> <c:out value="${project.registrationForm.moduleLeaderApproval.userId}" /> </strong> </li>
                            <li> Approval ID: <strong> <c:out value="${project.registrationForm.moduleLeaderApproval.approvalId}" /> </strong> </li>
                        </ul>
                    </c:when>

                    <c:otherwise>
                        <!-- CASE EDIT / APPROVE  -->
                        <p> By clicking on 'Approve', your are approving Registration form and Ethics 1 / 2. </p>
                        <p> By clicking on 'Disapprove', your are disapproving Registration form and Ethics 1 / 2. </p>

                        <div class="form-group">
                            <label for="comment">Comment:</label>
                            <textarea class="form-control" rows="5" id="comment" name="comment" ></textarea>
                        </div>

                        <input   class="btn btn-success" type="submit" name="act" value = "Approve"/>
                        <input   class="btn btn-danger" type="submit" name="act" value = "Disapprove"/><br /><br />
                        <span class="error"><c:out value="${message}"/></span>
                    </c:otherwise>
                </c:choose>

            </form>

    </body>
</html>
