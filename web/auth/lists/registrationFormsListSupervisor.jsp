<%-- 
    Document   : registrationList
    Created on : 25 mars 2016, 12:34:35
    Author     : Quentin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Registration Forms</title>
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

            <h1> List of Dissertation Registration Forms </h1>
            <br/>

            <h2> Registration forms waiting for review</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>StudentID </th>
                        <th>Dissertation Title </th>
                        <th>Assessor </th>
                        <th>Status </th>
                        <th>Feedback </th>
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
                            <td>${waiting.registrationForm.assessor.userId}</td>
                            <td>${waitingStatus}</td>
                            <td>${waitingFeedbacks}</td>
                            <td> <a href="<%=application.getContextPath()%>/auth/approveRegistrationSupervisor?id=${waiting.registrationForm.registrationFormId}"> Edit / Approve </a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

        </div>

        <hr>
        <div class="container">
            <h2> Registration forms reviewed</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>StudentID </th>
                        <th>Dissertation Title </th>
                        <th>Assessor </th>
                        <th>Status </th>
                        <th>Feedback </th>
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
                            <td>${r.registrationForm.assessor.userId}</td>
                            <td>${r.registrationForm.supervisorApproval.approvalStatus}</td>
                            <td>${r.registrationForm.supervisorApproval.feedbacks}</td>
                            <td> <a href="<%=application.getContextPath()%>/auth/approveRegistrationSupervisor?id=${r.registrationForm.registrationFormId}"> View </a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

        </div>
    </body>
</html>


