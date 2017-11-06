<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- �ֹ��� �Ϸ�� ���� �����ִ� ȭ�� -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Order Complete</title>
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
			<div style="width: 400px; height: 100px; background-color: gray; margin-left: auto; margin-right: auto; text-align: center">
			<h3>${customerName}�� �ֹ��� ���������� �Ϸ�Ǿ����ϴ�!</h3><br>
			<button type="button" onClick="location.href='${pageContext.request.contextPath}/home'">Home</button>
			</div>
		<div>����� :${address }</div>
		<div>����ó :${phoneNum }</div>	
		<div>���ε� ���� :${discountPrice }</div>
		<table border="1" cellpadding="5" cellspacing="1">
				<tr>
					<th>productNumber</th>
					<th>Name</th>
					<th>Price</th>
					<th>seller</th>
					<th>description</th>
					<th>count</th>
					
				</tr>
				
					<tr>
						<td><a href="productinfo?code=${product.productNumber}">${product.productNumber}</td>
						<td>${product.name}</td>
						<td>${product.price}</td>
						<td>${product.seller}</td>
						<td>${product.description}</td>
						<td>${count}</td>
					</tr>
			</table>
		</div>
		
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>