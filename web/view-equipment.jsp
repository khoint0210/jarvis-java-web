<%-- 
    Document   : view
    Created on : Jun 29, 2018, 11:37:31 AM
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
        <h1>Equipment Information</h1>
        <form action="MainController" method="POST">
            <div>ID : "${requestScope.DTO.ID}"</div>
            <div>Name : "${requestScope.DTO.name}"</div>
            <div>Owner : "${requestScope.DTO.owner}"</div>
            <div>Description : "${requestScope.DTO.description}"</div>
            <input type="submit" value="Back Equipment" name="action" />
            <input type="hidden" name="txtSearchAvenger" value="${param.txtSearchAvenger}"/>
        </form>
    </body>
</html>
