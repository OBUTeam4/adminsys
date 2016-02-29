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

        <h1> Welcome to your Student Dashboard!</h1>


        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Registration Form</h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-8 ">
                        <p> Not Submitted Yet! <strong> ${studentRegistrationForm} </strong>	</p>
                    </div>
                </div>
            </div>

        </div>


        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Upcoming Events</h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-8 ">
                        <p> Registration Form due <strong> ${studentRegistrationFormDate} </strong>	</p>
                        <p> Dissertation Proposal Submission due<strong>${studentProposalDate} </strong> </p>
                        <p> Presentation and Demonstration : <strong>${studentPresentationDate}</strong> </p>
                        <p> Final Report submission due <strong>${studentFinalReportDate}</strong> </p>
                        <p> Short Paper due  <strong>${studentShortPaperDate}</strong> </p>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>