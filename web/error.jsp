<%-- 
    Document   : error
    Created on : Jul 1, 2018, 7:22:32 PM
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
        <h1>Hello Error ! </h1>
        <font color="red">
        ${requestScope.ERROR}
        </font>
    </body>
</html>
