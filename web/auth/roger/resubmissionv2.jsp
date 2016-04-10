<%-- 
    Document   : resubmissionv2
    Created on : 03-Apr-2016, 02:23:59
    Author     : Roger
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Resubmission - Student Instruction </title>
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
            <h1> Resubmission - Student Instruction </h1>
            <p> In the case of a resubmission being required. </p>
            <p> Please resubmit 2 copies of your final report to the MSc administrator by 3pm
                on the resubmission date. Additionally you should re-prepare to present your 
                presentation and demonstration by arrangement with your supervisor and resubmitting
                the short paper.
            </p>

            <form>            
                <div>
                    <h4> <strong> Please note the following dissertation resubmission requirements:</strong>  </h4>
                    <%-- Supervisor resubmission requirement for student --%>
                    <textarea class="form-control" rows="5" id="resubmission_comment" readonly></textarea>
                </div>            
            </form>
                    
        </div>
    </body>
</html>
