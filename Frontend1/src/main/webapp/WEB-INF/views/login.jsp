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
<%-- 					<li><a href="#">Cart<span class="badge"></span></a></li> --%>
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
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/Frontend1//signup"><span class="glyphicon glyphicon-user"></span>
							Sign Up</a></li>
				</ul>
			</div>
		</div>
		</nav> <!-- End of Nav bar -->
		<h6>${message}</h6>
		<div class="well" align="center">
	<c:url value="/j_spring_security_check" var="login"></c:url>
	<form class="form-horizontal" action="${login }" method="post">
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Email:</label>
			<div class="col-xs-3">
				<input type="text" class="form-control" id="email"
					placeholder="Enter email" name="j_username">
					      
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="pwd">Password:</label>
			<div class="col-xs-3">
				<input type="password" class="form-control" id="pwd"
					placeholder="Enter password" name="j_password">
			</div>
		</div>
		  <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Login</button>
      </div>
    </div>
  </form>
  </div>
		</div>
</body>
</html>