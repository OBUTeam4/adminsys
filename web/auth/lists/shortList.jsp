<%-- 
    Document   : demoList
    Created on : 12-Apr-2016, 17:10:36
    Author     : Quentin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Short Paper List</title>
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

            <h1> List of short paper assessments </h1>
            <br/>
            
            <a href="<%=application.getContextPath()%>/auth/forms/shortPaperAssessment.jsp"> Add Short paper Assessment</a> </br>
            
            
            <h2> Short Paper assessments waiting for review</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Student <br/> Firstname</th>
                        <th>Student <br/> Lastname</th>
                        <th>Student ID </th>
                        <th>Dissertation Title </th>
                        <th>Supervisor ID </th>
                        <th>Demonstration Status </th>
                        <th>Action </th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="waiting" items="${waitings}">
                        <tr>
                            <td>${waiting.registrationForm.student.fName}</td>
                            <td>${waiting.registrationForm.student.lName}</td>
                            <td>${waiting.studentId}</td>
                            <td>${waiting.dissertationTitle}</td>
                            <td>${waiting.registrationForm.supervisor.userId}</td>
                            <td> Pending... </td>
                            <td>  <a href="<%=application.getContextPath()%>/auth/addProposalServlet?id=${waiting.projectId}"> Add proposal assessment </a> </td>
                                
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>

        <hr>
        <div class="container">
            <h2> Short Paper assessments reviewed</h2>
            <table class="table">
                <thead>
                   <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>StudentID </th>
                        <th>Dissertation Title </th>
                        <th>Supervisor ID </th>
                        <th>Demonstration Status </th>
                        <th>Action </th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="r" items="${reviewed}">
                        <tr>
                            <td>${r.registrationForm.student.fName}</td>
                            <td>${r.registrationForm.student.lName}</td>
                            <td>${r.studentId}</td>
                            <td>${r.dissertationTitle}</td>
                            <td>${r.registrationForm.supervisor.userId}</td>
                            <td>${r.registrationForm.assessor.userId}</td>

                            <td>
                                <a href="<%=application.getContextPath()%>/auth/approveRegistrationSupervisor?id=${r.registrationForm.registrationFormId}"> ${r.registrationForm.supervisorApproval.approvalStatus} <br/> (View) </a>
                            </td>

                            <td>
                                <a href="<%=application.getContextPath()%>/auth/approveRegistrationModuleLeader?id=${r.registrationForm.registrationFormId}"> ${r.registrationForm.moduleLeaderApproval.approvalStatus} <br/> (View) </a>
                            </td>
                            <td>${r.registrationForm.status}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>

    </body>
</html>

