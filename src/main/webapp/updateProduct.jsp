<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
 <link rel = "icon" type = "" href = "Assets/Images/medhublogo.png">
  <link rel="stylesheet" href="Assets/css/updateProduct.css">
 
<script>
    history.forward();
</script>

<title>Update Product</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<div id="container">
		<div id="navigation">
			<ul>
				<li><a href="allUsers">All Users</a></li>
				<li><a href="adminAllProducts">All Products</a></li>
				<li><a href="addProduct.jsp">Add Products</a></li>
				<li><a href="salesReports.jsp">Sales Reports</a></li>
				<li id="home"><a class="navbar-brand" href="adminHome.jsp">Logout</a></li>
			</ul>
		</div>
		
			
		
	<div id="addProductForm">
		<form action="UpdateProductController">
			<label for="category">Category</label> 
			<input class="inputBox" list="category" name="category" id="browser" placeholder="Category" value="${currentProduct.getProductCategory()}">
			<datalist id="category">
				<option value="medicine">
				<option value="sanitizer">
				<option value="babycare">
				<option value="devices">
				<option value="healthdrink">
			</datalist>
			
			<br>
			<br> <label for="name">Product Name</label>
			<input 	class="inputBox" type="text" required name="productName" placeholder="Product Name" value="${currentProduct.getProductName()}"><br>
			<br> <label for="price">Price</label> <br>
			<input class="inputBox" type="number" name="price" placeholder="Price" value="${currentProduct.getUnitPrice()}"><br>
			<br> <label for="Quantity">Quantity</label> <br>
			<input class="inputBox" type="number" required name="quantity" placeholder="Quantity" value="${currentProduct.getQuantity()}"><br>
			<br> <label for="image">Image Url</label> <br>
			<input class="inputBox" type="file" required name="imageUrl" placeholder="Image Url" value="${currentProduct.getProductImg()}"><br>
			<br> <label for="Points">Points</label> <br>
			 <input class="inputBox" type="text" required name="points" placeholder="Points" value="${currentProduct.getPoints()}"><br>
			<br> <label for="Offer">Offer</label> <br>
			<input class="inputBox" type="text" required name="offer" placeholder="Offer%" value="${currentProduct.getOffer()}"><br>
			<br>
			<br> <label for="">Description</label><br>
			<br>
			<input class="inputBox" style="max-height: 100px; min-height: 20px; width: 400px; max-width: 200px; min-width: 300px;"
				required name="description" placeholder="Product Description" value="${currentProduct.getDescription()}"></input>
			<br>
			<button name="currentProdId" value="${currentProduct.getProductId()}">Update</button>
		</form>
	</div>
	</div>
	

</body>
</html>