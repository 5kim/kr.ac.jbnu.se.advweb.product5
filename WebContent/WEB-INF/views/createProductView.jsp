<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<!-- 관리자가 제품 등록을 하기 위한 화면 -->
<head>
<meta charset="UTF-8">
<title>Create Product</title>
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
			<h3>Create Product</h3>

			<p style="color: red;">${errorString}</p>

			<form method="POST"
				action="${pageContext.request.contextPath}/createProduct">
				<table border="0">
					<tr>
						<td>Code</td>
						<td><input type="text" name="productNumber" value="${product.productNumber}" /></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name" value="${product.name}" /></td>
					</tr>
					<tr>
						<td>Price</td>
						<td><input type="text" name="price" value="${product.price}" /></td>
					</tr>
					<tr>
						<td>Seller</td>
						<td><input type="text" name="seller" value="${product.seller}" /></td>
					</tr>
					<tr>
						<td>Description</td>
						<td><textarea name="description" value="${product.description}"></textarea></td>
					</tr>
					<tr>
						<td>Inventory</td>
						<td><input type="text" name="inventory" value="${product.inventory}" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit" /> <a
							href="productList">Cancel</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>



</body>
</html>