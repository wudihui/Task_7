<%--
  Created by IntelliJ IDEA.
  User: fanchen
  Date: 17-7-16
  Time: 上午8:30
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>

<div class="container  hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt="" src="images/54537.png"></a>
                <a href="#" target="_blank"><img alt="" src="images/45678678.png"></a>
                <a href="#" target="_blank"> <img alt="" src="images/54375483543.png"></a>
                <%--头像--%>
                <a href="#" target="_blank"> <img alt="" src="${portrait}"></a>

                ${username}
                &nbsp; &nbsp;| &nbsp; &nbsp;
                ${reg_quit}

            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="images/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed"
                    aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="">首页</a></li>
                <li><a href="../profession">职业</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="">关于</a></li>
            </ul>
        </div>

    </div>
</nav>

<div id="myCarousel" class="carousel slide">
    <ol class="carousel-indicators">
        <li class="active" data-slide-to="0" data-target="#myCarousel"></li>
        <li data-slide-to="1" data-target="#myCarousel"></li>
        <li data-slide-to="2" data-target="#myCarousel"></li>
        <li data-slide-to="3" data-target="#myCarousel"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img alt="First slide" src="images/547567.jpg">
        </div>
        <div class="item">
            <img alt="Second slide" src="images/547567.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="images/547567.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="images/547567.jpg">
        </div>
        <a data-slide="prev" href="#myCarousel" class="carousel-control left">
            <i class="icon-left"><img src="images/54354.png"></i>
        </a>
        <a data-slide="next" href="#myCarousel" class="carousel-control right">
            <i class="icon-right"><img src="images/4525424.png"></i>
        </a>
    </div>
</div>
