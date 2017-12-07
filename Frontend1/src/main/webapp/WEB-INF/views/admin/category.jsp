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
<title>ADD Category</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="${js}/intial.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}/styles.css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body style="background-color:   #FAFAFF">
	<%@include file="/WEB-INF/views/admin/sidebar.jsp"%>
	<div style="margin-left: 25%; margin-right: 10%" id="box">
		<div class="w3-panel w3-red">
			<form:errors path="category.*" />
		</div>
		<div class="w3-card-4">
			<div class="w3-container w3-teal">
				<h2>Add Category</h2>
			</div>
			<h5>${message}</h5>
			<form:form class="w3-container" action="/Frontend1/categoryAddSuccess"
				method="post" commandName="category">
				<p>
					<label class="w3-text-orange"><b>Category Name:</b></label><span style="color:red">*</span> <input
						class="w3-input w3-border w3-round" name="category_name"
						type="text">
				</p>
				<p>
					<button class="w3-btn w3-teal">Add</button>
				</p>
			</form:form>
		</div>
		<form action="/Frontend1/admin/category/list">
		<button class="btn btn-primary">See All Category</button>
		</form>
	</div>
</body>
</html>