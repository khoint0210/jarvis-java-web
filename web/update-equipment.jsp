<%-- 
    Document   : view
    Created on : Jun 29, 2018, 11:37:31 AM
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
        <h1>Equipment Information</h1>
        <form action="MainController" method="POST">
            <div>ID : ${requestScope.EQUIPMENT_INFO.ID} </div>
            <div>Name : <input type="text" name="txtEquipmentName" value="${requestScope.EQUIPMENT_INFO.name}" /> </div>
            <c:set var="List" value="${requestScope.AVENGER_LIST}"/>
            <c:if test="${not empty List}">
                Owner : <select name="txtAvengerID">
                    <c:forEach var="item" items="${List}">
                        <option value="${item.ID}">${item.fullname}</option>
                    </c:forEach>
                </select>
            </c:if>
                <div>Description : <input type="text" name="txtDescription" value="${requestScope.EQUIPMENT_INFO.description}"/> </div>
            <input type="hidden" name="txtEquipmentID" value="${requestScope.EQUIPMENT_INFO.ID}" />
            <input type="hidden" name="txtSearchEquipment" value="${param.txtSearchEquipment}"/>
            <input type="submit" value="Back Equipment" name="action" />
            <input type="submit" value="Edit Equipment" name="action" />
        </form>
    </body>
</html>
