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
			<div style="height: 200px">
				<h2>Today's Recommend Item</h2>
				<br>
				<c:forEach items="${productList}" var="product">
					<tr>
						<li><td><a href="productinfo?code=${product.productNumber}">${product.name}</td><br></li>
					</tr>
				</c:forEach>
			</div>
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>

</body>
</html>