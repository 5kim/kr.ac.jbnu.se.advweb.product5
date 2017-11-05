<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/mainstyle.css"></link>
</head>
<body>
<div style = "margin-left: 10px">
	<br>
	<div>
	<button class="btn" type="button" onClick="location.href='${pageContext.request.contextPath}/home'">Home</button>
	</div>
	<div>
	<button class="btn" type="button" onClick="location.href='${pageContext.request.contextPath}/productList'">Outer</button>
	</div>
	<div>
	<button class="btn" type="button" onClick="location.href='${pageContext.request.contextPath}/productList'">Shirts</button>
	</div>
	<div>
	<button class="btn" type="button" onClick="location.href='${pageContext.request.contextPath}/productList'">Pants</button>
	</div>
	<div>
	<button class="btn" type="button" onClick="location.href='${pageContext.request.contextPath}/productList'">Shoes</button>
	</div>
	<div>
	<button class="btn" type="button" onClick="location.href='${pageContext.request.contextPath}/userInfo'">My Account Info</button>
	</div>
		<button class="btn" type="button" onClick="location.href='${pageContext.request.contextPath}/orderedProductList'">ordered product</button>
	</div>
	 	
</div> 
</body>    
</html>