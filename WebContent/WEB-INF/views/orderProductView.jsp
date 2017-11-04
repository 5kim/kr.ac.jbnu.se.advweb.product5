<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 제품 상세정보를 위한 화면 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Product</title>
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
			<h3>Order Product</h3>
			<form method="POST"
				action="${pageContext.request.contextPath}/ordercomplete">
				<table border="0">
					<tr>
						<td>Product Name :</td>
						<td>${product.name}<br></td>
					</tr>
					<tr>
						<td>-------------이미지 자리------------<br></td>
					</tr>
					<tr>
						<td>Product Price :</td>
						<td>${product.price}<br></td>
					</tr>
					<tr>
						<td>Use Coupon :</td>
						<td><select name="coupon">
							<option value="test">test!</option>
							</select><br></td>
					</tr>
					<tr>
						<td>Total Price :</td>
						<td>price~~~~~<br></td>
					</tr>
					
					<br>
					<br>
					<!-- 				<input type="checkbox" id="check"> Equals User Information<br> -->
					<tr>
						<td>Customer Name :</td>
						<td><input type="text" name="name" value=${user.name }><br></td>
					</tr>
					<tr>
						<td>Customer Address :</td>
						<td><input type="text" name="addr"><br></td>
					</tr>
					<tr>
						<td>Customer Contact :</td>
						<td><input type="text" name="contact" value=${user.contact }><br></td>
					</tr>
					<tr>
						<td>Payment Way :</td>
						<td><select name="payment">
								<option value="">Select Payment</option>
								<option value="card">Credit Card</option>
						</select><br></td>
					</tr>
					<tr>
						<td>Card Code:</td>
						<td><input type="text" name="cardcode"><br></td>
					</tr>
					<tr>
						<td>Card Password:</td>
						<td><input type="password" name="cardpassword"><br></td>
					</tr>
				</table>
				<br>
				<button type="submit">Order</button>
				<button type="reset" onClick="location.href='${pageContext.request.contextPath}/productinfo?code=${product.productNumber }'">cancel</button>
			</form>

		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>