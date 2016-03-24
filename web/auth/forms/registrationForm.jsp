<%-- 
    Document   : registrationForm
    Created on : 04-Mar-2016, 21:02:47
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

        <div class="container">
            <h1>Dissertation Registration From </h1>
            <p> Due on... : </p>

            <form method="POST"  action="register" role="form">
                <div class="form-group">
                    <label for="diss_mod_code" >Dissertation Module Code: <span class="required">*</span></label>
                    <input type="text" class="form-control" name="diss_mod_code"  value="<c:out value="${diss_mod_code}" />"  placeholder="P0099?" />
                    <span class="error"> ${errors['diss_mod_code']} </span>
                </div>
                
                <div class="form-group">
                    <label for="diss_title" >Dissertation Title: <span class="required">*</span> </label>
                    <input type="text" class="form-control" name="diss_title" value="<c:out value="${diss_title}" />" />
                    <span class="error"> ${errors['diss_title']} </span>
                </div>

                <div class="form-group">
                    <label for="supervisor">Supervisor  <span class="required">*</span> </label>
                    <c:out value="${supervisor}" />
                    <select name="supervisor" class="form-control">
                        <c:forEach items="${supervisors}" var="supervisorList">
                            <option value="<c:out value="${supervisorList.idNumber}" />"><c:out value="${supervisorList.firstName} ${supervisorList.lastName}" /></option>
                        </c:forEach>
                    </select>
                    <span class="error"> ${errors['supervisor']} </span>
                </div>
                
                <div class="form-group">
                    <label for="assessor">Assessor  <span class="required">*</span> </label>
                    <c:out value="${assessor}" />
                    <select name="supervisor" class="form-control">
                        <c:forEach items="${assessors}" var="assessorList">
                            <option value="<c:out value="${assessorList.idNumber}" />"><c:out value="${assessorList.firstName} ${assessorList.lastName}" /></option>
                        </c:forEach>
                    </select>
                    <span class="error"> ${errors['assessor']} </span>
                </div>

                <div class="form-group">
                    <label for="diss_parties">Related Parties: <span class="required">*</span> </label>
                    <input type="text" class="form-control" name="diss_parties" value="<c:out value="${diss_parties}" />" />
                    <span class="error"> ${errors['diss_parties']} </span>
                </div>

                <div class="form-group">
                    <label for="subjectArea">Subject area and relationship to course <span class="required">*</span> </label>
                    <input type="text" class="form-control" name="subjectArea" value="<c:out value="${subjectArea}" />" />
                    <span class="error"> ${errors['subjectArea']} </span>
                </div>

                <div class="form-group">
                    <label for="projectAim">Project aim and objectives <span class="required">*</span> </label>
                    <input type="text" class="form-control" name="projectAim" value="<c:out value="${projectAim}" />"  />
                    <span class="error"> ${errors['projectAim']} </span>
                </div>

                <div class="form-group">
                    <label for="literature">Literature influencing work: <span class="required">*</span> </label>
                    <input type="text" class="form-control" name="literature" value="<c:out value="${literature}" />" />
                    <span class="error"> ${errors['literature']} </span>
                </div>

                <div class="form-group">
                    <label for="diss_hypothesis">Hypothesis, proposition, research question or outline specification:<span class="required">*</span> </label>
                    <input type="text" class="form-control" name="diss_hypothesis" value="<c:out value="${diss_hypothesis}" />" placeholder="" />
                    <span class="error"> ${errors['diss_hypothesis']} </span>
                </div>

                <div class="form-group">
                    <label for="diss_deliverables">Proposed Deliverables: <span class="required">*</span> </label>
                    <input type="text" class="form-control" name="diss_deliverables" value="<c:out value="${diss_deliverables}" />" />
                    <span class="error"> ${errors['diss_deliverables']} </span>
                </div>



                <p class="${empty errors ? 'success' : 'error'}">${result}</p>	

            </form>

            <input   class="btn btn-default" type="submit" name="Save" value="save"/>
            <input   class="btn btn-default" type="submit" name="Submit" value="submit"/>
            <input   class="btn btn-default" type="reset" name="Cancel"/>


        </div>
    </body>
</html>
