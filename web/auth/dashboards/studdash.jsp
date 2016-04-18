<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=application.getContextPath()%>/includes/css/header.css">
        <link rel="stylesheet" href="<%=application.getContextPath()%>/includes/css/default.css">
    </head>
    <body>
        <%@ include file="/includes/menu.jsp" %>

        <h1> Welcome to your Student Dashboard!</h1>


        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Registration Form <b>(Please complete all the forms below.)</b></h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-8 ">
                        <a href="<%=application.getContextPath()%>/auth/dissertationRegistration?reg=1"> Registration Form  </a><br />  
                        <a href="<%=application.getContextPath()%>/EthicsServlet?ethics=1"> Ethics Form 1  </a><br />
                        <a href="<%=application.getContextPath()%>/EthicsServlet?ethics=2"> Ethics Form 2 </a><br /><br />
                        <span class="error"><c:out value="${message}" /></span>
                    </div>
                </div>
            </div>

        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Your Submissions <span class="error"><c:out value="${decision}"/></span></h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    
                    <div class="col-sm-8 ">
                        Registration Form: <c:choose>
                                        <c:when test="${registration.registrationDate != null }">
                                            Submitted on <c:out value = "${registration.registrationDate}" /> <a href="">view</a>
                                       </c:when>
                                       <c:otherwise>
                                           No submission
                                       </c:otherwise>   
                                        </c:choose>
                                       <br /><br />     
                        Ethics Form 1: <c:choose>
                                        <c:when test="${ethics1.submissionDate != null }">
                                            Submitted on <c:out value = "${ethics1.submissionDate}" />  <a href="">view</a>
                                       </c:when>
                                       <c:otherwise>
                                           No submission
                                       </c:otherwise>   
                                        </c:choose>
                                            <br /><br />
                        Ethics Form 2: <c:choose>
                                        <c:when test="${ethics2.submissionDate != null }">
                                            Submitted on <c:out value = "${ethics2.submissionDate}" /> <a href="">view</a>
                                       </c:when>
                                       <c:otherwise>
                                           No submission
                                       </c:otherwise>   
                                        </c:choose>
                        <br /><br />
                        <a href="">See feedback</a>
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
                        <p> Registration Form due <strong> ${regevent.dueDate} </strong>	</p>
                        <p> Dissertation Proposal Submission due<strong> ${propevent.dueDate} </strong> </p>
                        <p> Presentation and Demonstration  <strong>${demoevent.dueDate}</strong> </p>
                        <p> Final Report submission due <strong>${finalevent.dueDate}</strong> </p>
                        <p> Short Paper due  <strong>${paperevent.dueDate}</strong> </p>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>