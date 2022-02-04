<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
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

<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<script type="text/javascript">
    history.forward();
</script>

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

	
	<c:forEach items="${allProducts}" var="products">


		<div id="product">
			<div id="img">
				<img src="Assets/Images/${products.getProductImg()}"
					alt="${products.getProductName()}">
				<h5>${products.getProductName()}</h5>
			</div>
			<div id="details">
				<h5>Product Id : ${products.getProductId() }</h5>
				<h5>Description : ${products.getDescription() }</h5>
				<h5>price :${products.getUnitPrice()}rs</h5>
				<h5>Offer : ${products.getOffer()}%</h5>
				<h5>Points : ${products.getPoints() }</h5>
				<h5>Available Quantity : ${products.getQuantity() }</h5>
			</div>
			<div id="btn">
				<a href="ProdToBeUpdate?productId=${products.getProductId()}"
					class="btn btn-warning">Update</a><br> <br>
				<%-- <a 
					href="deleteProduct?deleteProductId=${products.getProductId()}"
					onclick="check()" class="btn btn-danger"  id="deleteBtn" onclick="confirmDelete()" >Delete</a> --%>

				<button id="deleteBtn"
					onclick="confirmdelete(${products.getProductId()})">Delete</button>
			</div>
		</div>

		<br>
		<br>
	</c:forEach>
	

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
	<c:when test="${updateCheck!=null}">
	<script type="text/javascript">showMessage('productUpdated')</script>
	</c:when>
	</c:choose>

	<script>
function check(){
    var result = confirm("Are You Sure To Delete The Product");

    if(result==false){
        event.preventDefault();
    }
}


function confirmdelete(productId) {
	 Swal.fire({
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
		})
}
	


</script>
</body>
</html>