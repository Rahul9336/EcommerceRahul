<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:url var="css" value="/resources/css/"></s:url>
<s:url value="/resources/js" var="js"></s:url>
<s:url var="url_img" value="/resources/Image/"></s:url>
<!DOCTYPE html>
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
<title>Order Detail</title>
</head>
<body>
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
					<li><a href="/Frontend1/cartdetail/">Cart<span
							class="badge">${cart.getCartItemCount()}</span></a></li>
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
						<li><a href="/Frontend1/login"><span
								class="glyphicon glyphicon-user"></span> Login</a></li>
					</ul>
				</c:if>
				<ul class="nav navbar-nav navbar-right">
					<c:url value="/j_spring_security_logout" var="logout"></c:url>
					<c:if test="${pageContext.request.userPrincipal.name!=null }">
						<li><a href="${logout}"><span
								class="glyphicon glyphicon-user"></span> Logout</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>

	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8" style="background-color: rgb(255, 190, 119)">
			<h2>Order Summary</h2>
			<br>
			<h3>Shipping Address</h3>
			<p>${address}</p>
			<div class="w3-responsive">
				<table class="w3-table-all">
					<tr class="w3-striped w3-bordered">
						<th>Name</th>
						<th style="padding-left: 10px">Price</th>
						<th style="padding-left: 10px">Quantity</th>
						<th style="padding-left: 10px">Total</th>
					</tr>
					<c:forEach var="pro" items="${cartitems}">
						<tr>
							<td>${pro.product.name}</td>
							<td style="padding-left: 10px">${pro.product.price}</td>
							<td style="padding-left: 15px">${pro.getSell_quantity()}</td>
							<c:set var="total"
								value="${pro.product.price*pro.getSell_quantity()}"></c:set>
							<td style="padding-left: 10px">${total}</td>
						</tr>
					</c:forEach>
				</table>
				<br>
				<p style="margin-left: 70%;">
					<strong>Grand Total:- &#x20B9 ${cart.getGrandTotal()}</strong>
				</p>
			</div>
			<br> <a href="/Frontend1/" style=" display: inline-block;"><button 
					class="btn btn-primary">Back To HoMe</button></a>
			<a href="/Frontend1/user/payment" style=" display: inline-block;"><button
					style="margin-left: 150px" class="btn btn-primary">Continue
					To Payment</button></a><br>
			<br>
		</div>
		<div class="col-sm-2"></div>
	</div>
	<br>
	<br>
	<br>
</body>
</html>