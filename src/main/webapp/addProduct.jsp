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
 <link rel="stylesheet" href="Assets/css/addProduct.css">
 
<script>
    history.forward();
</script> 

<title>Add Product</title>
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
				<li id="logout"><a class="navbar-brand" href="index.jsp">Logout</a></li>
			</ul>	
		</div>
		
	</div>
	<div id="addProductForm">
	
		
        <c:if test="${productExists!=null}">
		<p id="errorMsg">${productExists}</p>
		</c:if>  
		<c:remove var="productExists"  scope="session"/> 
		
		<form action="AddProductController">
		
			<input class="inputBox" list="category" onkeyup="hideErrorMsg()" name="category" id="browser"
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
		
			<input class="inputBox" type="text" onkeyup="hideErrorMsg()" required name="productName"
				placeholder="Product Name" ><br>
			<br>
			
 
			<input class="inputBox" type="number"  onkeyup="hideErrorMsg()" required min="1" name="price" placeholder="Price"><br>
			<br>
			
 
			<input class="inputBox" type="number" min="1" onkeyup="hideErrorMsg()" required  name="quantity"
				placeholder="Quantity"><br>
			<br>
 
			<label>Add Image</label>
			<input class="inputBox" type="file" onkeyup="hideErrorMsg()" required name="imageFile"
				placeholder="Image Url"><br>
			<br>
 
			<input class="inputBox" type="number" onkeyup="hideErrorMsg()" required min="1"  name="points"
				placeholder="Points"><br>
			<br>
 
			<input class="inputBox" type="number" onkeyup="hideErrorMsg()" required min="0" name="offer"
				placeholder="Offer%"><br>
			<br>
			<br>

			<textarea class="inputBox" 
				style="max-height: 70px; min-height: 20px; width: 400px; max-width: 200px; min-width: 300px;"
				required name="description" onkeyup="hideErrorMsg()" placeholder="Product Description"></textarea>
			<br>
			<button type="submit">Add</button>
		</form>
	</div>
	
</body>
<script>
	
function hideErrorMsg() {
    document.getElementById("errorMsg").style.visibility="hidden";
}
</script>
</html>