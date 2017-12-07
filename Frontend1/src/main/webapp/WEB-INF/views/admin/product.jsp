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
<title>ADD Product</title>
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
</head>
<body style="background-color:   #FAFAFF">
<%@include file="/WEB-INF/views/admin/sidebar.jsp"%>
  <div style="margin-left: 25%; margin-right: 10%" id="box">
  <br><br>
<div class="w3-panel w3-red"><form:errors path="product.*"/></div>
<div class="w3-card-4">
<h5>${message}</h5>
  <div class="w3-container w3-teal"><br>
    <h5>Add Product</h5>
    <br>
  </div>
  <form class="w3-container" action="/Frontend1/admin/productaddsuccess" enctype="multipart/form-data" method="post">
  <p>    
    <label class="w3-text-orange"><b>Product_name:</b></label>
    <input class="w3-input w3-border" name="name" type="text" ></p>
    <p> 
      <c:if test="${!empty brand}">
    <select name="brand">
    <c:forEach var="brand" items="${brand}">
	<option value="${brand.brand_name}">${brand.brand_name}</option>
	</c:forEach>
	</select>
	</c:if><br>
    <label class="w3-text-orange"><b>Image:</b></label>
    <input class="w3-input w3-border " name="file" type="file"></p>
    <p>
    <label class="w3-text-orange"><b>Supplier:</b></label>
    <input class="w3-input w3-border " name="supplier" type="text"></p>
    <p>
    <label class="w3-text-orange"><b>Price:</b></label>
    <input class="w3-input w3-border " name="price" type="number"></p>
    <p>
    <label class="w3-text-orange"><b>Quantity:</b></label>
    <input class="w3-input w3-border " name="quantity" type="number"></p>
    <p>
    <label class="w3-text-orange"><b>Keywords:</b></label>
    <input class="w3-input w3-border " name="keywords" type="text"></p>
    <p>
    <p>
    <label class="w3-text-orange"><b>Description:</b></label>
    <input class="w3-input w3-border " name="description" type="text"></p><br>
   <c:if test="${!empty category}">
    <select name="category_name">
    <c:forEach var="cat" items="${category}">
	<option value="${cat.category_name}">${cat.category_name}</option>
	</c:forEach>
	</select>
	</c:if>
    <p>
    <br>
    <button class="w3-btn w3-teal">Add</button></p>
  </form>
</div>
<div><br> 
		<form action="/Frontend1/admin/product/list">
		<button  class="btn btn-primary" >Show All Product</button>
		</form></div>
</div>
</body>
</html>