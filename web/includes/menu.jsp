<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>

    <h1>
        <% if (session.getAttribute("user") != null) {%>
        Connected as, <a href="<%=application.getContextPath()%>/auth/profile"> <c:out value="${user.getfName()}"/> <c:out value="${user.getlName()}"/> (<c:out value="${user.getUserId()})" /> </a> !
        <c:out value="${user.getOccupation()}" />
        <% } else {%>
        MSc Projects 2016
        <% }%>	
    </h1>

    <ul>
        <li><a class="btn btn-info" href="<%=application.getContextPath()%>/">Home</a></li>
        <li><a class="btn btn-info" href="<%=application.getContextPath()%>/auth/forms/formsTesting.jsp">Forms</a></li>
        
            <% if (session.getAttribute("user") != null) {%>
        <li><a class="btn btn-info" href="<%=application.getContextPath()%>/auth/message">Messages </a></li>
        <li><a class="btn btn-info" href="<%=application.getContextPath()%>/auth/dashboard">Dashboard</a></li> 
        <li><a class="btn btn-info" href="<%=application.getContextPath()%>/logout">Log out</a></li>

        <% } else {%>
        <li><a class="btn btn-info" href="<%=application.getContextPath()%>/login">Login</a></li>
        <li><a class="btn btn-info" href="<%=application.getContextPath()%>/register">Register</a></li>
            <% }%>	

    </ul>

    <div style="clear: both; float: none;"></div>
</header>