<%-- 
    Document   : proposalAssessment
    Created on : 18 mars 2016, 11:56:49
    Author     : Quentin
--%>
<%-- 
    Document   : proposalAssessmentv2
    Created on : 02-Apr-2016, 22:57:39
    Author     : Roger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Proposal Assessment</title>
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
            <h1> Proposal Assessment (10% of marks) </h1>
            <p> To be completed by supervisor and returned as feedback to student: </p>

            <form>

                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading"> Proposal Assessment - Details </div>
                        <div class="panel-body">

                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- first critera --%>
                                    <h4> Introduction and background </h4>
                                    <ul>
                                        <li> Overview of subject area, originality and theoretical framework </li>
                                        <li> Rationale for choice </li>
                                        <li> Aims and objectives </li>
                                        <li> Practical application </li>
                                        <li> Survey and evaluation of relevant material </li>
                                    </ul>
                                </div>
                                <div class="col-sm-2">
                                    <%-- Supervisor mark on first criteria --%>
                                    <h4> Marks out of  </h4>
                                    <input class="form-control" id="intro_marks" type="number" name="intro_marks"> <span> /20 </span> 
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor comments on first criteria --%>
                                    <h4> Comments: </h4>
                                    <textarea class="form-control" rows="5" id="comment_intro" name="intro_comments"></textarea>
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- second criteria --%>
                                    <h4> Methodology, Resources and Professional Issues </h4>
                                    <ul>
                                        <li> Development or solution approach to achieve objectives </li>
                                        <li> Equipment: hardware, software, and expert help needed. </li>
                                        <li> Test and evaluation methods </li>
                                        <li> LSEPI and risk management issues </li>
                                    </ul>
                                </div>
                                <div class="col-sm-2">
                                    <%-- Supervisor mark on second criteria --%>
                                    <h4> Marks out of </h4>                                    
                                    <input class="form-control" id="methodology_marks" type="number" name="methodology_marks"> <span> /20 </span> 
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor comments on second criteria --%>
                                    <h4> Comments: </h4>                                    
                                    <textarea class="form-control" rows="5" id="methodology_comments" name="methodology_comments"></textarea>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- third criteria --%>
                                    <h4> Project Plan </h4>
                                    <ul>
                                        <li> Tasks and milestones </li>
                                        <li> Plan of activities with time allocation (Gantt chart) </li>
                                        <li> Outcomes and deliverables </li>
                                    </ul>
                                </div>
                                <div class="col-sm-2">
                                    <%-- Supervisor mark on third criteria --%>
                                    <h4> Marks out of  </h4>
                                    <input class="form-control" id="plan_marks" type="number" name="plan_marks"> <span> /20 </span> 
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor comments on third criteria --%>
                                    <h4> Comments: </h4>
                                    <textarea class="form-control" rows="5" id="plan_comments" name="plan_comments"></textarea>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- fourth criteria --%>
                                    <h4> Progress and achievement to date </h4>
                                    <ul>
                                        <li> Work completed in relation to each objective </li>
                                        <li> Problems encountered with solutions proposed </li>
                                        <li> Use of supervision </li>
                                    </ul>
                                </div>
                                <div class="col-sm-2">
                                    <%-- Supervisor mark on fourth criteria --%>
                                    <h4> Marks out of  </h4>
                                    <input class="form-control" id="achievement_marks" type="number" name="achievement_marks"> <span> /20 </span> 
                                </div>

                                <div class="col-sm-6">
                                    <h4> Comments: </h4>
                                    <%-- Supervisor comments on fourth criteria --%>
                                    <textarea class="form-control" rows="5" id="achievement_comments" name="achievement_comments"></textarea>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- fifth criteria --%>
                                    <h4> Written presentation </h4>
                                    <ul>
                                        <li> Structure, Clarity & logical presentation </li>
                                        <li> Citations and references. </li>
                                    </ul>
                                </div>
                                <div class="col-sm-2">
                                    <%-- Supervisor mark on fifth criteria --%>
                                    <h4> Marks out of  </h4>
                                    <input class="form-control" id="presentation_marks" type="number" name="presentation_marks"> <span> /20 </span> 
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor comments on fifth criteria --%>
                                    <h4> Comments: </h4>
                                    <textarea class="form-control" rows="5" id="presentation_comments" name="presentation_comments"></textarea>
                                </div>
                            </div>


                        </div>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-heading"> Proposal Total </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- Supervisor given overall mark for student proposal --%>
                                    <h4> Overall Proposal mark %</h4>
                                    <input class="form-control" id="proposal_mark" type="number" name="proposal_mark"> 
                                </div>
                                <div class="col-sm-2">
                                    <%-- Weighted 10% of marks for student proposal --%>
                                    <h4> Proposal  Total </h4>
                                    <input class="form-control" id="proposal_total" type="number" name="proposal_total"> <span> /10 </span> 
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor overall comments on student proposal --%>
                                    <h4> Overall Comments: </h4>
                                    <textarea class="form-control" rows="5" id="proposalOverall_comment"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                                    
                <%-- Button to submit Supervisor marks and comments on student proposal --%>                    
                <input type="submit" value="Submit" class="btn btn-default"  />
                <br/>
                <br/>
                <br/>
            </form>
        </div>
    </body>
</html>
