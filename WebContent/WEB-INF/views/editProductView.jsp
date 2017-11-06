<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<!-- 등록한 제품을 수정하는 화면 -->
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
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
			<h3>Edit Product</h3>

				<form method="POST"
					action="${pageContext.request.contextPath}/editProduct">
					<table border="0">
						<tr>
							<td>Code</td>
							<td name="productNumber" style="color: red;">${product.productNumber}</td>
						</tr>
						<tr>
							<td>Inventory</td>
							<td><input type="text" name="inventory" value="${product.inventory}" /></td>
						</tr>
						<tr>
							<td>Price</td>
							<td><input type="text" name="price" value="${product.price}" /></td>
						</tr>
						<tr>
							<td>Recommend</td>
							<td><input type="text" name="recommend" value="${product.recommend}" /></td>
						</tr>
						<tr>
						<tr>
							<td colspan="2"><input type="submit" value="Submit" /> <a
								href="${pageContext.request.contextPath}/productList">Cancel</a>
							</td>
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