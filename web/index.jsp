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
        <link href="css/index.css" rel="stylesheet" type="text/css">
    <c:if test = "${sessionScope.ROLE != null}">
        <jsp:forward page="CheckRoleAndAvengerInfo"/>
    </c:if>
</head>
<body>
    <form action="MainController" method="POST">
        <div class="login">
            <h1>Login</h1>
            <form method="post">
                <input type="text" name="txtUsername" placeholder="Username" required="required" />
                <input type="password" name="txtPassword" placeholder="Password" required="required" />
                <font color="red">
                ${requestScope.ERROR}
                </font>
                <button type="submit" value="Login" name="action" class="btn btn-primary btn-block btn-large">Let me in.</button>
            </form>
        </div>
    </form>
</body>
</html>
