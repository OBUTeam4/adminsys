<%-- 
    Document   : presentationAssessmentv2
    Created on : Mar 25, 2016, 3:30:06 PM
    Author     : Roger-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Presentation and Demonstration Assessment </title>
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
            <h1>Presentation and Demonstration Assessment (10% of marks) </h1>
            <p> To be completed by supervisor or second assessor: </p>

            <form>
                <div class="panel-group">

                    <div class="panel panel-default">
                        <div class="panel-heading"> Quality of presentation </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- first criteria --%>
                                    <h4> Description of criteria </h4>
                                    <ul>
                                        <li> Materials </li>
                                        <li> Problem elucidation  </li>
                                        <li> Clarity </li>
                                        <li> Interest and enthusiasm  </li>
                                        <li> Structure </li>
                                    </ul>
                                </div>
                                <div class="col-sm-2">
                                    <%-- Supervisor or second assessor mark on first criteria --%>
                                    <h4> Marks out of  </h4>                                
                                    <input class="form-control" id="quality_marks" type="number" name="quality_marks"> <span> /20 </span>
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor or second assessor comments on first criteria --%>
                                    <h4> Comments: </h4>
                                    <textarea class="form-control" rows="5" id="quality_comments" name="quality_comments"></textarea>                                
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading"> Scholarly content </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- second criteria --%>
                                    <h4> Description of criteria </h4>
                                    <ul>
                                        <li> Context, aim, objectives and organisation </li>
                                        <li> Research background and use of literature </li>
                                        <li> Evidence of understanding (breadth and depth) </li>
                                        <li> Methodology choice </li>
                                    </ul>
                                </div>
                                <div class="col-sm-2">
                                    <%-- Supervisor or second assessor mark on second criteria --%>
                                    <h4> Marks out of  </h4>                               
                                    <input class="form-control" id="scholar_marks" type="number" name="scholar_marks"> <span> /20 </span>
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor or second assessor comments on second criteria --%>
                                    <h4> Comments: </h4>                                
                                    <textarea class="form-control" rows="5" id="scholar_comments" name="scholar_comments"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading"> Progress and achievement </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- third criteria --%>
                                    <h4> Description of criteria </h4>
                                    <ul>
                                        <li> Development process </li>
                                        <li> Results and implication of work </li>
                                        <li> Achievement in terms of planned objectives </li>
                                        <li> Identification of relevant wider and professional issues </li>
                                        <li> Project management </li>
                                        <li> Critical Evaluation </li>
                                        <li> Effective demonstration </li>
                                    </ul>
                                </div>
                                <div class="col-sm-2">
                                    <%-- Supervisor or second assessor mark on third criteria --%>
                                    <h4> Marks out of  </h4>                                                                 
                                    <input class="form-control" id="progress_marks" type="number" name="progress_marks"> <span> /40 </span>
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor or second assessor comments on third criteria --%>
                                    <h4> Comments: </h4>                                
                                    <textarea class="form-control" rows="5" id="progress_comments" name="progress_comments"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading"> Response to Questions </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- fourth criteria --%>
                                    <h4> Description of criteria </h4>
                                    <ul>
                                        <li> Knowledge and understanding </li>
                                    </ul>
                                </div>
                                <div class="col-sm-2">
                                    <%-- Supervisor or second assessor mark on fourth criteria --%>
                                    <h4> Marks out of </h4>                                
                                    <input class="form-control" id="response_marks" type="number" name="response_marks"> <span> /20 </span>
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor or second assessor comments on fourth criteria --%>
                                    <h4> Comments: </h4>                                
                                    <textarea class="form-control" rows="5" id="response_comments" name="response_comments"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-heading"> Presentation Total </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- Supervisor or second assessor given overall mark for student presentation --%>
                                    <h4> Supervisor or Second Assessor presentation mark % </h4>
                                    <input class="form-control" id="presdemo_mark" type="number" name="presdemo_mark">                                
                                </div>
                                <div class="col-sm-2">
                                    <%-- Weighted 10% of marks for student presentation --%>
                                    <h4> Pres./Demo. Mark </h4>                                
                                    <input class="form-control" id="presdemo_total" type="number" name="presdemo_total"> <span> /10 </span>
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor or second assessor overall comments on student presentation --%>
                                    <h4> Overall Comments: </h4>
                                    <textarea class="form-control" rows="5" id="presentationOverall_comment"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-heading"> Presentation Agreed Final Mark </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- Supervisor or second assessor agreed final mark for student presentation --%>
                                    <h4> Agreed Final Presentation and Demonstration mark </h4>                                                             
                                </div>
                                <div class="col-sm-2">
                                    <%-- Agreed percent mark for student presentation --%>
                                    <h4> As % mark </h4>
                                    <input class="form-control" id="presdemoPercent_mark" type="number" name="presdemoPercent_mark">                                 
                                </div>

                                <div class="col-sm-6">
                                    <%-- Agreed range mark for student presentation --%>
                                    <h4> As 0-10 mark </h4>
                                    <input class="form-control" id="presdemoRange_mark" type="number" name="presdemoRange_mark">                                 
                                </div>
                            </div>
                        </div>
                    </div> 
                                    
                </div>

                <%-- Button to submit Supervisor or second assessor marks and comments on student presentation --%>                    
                <input type="submit" value="Submit" class="btn btn-default"  />
                <br/>
                <br/>
                <br/>

            </form>
        </div>
    </body>
</html>


