<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/medhublogo.png">
<link rel="stylesheet" href="Assets/css/addProduct.css">
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
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
				<li><a href="allUsers"><label>All Users</label></a></li>
				<li><a href="adminAllProducts"><label>AllProducts</label></a></li>
				<li><a href="addProduct.jsp"><label>Add Products</label></a></li>
				<li><a href="salesReports.jsp"><label>Sales Reports</label></a></li>
				<li id="logout"><a class="navbar-brand" href="index.jsp"><label>Logout</label></a></li>
			</ul>
		</div>

	</div>
	<div id="addProductForm">


		<form action="AddProductController">

			<input class="inputBox" id="category" list="category"
				onkeyup="hideErrorMsg()" name="category" id="browser"
				placeholder="Category" aria-label="category" autofocus>
			<datalist id="category">
				<option value="medicine">
				<option value="sanitizer">
				<option value="babycare">
				<option value="devices">
				<option value="healthdrink">
			</datalist>
			<br> <br> <input class="inputBox" id="productName"
				type="text" onkeyup="hideErrorMsg()" required name="productName"
				placeholder="Product Name" aria-label="productName"><br>
			<br> <input class="inputBox" id="price" type="number"
				onkeyup="hideErrorMsg()" required min="1" name="price"
				placeholder="Price" aria-label="category"><br> <br>


			<input class="inputBox" id="quantity" type="number" min="1"
				onkeyup="hideErrorMsg()" required name="quantity"
				placeholder="Quantity" aria-label="quantity"><br> <br>

			<label>Add Image</label> <input class="inputBox" id="imageFile"
				type="file" onkeyup="hideErrorMsg()" required name="imageFile"
				placeholder="Image File" aria-label="imageFile"><br> <br>

			<input class="inputBox" id="points" type="number"
				onkeyup="hideErrorMsg()" required min="1" name="points"
				placeholder="Points" aria-label="points"><br> <br>

			<input class="inputBox" id="offer" type="number"
				onkeyup="hideErrorMsg()" required min="0" name="offer"
				placeholder="Offer%" aria-label="offer"><br> <br>
			<br>

			<textarea class="inputBox" id="Description"
				style="max-height: 70px; min-height: 20px; width: 400px; max-width: 200px; min-width: 300px;"
				required name="description" onkeyup="hideErrorMsg()"
				placeholder="Product Description" aria-label="Description"></textarea>
			<br>
			<button type="submit">Add</button>
		</form>
	</div>

	<script src="Assets/javascript/popupMessages.js"></script>

	<c:if test="${param.status!=null}">
		<script type="text/javascript">showMessage('productAdded')</script>
	</c:if>

	<c:set var="productExists" scope="request" value="${productExists}"></c:set>
	<c:if test="${productExists!=null}">
		<script type="text/javascript"> showMessage('${productExists}')</script>
		<c:remove var="productExists" scope="request" />
	</c:if>

</body>
<script>
	
function hideErrorMsg() {
    document.getElementById("errorMsg").style.visibility="hidden";
}
</script>
</html>