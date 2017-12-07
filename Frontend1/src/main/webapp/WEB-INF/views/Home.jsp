<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<s:url var="css" value="/resources/css/"></s:url>
<s:url value="/resources/js" var="js"></s:url>
<s:url var="url_img" value="/resources/Image/"></s:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${css}/styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Home</title>
</head>
<body>
	<div class="container" id="main">
		<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header" id="head">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img src="${url_img}/Logo.jpg"
					width="100px" height="60px" alt="Logo" id="imagetop" /></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Categories<span class="caret"></span></a>      
						<c:if test="${!empty category}">
							<ul class="dropdown-menu">
								<c:forEach var="cat" items="${category}">
									<li><a href="/Frontend1/bycategory/${cat.category_name}">${cat.category_name}</a></li>
								</c:forEach>
							</ul>
						</c:if></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Brand<span class="caret"></span></a> 
						<c:if test="${!empty brand}"></c:if>     
						<ul class="dropdown-menu">
							<c:forEach var="brand" items="${brand}">
								<li><a href="/Frontend1/bybrand/${brand.brand_name}">${brand.brand_name}</a></li>
							</c:forEach>
						</ul></li>
					<li><a href="/Frontend1/cartdetail/">Cart<span class="badge">${cart}</span></a></li>
				</ul>
				<form class="navbar-form navbar-left">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"
							id="searchbox">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit" id="searchbutton">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>
				<c:if test="${pageContext.request.userPrincipal.name==null }">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/Frontend1//signup"><span class="glyphicon glyphicon-user"></span>
							Sign Up</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/Frontend1/login"><span class="glyphicon glyphicon-user"></span>
							Login</a></li>
				</ul></c:if>
				<ul class="nav navbar-nav navbar-right">
				<c:url value="/j_spring_security_logout" var="logout"></c:url>
				<c:if test="${pageContext.request.userPrincipal.name!=null }">
					<li><a href="${logout}"><span class="glyphicon glyphicon-user"></span>
							Logout</a></li></c:if>
				</ul>
			</div>
		</div>
		</nav>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="${url_img}/carousel3.jpg" alt="sale" style="width: 100%;">
				</div>

				<div class="item">
					<img src="${url_img}/carousel4.jpg" alt="gillete"
						style="width: 100%;">
				</div>

				<div class="item">
					<img src="${url_img}/carousel5.jpg" alt="herbal"
						style="width: 100%;">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
		<div class="row" id="Bigcall">
			<div class="well well-sm visible-xs">
				<div class="page-header">
					<h3 align="center">Welcome ${pageContext.request.userPrincipal.name}</h3>
				</div>
				<a href="#" class="btn btn-large btn-block btn-primary"><span
					class="glyphicon glyphicon-hand-right"> Click For Continue</span></a>
			</div>
			<div class=col-12>
				<div class="well hidden-xs">
					<div class="page-header">
						<h1 align="center">
							Welcome ${pageContext.request.userPrincipal.name}<small> Thank You For Using Our Website</small>
						</h1>
					</div>
					<a href="#" class="btn btn-large btn-primary">Click For
						Continue</a>
				</div>
			</div>
		</div>
		<c:if test="${!empty product}"><div class="row" id="featureheading"  class="container">
			<c:forEach var="pro" items="${product}">
				<div class="col-sm-4" style="display:inline-block">
					<a href="/Frontend1/productdetail/${pro.product_id}"><img
						src="/Frontend1/resources/Image/${pro.name}.jpg"
						alt="productimage" width="250px" height="320px"><br>
					<strong><font size="2">${pro.name}</font></strong><br>
					<strong>&#x20B9 ${pro.price}</strong></a><br><br>
					<form action="/Frontend1/addcart/${pro.product_id}">
					<button class="btn btn-primary" type="submit">Add To Cart</button></form>
				</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</c:forEach></div>
		</c:if>
		<div class="row" id="features"></div>
		<div class="row" id="moreinfo"></div>
		<div class="row" id="morecourses"></div>
	</div>
	<footer>
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
				<h6>Copyright &copy:2017{Rahul Gupta}</h6>
			</div>
			<div class="col-sm-4">
				<h6>Abouts Us</h6>
			</div>
			<div class="col-sm-2">
				<h6>Navigation</h6>
				<ul class="list-unstyled">
					<li><a href="#">Home</a></li>
					<li><a href="#">Contact Us</a></li>
				</ul>
			</div>
			<div class="col-sm-2">
				<h6>Follow Us</h6>
				<ul class="list-unstyled">
					<li><a href="#">Twitter</a></li>
					<li><a href="#">Facebook</a></li>
					<li><a href="#">Google Plus</a></li>
				</ul>
			</div>
			<div class="col-sm-2">
				<h6>Bussiness With Us</h6>
			</div>
		</div>
	</div>
	</footer>
</body>
</html>