<%-- 
    Document   : EthicsForm2
    Created on : 02-Apr-2016, 04:39:28
    Author     : oussamak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Ethics Form 2</title>
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
            

            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <br />
                    <div class="container">
                        <h3>Ethics Review Form E2</h3>
                        <hr />
                        <form method="POST"  action="EthicsServlet?ethics=2" role="form">
                            <div class="form-group">
                                <p>This form is only for graduate (MSc) and undergraduate students on taught programmes. Before completing this form, 
                                    Form E1 should have been completed to establish whether a Form E2 is required. </p>
                                <p>The E2 Form should be completed by the Principal Investigator / Student undertaking the research.<br />
                                    Reference should be made to the University Code of Practice for the Ethical Standards for Research involving Human Participants, available at http://www.brookes.ac.uk/Research/Research-ethics/, 
                                    and to any guidelines provided by relevant academic or professional associations.</p>
                            </div>
                            <hr>
                            <div class="form-group">
                                <label>Project Type: <span class="required">*</span></label>
                                <input type="radio" name="ptype" value="mphil" required="true"> MPhil
                                <input type="radio" name="ptype" value="master"> Master's
                                <input type="radio" name="ptype" value="diploma">Diploma
                                <input type="radio" name="ptype" value="undergraduate">Undergraduate
                                <input type="radio" name="ptype" value="other">Other (please specify)
                                <input type="text" name="specify" value=""/>
                            </div>
                            <br />
                            <div class="form-group">
                                <label for="pfundedby" >Project funded by (if applicable): </label>
                                <input type="text" class="form-control" name="funded" value="<c:out value="${ethics2.funded}" />" />
                                <span class="error"> ${errors['funded']} </span>                               
                            </div>
                            <br />
                            <div class="form-group">
                                <label>Summary of proposed research: <span class="required">*</span> </label>
                                <input type="text" class="form-control" name="summary" value="<c:out value="${ethics2.summary}" />" required="true"/>
                                <span class="error"> ${errors['summary']} </span>           
                            </div>
                            <br />
                            <div class="form-group">
                                <label>Participants involved in the research: <span class="required">*</span> </label>
                                <input type="text" class="form-control" name="participants" value="<c:out value="${ethics2.participants}" />" required="true"/>
                                <span class="error"> ${errors['participants']} </span>           
                            </div>
                            <br />
                            <div class="form-group">
                                <label>Details of drugs or other substances used: <span class="required">*</span> </label>
                                <input type="text" class="form-control" name="details" value="<c:out value="${ethics2.details}" />" required="true"/>
                                <span class="error"> ${errors['details']} </span>           
                            </div>
                            <br />
                            <div class="form-group">
                                <label>Estimate of the risks and benefits of the proposed research: <span class="required">*</span> </label>
                                <input type="text" class="form-control" name="estimate" value="<c:out value="${ethics2.estimate}" />" required="true"/>
                                <span class="error"> ${errors['estimate']} </span>           
                            </div>
                            <br />
                            <div class="form-group">
                                <label>Plan for obtaining informed consent: (please attach copy of information sheet and consent form to application): <span class="required">*</span> </label>
                                <input type="text" class="form-control" name="plan" value="<c:out value="${ethics2.plan}" />" required="true"/>
                                <span class="error"> ${errors['plan']} </span>           
                            </div>
                            <br />
                            <div class="form-group">
                                <label>Steps to be taken to ensure confidentiality of data: <span class="required">*</span> </label>
                                <textarea rows="4" cols="50" class="form-control" name="steps" required="true"><c:out value="${ethics2.steps}" /></textarea>
                                <span class="error"> ${errors['steps']} </span>           
                            </div>
                            <br />
                            
                            <input   class="btn btn-default" type="submit" name="Submit" value="submit"/>
                            <input   class="btn btn-default" type="reset" name="Cancel"/>

                            <p class="${empty errors ? 'success' : 'error'}">${result}</p>	
                            

                        </form>

                    </div>


                </div>
               



            </div>



            

        </div>
    </body>
</html>

