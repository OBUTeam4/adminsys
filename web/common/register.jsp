<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/css/header.css">
        <link rel="stylesheet" href="<%=application.getContextPath()%>/includes/css/default.css">
    </head>
    <body>
        <%@ include file="/includes/menu.jsp" %>
        <div> 
            <h1>Register</h1>

            <form method="POST"  role="form">
                <div class="form-group">
                    <label for="firstname" >Firstname <span class="required">*</span></label>
                    <input type="text" class="form-control" name="firstname"  value="<c:out value="${firstname}" />" />
                    <span class="error"> ${errors['fname']} </span>
                </div>

                <div class="form-group">
                    <label for="lastname" >Lastname <span class="required">*</span> </label>
                    <input type="text" class="form-control" name="lastname" value="<c:out value="${lastname}" />" />
                    <span class="error"> ${errors['lname']} </span>
                </div>

                <div class="form-group">
                    <label for="email">Email <span class="required">*</span> </label>
                    <input type="email" class="form-control" name="email" value="<c:out value="${email}" />" />
                    <span class="error"> ${errors['email']} </span>
                </div>

                <div class="form-group">
                    <label for="idNumber">Student Number <span class="required">*</span> </label>
                    <input type="number" class="form-control" name="idNumber" value="<c:out value="${idNumber}" />" />
                    <span class="error"> ${errors['idNumber']} </span>
                </div>

                <div class="form-group">
                    <label for="courseCode">Course Code <span class="required">*</span> </label>
                    <input type="text" class="form-control" name="courseCode" value="<c:out value="${courseCode}" />" />
                    <span class="error"> ${errors['courseCode']} </span>
                </div>

                <div class="form-group">
                    <label for="courseTitle">Course Title <span class="required">*</span> </label>
                    <input type="text" class="form-control" name="courseTitle" value="<c:out value="${courseTitle}" />" />
                    <span class="error"> ${errors['courseTitle']} </span>
                </div>

                <div class="form-group">
                    <label for="courseMode">Course Mode <span class="required">*</span> </label>
                    <input type="text" class="form-control" name="courseMode" value="<c:out value="${courseMode}" />" />
                    <span class="error"> ${errors['courseMode']} </span>
                </div>

                <div class="form-group">
                    <label for="password">Password: <span class="required">*</span></label>
                    <input type="password" class="form-control" name="password" />
                    <span class="error"> ${errors['password']} </span>
                </div>

                <div class="form-group">
                    <label for="confirmation">Confirm : <span class="required">*</span></label>
                    <input id="confirmation" class="form-control" type="password"  name="confirm" />
                    <span class="erreur"> ${errors['confirm']} </span>
                </div>     
                <input type="submit" value="Register" class="btn btn-default"  />

            </form>
        </div>
    </body>
</html>
