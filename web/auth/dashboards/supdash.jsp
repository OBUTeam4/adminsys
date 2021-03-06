<%-- 
    Document   : supdash.jsp
    Created on : 29-Feb-2016, 02:01:16
    Author     : oussamak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/css/header.css">
        <link rel="stylesheet" href="<%=application.getContextPath()%>/includes/css/default.css">
    </head>
    <body>
        <%@ include file="/includes/menu.jsp" %>

        <div class="container">

            <h1> Welcome to your Supervisor Dashboard!</h1>

            <div class="panel panel-default">

                <div class="panel-heading">
                    <h3 class="panel-title">Marks and Comments</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-8 ">

                            <ul>
                                <li><a class="" href="<%=application.getContextPath()%>/auth/listRegistrationForms"> Registration Forms </a> </li>
                                <li><a class="" href="<%=application.getContextPath()%>/auth/listProposal">Proposal </a>  </li>
                                <li><a class="" href="<%=application.getContextPath()%>/auth/listDemo">Demonstration and Presentation </a>  </li>
                                <li><a class="" href="<%=application.getContextPath()%>/auth/listFinalReport">Final Report </a> </li>
                                <li><a class="" href="<%=application.getContextPath()%>/auth/listShortPaper">Short Paper </a>  </li>
                                <li><a class="" href="<%=application.getContextPath()%>/auth/listTurnitin">Turnitin Checks </a>  </li>
                                <li><a href="<%=application.getContextPath()%>/auth/forms/feedbacks.jsp"> PRESENTATION/DEMONSTRATION & FINAL REPORT – QUALITATIVE STUDENT FEEDBACK</a></li>
                            </ul>

                        </div>
                    </div>
                </div>

            </div>
        </div>
                            
    </body>
</html>