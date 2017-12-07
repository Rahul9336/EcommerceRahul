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
<title>Brand List</title>
</head>
<body>
<%@include file="/WEB-INF/views/admin/sidebar.jsp"%>
	<div style="margin-left: 25%; margin-right: 10%">
	<br>
	<br>
	<br>
	<h3>${delsuccess}</h3>
	<form action="/Frontend1/admin/brand">
		<button  class="btn btn-primary" >Hide All Brand</button>
		</form>
		<div class="w3-responsive">
			<c:if test="${!empty brand}">
				<table class="w3-table-all">
					<tr class="w3-striped w3-bordered">
						<th>ID</th>
						<th>Name</th>
						<th>Description</th>
						<th><th>
					</tr>
					<c:forEach var="brand" items="${brand}">
						<tr>
							<td>${brand.brand_id}</td>
							<td>${brand.brand_name}</td>
							<td>${brand.brand_description}</td>
								<td><form action="/Frontend1/brand/updateordelete/${brand.brand_id}">
								<input type="submit" value="EDIT" name="action"
								class="btn btn-primary btn-sm"> <input type="submit"
								name="action" value="DELETE" class="btn btn-primary btn-sm"></form></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>