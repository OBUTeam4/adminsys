<%-- 
    Document   : shortPaperAssessmentv2
    Created on : 26-Mar-2016, 01:43:05
    Author     : Roger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Short Paper Assessment </title>
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
            <h1>Short Paper Assessment (10% of marks) </h1>
            <p> To be completed by supervisor or second assessor: </p>

            <form>
            <div class="panel-group">

                <div class="panel panel-default">
                    <div class="panel-heading"> Introduction and background </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <%-- first criteria --%>
                                <h4> Description of criteria </h4>
                                <ul>
                                    <li> Abstract, introduction </li>
                                    <li> Research question or thesis </li>
                                    <li> Theoretical background </li>
                                    <li> Originality </li>                                    
                                </ul>
                            </div>
                            <div class="col-sm-2">
                                <%-- Supervisor or second assessor mark on first criteria --%>
                                <h4> Marks out of  </h4>
                                <input class="form-control" id="shortIntro_marks" type="number" name="shortIntro_marks"> <span> /20 </span>                       
                            </div>

                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor comments on first criteria --%>
                                <h4> Comments: </h4>
                                <textarea class="form-control" rows="5" id="shortIntro_comments" name="shortIntro_comments"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading"> Developmental approach </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <%-- second criteria --%>
                                <h4> Description of criteria </h4>
                                <ul>
                                    <li> Specifications </li>
                                    <li> Constraints & limitations </li>
                                    <li> Development process or methodology </li>
                                    <li> Testing and Evaluation </li>
                                </ul>
                            </div>
                            <div class="col-sm-2">
                                <%-- Supervisor or second assessor mark on second criteria --%>
                                <h4> Marks out of  </h4>
                                <input class="form-control" id="developmental_marks" type="number" name="developmental_marks"> <span> /20 </span>                                 
                            </div>

                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor comments on second criteria --%>
                                <h4> Comments: </h4>                                
                                <textarea class="form-control" rows="5" id="developmental_comments" name="developmental_comments"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading"> Results </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <%-- third criteria --%>
                                <h4> Description of criteria </h4>
                                <ul>
                                    <li> Achievement and limitations </li>
                                    <li> Contribution to the field </li>
                                </ul>
                            </div>
                            <div class="col-sm-2">
                                <%-- Supervisor or second assessor mark on third criteria --%>
                                <h4> Marks out of  </h4>
                                <input class="form-control" id="results_marks" type="number" name="results_marks"> <span> /20 </span>                                
                            </div>

                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor comments on third criteria --%>
                                <h4> Comments: </h4>                                
                                <textarea class="form-control" rows="5" id="results_comments" name="results_comments"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading"> Discussion and conclusion </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <%-- fourth criteria --%>
                                <h4> Description of criteria </h4>
                                <ul>
                                    <li> Applications </li>
                                    <li> Critical appraisal </li>
                                    <li> Professional and wider issues </li>
                                    <li> Further work </li>
                                </ul>
                            </div>
                            <div class="col-sm-2">
                                <h4> Marks out of  </h4>
                                <%-- Supervisor or second assessor mark on fourth criteria --%>                                
                                <input class="form-control" id="discussion_marks" type="number" name="discussion_marks"> <span> /20 </span>
                            </div>

                            <div class="col-sm-6">
                                <h4> Comments: </h4>
                                <%-- Supervisor or second assessor comments on fourth criteria --%>
                                <textarea class="form-control" rows="5" id="discussion_comments" name="discussion_comments"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading"> Written presentation </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <%-- fifth criteria --%>
                                <h4> Description of criteria </h4>
                                <ul>
                                    <li> Structure </li>
                                    <li> Clarity </li>
                                    <li> Readability </li>
                                    <li> Referencing </li>
                                </ul>
                            </div>
                            <div class="col-sm-2">
                                <%-- Supervisor or second assessor mark on fifth criteria --%>
                                <h4> Marks out of  </h4>
                                <input class="form-control" id="shortWritten_marks" type="number" name="shortWritten_marks"> <span> /20 </span>
                                <input class="form-control" id="ex1" type="text"> <span> /20 </span> 
                            </div>

                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor comments on fifth criteria --%>
                                <h4> Comments: </h4>
                                <textarea class="form-control" rows="5" id="shortWritten_comments" name="shortWritten_comments"></textarea>
                            </div>
                        </div>
                    </div>
                    
                </div>
                
                <div class="panel panel-primary">
                    <div class="panel-heading"> Short Paper Total </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <%-- Supervisor or second assessor given overall mark for student short paper --%>
                                <h4> Supervisor or Second Assessor Short Paper mark % </h4>
                                <input class="form-control" id="shortPaper_mark" type="number" name="shortPaper_mark">
                            </div>
                            <div class="col-sm-2">
                                <%-- Weighted 10% of marks for student short paper --%>
                                <h4> Final Report Mark </h4>
                                <input class="form-control" id="shortPaper_total" type="number" name="shortPaper_total"> <span> /10 </span>                                 
                            </div>

                            <div class="col-sm-6">
                                <%-- Supervisor or second assessor overall comments on student short paper --%>
                                <h4> Overall Comments: </h4>
                                <textarea class="form-control" rows="5" id="shortPaperOverall_comment"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="panel panel-primary">
                    <div class="panel-heading"> Short Paper Agreed Final Mark </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <%-- Supervisor or second assessor agreed final mark for student short paper --%>
                                <h4> Agreed Final Report mark </h4>                                                             
                            </div>
                            <div class="col-sm-2">
                                <%-- Agreed percent mark for student short paper --%>
                                <h4> As % mark </h4>
                                <input class="form-control" id="shortPercent_mark" type="number" name="shortPercent_mark">                                 
                            </div>

                            <div class="col-sm-6">
                                <%-- Agreed range mark for student short paper --%>
                                <h4> As 0-10 mark </h4>
                                <input class="form-control" id="shortRange_mark" type="number" name="shortRange_mark">                                 
                            </div>
                        </div>
                    </div>
                </div>                
                                
            </div>
            <%-- Button to submit Supervisor or second assessor marks and comments on student short paper --%>
            <input type="submit" value="Submit" class="btn btn-default"  />
                <br/>
                <br/>
                <br/>
                
        </form>
        </div>
    </body>
</html>
