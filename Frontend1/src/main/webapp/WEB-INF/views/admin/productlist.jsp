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
<title>Product List</title>
</head>
<body style="background-color:   #FAFAFF">
	<%@include file="/WEB-INF/views/admin/sidebar.jsp"%>
	<div style="margin-left: 25%; margin-right: 10%" id="box">
		<br> <br> <br>
		<form action="/Frontend1/admin/product">
		<button  class="btn btn-primary" >Hide All Product</button>
		</form>
		<div>
		<h3>${delsuccess}</h3>
			<div class="w3-responsive">
				<c:if test="${!empty product}">
					<table class="w3-table-all">
						<tr class="w3-striped w3-bordered">
							<th>ID</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Category</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Description</th>
							<th>Image</th>
							<th>Active</th>
							<th>Supplier</th>
						</tr>
						<c:forEach var="pro" items="${product}">
							<tr>
								<td>${pro.product_id}</td>
								<td>${pro.name}</td>
								<td>${pro.brand}</td>
								<td>${pro.category_name}</td>
								<td>${pro.quantity}</td>
								<td>${pro.price}</td>
								<td>${pro.description}</td>
								<td><img src="/Frontend1/resources/Image/${pro.name}.jpg" alt="productimage" width="100px" height="100px"></td>
								<td>${pro.activeIs}</td>
								<td>${pro.supplier}</td>								
								<td><form action="/Frontend1/updateordelete/${pro.product_id}">
<!-- 								<input name="id" value=""> -->
								<input type="submit" value="EDIT" name="action"
								class="btn btn-primary btn-sm"> <input type="submit"
								name="action" value="DELETE" class="btn btn-primary btn-sm">
								</form>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>