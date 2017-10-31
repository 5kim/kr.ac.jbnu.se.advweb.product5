<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<!-- 관리자가 재고량을 확인 할 수 있는 화면 -->
<head>
<meta charset="UTF-8">
<title>Product List</title>
<link rel="stylesheet" type="text/css" href="CSS/mainstyle.css"></link>
</head>
<body>
	<div id="box">
		<div id="top">
			<jsp:include page="_header.jsp"></jsp:include>
		</div>
		<div id="left">
			<jsp:include page="_menu.jsp"></jsp:include>
		</div>
		<div id="main">
			<h3>Product List</h3>

			<p style="color: red;">${errorString}</p>

			<table border="1" cellpadding="5" cellspacing="1">
				<tr>
					<th>productNumber</th>
					<th>Name</th>
					<th>Price</th>
					<th>seller</th>
					<th>description</th>
					<th>inventory</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.productNumber}</td>
						<td>${product.name}</td>
						<td>${product.price}</td>
						<td>${product.seller}</td>
						<td>${product.description}</td>
						<td>${product.inventory}</td>
						<td><a href="editProduct?code=${product.productNumber}">Edit</a></td>
						<td><a href="deleteProduct?code=${product.productNumber}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

			<a href="createProduct">Create Product</a>
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>



</body>
</html>