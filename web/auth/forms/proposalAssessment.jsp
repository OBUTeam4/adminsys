<%-- 
    Document   : proposalAssessment
    Created on : 18 mars 2016, 11:56:49
    Author     : Quentin
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
            <h1>Proposal Assessment (10% of mark) </h1>
            <p> To be completed by supervisor and returned as feedback to student: </p>

            <div class="panel-group">

                <div class="panel panel-default">
                    <div class="panel-heading">Introduction and background</div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <h4> Description of criteria</h4>
                                <ul>
                                    <li> Overview of subject area, originality and theoretical framework </li>
                                    <li> Rationale for choice  </li>
                                    <li> Aims and objectives </li>
                                    <li> Practical application  </li>
                                    <li> Survey and evaluation of relevant material </li>
                                </ul>
                            </div>
                            <div class="col-sm-2">
                                <h4> Marks out of  </h4>
                                <input class="form-control" id="ex1" type="text"> <span> /20 </span> 
                            </div>

                            <div class="col-sm-6">
                                <h4> Comments: </h4>
                                <textarea class="form-control" rows="5" id="comment"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">Methodology, Resources and Professional Issues</div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <h4> Description of criteria</h4>
                                <ul>
                                    <li> Development or solution approach to achieve objectives </li>
                                    <li> Equipment: hardware, software, and expert help needed. </li>
                                    <li> Test and evaluation methods </li>
                                    <li> LSEPI and risk management issues  </li>
                                </ul>
                            </div>
                            <div class="col-sm-2">
                                <h4> Marks out of  </h4>
                                <input class="form-control" id="ex1" type="text"> <span> /20 </span> 
                            </div>

                            <div class="col-sm-6">
                                <h4> Comments: </h4>
                                <textarea class="form-control" rows="5" id="comment"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">Project Plan</div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <h4> Description of criteria</h4>
                                <ul>
                                    <li> Tasks and milestones </li>
                                    <li> Plan of activities with time allocation (Gantt chart)  </li>
                                    <li> Outcomes and deliverables</li>
                                </ul>
                            </div>
                            <div class="col-sm-2">
                                <h4> Marks out of  </h4>
                                <input class="form-control" id="ex1" type="text"> <span> /20 </span> 
                            </div>

                            <div class="col-sm-6">
                                <h4> Comments: </h4>
                                <textarea class="form-control" rows="5" id="comment"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">Progress and achievement to date</div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <h4> Description of criteria</h4>
                                <ul>
                                    <li> Work completed in relation to each objective </li>
                                    <li> Problems encountered with solutions proposed  </li>
                                    <li> Use of supervision </li>
                                </ul>
                            </div>
                            <div class="col-sm-2">
                                <h4> Marks out of  </h4>
                                <input class="form-control" id="ex1" type="text"> <span> /20 </span> 
                            </div>

                            <div class="col-sm-6">
                                <h4> Comments: </h4>
                                <textarea class="form-control" rows="5" id="comment"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">Written presentation </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <h4> Description of criteria</h4>
                                <ul>
                                    <li> Structure, Clarity & logical presentation </li>
                                    <li> Citations and references.  </li>
                                </ul>
                            </div>
                            <div class="col-sm-2">
                                <h4> Marks out of  </h4>
                                <input class="form-control" id="ex1" type="text"> <span> /20 </span> 
                            </div>

                            <div class="col-sm-6">
                                <h4> Comments: </h4>
                                <textarea class="form-control" rows="5" id="comment"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel panel-primary">
                    <div class="panel-heading"> Proposal Total </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <h4> Overall Proposal %mark</h4>
                                
                            </div>
                            <div class="col-sm-2">
                                <h4> Proposal  Total </h4>
                                <input class="form-control" id="ex1" type="text"> <span> /10 </span> 
                            </div>

                            <div class="col-sm-6">
                                <h4> Overall Comments: </h4>
                                <textarea class="form-control" rows="5" id="comment"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
