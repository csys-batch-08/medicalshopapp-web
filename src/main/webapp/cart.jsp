
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="assets/images/medhublogo.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<link rel="stylesheet" href="assets/css/cart.css">

<title>Cart</title>
</head>

<body id="body">


	<div id="container">

		<div class="nav">

			<nav class="list">
				<ul>
					<li><a href="index.jsp"><label>SignOut</label></a></li>
					<li><a href="showCartServlet"><label>Cart</label></a></li>
					<li><a href="showUserProfile"><label>MyProfile</label></a></li>
					<li><a
						href="myOrdersServlet?orderId=0&totalPrice=0&quantity=0&points=0&productId=0"><label>MyOrders</label></a></li>
					<li><a href="aboutUs.jsp"><label>About-Us</label></a></li>
					<li><a href="userHomeServlet"><label>Home</label></a></li>

				</ul>
				<div class="logo">
					<img
						src="https://uxwing.com/wp-content/themes/uxwing/download/21-medical-science-lab/healthcare.png"
						alt="logo">
				</div>
			</nav>

		</div>


		<c:if test="${param.removestatus!=null}">
			<script>
		var toastMixin = Swal.mixin({
			toast: true,
			icon: 'success',
			title: 'General Title',
			animation: false,
			position: 'top-right',
			showConfirmButton: false,
			timer: 2000,
			timerProgressBar: true,
			didOpen: (toast) => {
			toast.addEventListener('mouseenter', Swal.stopTimer)
			toast.addEventListener('mouseleave', Swal.resumeTimer)
			}
			});

			deleted();
			function deleted(){
			toastMixin.fire({
			animation: true,
			title: 'Item Removed Successfully'
			});
			}
			</script>
		</c:if>


		<c:forEach items="${cartList}" var="cartList">
			<div id="product">

				<div id="img">
					<img src="assets/images/${cartList.getProduct().getProductImg()}"
						alt="horlicks">
					<h3>${cartList.getProduct().getProductName()}</h3>
				</div>
				<div id="details">
					<h3>Description : ${cartList.getProduct().getDescription()}</h3>
					<h3 name="unitPrice">price :${cartList.getUnitPrice()}Rs</h3>
					<h3>Offer Applied: ${cartList.getProduct().getOffer()}%</h3>
					<h3 name="cartpoints">Points :
						${cartList.getProduct().getPoints()}</h3>
					<h3 name="cartQuantity">Total Quantity: ${cartList.getQty()}</h3>
					<h3 name="totalPrice">Total Amt :
						${cartList.getTotalPrice()}Rs</h3>


				</div>
				<div id="btn">
					<button type="submit">
						<a id="BuyNow"
							href="cartOrder?CartproductId=${cartList.getProduct().getProductId()}&unitPrice=${cartList.getUnitPrice()}&cartpoints=${cartList.getProduct().getPoints()}&cartQuantity=${cartList.getQty()}&totalPrice=${cartList.getTotalPrice()}">Buy
							Now</a>
					</button>
					<br>

					<%-- <a id="Remove" href="removeCartItem?CartproductId=${cartList.getProduct().getProductId()}">Remove</a> --%>
					<button id="Remove"
						onclick="confirmdelete(${cartList.getProduct().getProductId()})">Remove</button>

				</div>
			</div>
			<br>
			<br>
		</c:forEach>

	</div>

	</div>


	<div class="lessStockMsgDiv"
		class="animate__animated  animate__zoomInDown animate__delay-0.5s">

		<img src="assets/images/lessStock11.png" id="lessStockMsg"
			alt="lessStockImg" class="animate__animated  animate__bounceIn">
		<button onclick="hidePopUp()" id="popUpBtn"
			class="animate__animated  animate__bounceIn animate__delay-0.3s">CLOSE</button>
	</div>
	<c:if test="${lessStock!=null}">
		<script>  
	document.getElementById("lessStockMsg").style.visibility = "visible";
	document.getElementById("popUpBtn").style.visibility = "visible";
	body.style.overflow = "hidden";
	</script>
	</c:if>
	<c:remove var="lessStock" scope="session" />

	<div id="footer"></div>

	<script>

function check(){
    var result = confirm("Are You Sure To Delete The Product");

    if(result==false){
        event.preventDefault();
    }
}




function hidePopUp() {
	
	document.getElementById("lessStockMsg").style.visibility = "hidden";
	document.getElementById("popUpBtn").style.visibility = "hidden";
	body.style.overflow = "auto";
	document.getElementById("body").style.overflowX = "hidden";
	
}



function confirmdelete(productId) {
	 Swal.fire({
		 title: "Are you want to remove this item?",
		    type: "info",
		    showCancelButton: true,
		    confirmButtonText: "Delete It",
		    confirmButtonColor: "#ff0055",
		    cancelButtonColor: "#999999",
		    focusConfirm: false,
		    focusCancel: true
		}).then((result) => {
		  if (result.isConfirmed) {
		    window.location.replace("removeCartItem?info=&CartproductId=" + productId);
		  }
		})
}
 </script>

</body>

</html>
