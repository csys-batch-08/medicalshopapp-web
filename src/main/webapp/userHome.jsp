<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel = "icon" type = "" href = "Assets/medhublogo.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
<meta name="theme-color" content="#ba8f88" >
<link rel="stylesheet" href="Css/UserHome.css">
<title>User Home</title>

<script>
    history.forward();
</script>
<style>
animate__fadeInRightBig
*{
  
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    text-decoration: none;
    font-family: Arial, sans-serif;
    
}

.list ul li {
   list-style: none;
   display: inline-block;
}

.nav{
  background: linear-gradient(to right, rgb(200, 47, 58) 0%,rgb(44, 169, 207) 100%);
  position: fixed;
  width: 100%;
  box-shadow:0 0 10px black;
  z-index: 1;
}

.list li {
   float: right;
   padding: 20px;
   transition: transform 0.4s;
}

.list ul {
   /* background-color: #10847E;*/
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

.list li:hover, .list a:hover {
   color: orange;
   border-radius: 5px;
   cursor: pointer;
}

.list li:hover{
   transition-duration: 0.2s;
   transform: translateY(-10px);
}

body {
   /* background: linear-gradient(rgba(26,176,156,0.7),rgba(239,78,28,0.5)) ,url(Images/homepage_img.jpg); */
   background-repeat: no-repeat;
   overflow-x: hidden;
   background-size: cover;
}
body{
background-image: url(Assets/homepage_img.jpg);
background-repeat: repeat-y;
}

.logo img {
   height: 60px;
   width: 60px;
   margin-left: 20px;
}

/* banner */
.slide {
   position: absolute;
   top: 120px;
}

.products tr td {
   padding-left: 220px;
}

.logo img {
   box-shadow: none;
}

#copyrights {
   text-align: center;
   color: yellow;	
}

#allproducts a {
   text-decoration: none;
   color: black;
}

#allproducts a:hover {
   text-decoration: underline;
   color: white;
}

#allproducts {
   text-align: center;
}


#product {
   position: relative;
   top: 30px;
   left: 50px;
   background-color: rgba(158, 202, 207, 0.5);
   height: 190px;
   border-radius: 5px;
   width: 1200px;
   top:150px;
}

#product:hover{
box-shadow: 0 0 10px black;
transition-duration:0.3s;
}

#product img {
   height: 100px;
   width: 90px;
   position: relative;
   left: 40px;
   top:20px;
}

#product h3 {
   position: relative;
   left: 10px;
}

#product #details {
   position: relative;
   left: 250px;
   top: -90px;
}

#product #btn {
   position: relative;
   top: -250px;
   left: 900px;
}

#product #btn button {
   height: 30px;
   width: 90px;
   border: none;
   border-radius: 5px;
   background-color: none;
}

#product #btn button{
   position: relative;
   background-color: yellowgreen;
   bottom:-150px;
   
}

#btn1 {
   position: relative;
}

#product #btn button:hover {
   box-shadow: 0 0 5px black;
   color: green;
   transition-duration: 0.2s;
   
}

#product #img h3 {
   position: relative;
   left: 40px;
   top:20px;
}

/* #btn #buynow {
   position: relative;

} */

a {
   text-decoration: none;
   color: black;
}

#userName{
position: absolute;
top:90px;
left: 55px;
}

.prodSearch{
position: fixed;
left:200px;
z-index: 1;
top:18px;
}

#searchBar{
height: 30px;
width:250px;
outline: none;
border: none;
border-top-left-radius: 2px;
border-bottom-left-radius: 2px;
}

#searchBtn{
position:absolute;
height:30px;
width: 40px;
border: none;
border-top-right-radius: 2px;
border-bottom-right-radius: 2px;
}

#searchBtn:hover{
cursor: pointer;
background-color: rgb(173, 238, 120);
box-shadow: 0 0 5px black;
transition-duration:0.2s;
}

#searchBar:Hover{
box-shadow: 0 0 10px black;
}


</style>

</head>

<body>

<%-- <%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>--%>
 	
	
	
	<div class="container-fluid p-0" >
		<div class="nav">

			<nav class="list">
				<ul>
					<li><a href="index.jsp">SignOut</a></li>
					<li><a href="showCartServlet">Cart</a></li>
					<li><a href="showUserProfile">MyProfile</a></li>
					<li><a href="myOrdersServlet?orderId=0&totalPrice=0&quantity=0&points=0&productId=0">MyOrders</a></li>
					<li><a href="aboutUs.jsp">About-Us</a></li>
					<li><a href="userHomeServlet">Home</a></li>					
				</ul>
				
				<div class="logo">
					<img
						src="Assets/medhublogo.png"
						alt="logo">
				</div>
			</nav>
		</div>
		
		
		
		 <%-- <%=currentUser.getName()%> --%>
		<h2 id="userName" class="animate__animated animate__bounceIn">welcome <c:out value="${sessionScope.user.userName}" /> </h2>
		</div>
		<br><br>
		
		
		
		
<!-- 					Search Products		
-->		
		<form action="filterProductservlet" class="prodSearch" method="get">
		<input id="searchBar" type="text" name="ProductName" required="required" placeholder="Search By Products & categories">
		<button type="submit" id="searchBtn">&#128269;</button>
		</form>
		
		
				
		<c:forEach items="${allProducts}" var="products" >
		
			<div id="product" >
				<div id="img">
					<img src="Assets/${products.getProductImg()}" alt="horlicks">
					<h3> ${products.getProductName()} </h3>
				
				</div>
				<div id="details">
					<h3>
						Description :
						${products.getDescription()}</h3>
					<h3>
						Price :${products.getUnitPrice()} rs</h3>
					<h3>
						Offer :
						${products.getOffer()}%
					</h3>
					<h3>
						Points :
						${products.getPoints()}</h3>
				</div>
				<div id="btn">
					<a><button>
						<a id="buynow" href="showBuyProduct?pid=${products.getProductId()} ">Buy Now</a>
					</button></a>
					
				</div>
			</div>
		
		<br>
		<br>
		</c:forEach>
		

	</div>

	</div>
	
	<div id="footer">
			
	</div>


</body>

</html>
