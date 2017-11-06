<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 주문을 위한 화면 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Information</title>
<link rel="stylesheet" type="text/css" href="CSS/mainstyle.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		google.charts.load('current', {'packages':['corechart']});
		google.charts.setOnLoadCallback(drawVisualization);
	
		function drawVisualization() { 
			var data = google.visualization.arrayToDataTable([
					['Month', '10대', '20대', '30대', '40대', '50대', '60대'],
					['남성',    165,    938,         522,             998,           450,      614.6],
					['여성',    135,   1120,        599,             1268,          288,      682],
				]);
			var options = {
					title : '제품 구매 통계',
					vAxis: {title: '구매수'},
					hAxis: {title: '성별'}, 
					seriesType: 'bars',
				};
			
			var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
			chart.draw(data, options);
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
			<h3>Product View</h3>
		<table border="0">
		<tr>
				<td>Product Name :</td> <td>${product.name}<br></td>
		</tr>
		<tr>
				<td>-------------이미지 자리------------<br></td>
		</tr>
		<tr>
				<td>Product Price :</td> <td>${product.price}<br></td>
		</tr>
		<tr>
				<td>Product Description :</td> <td>${product.description}<br></td>
		</tr>
		<tr>
				<td>Product Inventory :</td> <td>${product.inventory}<br></td>
		</tr>
				<br><br>
		<form method="GET" action="${pageContext.request.contextPath}/order">
		<input type="hidden" name="productNumber" value=${product.productNumber }>
		<tr>
				<td>Order Volume :</td> <td><input type="text" name="volume" value=""><br></td>
		</tr>
		<tr></tr>
		</table>
				<button type="submit" onClick="location.href='${pageContext.request.contextPath}/order?code=${product.productNumber}'">Order</button>			
				
		</form>
		
		<form method="GET" action="${pageContext.request.contextPath}/insertCart">
		<input type="hidden" name="productNumber" value=${product.productNumber }>
		<button type="submit" onClick="location.href='${pageContext.request.contextPath}/insertCart?code=${product.productNumber}'">Cart</button><br>				
		</form>		
		<div id="chart_div" style="width:500px; height: 300px;"></div>
		
		
		</div>
		
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>