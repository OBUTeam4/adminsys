<%-- 
    Document   : feedbacksv2
    Created on : 18 mars 2016, 11:56:49
    Author     : Quentin
--%>
<%-- 
    Document   : feedbacksv2
    Created on : 26-Mar-2016, 03:19:46
    Author     : Roger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> PRESENTATION/DEMONSTRATION & FINAL REPORT – QUALITATIVE STUDENT FEEDBACK </title>
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
            <h1>PRESENTATION/DEMONSTRATION & FINAL REPORT – QUALITATIVE STUDENT FEEDBACK </h1>
            <p> To be completed and agreed by supervisor and second assessor: </p>
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home"> Presentation and Demonstration Feedback </a></li>
                <li><a data-toggle="tab" href="#menu1"> Final Report Feedback </a></li>
                <li><a data-toggle="tab" href="#menu2"> Short Paper Feedback </a></li>
            </ul>

            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <h3> Presentation and Demonstration Feedback </h3>
                    <div class="panel-body">    
                        <div class="row">
                            <div class="col-sm-4">
                                <h4> Description of criteria </h4>
                            </div>
                            <div class="col-sm-6">
                                <h4> Comments: </h4>
                            </div>
                        </div>
                    </div>                    
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <p> Presentation quality </p>
                            </div>
                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor agreed comment on Presentation quality criteria --%>
                                <textarea class="form-control" rows="3" id="presentationQuality_comment" readonly></textarea>  
                            </div>    
                        </div>        
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <p> Scholarly content </p>
                            </div>
                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor agreed comment on Scholarly content criteria --%>
                                <textarea class="form-control" rows="3" id="scholarlyContent_comment" readonly></textarea>  
                            </div>    
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <p> Progress and achievement </p>
                            </div>
                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor agreed comment on Progress and achievement criteria --%>
                                <textarea class="form-control" rows="3" id="progressAchievement_comment" readonly></textarea>  
                            </div>    
                        </div>
                    </div>    
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <p> Response to questions </p>
                            </div>
                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor agreed comment on Response to questions criteria --%>
                                <textarea class="form-control" rows="3" id="responseQuestions_comment" readonly></textarea>  
                            </div>    
                        </div>                       
                    </div>
                </div>

                <div id="menu1" class="tab-pane fade">
                    <h3> Final Report Feedback </h3>
                    <div class="panel-body">    
                        <div class="row">
                            <div class="col-sm-4">
                                <h4> Description of criteria </h4>
                            </div>
                            <div class="col-sm-6">
                                <h4> Comments: </h4>
                            </div>
                        </div>
                    </div> 
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <p> Background and Research </p>
                            </div>
                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor agreed comment on Background and Research criteria --%>
                                <textarea class="form-control" rows="3" id="backgroundResearch_comment" readonly></textarea>  
                            </div>    
                        </div>        
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <p> Technical/practical effectiveness </p>
                            </div>
                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor agreed comment on Technical/practical effectiveness criteria --%>
                                <textarea class="form-control" rows="3" id="technicalPractical_comment" readonly></textarea>  
                            </div>    
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <p> Critical appraisal </p>
                            </div>
                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor agreed comment on Critical appraisal criteria --%>
                                <textarea class="form-control" rows="3" id="criticalAppraisal_comment" readonly></textarea>  
                            </div>    
                        </div>
                    </div>    
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <p> Written presentation </p>
                            </div>
                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor agreed comment on short paper Written presentation criteria --%>
                                <textarea class="form-control" rows="3" id="finalWrittenPresentation_comment" readonly></textarea>  
                            </div>    
                        </div>                       
                    </div>
                </div>

                <div id="menu2" class="tab-pane fade">
                    <h3> Short Paper Feedback </h3>
                    <div class="panel-body">    
                        <div class="row">
                            <div class="col-sm-4">
                                <h4> Description of criteria </h4>
                            </div>
                            <div class="col-sm-6">
                                <h4> Comments: </h4>
                            </div>
                        </div>
                    </div> 
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <p> Introduction and Background </p>
                            </div>
                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor agreed comment on Introduction and Background criteria --%>
                                <textarea class="form-control" rows="3" id="introduction_comment" readonly></textarea>  
                            </div>    
                        </div>        
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <p> Developmental approach </p>
                            </div>
                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor agreed comment on Developmental approach criteria --%>
                                <textarea class="form-control" rows="3" id="developmentalApproach_comment" readonly></textarea>  
                            </div>    
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <p> Results </p>
                            </div>
                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor agreed comment on Results criteria --%>
                                <textarea class="form-control" rows="3" id="resultsCriteria_comment" readonly></textarea>  
                            </div>    
                        </div>
                    </div>    
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <p> Discussion and conclusion </p>
                            </div>
                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor agreed comment on Discussion and conclusion criteria --%>
                                <textarea class="form-control" rows="3" id="discussionConclusion_comment" readonly></textarea>  
                            </div>    
                        </div>                       
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <p> Written presentation </p>
                            </div>
                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor agreed comment on Written presentation criteria --%>
                                <textarea class="form-control" rows="3" id="shortWrittenPresentation_comment" readonly></textarea>  
                            </div>    
                        </div>                       
                    </div>
                </div>
            </div>
    </body>
</html>
