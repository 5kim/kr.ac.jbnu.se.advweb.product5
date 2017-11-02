<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- 회원정보화면 -->
<head>
<meta charset="UTF-8">
<title>User Info</title>
<link rel="stylesheet" type="text/css" href="CSS/mainstyle.css"></link>
<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script>
	$(document).ready(function() {
	});

	function showUserInfo() {
		$.get("${pageContext.request.contextPath}/userInfo", {
			more : "Yes"
		}, function(data) {
			$('#additioalUserInfo').html(data);
		});
	}
</script>


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
			<h3>Edit your information</h3>

			User Name: <input type="text" value="${user.name}"> <br /> 
			Gender: ${user.gender } <br />

			<a href="javascript:void(0);" onclick="javascript:showUserInfo();">Show
				More</a>
			<div id="additioalUserInfo"></div>
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>




</body>
</html>