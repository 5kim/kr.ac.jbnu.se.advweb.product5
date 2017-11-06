<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="CSS/mainstyle.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		// Newly Added by STKim. 
		// The following code is for submitting the form data to server and redirect to another page. 
		$("#login_form_id").on('submit', function(e) {
			$.post('${pageContext.request.contextPath}/login', {
				userid : $("#id_id").val(),
				password : $("#passwd_id").val(),
				rememberMe : $("#rememberMe_id").val()
			}, function(data) {
				// move another page
				var win = window.open();
				win.document.write(data);
			});
		});
	})
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
			<h3>Login Page</h3>
			<p style="color: red;">${errorString}</p>

			<!--  old code -->
			<%--       <form method="POST" action="${pageContext.request.contextPath}/login"> --%>
			<!--          <table border="0"> -->
			<!--             <tr> -->
			<!--                <td>User Name</td> -->
			<%--                <td><input type="text" name="userName" value= "${user.userName}" /> </td> --%>
			<!--             </tr> -->
			<!--             <tr> -->
			<!--                <td>Password</td> -->
			<%--                <td><input type="text" name="password" value= "${user.password}" /> </td> --%>
			<!--             </tr> -->
			<!--             <tr> -->
			<!--                <td>Remember me</td> -->
			<!--                <td><input type="checkbox" name="rememberMe" value= "Y" /> </td> -->
			<!--             </tr> -->
			<!--             <tr> -->
			<!--                <td colspan ="2"> -->
			<!--                   <input type="submit" value= "Submit" /> -->
			<%--                   <a href="${pageContext.request.contextPath}/">Cancel</a> --%>
			<!--                </td> -->
			<!--             </tr> -->
			<!--          </table> -->
			<!--       </form> -->

			<!--  new code -->
			<form id="login_form_id" method="POST">
				<table border="0">
					<tr>
						<td>ID</td>
						<td><input type="text" id="id_id" name="id"
							value="${user.id}" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" id="passwd_id" name="password"
							value="${user.password}" /></td>
					</tr>
					<tr>
						<td>Remember me</td>
						<td><input type="checkbox" id="rememberMe_id"
							name="rememberMe" value="Y" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit" /> <a
							href="${pageContext.request.contextPath}/">Cancel</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>


</body>
</html>