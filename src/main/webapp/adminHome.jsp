<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel = "icon" type = "" href = "Assets/medhublogo.png">
<link rel="stylesheet" href="NavStyle.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
<title>AdminHome</title>
<script>
    history.forward();
</script>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

body {
	background-color: white;
	background-image: url("Assets/homepage_img.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

#navigation ul li {
	list-style: none;
	padding: 20px;
	display: inline-block;
	margin-right: 0%;
}

#navigation {
   background: linear-gradient(to right, rgb(200, 47, 58) 0%,rgb(44, 169, 207) 100%);
   margin-top: 0%;
}

#navigation ul li a {
	text-decoration: none;
	color: whitesmoke;
	display: inline;
		float:right;
	
}

#navigation ul li a:hover {
	color: black;
}


#navigation #logout a {
	position: relative;
	right: 10px;
}

h3 {
	text-align: center;
	position: relative;
	top:100px;
}
</style>
</head>

<body>

<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<div class="container-fluid p-0">
		<div id="navigation" >
			<ul >
				<li><a  href="allUsers">All Users</a></li>
				<li><a  href="adminAllProducts">All Products</a></li>
				<li><a  href="addProduct.jsp">Add Products</a></li>
				<li><a  href="salesReports.jsp">Sales Reports</a></li>		
				<li id="logout"><a href="index.jsp">Logout</a></li>
		</div>
		</ul>
		
		<h3>Welcome Admin</h3>
	</div>
	
</body>

</html>