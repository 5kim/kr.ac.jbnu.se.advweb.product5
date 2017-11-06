<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 단어를 입력하거나 카테고리를 이용해 검색한 제품의 목록을 보여주는 화면 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Search Product</title>
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
			<div style="margin-top: 20px">
			<table border="1" cellpadding="5" cellspacing="1">
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>seller</th>
					<th>description</th>
					<th>inventory</th>
				</tr>
				<c:forEach items="${searchList}" var="product">
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