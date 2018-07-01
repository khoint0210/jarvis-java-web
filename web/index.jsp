<%-- 
    Document   : index
    Created on : Jun 22, 2018, 11:06:22 PM
    Author     : khoint0210
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>! Login Page !</h1>
        <form action="MainController" method="POST">
            Username : <input type="text" name="txtUsername" required="true"/>
            <br>
            Password : <input type="password" name="txtPassword" required="true"/>
            <br>
            <input type="submit" value="Login" name="action" />
        </form>
    </body>
</html>
