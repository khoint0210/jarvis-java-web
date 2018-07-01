<%-- 
    Document   : index
    Created on : Jun 22, 2018, 11:06:22 PM
    Author     : khoint0210
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Avenger List !</h1>
        <form action="MainController" method="POST">
            <input name="action" type="submit" value="List" />
        </form>
        <c:set var="List" value="${requestScope.RESULT}"/>
        <c:if test="${not empty List}">
            <c:forEach var="item" items="${List}">
                <div>
                    ${item.fullname}
                </div>
            </c:forEach>
        </c:if>
    </body>
</html>
