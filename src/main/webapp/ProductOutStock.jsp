<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Out Of Stock</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}


.list ul li {
	list-style: none;
	display: inline-block;
}

.nav{
   background: linear-gradient(to right, rgb(200, 47, 58) 0%,rgb(44, 169, 207) 100%);
   position: fixed;
   width: 100%;
   z-index: 1;
}

.list li {
	float: right;
	padding: 20px;
	transition: transform 0.4s;
}

.list ul {
	/* background-color: #10847E;*/
	height: 70px;
	position: absolute;
	margin-right: 0%;
	position: absolute;
	top: 0;
	box-shadow: 0 5 black;
	/* margin-top: 0%; */
	right: 0px;
	width: 1372px;
}

.list ul {
	padding-right: 0px;
}

.list ul, .list li, .list a {
	text-decoration: none;
	color: white;
	font-family: monospace;
	font-size: 25px;
	font-weight: 500;
	/* margin-right: 20px; */
}

.list li:hover{
	transition-duration: 0.2s;
	transform: translateY(-10px);
}

.list li:hover, .list a:hover {
	color: orange;
	border-radius: 5px;
	cursor: pointer;
}

body {
	/* background: linear-gradient(rgba(26,176,156,0.7),rgba(239,78,28,0.5)) ,url(Images/homepage_img.jpg); */
	background-image: url(Assets/OutOfStockBg.png);
	background-repeat: no-repeat;
	background-size: cover;
	
}

.logo img {
	height: 60px;
	width: 60px;
	margin-left: 20px;
}

.outOfStockLogo{
position: absolute;
left: 600px;
top:400px;
}

.msg{
position: absolute;
left:250px;
top:300px;
}
</style>
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
		<img class="outOfStockLogo animate__animated  animate__zoomInDown animate__delay-1s" alt="outOfStockLogo" src="Assets/OutOfStockImage1.png">
		<h1 class="msg animate__animated  animate__zoomIn "> Sorry For Inconvenience ! Please Try Again After Sometime</h1>

	</div>	
</body>
</html>