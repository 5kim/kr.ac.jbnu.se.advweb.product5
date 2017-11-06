<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- ���� ����� �����ִ� ȭ�� 
	������ ��ǰ�� Ŭ���� ��ǰ�� ������ ȭ������ �Ѿ��.
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
					<th>Product Name</th>
					<th>Price</th>
					<th>Order Date</th>
					<th>Count</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${orderNProductList}" var="orderNProduct">
					<tr>
						<td><a href="productinfo?code=${orderNProduc.productNumbert}">${orderNProduct.productName}</td>
						<td>${orderNProduct.price}</td>
						<td>${orderNProduct.date}</td>
						<td>${orderNProduct.count}</td>
						<td><a href="deleteOrder?orderNumber=${orderNProduct.orderNumber }">delete</td>
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