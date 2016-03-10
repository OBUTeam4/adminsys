<%-- 
    Document   : login
    Created on : 26 févr. 2016, 00:29:31
    Author     : Quentin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/css/header.css">
        <link rel="stylesheet" href="<%=application.getContextPath()%>/includes/css/default.css">
    </head>
    <body>
        <%@ include file="/includes/menu.jsp" %>
        <div>

            <h1> Login </h1>

            <form method="POSt" action="login">

                <div class="form-group">
                    <label for="idNumber">ID Number <span class="required">*</span> </label>
                    <input type="text" name="idNumber" class="form-control" value="<c:out value="${idNumber}" />" />
                    <span class="error"> ${errors['idNumber']} </span>
                </div>

                <div class="form-group">
                    <label for="password">Password:  <span class="required">*</span> </label>
                    <input type="password" class="form-control" name="password" />
                    <span class="error"> ${errors['password']} </span>
                </div>

                <input type="submit" value="Log-In" class="btn btn-default" /><br>

                <!--<p class="${empty errors ? 'success' : 'error'}">${result}</p>-->
                <span class="error"> ${errors['result']} </span><br>
                <a href="<%=application.getContextPath()%>/register">Register</a>

            </form>
            
        </div>
    </body>
</html>
