<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel = "icon" type = "" href = "Assets/medhublogo.png">
<script>
    history.forward();
</script> 

<title>Add Product</title>
<style>

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

body {
	
	overflow-x: hidden;
}
body{
background-image: url(Assets/homepage_img.jpg);
background-size: cover;
}

#addProductForm {
	position: absolute;
	top: 90px;
	left: 500px;
	background-color: rgb(240, 231, 231);
	height: 525px;
	width: 360px;
	border-radius: 5px;
}

#addProductForm label {
	position: relative;
	top: 20px;
	padding-top: 20px;
}

#addProductForm input {
	position: relative;
	top: 20px;
	left: 30px;
	height: 30px;
	width: 300px;
}

#addProductForm textarea {
	margin-left: 30px;
	width: 300px;
}

#addProductForm .inputBox {
	position: relative;
}

#addProductForm  button {
	position: relative;
	width: 60px;
	padding: 5px;
	left: 150px;
	top: 50px;
	border-radius: 2px;
	outline: none;
	border: none;
	box-shadow: 0 0 5px black;
}

#addProductForm  button:hover {
	background: green;
	border: none;
	color: white;
}

#addProductForm:hover {
	background: rgb(240, 231, 231);
	border: none;
	box-shadow: 0 0 5px black;
	transition-duration: 0.2s;
	
}

#navigation ul li {
	list-style: none;
	padding: 20px;
	display: inline-block;
	margin-left: 60px;
	/* font-weight: 600;
	font-size: 20px; */
}

#navigation {
	   background: linear-gradient(to right, rgb(200, 47, 58) 0%,rgb(44, 169, 207) 100%);
	align-items: center;
}

#navigation ul li a {
	text-decoration: none;
	color: whitesmoke;
	display: inline;
}

#navigation ul li a:hover {
	text-shadow: 2px 2px black;
}

#allusers table, th, tr, td {
	border: 1px solid black;
	border: none;
	padding: 15px;
}
#addProductForm label{
position: relative;
left:33px;
outline: none;
border: none;
}

input[type="file"]{
outline:none;
}
</style>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<div id="container">
		<div id="navigation">
			<ul>
				<li><a href="allUsers">All Users</a></li>
				<li><a href="adminAllProducts">AllProducts</a></li>
				<li><a href="addProduct.jsp">Add Products</a></li>
				<li><a href="salesReports.jsp">Sales Reports</a></li>
				<li id="logout"><a class="navbar-brand" href="Index.jsp">Logout</a></li>
			</ul>	
		</div>
		
	</div>
	<div id="addProductForm">
	
		<% if(session.getAttribute("productExists") != null)
           {%>
		<p id="errorMsg"><%=session.getAttribute("productExists") %></p>

		<%} session.removeAttribute("productExists"); %>
		<form action="AddProductController">
		
			<input class="inputBox" list="category" name="category" id="browser"
				placeholder="Category">
			<datalist id="category">
				<option value="medicine">
				<option value="sanitizer">
				<option value="babycare">
				<option value="devices">
				<option value="healthdrink">
			</datalist>
			<br>
			<br>
		
			<input class="inputBox" type="text" required name="productName"
				placeholder="Product Name" ><br>
			<br>
			
 
			<input class="inputBox" type="number"  required min="1" name="price" placeholder="Price"><br>
			<br>
			
 
			<input class="inputBox" type="number" required min="1" name="quantity"
				placeholder="Quantity"><br>
			<br>
 
			<label>Add Image</label>
			<input class="inputBox" type="file" required name="imageFile"
				placeholder="Image Url"><br>
			<br>
 
			<input class="inputBox" type="number" required min="1"  name="points"
				placeholder="Points"><br>
			<br>
 
			<input class="inputBox" type="number" required min="1" name="offer"
				placeholder="Offer%"><br>
			<br>
			<br>

			<textarea class="inputBox"
				style="max-height: 70px; min-height: 20px; width: 400px; max-width: 200px; min-width: 300px;"
				required name="description" placeholder="Product Description"></textarea>
			<br>
			<button type="submit">Add</button>
		</form>
	</div>
	
</body>
<script>
	
</script>
</html>