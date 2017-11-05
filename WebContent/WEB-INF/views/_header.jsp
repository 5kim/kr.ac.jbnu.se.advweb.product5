<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/mainstyle.css"></link>
</head>
<body>
	<div class="header" style="height: 100px; padding: 5px;">
		<div>
			<div>
				<img src="Image/title.png" width=200px; height=100px;
					onClick="location.href='${pageContext.request.contextPath}/home'">
				<div
					style="float: right; margin-right: 100px; margin-top: 15px; margin-left: 5px; padding: 10px; text-align: right;">
					<img src="Image/user.png" width=40px; height=40px;
						onClick="location.href='${pageContext.request.contextPath}/usermain'">
					<img src="Image/cart.png" width=40px; height=40px; onClick="location.href='${pageContext.request.contextPath}/cart'">
				</div>
				<form method="GET" action="${pageContext.request.contextPath}/searchproduct">
				<div style="text-align : center">
				<b>Search</b> <input type="text" name="searchWord" width= 300px;> <button type="submit">Search</button>
				</div>
				</form>

			</div>
		</div>
</body>
</html>



