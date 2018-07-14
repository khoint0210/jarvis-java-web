<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <c:if test = "${!fn:contains(sessionScope.ROLE, 'root')}">
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
                        <c:url var="BackAvenger" value="MainController">
                            <c:param name="action" value="Back Avenger" />
                        </c:url>
                        <a href="${BackAvenger}">
                            <i class="icon-home"></i>Back Avenger</a>
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
                            <a href="#">Home</a>
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
                                        <strong>Avenger</strong>
                                    </div>
                                    <div class="table-responsive">
                                        <c:if test="${not empty requestScope.AVENGER_INFO.avatar}">
                                            <div class="avatar">
                                                <center>
                                                    <img src="${requestScope.AVENGER_INFO.avatar}" alt="..." class="img-fluid rounded-circle" width="320px" height="320px">
                                                </center>
                                            </div>
                                        </c:if>
                                        <div class="col-lg-12">
                                            <div class="block">
                                                <div class="title">
                                                    <strong>ID : ${requestScope.AVENGER_INFO.ID}</strong>
                                                </div>
                                                <div class="block-body">
                                                    <form class="form-horizontal">

                                                        <div class="form-group row">
                                                            <label class="col-sm-3 form-control-label">Username :</label>
                                                            <div class="col-sm-9">
                                                                <input type="text" class="form-control" required value="${requestScope.AVENGER_INFO.username}" name="txtUsername" required>
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-sm-3 form-control-label">Password :</label>
                                                            <div class="col-sm-9">
                                                                <input type="password" class="form-control" name="txtPassword" required value="">
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-sm-3 form-control-label">Real Name :</label>
                                                            <div class="col-sm-9">
                                                                <input type="text" class="form-control" required name="txtFullname" value="${requestScope.AVENGER_INFO.fullname}">
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-sm-3 form-control-label">Made Up Name :</label>
                                                            <div class="col-sm-9">
                                                                <input type="text" class="form-control" required name="txtMadeUpName" value="${requestScope.AVENGER_INFO.madeUpName}">
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-sm-3 form-control-label">Role :</label>
                                                            <div class="col-sm-9">
                                                                <input type="text" class="form-control" required name="txtRole" value="${requestScope.AVENGER_INFO.role}" pattern="^root$|^user$|^admin$" title="root, admin and user only">
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-sm-3 form-control-label">Age :</label>
                                                            <div class="col-sm-9">
                                                                <input type="number" min="1" class="form-control" required name="txtAge" value="${requestScope.AVENGER_INFO.age}">
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-sm-3 form-control-label">DrawBack :</label>
                                                            <div class="col-sm-9">
                                                                <textarea maxlength="450" rows="4" cols="50" name="txtDrawBack" class="form-control" required>${requestScope.AVENGER_INFO.drawback}
                                                                </textarea>
                                                            </div>
                                                        </div>

                                                        <div class="line"></div>
                                                        <div class="form-group row">
                                                            <div class="col-sm-9 ml-auto">
                                                                <button type="submit" class="btn btn-primary" value="Edit Avenger" name="action">Edit Avenger</button>
                                                                <input type="hidden" name="txtAvatar" value="${requestScope.AVENGER_INFO.avatar}" />
                                                                <input type="hidden" name="txtAvengerID" value="${param.txtAvengerID}" />
                                                                <input type="hidden" name="txtSearchAvenger" value="${param.txtSearchAvenger}" />
                                                            </div>
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