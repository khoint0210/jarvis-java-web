<%-- 
    Document   : user.jsp
    Created on : Jun 26, 2018, 12:34:14 AM
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
        <h1>Hello ${sessionScope.NICKNAME}</h1>
        <form action="MainController" method="post" enctype="multipart/form-data">
            <input name="uploadfile" type="file" size="50">
            <input type="submit" value="Upload Avartar" />
        </form>
        <div>Your full name : ${requestScope.INFO.fullname} </div>
        <div>Your age : ${requestScope.INFO.age} </div>
        <div>Your draw back : ${requestScope.INFO.drawback} </div>
        <div>Your role in team is : ${requestScope.INFO.role} </div>
        <div><h3>!!!! Notification !!!!</h3></div>
        <c:if test="${requestScope.INFO.status == 0}">
            <div>You are free</div>
        </c:if>
        <c:if test="${requestScope.INFO.status == 1}">
            <div>You have mission</div>
        </c:if>
        <br>
        <form action="MainController" method="POST">
            <input type="submit" value="Log Out" name="action" />
        </form>
    </body>
</html>
