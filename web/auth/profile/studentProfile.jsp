<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit and View Profile</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/css/header.css">
        <link rel="stylesheet" href="<%=application.getContextPath()%>/includes/css/default.css">
    </head>
    <body>
        <%@ include file="/includes/menu.jsp" %>
        <div>

            <h1>Profile </h1>
            <p> You can edit and View your infos here </p>

            <h2> My profile </h2>

            <p> Firstname : <c:out value="${firstname}" /> </p>
            <p> Lastname : <c:out value="${lastname}" /> </p>
            <p> Email : <c:out value="${email}" /> </p>
            <p> ID Number  : <c:out value="${IdNumber}" /> </p>
            <p> Course Code : <c:out value="${courseCode}" /> </p>
            <p> Course Mode : <c:out value="${courseMode}" /> </p>
            <p> Course Title : <c:out value="${courseTitle}" /> </p>

            <h2> Edit profile </h2>
            <form method="POST">

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
                    <c:out value="${courseMode}" />
                    <select name="courseMode" class="form-control">
                        <option value="full">Full Time</option>
                        <option value="part">Part Time</option>
                    </select>
                    <span class="error"> ${errors['courseMode']} </span>
                </div>

                <div class="form-group">
                    <label for="password">New Password:</label>
                    <input type="password"  class="form-control" name="password"  />
                    <span class="error"> ${errors['password']} </span>
                </div>

                <div class="form-group">
                    <label for="confirm">Password Confirm</label>
                    <input type="password"  class="form-control" name="confirm"  />
                    <span class="error"> ${errors['confirm']} </span>
                </div>

                <input type="submit" value="Submit"  class="btn btn-default" />

            </form>

            <br/>
            <br/>
        </div>
    </body>
</html>
