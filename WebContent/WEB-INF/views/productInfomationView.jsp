<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 제품 상세정보를 위한 화면 -->
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
				Product Name : ${product.name}<br>
				Product Price : ${product.price}<br>
				Product Seller : ${product.seller}<br>
				Product Description : ${product.description}<br>
				Product Inventory : ${product.inventory}<br>
					
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>