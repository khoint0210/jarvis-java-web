<%-- 
    Document   : root
    Created on : Jun 26, 2018, 12:34:04 AM
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
    <body>
        <c:if test = "${!fn:contains(sessionScope.ROLE, 'root')}">
            <jsp:forward page="index.jsp"/>
        </c:if>
        <h1>Hello ${sessionScope.NICKNAME}</h1>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="List All Avenger" />
        </form>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="List All Equipments" />
        </form>
        <c:set var="List" value="${requestScope.RESULT}"/>
        <c:if test="${List != null}">
            <c:if test="${not empty List}" var="check">
                <form action="MainController" method="POST">
                    Search Equipment : <input type="text" name="txtSearchAvenger" value="${param.txtSearchAvenger}"/>
                    <input type="submit" value="Search Avenger" name="action" />
                    <input type="submit" value="Insert New Avenger" name="action" />
                </form>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Username</th>
                            <th>Fullname</th>
                            <th>Role</th>
                            <th>View</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <c:forEach var="item" items="${List}" varStatus="counter">
                        <tbody>
                            <tr>
                                <td>${counter.count}</td>
                                <td>${item.username}</td>
                                <td>${item.fullname}</td>
                                <td>${item.role}</td>
                                <td>
                                    <form action="MainController" method="POST">
                                        <input type="hidden" name="txtAvengerID" value="${item.ID}"/>
                                        <input type="hidden" name="txtSearchAvenger" value="${param.txtSearchAvenger}" />
                                        <input type="submit" value="View Avenger" name="action" />
                                    </form>
                                </td>
                                <td>Update</td>
                                <td>Delete</td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${!check}">
                <form action="MainController" method="POST">
                    Search Equipment : <input type="text" name="txtSearchAvenger" value="${param.txtSearchAvenger}"/>
                    <input type="submit" value="Search Avenger" name="action" />
                    <input type="submit" value="Insert New Avenger" name="action" />
                </form>
                <div>No record found</div>
            </c:if>
        </c:if>



        <c:set var="List" value="${requestScope.EQUIPMENT}"/>
        <c:if test="${List != null}">
            <c:if test="${not empty List}" var="check">
                <form action="MainController" method="POST">
                    Search Equipment : <input type="text" name="txtSearchEquipment" value="${param.txtSearchEquipment}"/>
                    <input type="submit" value="Search Equipment" name="action" />
                    <input type="submit" value="Insert New Equipment" name="action" />
                </form>
                <table>
                    <c:forEach var="item" items="${List}" varStatus="counter">
                        <tr>
                        <form action="MainController" method="POST">
                            <td>${counter.count} : This item has name ${item.name} and it belong to ${item.description}</td>
                            <td><input type="submit" value="View Equipment" name="action" /></td>
                            <td><input type="submit" value="Update Equipment" name="action"/></td>
                            <td><input type="submit" value="Delete Equipment" name="action" /></td>
                            <input type="hidden" name="id" value="${item.ID}"/>
                            <input type="hidden" name="avenger_id" value="${item.avengerID}"/>
                            <input type="hidden" name="txtSearchEquipment" value="${param.txtSearchEquipment}"/>
                        </form>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${!check}">
            <form action="MainController" method="POST">
                Search Equipment : <input type="text" name="txtSearchEquipment"/>
                <input type="submit" value="Search Equipment" name="action" />
                <input type="submit" value="Insert New Equipment" name="action" />
            </form>
            <div>No record found</div>
        </c:if>
    </c:if> 

    <form action="MainController" method="POST">
        <input type="submit" value="Log Out" name="action" />
    </form>
</body>
</html>
