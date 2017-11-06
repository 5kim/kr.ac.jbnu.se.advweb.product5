<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 회원의 정보를 수정하기 위한 화면 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/mainstyle.css"></link>
<title>Edit Information</title>
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
			<h3>Edit Information</h3>
			<form method="POST"
				action="${pageContext.request.contextPath}/edituser">
				ID : ${user.id} <br> 
				PASSWORD : <input type="password" name="password" value="${user.password }"><br> 
				NAME : ${user.name }<br>
				BIRTHDAY : ${user.birth }<br> 
				GENDER : ${user.gender }<br>
				CONTACT : <input type="text" name="contact" value="${user.contact}"><br>
				E-MAIL : <input type="text" name="email" value="${user.email}"><br>
				ADDRESS : <input type="text" name="address" value="${user.address}"><br>
				<button type="submit" value="submit">Complete</button>
			</form>
		</div>

		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>