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
                                        <select name="supervisor" class="" ${project.registrationForm.supervisorApproval.approvalStatus == 'approved' || project.registrationForm.supervisorApproval.approvalStatus == 'disapproved' ? 'disabled' : ''}>
                                            <c:forEach items="${supervisors}" var="supervisorList">
                                                <option value="<c:out value="${supervisorList.userId}" />" selected=${supervisorList.userId == selectedSupervisor ? 'selected' : ''} ><c:out value="${supervisorList.fName} ${supervisorList.lName}" /></option>
                                            </c:forEach>
                                        </select>
                                        <span class="error"> ${errors['supervisor']} </span><span class="error"> ${errors['same']} </span>
                                    </div>
                                    <div class="form-group">
                                        <label for="assessor"> <b>Second Assessor:</b>  </label>
                                        <select name="assessor" class="" ${project.registrationForm.supervisorApproval.approvalStatus == 'approved' || project.registrationForm.supervisorApproval.approvalStatus == 'disapproved' ? 'disabled' : ''}>
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

                </div>


                <c:choose>
                    <c:when test="${project.registrationForm.supervisorApproval.approvalStatus == 'approved' || project.registrationForm.supervisorApproval.approvalStatus == 'disapproved' }">
                        <!-- CASE VIEW -->
                        <h4> Status </h4>
                        <ul>
                            <li> Registration Form Status: <strong> <c:out value="${project.registrationForm.supervisorApproval.approvalStatus}" /> </strong> </li>
                            <li> Feedbacks: <strong> <c:out value="${project.registrationForm.supervisorApproval.feedbacks}" /> </strong> </li>
                            <li> Published date: <strong> <c:out value="${project.registrationForm.supervisorApproval.approvalDate}" /> </strong> </li>
                            <li> Supervisor ID: <strong> <c:out value="${project.registrationForm.supervisorApproval.userId}" /> </strong> </li>
                            <li> Approval ID: <strong> <c:out value="${project.registrationForm.supervisorApproval.approvalId}" /> </strong> </li>
                        </ul>
                    </c:when>

                    <c:otherwise>
                        <!-- CASE EDIT / APPROVE  -->
                        <p> By clicking on 'Approve', your are approving Registration form . </p>
                        <p> By clicking on 'Disapprove', your are disapproving Registration form . </p>
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
