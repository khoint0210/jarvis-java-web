<%-- 
    Document   : admin
    Created on : Jun 26, 2018, 12:34:22 AM
    Author     : khoint0210
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <c:if test = "${!fn:contains(sessionScope.ROLE, 'admin')}">
        <jsp:forward page="index.jsp"/>
    </c:if>
    <body>
        <h1>Hello ${sessionScope.NICKNAME}</h1>
        <form action="MainController" method="POST">
            <input type="submit" value="Log Out" name="action" />
        </form>
    </body>
</html>
