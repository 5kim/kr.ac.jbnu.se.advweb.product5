<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- �ܾ �Է��ϰų� ī�װ��� �̿��� �˻��� ��ǰ�� ����� �����ִ� ȭ�� -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Search Product</title>
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
			<div style="margin-top: 20px">
				<c:forEach items="${searchList}" var="product">
					<tr>
						<td>${product.name}</td>
					</tr>
				</c:forEach>
			</div>
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>

</body>
</html>