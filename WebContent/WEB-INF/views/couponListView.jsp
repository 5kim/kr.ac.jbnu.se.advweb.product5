<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- 쿠폰 리스트 화면 -->
<head>
<meta charset="UTF-8">
<title>Coupon List</title>
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
			<h3>Coupon List</h3>

			<p style="color: red;">${errorString}</p>

			<table border="1" cellpadding="5" cellspacing="1">
				<tr>
					<th>serialNumber</th>
					<th>couponName</th>
					<th>userId</th>
					<th>discountRate</th>
					<th>period</th>
				</tr>
				<c:forEach items="${couponList}" var="coupon">
					<tr>
						<td>${coupon.serialNumber}</td>
						<td>${coupon.couponName}</td>
						<td>${coupon.userId}</td>
						<td>${coupon.discountRate}</td>
						<td>${coupon.period}</td>
					</tr>
				</c:forEach>
			</table>

			<a href="providecoupon">Provide coupon</a>
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>

</body>
</html>