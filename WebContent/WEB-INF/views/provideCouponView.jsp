<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 관리자가 회원에게 쿠폰 발급을 위한 화면 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Provide Coupon</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign in</title>

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
				<form method="POST"
					action="${pageContext.request.contextPath}/providecoupon">
					<tr>
						<td>Customer ID :</td>
						<td><input type="text" name="userId"><br></td>
					</tr>
					<tr>
						<td>CouponName :</td>
						<td><input type="text" name="couponName"><br></td>
					</tr>
					<tr>
						<td>Discount Rate :</td>
						<td><select name="discountRate">
								<option value="5">5%
								<option value="10">10%
								<option value="15">15%
								<option value="20">20%
						</select><br></td>
					</tr>
					<tr>
						<td>Limit Period :</td>
						<td><select name="year">
								<option value="">년</option>
								<option value=2017>2017</option>
						</select> <select name="month">
								<option value="">월</option>
								<option value="01">1</option>
								<option value="02">2</option>
								<option value="03">3</option>
								<option value="04">4</option>
								<option value="05">5</option>
								<option value="06">6</option>
								<option value="07">7</option>
								<option value="08">8</option>
								<option value="09">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
						</select><select name="day">
								<option value="">일</option>
								<option value="01">1</option>
								<option value="02">2</option>
								<option value="03">3</option>
								<option value="04">4</option>
								<option value="05">5</option>
								<option value="06">6</option>
								<option value="07">7</option>
								<option value="08">8</option>
								<option value="09">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="28">28</option>
								<option value="29">29</option>
								<option value="30">30</option>
								<option value="31">31</option>
						</select></td><br>
					</tr>
					<tr>
						<button type="submit">Provide</button>
					</tr>
				</form>
			</div>
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>

</body>
</html>