<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/mainstyle.css"></link>

<title>userMain</title>
</head>
<body>
	<div id="box">
		<div id="top">
			<jsp:include page="_header.jsp"></jsp:include></div>
		<div id="left">
			<jsp:include page="_menu.jsp"></jsp:include>
		</div>
		<div id="main">
		<div style="float: left; height: 100px; width: 50%;">
		<h3>Log In</h3>
		<b>Are you a member of our site?</b><br>
		<b>Move Log In page!</b><br>
		<button type="button" value="로그인" name="로그인" onClick="location.href='${pageContext.request.contextPath}/login'">Login</button>		
		</div>
		<div style="float: right; height: 100px; width: 50%;">
		<h3>Sign In</h3>
		<b>Thanks to visit Bean's Powder</b><br>
		<b>Move Sign In Page for use our site!</b><br>
		<button type="button" value="회원가입" name="회원가입" onClick="location.href='${pageContext.request.contextPath}/signin'">Signin</button>		
		</div>
		<div style="float: left; margin-top: 100px; height: 100px; width: 50%;">
		<h3>Edit Information</h3>
		<b>Edit your information</b><br>
		<b>Move Edit page!</b><br>
		<button type="button" value="회원정보수정" name="회원정보수정" onClick="location.href='${pageContext.request.contextPath}/login'">Edit</button>		
		</div>
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include></div>
	</div>
</body>
</html>