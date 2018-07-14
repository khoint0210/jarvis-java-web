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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Dark Bootstrap Admin by Bootstrapious.com</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="robots" content="all,follow">
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/font.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:300,400,700">
        <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
        <link rel="stylesheet" href="css/custom.css">
        <link rel="shortcut icon" href="img/favicon.ico">
    </head>
</head>
<body>
    <c:if test = "${!fn:contains(sessionScope.ROLE, 'root')}">
        <jsp:forward page="index.jsp"/>
    </c:if>
    <header class="header">
        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid d-flex align-items-center justify-content-between">
                <div class="navbar-header">
                    <!-- Navbar Header-->
                    <a href="index.html" class="navbar-brand">
                        <div class="brand-text brand-big visible text-uppercase">
                            <strong class="text-primary">J A R</strong>
                            <strong>V I S</strong>
                        </div>
                        <div class="brand-text brand-sm">
                            <strong class="text-primary">J</strong>
                            <strong>S</strong>
                        </div>
                    </a>
                    <!-- Sidebar Toggle Btn-->
                    <button class="sidebar-toggle">
                        <i class="fa fa-long-arrow-left"></i>
                    </button>
                </div>
                <div class="list-inline-item logout">
                    <c:url var="LogOut" value="MainController">
                        <c:param name="action" value="Log Out" />
                    </c:url>
                    <a id="logout" href="${LogOut}" class="nav-link">Logout
                        <i class="icon-logout"></i>
                    </a>
                </div>
            </div>
            </div>
        </nav>
    </header>
    <div class="d-flex align-items-stretch">
        <!-- Sidebar Navigation-->
        <nav id="sidebar">
            <!-- Sidebar Header-->
            <div class="sidebar-header d-flex align-items-center">
                <!-- <div class="avatar">
                  <img src="img/avatar-6.jpg" alt="..." class="img-fluid rounded-circle">
                </div> -->
                <div class="title">
                    <h1 class="h5">${sessionScope.NICKNAME}</h1>
                    <p>Just A Rather Very Intelligent System</p>
                </div>
            </div>
            <!-- Sidebar Navidation Menus-->
            <span class="heading">Action List</span>
            <ul class="list-unstyled">
                <li>
                    <c:url var="listAllAvenger" value="MainController">
                        <c:param name="action" value="List All Avenger" />
                    </c:url>
                    <a href="${listAllAvenger}">
                        <i class="icon-grid"></i>List All Avenger</a>
                </li>
                <li>
                    <c:url var="listAllEquipments" value="MainController">
                        <c:param name="action" value="List All Equipments" />
                    </c:url>
                    <a href="${listAllEquipments}">
                        <i class="icon-grid"></i>List All Equipments</a>
                </li>
                <li>
                    <c:url var="listAllMission" value="MainController">
                        <c:param name="action" value="List All Missions" />
                    </c:url>
                    <a href="${listAllMission}"><i class="icon-grid"></i>List All Missions</a>
                </li>
        </nav>
        <div class="page-content">
            <!-- Page Header-->
            <div class="page-header no-margin-bottom">
                <div class="container-fluid">
                    <h2 class="h5 no-margin-bottom">Tables</h2>
                </div>
            </div>
            <!-- Breadcrumb-->
            <div class="container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item">
                        <c:url var="CheckAvengerInfo" value="MainController">
                            <c:param name="action" value="Check Avenger Info" />
                        </c:url>
                        <a href="${CheckAvengerInfo}">Home</a>
                    </li>
                    <li class="breadcrumb-item active">Tables </li>
                </ul>
            </div>
            <section class="no-padding-top">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="block margin-bottom-sm">
                                <div class="title">
                                    <strong>List Thing</strong>
                                </div>
                                <div class="table-responsive">
                                    <c:set var="List" value="${requestScope.MISSION}"/>
                                    <c:if test="${List != null}">
                                        <c:if test="${not empty List}" var="check">
                                            <form action="MainController" method="POST">
                                                <input type="submit" value="Insert New Mission" name="action" class="btn btn-primary" />
                                            </form>
                                            <form action="MainController" method="POST" class="form-inline">
                                                Search Mission : <input type="text" name="txtSearchMission" value="${param.txtSearchMission}"class="mr-sm-3 form-control" required/>
                                                <br>
                                                <input type="submit" value="Search Mission" name="action" class="btn btn-primary" />
                                            </form>
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>Name</th>
                                                        <th>Location</th>
                                                        <th>Complete</th>
                                                        <th>View</th>
                                                        <th>Update</th>
                                                        <th>Delete</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="item" items="${List}" varStatus="counter">
                                                        <tr>
                                                            <td>${counter.count}</td>
                                                            <td>${item.name}</td>
                                                            <td>${item.location}</td>
                                                            <td>
                                                                <c:if test="${item.complete == 1}">
                                                                    <input checked="checked" type="radio"/>
                                                                </c:if>
                                                                <c:if test="${item.complete == 0}">
                                                                    <input type="radio" disabled="true"/>
                                                                </c:if>
                                                            </td>
                                                            <td>
                                                                <form action="MainController" method="POST">
                                                                    <input type="hidden" name="txtMissionID" value="${item.ID}"/>
                                                                    <input type="hidden" name="txtSearchMission" value="${param.txtSearchMission}" />
                                                                    <input type="submit" value="View Mission" name="action" class="btn btn-primary" />
                                                                </form>
                                                            </td>
                                                            <td>
                                                                <form action="MainController" method="POST">
                                                                    <input type="hidden" name="txtMissionID" value="${item.ID}"/>
                                                                    <input type="hidden" name="txtSearchMission" value="${param.txtSearchMission}" />
                                                                    <input type="submit" value="Update Mission" name="action" class="btn btn-primary" />
                                                                </form>
                                                            </td>
                                                            <td>
                                                                <form action="MainController" method="POST">
                                                                    <input type="hidden" name="txtMissionID" value="${item.ID}"/>
                                                                    <input type="hidden" name="txtSearchMission" value="${param.txtSearchMission}" />
                                                                    <input type="submit" value="Delete Mission" name="action" class="btn btn-primary" />
                                                                </form>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </c:if>
                                        <c:if test="${!check}">
                                            <form action="MainController" method="POST">
                                                <input type="submit" value="Insert New Mission" name="action" class="btn btn-primary" />
                                            </form>
                                            <form action="MainController" method="POST" class="form-inline">
                                                Search Mission : <input type="text" name="txtSearchMission" value="${param.txtSearchMission}"class="mr-sm-3 form-control" required/>
                                                <br>
                                                <input type="submit" value="Search Mission" name="action" class="btn btn-primary" />
                                            </form>
                                            <div>No record found</div>
                                        </c:if>
                                    </c:if>

                                    <c:set var="List" value="${requestScope.RESULT}"/>
                                    <c:if test="${List != null}">
                                        <c:if test="${not empty List}" var="check">
                                            <form action="MainController" method="POST">
                                                <input type="submit" value="Insert New Avenger" name="action" class="btn btn-primary" />
                                            </form>
                                            <form action="MainController" method="POST" class="form-inline">
                                                Search Equipment : <input type="text" name="txtSearchAvenger" value="${param.txtSearchAvenger}" class="mr-sm-3 form-control" required/>
                                                <br>
                                                <input type="submit" value="Search Avenger" name="action" class="btn btn-primary" />
                                            </form>
                                            <table class="table">
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
                                                <tbody>
                                                    <c:forEach var="item" items="${List}" varStatus="counter">
                                                        <tr>
                                                            <th scope="row">${counter.count}</th>
                                                            <td>${item.username}</td>
                                                            <td>${item.fullname}</td>
                                                            <td>${item.role}</td>
                                                            <td>
                                                                <form action="MainController" method="POST">
                                                                    <input type="hidden" name="txtAvengerID" value="${item.ID}"/>
                                                                    <input type="hidden" name="txtSearchAvenger" value="${param.txtSearchAvenger}" />
                                                                    <input type="submit" value="View Avenger" name="action" class="btn btn-primary" />
                                                                </form>
                                                            </td>
                                                            <td>
                                                                <form action="MainController" method="POST">
                                                                    <input type="hidden" name="txtAvengerID" value="${item.ID}"/>
                                                                    <input type="hidden" name="txtSearchAvenger" value="${param.txtSearchAvenger}" />
                                                                    <input type="submit" value="Update Avenger" name="action" class="btn btn-primary" />
                                                                </form>
                                                            </td>
                                                            <td>
                                                                <form action="MainController" method="POST">
                                                                    <input type="hidden" name="txtAvengerID" value="${item.ID}"/>
                                                                    <input type="hidden" name="txtSearchAvenger" value="${param.txtSearchAvenger}" />
                                                                    <input type="submit" value="Delete Avenger" name="action" class="btn btn-primary" />
                                                                </form>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </c:if>
                                        <c:if test="${!check}">
                                            <form action="MainController" method="POST">
                                                <input type="submit" value="Insert New Avenger" name="action" class="btn btn-primary" />
                                            </form>
                                            <form action="MainController" method="POST" class="form-inline">
                                                Search Equipment : <input type="text" name="txtSearchAvenger" value="${param.txtSearchAvenger}" class="mr-sm-3 form-control" required/>
                                                <br>
                                                <input type="submit" value="Search Avenger" name="action" class="btn btn-primary" />
                                                Ï                                            </form>
                                            <div>No record found</div>
                                        </c:if>
                                    </c:if>

                                    <c:set var="List" value="${requestScope.EQUIPMENT}"/>
                                    <c:if test="${List != null}">
                                        <c:if test="${not empty List}" var="check">
                                            <form action="MainController" method="POST">
                                                <input type="submit" value="Insert New Equipment" name="action" class="btn btn-secondary"/>
                                            </form>
                                            <form action="MainController" method="POST" class="form-inline">
                                                Search Equipment : <input type="text" name="txtSearchEquipment" value="${param.txtSearchEquipment}" class="mr-sm-3 form-control" required/>
                                                <br>
                                                <input type="submit" value="Search Equipment" name="action" class="btn btn-primary" />
                                            </form>
                                            <table class="table">
                                                <c:forEach var="item" items="${List}" varStatus="counter">
                                                    <tr>
                                                    <form action="MainController" method="POST">
                                                        <td>${counter.count} :<h7> This item has name ${item.name} and it belong to ${item.description}</h7></td>
                                                        <td><input type="submit" value="View Equipment" name="action" class="btn btn-primary"/></td>
                                                        <td><input type="submit" value="Update Equipment" name="action" class="btn btn-primary"/></td>
                                                        <td><input type="submit" value="Delete Equipment" name="action" class="btn btn-primary"/></td>
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
                                                <input type="submit" value="Insert New Equipment" name="action" class="btn btn-secondary"/>
                                            </form>
                                            <form action="MainController" method="POST" class="form-inline">
                                                Search Equipment : <input type="text" name="txtSearchEquipment" value="${param.txtSearchEquipment}" class="mr-sm-3 form-control" required/>
                                                <br>
                                                <input type="submit" value="Search Equipment" name="action" class="btn btn-primary" />
                                            </form>
                                            <div>No record found</div>
                                        </c:if>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
            </section>
            <center>
                <font color="red">
                ${requestScope.ERROR}
                </font>
            </center>
            <center><h5>${requestScope.GREETING}</h5></center>
            <footer class="footer">
                <div class="footer__block block no-margin-bottom">
                    <div class="container-fluid text-center">
                        <!-- Please do not remove the backlink to us unless you support us at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                        <p class="no-margin-bottom">2018 &copy; J.A.R.V.I.S. Design by
                            <a href="#">khont0210</a>.</p>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <!-- JavaScript files-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper.js/umd/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"></script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="js/front.js"></script>
</body>
</html>
