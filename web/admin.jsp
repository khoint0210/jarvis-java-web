<%-- 
    Document   : admin
    Created on : Jun 26, 2018, 12:34:22 AM
    Author     : khoint0210
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <c:if test = "${!fn:contains(sessionScope.ROLE, 'admin')}">
        <jsp:forward page="index.jsp"/>
    </c:if>
    <body>
        <h1>Hello ${sessionScope.NICKNAME}</h1>
        <c:if test="${not empty requestScope.AVENGER_INFO.avatar}">
            <img src="${requestScope.AVENGER_INFO.avatar}" width="320px" height="320px" />
        </c:if>
         <br>
        <font color="red">
        ${requestScope.ERROR}
        </font>
        <form action="MainController" method="post" enctype="multipart/form-data">
            <input name="Upload Avatar" type="file">
            <input type="submit" value="Upload Avatar"/>
        </form>
        <form action="MainController" method="POST">
            <input type="hidden" name="txtAvengerID" value="${sessionScope.ID}" />
            <input type="submit" value="List Your Equipment" name="action"/>
            <input type="submit" value="Log Out" name="action" />
            <c:set var="List" value="${requestScope.EQUIPMENT_INFO}"/>
            <c:if test="${List != null}">
                <c:if test="${not empty List}" var="check">
                    <table border="1" width="50%">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>In Use</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${List}" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${item.name}</td>
                                    <td>${item.description}</td>
                                    <td>
                                        <c:if test="${item.inUse == 1}">
                                            <input name="InUse"checked="checked" type="radio" value="${item.ID}"/>
                                        </c:if>
                                        <c:if test="${item.inUse == 0}">
                                            <input type="radio" name="InUse" value="${item.ID}"/>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <input type="submit" value="Update Select Mark" name="action"/>
                </c:if>
            </c:if>
        </form>
    </body>
</html>
