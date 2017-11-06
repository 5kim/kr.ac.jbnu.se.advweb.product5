<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 장바구니 화면 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Cart</title>
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
			<h3>Cart</h3>
			<table border="1" cellpadding="5" cellspacing="1">
				<tr>
					<th>cartNumber</th>
					<th>userId</th>
					<th>productNumber</th>
					<th>count</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${cartList}" var="cart">
					<tr>
						<td>${cart.cartNumber}</td>
						<td>${cart.userId}</td>
						<td>${cart.productNumber}</td>
						<td>${cart.count}</td>
						<td><a href="deleteCart?cartNumber=${cart.cartNumber }">Delete</a></td>
					</tr>
				</c:forEach>
				</table>
		</div>
		
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>



</body>
</html>