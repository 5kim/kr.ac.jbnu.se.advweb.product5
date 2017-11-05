<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 구매 목록을 보여주는 화면 
	구매한 제품을 클릭시 제품의 상세정보 화면으로 넘어간다.
-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
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
			<h3>My Order List</h3>

			<p style="color: red;">${errorString}</p>

			<table border="1" cellpadding="5" cellspacing="1">
				<tr>
					<th>orderNumber</th>
					<th>Name</th>
					<th>Price</th>
					<th>seller</th>
					<th>description</th>
					<th>Count</th>
				
				</tr>
				<c:forEach items="${orderList}" var="order">
					<tr>
						<td><a href="productinfo?code=${order.productNumber}">${order.productNumber}</td>
						<td>${order.orderNumber}</td>
						<td>${order.count}</td>
						<td>${order.count}</td>
						<td>${order.count}</td>
						<td><a href="productDelete?code=${order.productNumber}">delete</td>
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