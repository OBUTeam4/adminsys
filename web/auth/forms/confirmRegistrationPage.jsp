<%-- 
    Document   : confirmRegistrationPage
    Created on : 31-Mar-2016, 19:33:49
    Author     : oussamak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Registration Form</title>
        <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"> -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/css/header.css">
        <link rel="stylesheet" href="<%=application.getContextPath()%>/includes/css/default.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    </head>
    <body>
        <%@ include file="/includes/menu.jsp" %>  

        <br/>
        
        <div class="container">
            

            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">

                    <div class="container">
                        <h3>Registration: due semester <c:out value="${semester.semesterId}" />, <c:out value="${event.dueDate}" /></h3>
                        <form method="GET"  action="dissertationRegistration" role="form">
                            <div class="form-group">
                                <label>Start Date: <c:out value="${semester.startDate}" /></label> 
                                <label>Completion Date: <c:out value="${semester.completionDate}" /></label><br />
                            </div>
                            <hr>
                            <div class="form-group">
                                This is a confirmation page, please verify your data and press submit button. If you want to change your data press edit button. 
                            </div>
                            <div class="form-group">
                                <label for="diss_mod_code" ><b>Dissertation Module Code:</b></label><label> <c:out value="${moduleCode}" /></label><br />
                            </div>
                            
                            <div class="form-group">
                                <label for="diss_title" ><b>Dissertation Title: </b></label><label><c:out value="${project.dissertationTitle}" /></label><br />
                            </div>
                            
                            <div class="form-group">
                                <label for="supervisor"><b>Supervisor:  </b></label><label> <c:out value="${supervisor}" /></label><br />
                            </div>
                            
                            <div class="form-group">
                                <label for="diss_parties"><b>Related Parties:</b></label><label><c:out value="${project.relatedParties}" /></label><br />
                            </div>
                            <div class="form-group">
                                <label for="subjectArea"><b>Subject area and relationship to course:</b></label><label>  <c:out value="${project.subjectArea}" /></label><br />
                            </div>
                            <br />
                            <div class="form-group">
                                <label for="projectAim"><b>Project aim and objectives:</b></label><label> <c:out value="${project.projectAim}" /></label><br />
                            </div>
                            <div class="form-group">
                                <label for="literature"><b>Literature influencing work:</b></label><label>  <c:out value="${project.literature}" /></label><br />
                            </div>
                            <br />
                            <div class="form-group">
                                <label for="diss_hypothesis"><b>Hypothesis, proposition, research question or outline specification:</b></label>
                                <label><c:out value="${project.hypothesis}" /></label><br />
                            </div>
                            <br /><br />
                            <div class="form-group">
                                <label for="diss_deliverables"><b>Proposed Deliverables:</b></label><label> <c:out value="${project.deliverables}" /></label><br />
                            </div>
                            <input   class="btn btn-default" type="submit" name="submit" value = "Submit"/>
                            <input   class="btn btn-default" type="submit" name="edit" value = "Edit"/><br /><br />
                            <span class="error"><c:out value="${message}"/></span>
                        </form>

                    </div>
                </div>
            </div>
        </div>

    </body>
</html>

