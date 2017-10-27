<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href=”bootstrap/css/bootstrap.min.css” rel=”stylesheet”
	type=”text/css” />
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>Home Page</title>

   <style>
     div{
        color:red;
        text-decoration:underline;
      }
    </style>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
	<svg width="960" height="960" font-family="sans-serif" font-size="10"
		text-anchor="middle"></svg>
	<script src="https://d3js.org/d3.v4.min.js"></script>
	
	<div id="box">
		<div id="top">
			<jsp:include page="_header.jsp"></jsp:include>
		</div>
		<div id="left">
			<jsp:include page="_menu.jsp"></jsp:include>
		</div>
		<div id="main">
			<b>여기에다가는 추천상품과 신규상품을 넣어야 하겠지....</b>
		</div>
		<div id="bottom">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>

	<h3>Home Page</h3>

	This is demo Simple web application using jsp,servlet &amp; Jdbc.
	<br>
	<br>
	<b>It includes the following functions:</b>
	<ul>
		<li>Login</li>
		<li>Storing user information in cookies</li>
		<li>Product List</li>
		<li>Create Product</li>
		<li>Edit Product</li>
		<li>Delete Product</li>
	</ul>

	<div class=”container”>

		<form role=”form”>
			<div class=”form-group”>
				<label for=”exampleInputEmail1″>Email address</label>
				<inputtype =”email” class=”form-control” id=”exampleInputEmail1″
					placeholder=”Enteremail”>
			</div>
			<div class=”form-group”>
				<label for=”exampleInputPassword1″>Password</label> <input
					type=”password” class=”form-control” id=”exampleInputPassword1″
					placeholder=”Password”>
			</div>
			<div class=”form-group”>
				<label for=”exampleInputFile”>File input</label> <input type=”file”
					id=”exampleInputFile”>
				<p class=”help-block”>Example block-level help text here.</p>
			</div>
			<div class=”checkbox”>
				<label> <input type=”checkbox”> Check me out
				</label>
			</div>
			<button type=”submit” class=”btnbtn-default”>Submit</button>
		</form>
	</div>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>