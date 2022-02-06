<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.medhub.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="icon" type="" href="Assets/medhublogo.png">
<link rel="stylesheet" href="Assets/css/adminAllProducts.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
    history.forward();
</script>
<style type="text/css">
* {
	margin-left: 0px;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

body {
	background-color:rgb(241,224,187);
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
	height: 40px;
	width: 80px;
	border: none;
	border-radius: 5px;
	background-color: red;
}

#btn1 {
	position: relative;
	left: 120px;
	top: 30px;
}

#product #btn button:hover {
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
#deleteButton{
color: white;
background-color: red;
outline: none;
border: none;
height: 40px;
width: 80px;
border-radius: 5px;
}

</style>
<title>All Products</title>
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

	
	<%-- <c:forEach items="${allProducts}" var="products">
		<div id="product">
			<div id="img">
				<img src="Assets/Images/${products.getProductImg()}"
					alt="${products.getProductName()}">
				<h5>${products.getProductName()}</h5>
			</div>
			<div id="details">
				<h5>Product Id : ${products.getProductId()}</h5>
				<h5>Description : ${products.getDescription()}</h5>
				<h5>price :${products.getUnitPrice()}rs</h5>
				<h5>Offer : ${products.getOffer()}%</h5>
				<h5>Points : ${products.getPoints()}</h5>
				<h5>Available Quantity : ${products.getQuantity()}</h5>
			</div>
			<div id="btn">
				<a href="ProdToBeUpdate?productId=${products.getProductId()}"
					class="btn btn-warning">Update</a><br> <br>
				<a 
					href="deleteProduct?deleteProductId=${products.getProductId()}"
					onclick="check()" class="btn btn-danger"  id="deleteBtn" onclick="confirmDelete()" >Delete</a>
			
				<button id="deleteBtn"
					 onclick="confirmdelete(${products.getProductId()})">Delete</button>
			</div>
		</div>
		<br>
		<br>
	</c:forEach> --%>
	
	<table aria-describedby="Sales report" id="table_id" aria-describedby="Sales report" style="width: 100%" >
	<thead>
	<th id="Product Id">S No</th>
	<th id="Product Id">Product Id</th>
	<th id="Description">Description</th>
	<th id="price">price</th>
	<th id="Offer">Offer</th>
	<th id="Points">Points</th>
	<th id="Available">Available</th>
	<th id="Status">Status</th>
	<th id="delete">Delete</th>
	<th id="update">Update</th>
	
	
	</thead>
	
	<tbody>
	<c:forEach begin="0" items="${allProducts}" var="products" varStatus="loop">
	<tr>
	<td>${loop.count}</td>
	<td>${products.getProductId()}</td>
	<td>${products.getDescription()}</td>
	<td>${products.getUnitPrice()}rs</td>
	<td>${products.getOffer()}%</td>
	<td>${products.getPoints()}</td>
	<td>${products.getQuantity()}</td>
	<td>${products.getStatus()}</td>
	<td><c:if test="${products.getStatus()=='available'}">
	<button id="deleteButton" onclick="confirmdelete(${products.getProductId()})">Delete</button></c:if>
	</td>
	<td><a href="ProdToBeUpdate?productId=${products.getProductId()}" class="btn btn-warning">Update</a></td>
	
	</tr>
	</c:forEach>
	</tbody>
	</table>
	

	<script src="Assets/javascript/popupMessages.js"></script>
	<c:choose>
	<c:when test="${param.status!=null}">
		<script type="text/javascript">  showMessage('deleteSucess')</script>
	</c:when>
	
	<c:when test="${param.deleteFailure!=null}">
		<script type="text/javascript"> showMessage('deleteFailure')</script>
	</c:when>
	
	<c:when test="${updateCheck!=null}">
	<script type="text/javascript">showMessage('productUpdated')</script>
	<c:remove var="updateCheck" scope="request" />
	</c:when>
	</c:choose>

	<script>
	$(document).ready(function() {
		$('#table_id').DataTable();
	});
	
	
function check(){
    var result = confirm("Are You Sure To Delete The Product");

    if(result==false){
        event.preventDefault();
    }
}


function confirmdelete(productId) {
	Swal.fire({
	    title: "Are you sure about deleting this Product?",
	    type: "info",
	    showCancelButton: true,
	    confirmButtonText: "Delete It",
	    confirmButtonColor: "#ff0055",
	    cancelButtonColor: "#999999",
	    reverseButtons: true,
	    focusConfirm: false,
	    focusCancel: true
	  }).then((result) => {
		  if (result.isConfirmed) {
			    window.location.replace("deleteProduct?info=&deleteProductId=" + productId);
			  }
	  })
	
}

	
  
 /*   Swal.fire({
		 title: "Are you sure about \n deleting this Package?",
		    type: "info",
		    showCancelButton: true,
		    confirmButtonText: "Delete It",
		    confirmButtonColor: "#ff0055",
		    cancelButtonColor: "#999999",
		    focusConfirm: false,
		    focusCancel: true
		}).then((result) => {
		  if (result.isConfirmed) {
		    window.location.replace("deleteProduct?info=&deleteProductId=" + productId);
		  }
		}) */


</script>
</body>
</html>