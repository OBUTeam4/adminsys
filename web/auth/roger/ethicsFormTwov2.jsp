<%-- 
    Document   : ethicsFormTwov2
    Created on : 04-Apr-2016, 12:45:06
    Author     : Roger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Ethics Review Form E2 </title>
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
            <h4> Faculty of Technology, Design and Environment </h4>
            <h4> Ethics Review Form E2 </h4>
            <p> This form is only for graduate (MSc) and undergraduate students on taught
                programmes. Before completing this form, Form E1 should have been completed
                to establish whether a Form E2 is required.
            </p>
            <p> The E2 Form should be completed by the Principal Investigator / Student 
                undertaking the research. Reference should be made to the University
                <b> Code of Practice for the Ethical Standards for Research 
                    involving Human Participants</b>, available at 
                    <a href="http://www.brookes.ac.uk/Research/Research-ethics/">
                        http://www.brookes.ac.uk/Research/Research-ethics/
                    </a>, and to any guidelines provided by relevant academic 
                    or professional associations.  
            </p>
            
            <form method="POST"  action="ethicsRegister" role="form">            
                <%-- Principal Investigator / Supervisor of student for this project, load in drop-down list --%>
                <div class="form-group">                    
                    <label for="supervisor"> 1. Name of Principal Investigator / Supervisor: <span class="required">*</span> </label>
                    <c:out value="${supervisor}" />
                    <select name="supervisor" class="form-control">
                        <c:forEach items="${supervisors}" var="supervisorList">
                            <option value="<c:out value="${supervisorList.idNumber}" />"><c:out value="${supervisorList.firstName} ${supervisorList.lastName}" /></option>
                        </c:forEach>
                    </select>
                    <span class="error"> ${errors['supervisor']} </span>
                </div>
                <%-- Student Fullname on this project displayed in the readonly input text box --%>
                <div class="form-group">                    
                    <label for="fullname" > 2. Name of Student: </label>
                    <input type="text" class="form-control" name="fullname" value="<c:out value="${firstname} ${lastname}" />" readonly />
                    <span class="error"> ${errors['fname' + 'lname']} </span>
                </div>                
                <div class="form-group">
                    <%-- Title of the current project registered by student displayed in the readonly input text box --%>
                    <label for="diss_title" > 3. Project Title: </label>
                    <input type="text" class="form-control" name="diss_title" value="<c:out value="${diss_title}" />" readonly />
                    <span class="error"> ${errors['diss_title']} </span>
                </div>    
                <div class="form-group">
                    <%-- Project Type options --%>
                    <label for="project_type" > 4. Project Type: <span class="required">*</span> </label>
                    <select name="project_type" class="form-control">
                        <option value="MPhil"> MPhil </option>
                        <option value="Masters"> Master's </option>
                        <option value="Undergraduate"> Undergraduate </option>
                        <option value="Other"> Other(please specify) </option>
                    </select>
                    <span class="error"> ${errors['project_type']} </span>
                    <%-- Project Type other: input text box --%>
                    <label for="other_info"> Other: </label>
                    <input type="text" class="form-control" name="other_info" />
                    <span class="error"> ${errors['other_info']} </span>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-4">
                            <p> 5. Project funded by (if applicable): </p>
                        </div>
                        <div class="col-sm-6">
                            <%-- Project funding information text area --%>
                            <textarea class="form-control" rows="3" id="fund_info" ></textarea>  
                        </div>    
                    </div>
                </div>  
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-4">
                            <p> 6. Summary of proposed research: </p>
                        </div>
                        <div class="col-sm-6">
                            <%-- Summary of proposed research text area --%>
                            <textarea class="form-control" rows="3" id="research_info" ></textarea>  
                        </div>    
                    </div>
                </div>  
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-4">
                            <p> 7. Participants involved in the research: </p>
                        </div>
                        <div class="col-sm-6">
                            <%-- Participants involved in the research text area --%>
                            <textarea class="form-control" rows="3" id="participants_info" ></textarea>  
                        </div>    
                    </div>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-4">
                            <p> 8. Details of drugs or other substances used: </p>
                        </div>
                        <div class="col-sm-6">
                            <%-- Details of drugs or other substances used text area --%>
                            <textarea class="form-control" rows="3" id="drugs_info" ></textarea>  
                        </div>    
                    </div>
                </div>            
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-4">
                            <p> 9. Estimate of the risks and benefits of the proposed research: </p>
                        </div>
                        <div class="col-sm-6">
                            <%-- Estimate of the risks and benefits text area --%>
                            <textarea class="form-control" rows="3" id="risks_info" ></textarea>  
                        </div>    
                    </div>
                </div>             
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-4">
                            <p> 10. Plan for obtaining informed consent:(please attach copy of 
                                information sheet and consent form to application) </p>
                        </div>
                        <div class="col-sm-6">
                            <%-- Plan for obtaining informed consent text area --%>
                            <textarea class="form-control" rows="3" id="risks_info" ></textarea>  
                        </div>    
                    </div>
                </div>                              
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-4">
                            <p> 11. Steps to be taken to ensure confidentiality of data: </p>
                        </div>
                        <div class="col-sm-6">
                            <%-- Plan for obtaining informed consent text area --%>
                            <textarea class="form-control" rows="3" id="risks_info" ></textarea>  
                        </div>    
                    </div>
                </div> 
                            
                <br>
                <%-- Button to submit students' Ethics E2 form application --%>
                <input type="submit" value="Submit" class="btn btn-default"  />
                    <br/>
                    <br/>
                    <br/> 
            </form>
        </div>
    </body>
</html>
