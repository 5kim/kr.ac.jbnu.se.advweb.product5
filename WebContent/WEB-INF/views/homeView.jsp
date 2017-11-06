<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Home Page</title>
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
			<div>
				<h2>Today's Recommend Item</h2>
				<table border="1" cellpadding="5" cellspacing="1">
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>seller</th>
					<th>description</th>
					<th>inventory</th>
				</tr>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td><a href="productinfo?code=${product.productNumber}">${product.name}</td>
						<td>${product.price}</td>
						<td>${product.seller}</td>
						<td>${product.description}</td>
						<td>${product.inventory}</td>
						<br>
					</tr>
				</c:forEach>
			</table>
			</div>
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>

</body>
</html>