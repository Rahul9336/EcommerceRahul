<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>${product.name}</title>
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
					<li class="active"><a href="#">Home</a></li>
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
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
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
		<div class="row">
			<c:if test="${!empty product}">
				<div class="col-sm-4">
					<img src="/Frontend1/resources/Image/${product.name}.jpg"
						alt="productimage" height="500px" class="pop">
				</div>
				<div class="col-sm-4">
					<br> <br> <br>
					<hr>
					<h5 id="productname">${product.name}</h5>
					<br> <strong><font size="+1">&#x20B9
							${product.price}</font></strong><br>
					<br>
					<hr>
					<h6 style="color: green; font-size: 15px">
						Quantity In Stock<span class="badge">${product.quantity}</span>
					</h6>
					<hr>
					<h6 id="heading">Description</h6>
					<br>
					<p id="paragraph">${product.description}</p>
					<hr>
					<h6 id="heading">Keywords</h6>
					<br>
					<p id="paragraph">${product.keywords}</p>
					<hr>
					<h6 id="heading">Supplier</h6>
					<hr>
					<h4>${product.supplier}<span class="badge"
							style="color: green; font-weight: bold; background-color: black">&#10004
							VERIFIED</span>
					</h4>
					<hr>
					<h6 id="heading">More about Product</h6>
					<br>
					<p id="paragraph"><strong>Brand name:-</strong>${product.brand}</p>
					<br>
					<p id="paragraph"><strong>Category name:-</strong>${product.category_name}</p>
					<hr>
					<a href="#"><button class="btn" style="background-color:green;font-weight:bold;color:black">Buy Now</button></a>
					<form action="/Frontend1/addcart/${product.product_id}">
					<button class="btn btn-primary" type="submit">Add To Cart</button></form>
				</div>
			</c:if>
			<div class="col-sm-4">
				<c:if test="${!empty suggestproduct}">
					<div class="row" id="featureheading" class="container">
						<div class="col-sm-4" style="display: inline-block">
							<br> <br> <br>
							<h4>Suggested</h4>
							<a href="/Frontend1/productdetail/${suggestproduct.product_id}"><img
								src="/Frontend1/resources/Image/${suggestproduct.name}.jpg"
								alt="productimage" width="250px" height="320px"><br>
								<strong><font size="2">${suggestproduct.name}</font></strong><br>
								<strong>&#x20B9 ${suggestproduct.price}</strong></a><br>
							<br>
						</div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
				</c:if>
			</div>
		</div>
		<div>
			<c:if test="${!empty suggestion}">
				<div class="row" id="featureheading" class="container">
					<hr>
					<h2>More product From Same Category........</h2>
					<hr>
					<c:forEach var="pro" items="${suggestion}">
						<div class="col-sm-4" style="display: inline-block">
							<a href="/Frontend1/productdetail/${pro.product_id}"><img
								src="/Frontend1/resources/Image/${pro.name}.jpg"
								alt="productimage" width="250px" height="220px"><br>
								<strong><font size="2">${pro.name}</font></strong><br> <strong>&#x20B9
									${pro.price}</strong></a><br>
							<br>
						</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</c:forEach>
					<br>
				</div>
				<hr>
			</c:if>
		</div>
	</div>
</body>
</html>