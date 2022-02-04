<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Out Of Stock</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
<link rel="stylesheet" href="Assets/css/ProductOutStock.css">

</head>
<body>

	<div id="container">

		<div class="nav">

			<nav class="list">
				<ul>
					<li><a href="index.jsp">SignOut</a></li>
					<li><a href="showCartServlet">Cart</a></li>
					<li><a href="showUserProfile">MyProfile</a></li>
					<li><a href="myOrdersServlet">MyOrders</a></li>
					<li><a href="aboutUs.jsp">About-Us</a></li>
					<li><a href="userHomeServlet">Home</a></li>
					
				</ul>
				<div class="logo">
					<img
						src="https://uxwing.com/wp-content/themes/uxwing/download/21-medical-science-lab/healthcare.png"
						alt="logo">
				</div>		
			</nav>
		</div>
<!-- 		
 -->		
		<img class="outOfStockLogo animate__animated  animate__zoomInDown animate__delay-0.5s" alt="outOfStockLogo" src="Assets/Images/OutOfStockImage1.png">
		<h1 class="msg animate__animated  animate__zoomIn "> Sorry For Inconvenience ! Please Try Again After Sometime</h1>

	</div>	
</body>
</html>