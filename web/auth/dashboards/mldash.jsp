<%-- 
    Document   : mldash
    Created on : 29-Feb-2016, 02:01:41
    Author     : oussamak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/css/header.css">
        <link rel="stylesheet" href="<%=application.getContextPath()%>/includes/css/default.css">
    </head>
    <body>
        <%@ include file="/includes/menu.jsp" %>

        <h1> Welcome to your Module Leader Dashboard!</h1>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Marks and Comments</h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-8 ">

                        <ul>
                            <li><a class="btn btn-info" href="<%=application.getContextPath()%>/">Dissertation Registration</a></li>
                            <li><a class="btn btn-info" href="<%=application.getContextPath()%>/">Proposal </a></li>
                            <li><a class="btn btn-info" href="<%=application.getContextPath()%>/">Demonstration and Presentation </a></li>
                            <li><a class="btn btn-info" href="<%=application.getContextPath()%>/">Final Report </a></li>
                            <li><a class="btn btn-info" href="<%=application.getContextPath()%>/">Short Paper </a></li>

                        </ul>

                    </div>
                </div>
            </div>

        </div>

    </body>
</html>