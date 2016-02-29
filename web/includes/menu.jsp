<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>

     <h1>
        <c:if test="${!empty user}">
            Connected as, <a href="<%=application.getContextPath()%>/auth/profile"> <c:out value="${user.getFirstName()}"/> <c:out value="${user.getLastName()}"/> (<c:out value="${user.getIdNumber()})" /> </a> !
        </c:if>
            
        <c:if test="${empty user}">
             MSc Projects 2016
        </c:if>
    </h1>
    
    <ul>
        <li><a class="btn btn-info" href="<%=application.getContextPath()%>/">Home</a></li>

        <% if (session.getAttribute("user") != null) {%>
        <li><a class="btn btn-info" href="<%=application.getContextPath()%>/auth/message">Messages </a></li>

            <!-- FOR TESTs 
            <li><a class="btn btn-info" href="<%=application.getContextPath()%>/dashboard">Dashboard</a></li> -->
            <li><a class="btn btn-info" href="<%=application.getContextPath()%>/logout">Log out</a></li>
        <% } else {%>
            <li><a class="btn btn-info" href="<%=application.getContextPath()%>/login">Login</a></li>
            <li><a class="btn btn-info" href="<%=application.getContextPath()%>/register">Register</a></li>
        <% }%>		

    </ul>

    <div style="clear: both; float: none;"></div>
</header>