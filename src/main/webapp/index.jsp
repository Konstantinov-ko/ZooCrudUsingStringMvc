<%@ page import="ru.konstantinov.Main" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>ZOO</title>

    <link href="/assets/css/bootstrap.css" rel="stylesheet">
    <link href="/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/assets/lineicons/style.css">
    <link href="/assets/css/style.css" rel="stylesheet">
    <link href="/assets/css/style-responsive.css" rel="stylesheet">
</head>

<body>

<section id="container" >
    <header class="header black-bg">
        <div class="sidebar-toggle-box">
            <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
        </div>

        <a href="/" class="logo"><b>ZOO</b></a>
    </header>

    <aside>
        <div id="sidebar"  class="nav-collapse ">
            <ul class="sidebar-menu" id="nav-accordion">
                <p class="centered"><a href="/"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
                <h5 class="centered">ZOO</h5>
                <li class="mt">
                    <a href="/zoo.html">
                        <i class="fa fa fa-book"></i>
                        <span>ZOO admin</span>
                    </a>
                </li>
            </ul>
        </div>
    </aside>
    <section id="main-content">
        <section class="wrapper">
            <div class="row">
                <div class="col-lg-12 main-chart">
                    <div class="row mtbox">
                        <div class="col-md-2 col-sm-2 col-md-offset-1 box0">
                            <div class="box1">
                                <span class="li_heart"></span>
                                <h3><%=Main.getBaseSize()%></h3>
                            </div>
                            <p><%=Main.getBaseSize()%> зоопарков</p>
                        </div>
                        <div class="col-md-2 col-sm-2 box0">
                            <div class="box1">
                                <span class="li_data"></span>
                                <h3><%=Main.checkBase()%></h3>
                            </div>
                            <p>Наличие базы</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </section>

    <footer class="site-footer">
        <div class="text-center">
            <a target="_blank" href="https://github.com/Konstantinov-ko/ZooCrudUsingStringMvc">To GitHub</a>
            <a href="#" class="go-top">
                <i class="fa fa-angle-up"></i>
            </a>
        </div>
    </footer>
</section>

<script src="/assets/js/jquery.js"></script>
<script src="/assets/js/jquery-3.2.0.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="/assets/js/jquery.scrollTo.min.js"></script>
<script src="/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="assets/js/common-scripts.js"></script>

</body>
</html>

