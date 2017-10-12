<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign in</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<div>
	<label>ID</label>
	<input type ="text">
	</div>
	<div>
	<label>PASSWORD</label>
	<input type ="password">
	</div>
	<div>
	<label>이름</label>
	<input type ="text">
	</div>
	<div>
	<label>전화번호</label>
	<input type = "number">
	-
	<input type = "number">
	-
	<input type = "number">
	</div>
	<div>
	<label>성별</label>
	남자<input type ="radio" name="성별" value="male">
	여자<input type ="radio" name="성별" value="female">
	</div>
	<div>
	<label>E-mail</label>
	<input type ="text">
	</div>
	<button type="submit">확인</button>
	<button type="reset">취소</button>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>