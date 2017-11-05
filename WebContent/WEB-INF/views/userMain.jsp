<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/mainstyle.css"></link>

<title>userMain</title>
</head>
<body>
	<div id="box">
		<div id="top">
			<jsp:include page="_header.jsp"></jsp:include></div>
		<div id="left">
			<jsp:include page="_menu.jsp"></jsp:include>
		</div>
		<div id="main">
		<div style="float: left; height: 100px; width: 50%;">
		<h3>Log Out</h3>
		<b>Thank you for use our site!</b><br>
		<b>Good bye~</b><br>
		<button type="button" onClick="location.href='${pageContext.request.contextPath}/logout'">Logout</button>		
		</div>
		<div style="float: right; height: 100px; width: 50%;">
		<h3>Edit Information</h3>
		<b>Edit your information</b><br>
		<b>Move Edit page!</b><br>
		<button type="button" onClick="location.href='${pageContext.request.contextPath}/edituser'">Edit</button>		
		</div>
		<div style="float: left; margin-top: 100px; height: 100px; width: 50%;">
		<h3>Coupon List</h3>
		<b>Show your coupon!</b><br>
		<button type="button" onClick="location.href='${pageContext.request.contextPath}/couponlist'">Coupon</button>		
		</div>
		<div style="float: right; margin-top : 100px; height: 100px; width: 50%;">
		<h3>Order History</h3>
		<b>Show your order history</b><br>
		<button type="button" onClick="location.href='${pageContext.request.contextPath}/orderedlist'">Order History</button>		
		</div>
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include></div>
	</div>
</body>
</html>