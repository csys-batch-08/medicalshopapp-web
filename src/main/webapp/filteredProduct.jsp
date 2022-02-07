<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/Images/medhublogo.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<meta name="theme-color" content="#ba8f88">
<link rel="stylesheet" href="Assets/css/filteredProduct.css">

<title>Userhome</title>
</head>

<body>


	<%session.setAttribute("userNotFound", null);%>

	<div id="container">
		<div class="container-fluid p-0">
			<div class="nav">

				<nav class="list">
					<ul>
						<li><a href="showCartServlet">Cart</a></li>
						<li><a href="index.jsp">SignOut</a></li>
						<li><a href="showUserProfile">MyProfile</a></li>
						<li><a href="myOrders.jsp?orderId=0">MyOrders</a></li>
						<li><a href="aboutUs.jsp">About-Us</a></li>
						<li><a href="userHomeServlet">Home</a></li>
					</ul>

					<div class="logo">
						<img src="Assets/Images/medhublogo.png" alt="logo">
					</div>
				</nav>
			</div>
		</div>

		<form action="" class="prodSearch">
			<input id="searchBar" type="text" name="ProductName" required
				placeholder="Search By Products & categories">
			<button id="searchBtn">&#128269;</button>
		</form>



		<c:if test="${not empty allProducts}">

			<c:forEach items="${allProducts}" var="products">
				<div id="product" class="animate__animated  animate__bounceInLeft">
					<div id="img">
						<img src="Assets/Images/${products.getProductImg()}"
							alt="${ products.getProductName()}">
						<h3>${products.getProductName()}</h3>
					</div>
					<div id="details">
						<h3>Description : ${products.getDescription()}</h3>
						<h3>price :${products.getUnitPrice()}rs</h3>
						<h3>Offer : ${products.getOffer() }%</h3>
						<h3>Points : ${products.getPoints() }</h3>
					</div>
					<div id="btn">
						<button>
							<a id="buynow"
								href="BuyProduct.jsp?pid=${products.getProductId() }">Buy
								Now</a>
						</button>


					</div>
				</div>
				<br>
				<br>
			</c:forEach>
		</c:if>

		<c:if test="${empty allProducts}">

			<h1 id="noProd">NO Products Matches !</h1>
		</c:if>

	</div>


	<div id="footer"></div>


</body>

</html>
