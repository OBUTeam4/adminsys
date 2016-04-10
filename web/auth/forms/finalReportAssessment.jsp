<%-- 
    Document   : finalReportAssessmentv2
    Created on : 26-Mar-2016, 00:43:28
    Author     : Roger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Final Report Assessment </title>
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
            <h1> Final Report Assessment (70% of marks) </h1>
            <p> To be completed by supervisor or second assessor: </p>

            <form>
                <div class="panel-group">

                    <div class="panel panel-default">
                        <div class="panel-heading"> Background research and theory </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- first criteria --%>
                                    <h4> Description of criteria </h4>
                                    <ul>
                                        <li> Theoretical framework </li>
                                        <li> Knowledge of tools and technologies </li>
                                        <li> Justification and use of chosen methods and tools </li>
                                        <li> Literature survey and use of sources </li>                                    
                                    </ul>
                                </div>
                                <div class="col-sm-2">
                                    <%-- Supervisor or second assessor mark on first criteria --%>
                                    <h4> Marks out of  </h4>                                
                                    <input class="form-control" id="background_marks" type="number" name="background_marks"> <span> /20 </span>
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor or second assessor comments on first criteria --%>
                                    <h4> Comments: </h4>                                
                                    <textarea class="form-control" rows="5" id="background_comments" name="background_comments"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading"> Technical/practical effectiveness </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- second criteria --%>
                                    <h4> Description of criteria </h4>
                                    <ul>
                                        <li> Description of development process or methodology </li>
                                        <li> Constraints & limitations </li>
                                        <li> Original contribution </li>
                                        <li> Understanding of issues </li>
                                        <li> Academic achievement </li>
                                        <li> Evaluation and discussion </li>
                                        <li> Dissertation Conclusion </li>
                                    </ul>
                                </div>
                                <div class="col-sm-2">
                                    <%-- Supervisor or second assessor mark on second criteria --%>
                                    <h4> Marks out of  </h4>                                
                                    <input class="form-control" id="technical_marks" type="number" name="technical_marks"> <span> /30 </span>
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor or second assessor comments on second criteria --%>
                                    <h4> Comments: </h4>
                                    <textarea class="form-control" rows="5" id="technical_comments" name="technical_comments"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading"> Critical appraisal of: </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- third criteria --%>
                                    <h4> Description of criteria </h4>
                                    <ul>
                                        <li> Dissertation results or achievement </li>
                                        <li> Research methods </li>
                                        <li> Development methodology </li>
                                        <li> Project management </li>
                                        <li> Relevant legal, social, ethical and professional issues </li>
                                        <li> Risk management issues </li>
                                        <li> Your professional development </li>
                                    </ul>
                                </div>
                                <div class="col-sm-2">
                                    <%-- Supervisor or second assessor mark on third criteria --%>
                                    <h4> Marks out of  </h4>                                
                                    <input class="form-control" id="critical_marks" type="number" name="critical_marks"> <span> /10 </span>
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor or second assessor comments on third criteria --%>
                                    <h4> Comments: </h4>
                                    <textarea class="form-control" rows="5" id="critical_comments" name="critical_comments"></textarea>                                
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading"> Written presentation </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- fourth criteria --%>
                                    <h4> Description of criteria </h4>
                                    <ul>
                                        <li> Structure </li>
                                        <li> Clarity & Presentation </li>
                                        <li> Readability </li>
                                        <li> Citations and references </li>
                                    </ul>
                                </div>
                                <div class="col-sm-2">
                                    <%-- Supervisor or second assessor mark on fourth criteria --%>
                                    <h4> Marks out of  </h4>
                                    <input class="form-control" id="written_marks" type="number" name="written_marks"> <span> /10 </span>                                 
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor or second assessor comments on fourth criteria --%>
                                    <h4> Comments: </h4>
                                    <textarea class="form-control" rows="5" id="written_comments" name="written_comments"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-heading"> Final Report Total </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- Supervisor or second assessor given overall mark for student final report --%>
                                    <h4> Supervisor or Second Assessor Final Report mark % </h4>
                                    <input class="form-control" id="finalReport_mark" type="number" name="finalReport_mark">
                                </div>
                                <div class="col-sm-2">
                                    <%-- Weighted 70% of marks for student final report --%>
                                    <h4> Final Report Mark </h4>                               
                                    <input class="form-control" id="finalReport_total" type="number" name="finalReport_total"> <span> /70 </span>
                                </div>

                                <div class="col-sm-6">
                                    <%-- Supervisor or second assessor overall comments on student final report --%>
                                    <h4> Overall Comments: </h4>
                                    <textarea class="form-control" rows="5" id="finalReportOverall_comment"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-heading"> Final Report Agreed Final Mark </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <%-- Supervisor or second assessor agreed final mark for student final report --%>
                                    <h4> Agreed Final Report mark </h4>                                                             
                                </div>
                                <div class="col-sm-2">
                                    <%-- Agreed percent mark for student final report --%>
                                    <h4> As % mark </h4>
                                    <input class="form-control" id="finalPercent_mark" type="number" name="finalPercent_mark">                                 
                                </div>

                                <div class="col-sm-6">
                                    <%-- Agreed range mark for student final report --%>
                                    <h4> As 0-10 mark </h4>
                                    <input class="form-control" id="finalRange_mark" type="number" name="finalRange_mark">                                 
                                </div>
                            </div>
                        </div>
                    </div>
                                    
                </div>

                <%-- Button to submit Supervisor or second assessor marks and comments on student final report --%>                 
                <input type="submit" value="Submit" class="btn btn-default"  />
                <br/>
                <br/>
                <br/>

            </form>
        </div>
    </body>
</html>

