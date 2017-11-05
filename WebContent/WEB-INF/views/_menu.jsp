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
	<form method="GET" action="${pageContext.request.contextPath}/searchproduct">
	<button class="btn" type="button" onClick="location.href='${pageContext.request.contextPath}/searchproduct?category=outer'">Outer</button>
	</div>
	<div>
	<button class="btn" type="button" onClick="location.href='${pageContext.request.contextPath}/searchproduct?category=shirts'">Shirts</button>
	</div>
	<div>
	<button class="btn" type="button" onClick="location.href='${pageContext.request.contextPath}/searchproduct?category=pants'">Pants</button>
	</div>
	<div>
	<button class="btn" type="button" onClick="location.href='${pageContext.request.contextPath}/searchproduct?category=shoes'">Shoes</button>
	</div>
	<div>
	</form>
	<button class="btn" type="button" onClick="location.href='${pageContext.request.contextPath}/userInfo'">My Account Info</button>
	</div>
		<button class="btn" type="button" onClick="location.href='${pageContext.request.contextPath}/orderedProductList'">ordered product</button>
	</div>
	 	
</div> 
</body>    
</html>