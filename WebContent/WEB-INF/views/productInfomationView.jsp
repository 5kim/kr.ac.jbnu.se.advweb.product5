<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 주문을 위한 화면 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Information</title>
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
			<h3>Product View</h3>
		<table border="0">
		<tr>
				<td>Product Name :</td> <td>${product.name}<br></td>
		</tr>
		<tr>
				<td>-------------이미지 자리------------<br></td>
		</tr>
		<tr>
				<td>Product Price :</td> <td>${product.price}<br></td>
		</tr>
		<tr>
				<td>Product Description :</td> <td>${product.description}<br></td>
		</tr>
		<tr>
				<td>Product Inventory :</td> <td>${product.inventory}<br></td>
		</tr>
				<br><br>
		<tr>
				<td>Order Volume :</td> <td><input type="text" name="volume" value=""><br></td>
		</tr>
		<tr>
					<td>------------그래프 자리--------------</td>
				</tr>
		</table>
				<button type="submit" onClick="location.href='${pageContext.request.contextPath}/order?code=${product.productNumber}'">Order</button><br>				
				
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>