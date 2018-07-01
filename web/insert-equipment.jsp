<%-- 
    Document   : insert
    Created on : Jun 29, 2018, 6:56:13 PM
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
        <h1>Insert Equipment !</h1>
        <form action="MainController" method="POST">
            Equipment's name : <input type="text" name="txtEquipmentName" />
            <c:set var="List" value="${requestScope.AVENGER_LIST}"/>
            <c:if test="${not empty List}">
                This Equipment belong to <select name="txtAvengerID">
                    <c:forEach var="item" items="${List}">
                        <option value="${item.ID}">${item.fullname}</option>
                    </c:forEach>
                </select>
            </c:if>
            Description : <input type="text" name="txtDescription"/>
            <input type="submit" value="Insert Equipment" name="action" />
            <input type="submit" value="Back Equipment" name="action" />
            <input type="hidden" name="txtSearchEquipment" value="${param.txtSearchEquipment}"/>
        </form>
    </body>
</html>
