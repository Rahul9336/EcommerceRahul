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
<title>Admin_Login_page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cloud.tinymce.com/stable/tinymce.min.js?apiKey=8t7rv0vydbhhi2g0c7k7kbuoix5kck3mux35fnnlcbgjt8sv"></script>
  <script>tinymce.init({ selector:'textarea' });</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script
	src="${js}/intial.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}/styles.css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
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
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/Frontend1/"><span class="glyphicon glyphicon-user"></span>
							Customer</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/Frontend1/admin/page"><span class="glyphicon glyphicon-user"></span>
							Login</a></li>
				</ul>
			</div>
		</div>
		</nav>
		<h6>${message}</h6>
		<div class="well" align="center">
	<h2 class="bg-success" align="center">Admin Login Page</h2>
	<form class="form-horizontal" action="/Frontend1/admin/loginsuccess" method="post">
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Email:</label>
			<div class="col-xs-3">
				<input type="text" class="form-control" id="email"
					placeholder="Enter email" name="username">
					      
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="pwd">Password:</label>
			<div class="col-xs-3">
				<input type="password" class="form-control" id="pwd"
					placeholder="Enter password" name="password">
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
  <footer><div class="container">
	<div class="row">
	<div class="col-sm-2"><h6>Copyright &copy:2017{Rahul Gupta}</h6></div>
	<div class="col-sm-4"><h6>Abouts Us</h6></div>
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
	</ul></div>
	<div class="col-sm-2"><h6>Bussiness With Us</h6></div>
	</div>
	</div>  </footer>
</body>
</html>