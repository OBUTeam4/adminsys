<%-- 
    Document   : formsTesting
    Created on : 18 mars 2016, 12:16:20
    Author     : Quentin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Proposal Assessment</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/css/header.css">
        <link rel="stylesheet" href="<%=application.getContextPath()%>/includes/css/default.css">
    </head>
    <body>
        <%@ include file="/includes/menu.jsp" %>  
        <div>
            <a href="<%=application.getContextPath()%>/auth/forms/proposalAssessment.jsp"> Proposal Assessment</a> </br>
            <a href="<%=application.getContextPath()%>/auth/forms/proposalAssessmentv2.jsp"> Proposal Assessment V2</a> </br>

            <a href="<%=application.getContextPath()%>/auth/forms/presentationAssessment.jsp"> Presentation & demo Assessment</a> </br>
            <a href="<%=application.getContextPath()%>/auth/forms/finalReportAssessment.jsp"> Final report Assessment</a> </br>
            <a href="<%=application.getContextPath()%>/auth/forms/shortPaperAssessment.jsp"> Short paper Assessment</a> </br>
            <a href="<%=application.getContextPath()%>/auth/forms/feedbacks.jsp"> PRESENTATION/DEMONSTRATION & FINAL REPORT – QUALITATIVE STUDENT FEEDBACK</a> </br>
            <a href="<%=application.getContextPath()%>/auth/forms/registrationForm.jsp"> registration form </a> </br>


            <a href="<%=application.getContextPath()%>/auth/roger/ethicsFormOnev2.jsp"> e1 form </a> </br>
            <a href="<%=application.getContextPath()%>/auth/roger/ethicsFormTwov2.jsp"> e2 form </a> </br>

            <a href="<%=application.getContextPath()%>/auth/forms/EthicsForm1.jsp"> e1 form </a> </br>
            <a href="<%=application.getContextPath()%>/auth/forms/EthicsForm2.jsp"> e2 form </a> </br>
        </div>
    </body>
</html>