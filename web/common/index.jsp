<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INDEX</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/css/header.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/css/default.css">
    </head>
    <body>
        <%@ include file="../includes/menu.jsp" %>

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
                            <li> View your marks and comments </li>
                            <li> Bla bla bla test test </li>
                        </ul>
                        <p> As a student you need to create an account first. <a href="<%=application.getContextPath()%>/register">Register</a> now </p>    
                    </div>
                </div>
            </div>

            <hr>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-12 ">
                        <p> As a supervisor/module leader...</p>
                        <ul>
                            <li> Register your dissertation form</li>
                            <li> View your marks and comments </li>
                            <li> Bla bla bla </li>
                        </ul>
                        <p> As a member of the Staff, your account is already created and you need to connect with the credentials provided by the administration. 
                            <a href="<%=application.getContextPath()%>/login">Login</a>  </p>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>

