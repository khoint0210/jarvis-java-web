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
        <form action="MainController" method="POST">
            <div>ID : ${param.txtAvengerID}</div>
            <div>Username  : <input type="text" name="txtUsername" /> </div>
            <div>Password : <input type="text" name="txtPassword"/> </div>
            <div>Full name : <input type="text" name="txtFullname" /> </div>
            <div>Made Up Name : <input type="text" name="txtMadeUpName" /> </div>
            <div>Role  :  <input type="text" name="txtRole" /> </div>
            <div>Status : <input type="number" name="txtStatus" /> </div>
            <div>Age : <input type="number" name="txtAge" /> </div>
            <div>Drawback : <input type="text" name="txtDrawBack" />  </div>
            <input type="submit" value="Back Avenger" name="action" />
            <input type="submit" value="Insert Avenger" name="action"/>
            <input type="hidden" name="txtSearchAvenger" value="${param.txtSearchAvenger}" />
        </form>
    </body>
</html>
