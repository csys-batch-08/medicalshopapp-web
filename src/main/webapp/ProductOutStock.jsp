<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Out Of Stock</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link rel="stylesheet" href="assets/css/ProductOutStock.css">

</head>
<body>

	<div id="container">

		<div class="nav">

			<nav class="list">
				<ul>
					<li><a href="index.jsp"><label>SignOut</label></a></li>
					<li><a href="showCartServlet"><label>Cart</label></a></li>
					<li><a href="showUserProfile"><label>MyProfile</label></a></li>
					<li><a href="myOrdersServlet"><label>MyOrders</label></a></li>
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
		<img
			class="outOfStockLogo animate__animated  animate__zoomInDown animate__delay-0.5s"
			alt="outOfStockLogo" src="assets/images/OutOfStockImage1.png">
		<h1 class="msg animate__animated  animate__zoomIn ">Sorry For
			Inconvenience ! Please Try Again After Sometime</h1>

	</div>
</body>
</html>