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


        <form action="" method="POST">
            <table>
                <tr>
                    <td>Dissertation Module Code:</td>
                    <td><input type="text" name="diss_mod_code"/></td>
                </tr>
                <tr>
                    <td>Dissertation Title:</td>
                    <td><input type="text" name="diss_title"/></td>
                </tr>
                <tr>
                    <td>Dissertation Supervisor:</td>
                    <td>
                        <select name="supervisor">
                            <option>xxxx</option>
                            <option>yyyy</option> 
                            <option>zzzz</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Second Assessor:</td>
                    <td>
                        <select name="assessor">
                            <option>xxxx</option>
                            <option>yyyy</option>
                            <option>zzzz</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Related Parties:</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Subject area and relationship to course:</td>
                    <td><input type="text" name="text1"/></td>
                </tr>
                <tr>
                    <td>Subject area and relationship to course:</td>
                    <td><input type="text" name="text1"/></td>
                </tr>
                <tr>
                    <td>Project aim and objectives:</td>
                    <td><input type="text" name="text2"/></td>
                </tr>
                <tr>
                    <td>Literature influencing work:</td>
                    <td><input type="text" name="text3"/></td>
                </tr>
                <tr>
                    <td>Hypothesis, proposition, research question or outline specification:</td>
                    <td><input type="text" name="text4"/></td>
                </tr>
                <tr>
                    <td>Proposed Deliverables:</td>
                    <td><input type="text" name="text5"/></td>
                </tr>

            </table>
            <input type="checkbox" name="confirmation"/>
            <input type="submit" name="Save" value="save"/>
            <input type="submit" name="Submit" value="submit"/>
            <input type="reset" name="Cancel"/>
        </form>
    </body>
</html>
