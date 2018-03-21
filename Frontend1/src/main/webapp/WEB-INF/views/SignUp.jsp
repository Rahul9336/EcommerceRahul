<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
	<script>
$(document).ready(function(){
    $("#userid,#role").hide();
});
</script>
</head>
<body>
<s:url var="url_img" value="/resources/Image/"></s:url>

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
	<div class="w3-panel w3-red"><form:errors path="user1.*"/></div>
<div class="w3-card-4">
  <div class="w3-container w3-teal">
    <h2>Sign Up</h2>
  </div>
  <form class="w3-container" action="/Frontend1/signupSuccess" method="post">
  <p> 
  <h3 class="w3-red">${message}${Exception}</h3>     
    <input class="w3-input w3-border " id="userid" name="user_id" type="text"></p>
    <p> 
    <p>      
    <label class="w3-text-orange"><b>Full Name:</b></label>
    <input class="w3-input w3-border" name="name" type="text"></p>
    <p>      
    <label class="w3-text-orange"><b>Email_ID:</b></label>
    <input class="w3-input w3-border " name="email" type="text"></p>
    <p>
    <label class="w3-text-orange"><b>Password:</b></label>
    <input class="w3-input w3-border " name="password" type="password"></p>
    <p>
    <label class="w3-text-orange"><b>Address:</b></label>
    <input class="w3-input w3-border " name="address" type="text"></p>
    <p>
    <label class="w3-text-orange"><b>Mobile_No:</b></label>
    <input class="w3-input w3-border " name="contact" type="password"></p>
    <p>
    <input class="w3-input w3-border " id="role" name="role" type="text" value="CUSTOMER"></p>
    <p>
    <p>
    <button class="w3-btn w3-teal">Register</button></p>
  </form>
</div>
</body>
</html>
