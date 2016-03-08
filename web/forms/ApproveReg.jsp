<%-- 
    Document   : ApproveReg.jsp
    Created on : 04-Mar-2016, 21:46:54
    Author     : oussamak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approve Registration</title>
    </head>
    <body>
            <table>
                <tr>
                    <td>Dissertation Module Code:</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Dissertation Title:</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Dissertation Supervisor:</td>
                        <td>
                        </td>
                </tr>
                <tr>
                    <td>Second Assessor:</td>
                    <td>
                    </td>
                </tr>
                <tr>
                    <td>Related Parties:</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Subject area and relationship to course:</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Subject area and relationship to course:</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Project aim and objectives:</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Literature influencing work:</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Hypothesis, proposition, research question or outline specification:</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Proposed Deliverables:</td>
                    <td></td>
                </tr>
                
            </table>
        <form>
            <input type="radio" name="approved" value="1"/>
            <input type="radio" name="disapproved" value="0"/>
            <input type="submit" name="Add Feedback" value="addfeed"/>
            
        </form>
    </body>
</html>
