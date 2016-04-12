<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Msc Project HOME</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/css/header.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/css/default.css">
    </head>
    <body>
        <%@ include file="../includes/menu.jsp" %>

        <div class="container">
            <h1> Welcome to the MSc Projects website!</h1>


            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">On this website you can:</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12 ">
                            <p> As a student: </p>
                            <ul>
                                <li> Register your dissertation form</li>
                                <li> Check if your registration form is approved / disapproved and read the feedbacks from your supervisor and module leader. </li>
                                <li> View your marks and comments of the Proposal, Presentation, Final report and Short Paper </li>
                            </ul>

                            <% if (session.getAttribute("user") == null) {%>
                            <p> As a student you need to <a href="<%=application.getContextPath()%>/register">Register</a> first.</p>  
                            <% }%>
                        </div>
                    </div>
                </div>

                <hr>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12 ">
                            <p> As a staff member (supervisor/module leader/assessor/admin):</p>
                            <ul>
                                <li> You can manage student registration forms.</li>
                                <li> Assess Proposal, Presentation, Final report, Short Paper </li>
                                <li> Generate spreadsheet. </li>
                                <li> See statistics </li>
                            </ul>

                            <% if (session.getAttribute("user") == null) {%>
                            <p> As a member of the Staff, your account is already created and you need to <a href="<%=application.getContextPath()%>/login">Login</a> with the credentials provided by the administration. </p>  
                            <% }%>
                        </div>
                    </div>
                </div>
            </div>



            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">The MSc Dissertation is:</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12 ">
                            <ul>
                                <li> Essential requirement for the MSc award</li>
                                <li>Pre-requisite P00990</li>
                                <li>Guided by the BCS code of practice</li>
                                <li>A thorough and critical research investigation and evaluation</li>
                                <li>Topic area should be related to your MSc course</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Registration and Supervision:</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12 ">
                            <ul>
                                <li> Students should choose a suitable project from those listed under ‘Supervisor Interests and Suggested Projects’ on Moodle: MSc Dissertation for Computing and Communications. Alternatively students can propose their own ideas. </li>
                                <li>Projects are described in terms of: Supervisor, Title, Objectives, Required skills, Deliverables, References and Outline specification (see examples) </li>
                                <li>Contact and meet possible supervisors to discuss what is involved </li>
                                <li>It is up to students to choose a supervisor and dissertation title </li>
                                <li>Note that projects listed cover the whole department therefore not all will be suitable for you.  Note also that supervisors have a limited supervision quota.</li>
                                <li>Also if a new specification can be drawn up between student and supervisor using this template then this may be used </li>
                                <li> <strong> When you have a dissertation outline and have a supervisor agreeing to supervise you should complete a registration on this website.  </strong> </li> 
                                <li>  Deadline for dissertation registration is Friday 3 June. Note: students failing to register a project by this date will be allocated a supervisor by the module leader </li>

                            </ul>

                        </div>
                    </div>
                </div>
            </div> 


        </div>
    </body>
</html>

