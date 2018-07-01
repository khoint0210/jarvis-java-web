<%-- 
    Document   : view-avenger
    Created on : Jul 1, 2018, 7:03:36 PM
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
        <c:if test="${requestScope.AVENGER_INFO.avatar != null}">
            <img src="${requestScope.AVENGER_INFO.avatar}"/>
        </c:if>
        <div>full name : ${requestScope.AVENGER_INFO.fullname} </div>
        <div>age : ${requestScope.AVENGER_INFO.age} </div>
        <div>draw back : ${requestScope.AVENGER_INFO.drawback} </div>
        <div>role in team is : ${requestScope.AVENGER_INFO.role} </div>
        <div><h3>!!!! Notification !!!!</h3></div>
        <c:if test="${requestScope.AVENGER_INFO.status == 0}">
            <div>This user is free</div>
        </c:if>
        <c:if test="${requestScope.AVENGER_INFO.status == 1}">
            <div>This user have mission</div>
        </c:if>
        <form action="MainController" method="POST">
            <input type="submit" value="Back Avenger" name="action" />
            <input type="hidden" name="txtSearchAvenger" value="${param.txtSearchAvenger}" />
        </form>
    </body>
</html>
