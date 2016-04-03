<%-- 
    Document   : EthicsForm1
    Created on : 02-Apr-2016, 04:39:15
    Author     : oussamak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Ethics Form 1</title>
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
                        <h3>Ethics Review Form E1</h3>
                        <hr />
                        If you did not submit your registration, do it before you submit ethics.  
                        <form method="POST"  action="EthicsServlet?ethics=1" role="form">
                            <div class="form-group">
                                <p>Before completing this form, please refer to the University Code of Practice for the Ethical Standards 
                                    for Research involving Human Participants, available at 
                                   http://www.brookes.ac.uk/Research/Research-ethics/, 
                                       and to any guidelines provided by relevant academic or professional associations. </p>
                            </div>
                            <hr>
                            <div class="form-group">
                                <label  >Does the study involve participants who are unable to give informed consent? (e.g. children, people with learning disabilities, unconscious patients) <span class="required">*</span></label>
                                <input type="radio" name="answer1" value="yes" required="true"> Yes
                                <input type="radio" name="answer1" value="no"> No<br>                               
                            </div>
                            <br /><br /><br /><br />
                            <div class="form-group">
                                <label>If the study will involve participants who are unable to give 
                                    informed consent (e.g. children under the age of 16, people with learning disabilities), 
                                    will you be unable to obtain permission from their parents or guardians (as appropriate)?<span class="required">*</span> </label>
                                <input type="radio" name="answer2" value="yes" required="true"> Yes
                                <input type="radio" name="answer2" value="no"> No<br>                                
                            </div>
                            <br /><br /><br /><br /><br /><br />
                            <div class="form-group">
                                <label>Will the study require the cooperation of a gatekeeper for initial access to groups or individuals to be recruited? (e.g. students, 
                                    members of a self-help group, employees of a company, residents of a nursing home)  <span class="required">*</span> </label>
                                <input type="radio" name="answer3" value="yes" required="true"> Yes
                                <input type="radio" name="answer3" value="no"> No<br>  
                            </div>
                            <br /><br /><br /><br /><br /><br />
                            <div class="form-group">
                                <label>Are there any problems with the participants’ right to remain anonymous, 
                                    or to have the information they give not identifiable as theirs?<span class="required">*</span> </label>
                                <input type="radio" name="answer4" value="yes" required="true"> Yes
                                <input type="radio" name="answer4" value="no"> No<br>
                            </div>
                            <br /><br /><br /><br />
                            <div class="form-group">
                                <label>Will it be necessary for the participants to take part in the study without 
                                    their knowledge/consent at the time? (eg, covert observation of people in non-public places?) <span class="required">*</span> </label>
                                <input type="radio" name="answer5" value="yes" required="true"> Yes
                                <input type="radio" name="answer5" value="no"> No<br>
                            </div>
                            <br /><br /><br /><br />
                            <div class="form-group">
                                <label>Will the study involve discussion of or responses to questions the participants might 
                                    find sensitive? (e.g. own drug use, own traumatic experiences)<span class="required">*</span> </label>
                                <input type="radio" name="answer6" value="yes" required="true"> Yes
                                <input type="radio" name="answer6" value="no"> No<br>
                            </div>
                            <br /><br /><br /><br />
                            <div class="form-group">
                                <label>Are drugs, placebos or other substances 
                                    (e.g. food substances, vitamins) to be administered to the study participants?<span class="required">*</span> </label>
                                <input type="radio" name="answer7" value="yes" required="true"> Yes
                                <input type="radio" name="answer7" value="no"> No<br>    
                            </div>
                            <br /><br /><br />
                            <div class="form-group">
                                <label>Will blood or tissue samples be obtained from participants? <span class="required">*</span> </label>
                                <input type="radio" name="answer8" value="yes" required="true"> Yes
                                <input type="radio" name="answer8" value="no"> No<br>
                            </div>
                            <br />
                            <div class="form-group">
                                <label>Is pain or more than mild discomfort likely to result from the study?<span class="required">*</span> </label>
                                <input type="radio" name="answer9" value="yes" required="true"> Yes
                                <input type="radio" name="answer9" value="no"> No<br>
                            </div>
                            <br />
                            <div class="form-group">
                                <label>Could the study induce psychological stress or anxiety?<span class="required">*</span> </label>
                                <input type="radio" name="answer10" value="yes" required="true"> Yes
                                <input type="radio" name="answer10" value="no"> No<br>
                            </div>
                            
                            <div class="form-group">
                                <label>Will the study involve prolonged or repetitive testing?<span class="required">*</span> </label>
                                <input type="radio" name="answer11" value="yes" required="true"> Yes
                                <input type="radio" name="answer11" value="no"> No<br>
                            </div>
                            <div class="form-group">
                                <label>Will financial inducements (other than reasonable expenses and 
                                    compensation for time) be offered to participants?<span class="required">*</span> </label>
                                <input type="radio" name="answer12" value="yes" required="true"> Yes
                                <input type="radio" name="answer12" value="no"> No<br>
                            </div>
                            <br /><br /><br />
                            <div class="form-group">
                                <label>Will deception of participants be necessary during the study?<span class="required">*</span> </label>
                                <input type="radio" name="answer13" value="yes" required="true"> Yes
                                <input type="radio" name="answer13" value="no"> No<br>
                            </div>
                            <br />
                            <div class="form-group">
                                <label>Will the study involve NHS patients, staff, carers or premises?<span class="required">*</span> </label>
                                <input type="radio" name="answer14" value="yes" required="true"> Yes
                                <input type="radio" name="answer14" value="no"> No<br>
                            </div>
                            <br /><br />
                            <div class="form-group">
                                <p>If you have answered ‘no’ to all the above questions, send the completed form 
                                    to your Module Leader and keep the original in case you need to submit it with your work.</p>
                                <p>If you have answered ‘yes’ to any of the above questions, 
                                    you should complete the Form E2 available at 
                                    http://www.brookes.ac.uk/Research/Research-ethics/Ethics-review-forms/ 
                                    and, together with this E1 Form, email it to the Faculty Research Ethics Officer, 
                                    whose name can be found at http://www.brookes.ac.uk/Research/Research-ethics/Research-ethics-officers/ </p>

                                <p>If you answered ‘yes’ to any of questions 1-13 and ‘yes’ to question 14, an application must be submitted to the appropriate NHS research ethics committee.

                                </p>
                            </div>
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
