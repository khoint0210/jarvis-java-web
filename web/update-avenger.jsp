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
            <div>Username  : <input type="text" name="txtUsername" value="${requestScope.AVENGER_INFO.username}" /> </div>
            <div>Password : <input type="password" name="txtPassword" required="true"/> </div>
            <div>Full name : <input type="text" name="txtFullname" value="${requestScope.AVENGER_INFO.fullname}" /> </div>
            <div>Made Up Name : <input type="text" name="txtMadeUpName" value="${requestScope.AVENGER_INFO.madeUpName}" /> </div>
            <div>Role  :  <input type="text" name="txtRole" value="${requestScope.AVENGER_INFO.role}" /> </div>
            <div>Status : <input type="number" name="txtStatus" value="${requestScope.AVENGER_INFO.status}" /> </div>
            <div>Age : <input type="number" name="txtAge" value="${requestScope.AVENGER_INFO.age}" /> </div>
            <div>Drawback : <input type="text" name="txtDrawBack" value="${requestScope.AVENGER_INFO.drawback}" />  </div>
            <input type="submit" value="Back Avenger" name="action" />
            <input type="submit" value="Edit Avenger" name="action"/>
            <input type="hidden" name="txtAvengerID" value="${param.txtAvengerID}" />
            <input type="hidden" name="txtSearchAvenger" value="${param.txtSearchAvenger}" />
        </form>
    </body>
</html>
