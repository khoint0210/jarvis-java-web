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
        <link rel="stylesheet" href="css/error.css">
    </head>
    <body>
        <h1>Whoops!</h1>
        <p>Something went wrong</p>
        <p>        
            <font color="red">
            ${requestScope.ERROR}
            </font>
        </p>
    </body>
</html>
