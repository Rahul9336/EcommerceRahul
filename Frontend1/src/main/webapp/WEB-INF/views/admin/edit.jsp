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
<title>Edit</title>
</head>
<body style="background-color:   #FAFAFF">
<%@include file="/WEB-INF/views/admin/sidebar.jsp"%>
<div  style="margin-left: 25%; margin-right: 10%" id="box">
<br> <br> <br>
<h3>${delsuccess}</h3>
		<form:form action="/Frontend1/product/edit" enctype="multipart/form-data" method="post" modelAttribute="product">
		<form:hidden path="product_id"/>
		<p><label class="w3-text-orange"><b>Product name:</b></label><span style="color:red">*</span>
		<form:input class="w3-input w3-border " path="name"/>
		</p>
		<p><label class="w3-text-orange"><b>Brand:</b></label><span style="color:red">*</span>
		 <c:if test="${!empty brand}">
    <form:select path="brand">
    <c:forEach var="brand" items="${brand}">
	<form:option value="${brand.brand_name}">${brand.brand_name}</form:option>
	</c:forEach>
	</form:select>
	</c:if>
		</p>
		<p>
	<label class="w3-text-orange"><b>Old Image:</b><img src="/Frontend1/resources/Image/${productedit.name}.jpg" alt="productimage" width="100px" height="100px"></label>
	</p>
	<p>
	 <label class="w3-text-orange"><b> New Image:</b></label>
    <form:input class="w3-input w3-border " path="file" type="file"></form:input></p>
      <p>
    <label class="w3-text-orange"><b>Supplier:</b></label>
    <form:input class="w3-input w3-border " type="text" path="supplier"></form:input></p>
    <p>
    <label class="w3-text-orange"><b>Price:</b></label>
    <form:input class="w3-input w3-border " path="price" type="number" ></form:input></p>
    <p>
    <label class="w3-text-orange"><b>Quantity:</b></label>
    <form:input class="w3-input w3-border " path="quantity" type="number" ></form:input></p>
    <p>
    <label class="w3-text-orange"><b>Keywords:</b></label>
    <form:input class="w3-input w3-border " path="keywords" type="text"></form:input></p>
    <p>
    <p>
    <label class="w3-text-orange"><b>Description:</b></label>
    <form:input class="w3-input w3-border " path="description" type="text"></form:input></p><br>
    <p><label class="w3-text-orange"><b>Category:</b></label><span style="color:red">*</span>
   <c:if test="${!empty category}">
    <form:select path="category_name">
    <c:forEach var="cat" items="${category}">
	<form:option value="${cat.category_name}">${cat.category_name}</form:option>
	</c:forEach>
	</form:select>
	</c:if>
	</p>
    <p>
		<input type="submit" name="action" value="UPDATE">
		</form:form><br>
		<form action="/Frontend1/admin/product/list"><input class="btn btn-primary" type="submit" value="Back"></form>
		</div>
</body>
</html>