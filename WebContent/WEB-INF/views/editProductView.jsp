<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<!-- 등록한 제품을 수정하는 화면 -->
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
<link rel="stylesheet" type="text/css" href="CSS/mainstyle.css"></link>
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
			<h3>Edit Product</h3>

			<p style="color: red;">${errorString}</p>

			<c:if test="${not empty product}">
				<form id ="Edit_Product_id" method="POST"
					action="${pageContext.request.contextPath}/editProduct">
					<input type="hidden" name="code" value="${product.productNumber}" />
					<table border="0">
						<tr>
							<td>Code</td>
							<td style="color: red;">${product.productNumber}</td>
						</tr>
						<tr>
							<td>inventory</td>
							<td><input type="text" name="name" value="${product.inventory}" /></td>
						</tr>
						<tr>
							<td>Price</td>
							<td><input type="text" name="price" value="${product.price}" /></td>
						</tr>
						<tr>
							<td>recomend</td>
							<td><input type="text" name="price" value="${product.recomend}" /></td>
						</tr>
						<tr>
						<tr>
							<td colspan="2"><input type="submit" value="Submit" /> <a
								href="${pageContext.request.contextPath}/productList">Cancel</a>
							</td>
						</tr>
					</table>
				</form>
			</c:if>
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>



</body>
</html>