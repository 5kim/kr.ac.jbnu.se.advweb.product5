<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<script>

var svg = d3.select("svg"),
    width = +svg.attr("width"),
    height = +svg.attr("height");

var format = d3.format(",d");

var color = d3.scaleOrdinal(d3.schemeCategory20c);

var pack = d3.pack()
    .size([width, height])
    .padding(1.5);

d3.csv("file/flare.csv", function(d) {
  d.value = +d.value;
  if (d.value) return d;
}, function(error, classes) {
  if (error) throw error;

  var root = d3.hierarchy({children: classes})
      .sum(function(d) { return d.value; })
      .each(function(d) {
        if (id = d.data.id) {
          var id, i = id.lastIndexOf(".");
          d.id = id;
          d.package = id.slice(0, i);
          d.class = id.slice(i + 1);
        }
      });

  var node = svg.selectAll(".node")
    .data(pack(root).leaves())
    .enter().append("g")
      .attr("class", "node")
      .attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; });
node.append("circle").attr("id", function(d) { return d.id; }).attr("r", function(d) { return d.r; }).style("fill", function(d) { return color(d.package); });

  node.append("clipPath").attr("id", function(d) { return "clip-" + d.id; }).append("use").attr("xlink:href", function(d) { return "#" + d.id; });

  node.append("text").attr("clip-path", function(d) { return "url(#clip-" + d.id + ")"; })
    .selectAll("tspan")
    .data(function(d) { return d.class.split(/(?=[A-Z][^A-Z])/g); })
    .enter().append("tspan")
      .attr("x", 0)
      .attr("y", function(d, i, nodes) { return 13 + (i - nodes.length / 2 - 0.5) * 10; })
      .text(function(d) { return d; });

  node.append("title")
      .text(function(d) { return d.id + "\n" + format(d.value); });
});

</script>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<div class="container">
		<!-- Content here -->
	</div>

	<div class="container">
		<div class="row">
			<div class="col">1 of 2</div>
			<div class="col">2 of 2</div>
		</div>
		<div class="row">
			<div class="col">1 of 3</div>
			<div class="col">2 of 3</div>
			<div class="col">3 of 3</div>
		</div>
	</div>
	<div class="alert alert-primary" role="alert">This is a primary
		alert—check it out!</div>
	<div class="alert alert-secondary" role="alert">This is a
		secondary alert—check it out!</div>
	<div class="alert alert-success" role="alert">This is a success
		alert—check it out!</div>
	<div class="alert alert-danger" role="alert">This is a danger
		alert—check it out!</div>
	<div class="alert alert-warning" role="alert">This is a warning
		alert—check it out!</div>
	<div class="alert alert-info" role="alert">This is a info
		alert—check it out!</div>
	<div class="alert alert-light" role="alert">This is a light
		alert—check it out!</div>
	<div class="alert alert-dark" role="alert">This is a dark
		alert—check it out!</div>

	<button type="button" class="btn btn-primary">Primary</button>
	<button type="button" class="btn btn-secondary">Secondary</button>
	<button type="button" class="btn btn-success">Success</button>
	<button type="button" class="btn btn-danger">Danger</button>
	<button type="button" class="btn btn-warning">Warning</button>
	<button type="button" class="btn btn-info">Info</button>
	<button type="button" class="btn btn-light">Light</button>
	<button type="button" class="btn btn-dark">Dark</button>

	<button type="button" class="btn btn-link">Link</button>

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