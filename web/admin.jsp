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
    <c:if test = "${!fn:contains(sessionScope.ROLE, 'admin')}">
        <jsp:forward page="index.jsp"/>
    </c:if>
    <body>
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
                        <c:url var="ListYourEquipment" value="MainController">
                            <c:param name="txtAvengerID" value="${sessionScope.ID}" />
                            <c:param name="action" value="List Your Equipment" />
                        </c:url>
                        <a href="${ListYourEquipment}">
                            <i class="icon-home"></i>List Your Equipment
                        </a>
                    </li>
            </nav>
            <!-- Sidebar Navigation end-->
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
                                        <strong>Hello ${sessionScope.NICKNAME}</strong>
                                    </div>
                                    <div class="table-responsive">
                                        <c:if test="${not empty requestScope.AVENGER_INFO.avatar}">
                                            <div class="avatar">
                                                <center>
                                                    <img src="${requestScope.AVENGER_INFO.avatar}" alt="..." class="img-fluid rounded-circle" width="320px" height="320px">
                                                </center>
                                            </div>
                                        </c:if>
                                        <br>
                                        <center>
                                            <font color="red">
                                            ${requestScope.ERROR}
                                            </font>
                                            <form action="MainController" method="post" enctype="multipart/form-data">
                                                <input name="Upload Avatar" type="file" required>
                                                <input type="submit" value="Upload Avatar" class="btn btn-secondary" />
                                            </form>
                                        </center>
                                        <div class="col-lg-12">
                                            <div class="block">
                                                <div class="title">
                                                    <strong>ID : ${sessionScope.ID}</strong>
                                                </div>
                                                <div class="block-body">
                                                    <form class="form-horizontal">

                                                        <div class="form-group row">
                                                            <label class="col-sm-3 form-control-label">Real Name :</label>
                                                            <div class="col-sm-9">
                                                                <input type="text" class="form-control" value="${requestScope.AVENGER_INFO.fullname}" disabled>
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-sm-3 form-control-label">Age :</label>
                                                            <div class="col-sm-9">
                                                                <input type="text" class="form-control" value="${requestScope.AVENGER_INFO.age}" disabled>
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-sm-3 form-control-label">Role :</label>
                                                            <div class="col-sm-9">
                                                                <input type="text" class="form-control" value="${requestScope.AVENGER_INFO.role}" disabled>
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-sm-3 form-control-label">DrawBack :</label>
                                                            <div class="col-sm-9">
                                                                <textarea rows="4" cols="50" class="form-control" disabled>${requestScope.AVENGER_INFO.drawback}
                                                                </textarea>
                                                            </div>
                                                        </div>

                                                        <div class="line"></div>
                                                        <c:set var="List" value="${requestScope.EQUIPMENT_INFO}" />
                                                        <c:if test="${List != null}">
                                                            <c:if test="${not empty List}" var="check">
                                                                <table class="table">
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
                                                                                        <input name="InUse" checked="checked" type="radio" value="${item.ID}" />
                                                                                    </c:if>
                                                                                    <c:if test="${item.inUse == 0}">
                                                                                        <input type="radio" name="InUse" value="${item.ID}" />
                                                                                    </c:if>
                                                                                </td>
                                                                            </tr>
                                                                        </c:forEach>
                                                                    </tbody>
                                                                </table>
                                                                <input type="submit" class="btn btn-primary" value="Update Select Mark" name="action" />
                                                            </c:if>
                                                        </c:if>
                                                        <form action="MainController" method="POST">
                                                            <input type="submit" value="Mission Notification" class="btn btn-primary" name="action" />
                                                            <br>
                                                            <br>
                                                            <input type="hidden" name="txtAvengerID" value="${requestScope.AVENGER_INFO.ID}" />
                                                            <c:set var="info" value="${requestScope.AVENGER_STATUS}"/>
                                                            <c:if test="${info == 0}">
                                                                <div>Your are free</div>
                                                            </c:if>
                                                            <c:if test="${info == 1}">
                                                                <input type="submit" value="View Your Mission" class="btn btn-primary" name="action" />
                                                                <c:set var="List" value="${requestScope.MISSION_INFO}"/>
                                                                <c:if test="${not empty List}" var="check">
                                                                    <table class="table-responsive table">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>No</th>
                                                                                <th>Name</th>
                                                                                <th>Location</th>
                                                                                <th>Action</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <c:forEach var="item" items="${List}" varStatus="counter">
                                                                                <tr>
                                                                                    <td>${counter.count}</td>
                                                                                    <td>${item.name}</td>
                                                                                    <td>${item.location}</td>
                                                                                    <td>
                                                                                        <form action="MainController" method="POST">
                                                                                            <input type="hidden" name="txtMissionID" value="${item.ID}"/>
                                                                                            <input class="btn-primary" type="submit" value="View Mission" name="action" />
                                                                                        </form>
                                                                                    </td>
                                                                                </tr>
                                                                            </c:forEach>
                                                                        </tbody>
                                                                    </table>
                                                                </c:if>
                                                            </c:if>
                                                        </form>
                                                    </form>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
    </section>
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