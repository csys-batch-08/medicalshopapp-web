<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
<link rel = "icon" type = "" href = "Assets/medhublogo.png">
<script>
    history.forward();
</script>

<title>All Products</title>
<style>
* {
	margin-left: 0px;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

body {
	background-image: url(Assets/homepage_img.jpg);
	background-repeat: repeat-y;
	background-size: cover;
	overflow-x:hidden;
	margin-top: 0px;
}


#navigation ul li {
	list-style: none;
	padding: 20px;
	display: inline-block;
	padding-right: 80px;
	/* font-weight: 600;
	font-size: 20px; */
}

#navigation {
	background: linear-gradient(to right, rgb(200, 47, 58) 0%,rgb(44, 169, 207) 100%);
	width: 100%;
	margin-top: 0%;
}

#navigation ul li a {
	text-decoration: none;
	color: whitesmoke;
	display: inline;
}

#navigation ul li a:hover {
	color: black;
}



#product {
	position: relative;
	background-color: rgb(158, 202, 207, 0.5);
	height: 250px;
	border-radius: 5px;
	width: 1200px;
	left: 70px;
}

#product img {
	height: 100px;
	width: 90px;
	position: relative;
	left: 40px;
	top:50px;
}

#product h5 {
	position: relative;
	left: 20px;
	top:60px;
}

#product #details {
	position: relative;
	left: 220px;
	top:-60px;
	}

#product #btn {
	position: relative;
	top: -250px;
	left: 900px;
}

#product #btn button {
	height: 30px;
	width: 90px;
	background-color: rgb(145, 230, 18);
	border: none;
	border-radius: 5px;
}

#btn1 {
	position: relative;
	left: 120px;
	top: 30px;
}

#product #btn button:hover {
	background-color: white;
	box-shadow: 0 0 5px black;
}

#product #img h5 {
	position: relative;
	left: 40px;
}

#details h5{
	position: relative;
	top:-40px;
	left:50px;
}
#deleteBtn{
position: relative;
left:100px;
bottom: 63px;
}
</style>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<div id="navigation" class="container-fluid">
		<ul>
			<li><a href="allUsers">All Users</a></li>
			<li><a href="adminAllProducts">All Products</a></li>
			<li><a href="addProduct.jsp">Add Products</a></li>
			<li><a href="salesReports.jsp">Sales Reports</a></li>
			<li id="logout"><a href="index.jsp">Logout</a></li>
			
	</div>
	</ul>
	</div>

	
	<c:forEach items="${allProducts}" var="products" >
	<form action="cart" method="get">
		<div id="product">
			<div id="img">
				<img src="Assets/${ products.getProductImg()}" alt="${products.getProductName()}">
				<h5>${products.getProductName()}</h5>
			</div>
			<div id="details">
				<h5>
					Product Id :
					${products.getProductId() }</h5>
				<h5>
					Description :
					${products.getDescription() }</h5>
				<h5>
					price :${products.getUnitPrice()}rs</h5>
				<h5>
					Offer :
					${products.getOffer()}%
				</h5>
				<h5>
					Points :
					${products.getPoints() }</h5>
				<h5>
					Available Quantity :
					${products.getQuantity() }</h5>
			</div>
			<div id="btn">
				<a href="ProdToBeUpdate?productId=${products.getProductId()}"
					 class="btn btn-warning" >Update</a><br>
				<br> <a
					href="deleteProduct?deleteProductId=${products.getProductId() }"
					class="btn btn-danger" id="deleteBtn" >Delete</a>
			</div>
		</div>
	</form>
	<br>
	<br>
	</c:forEach>

</body>
</html>