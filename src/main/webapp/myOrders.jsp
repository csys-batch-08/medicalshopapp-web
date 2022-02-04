<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel = "icon" type = "" href = "Assets/Images/medhublogo.png">
 <link rel="stylesheet" href="Assets/css/myOrders.css">

<title>My Orders</title>
<style>

/* * {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

.list ul li {
	list-style: none;
	display: inline-block;
}

.list li {
	float: right;
	padding: 20px;
	transition: transform 0.4s;
	
}

.list ul {
	height: 70px;
	position: absolute;
	margin-right: 0%;
	position: absolute;
	top: 0;
	box-shadow: 0 5 black;
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
	transform: translateY(-10px);
	
}

.list{
   background: linear-gradient(to right, rgb(200, 47, 58) 0%,rgb(44, 169, 207) 100%);
    position: fixed;
   width: 100%;
   z-index: 1;

}
body {
	background-image: url(Assets/Images/homepage_img.jpg);
	background-size: cover;
	overflow-x:hidden; 
	
}

.logo img {
	height: 60px;
	width: 60px;
	margin-left: 20px;
}

.slide {
	position: absolute;
	top: 120px;
}
.products {
	margin-top: 330px;
	border-spacing: 0 200px;
	
}


#product:hover{
box-shadow: 5px 5px 20px black;
transition-duration:0.3s;
}

.slide img {
	box-shadow: 0 0 10px black;
}

.products tr td {
	padding-left: 220px;
}

img {
	box-shadow: -5px -5px 10px black;
	border-radius: 3px;
}

.logo img {
	box-shadow: none;
}

#copyrights {
	text-align: center;
	color: yellow;
	position: relative;
	top:300px;	
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
}

#product {
	position: relative;
	background-color: rgba(158, 202, 207, 0.5);
	height: 190px;
	border-radius: 5px;
	width: 1200px;
	top:150px;
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
	left: 240px;
	top: -116px;
}

#product #btn {
	position: relative;
	left: 900px;
	top:-180px;
}

#product #btn button {
	height: 30px;
	width: 90px;
	background-color: orange;
	border: none;
	border-radius: 5px;
}


#btn1 {
	position: relative;
	left: 120px;
	top: -40px;
}

#product #btn button:hover {
	background-color: red;
	box-shadow: 0 0 5px black;
	color: white;
}

#product #img h3 {
	position: relative;
	left: 40px;
	top:20px;
}

#btn  {
	position: relative;
	top: -40px;
}

a {
	text-decoration: none;
	color: black;
}

#userName{
position: absolute;
top:90px;
left: 55px;
}

#productId{
visibility: hidden;
} */

</style>
</head>

<body>

	<div id="container">

		<div class="nav" class="container-fluid p-0">

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
						src="https://uxwing.com/wp-content/themes/uxwing/download/21-medical-science-lab/healthcare.png"
						alt="logo">
				</div>		
			</nav>
		</div>
						
	
		<jsp:useBean id="orderItem" class="com.medhub.dao.OrderItemsDaoImpl"/>
		 <jsp:useBean id="orderDao" class="com.medhub.dao.OrderDaoImpl"/>
			<c:forEach items="${myOrders}" var="myAllOrders" >
			
		
			
			<div id="product">
				<div id="img">
					<img src="Assets/Images/${myAllOrders.getProduct().getProductImg()}" alt="horlicks">
					<h3>${myAllOrders.getProduct().getProductName() }</h3>
				</div>
				<div id="details">
				
				<fmt:parseDate value="${myAllOrders.getOrderdate()}" pattern="yyyy-MM-dd" var="orderDate" type="date"/>	
				
					   <h3>
						Order Date :
						<fmt:formatDate pattern="dd/MM/yyyy" value="${orderDate}"/>
						</h3> 
				<h3> 
					Description :
					${myAllOrders.getProduct().getDescription()}
					</h3>
					<h3>
						price : ${myAllOrders.getUnitPrice()}rs</h3>
					<h3>
						Offer Applied:
						${myAllOrders.getProduct().getOffer() }%
					</h3>
					
					<h3 name="points">
						Points :
						${myAllOrders.getProduct().getPoints() }</h3>
						
						<h3 name="quantity" >
						Total Quantity:
						${myAllOrders.getQuantity() }</h3>
					<h3 name="totalPrice">
						Total Amt :
						${myAllOrders.getTotalPrice() }rs</h3>
					<h3>
						Order Status :
						${myAllOrders.getOrderModel().getOrderStatus() }</h3>	
						
						<h3 name="productId" id="productId">
						Order Date :
						${myAllOrders.getProduct().getProductId() }</h3>
					
		
						
				</div>
				<c:if test="${orderItem.cancelDate(myAllOrders.getOrderdate(),myAllOrders.getOrderModel().getOrderId())and orderDao.checkStatus(myAllOrders.getOrderModel().getOrderId())}">
				<div id="btn">
					<button>
						<a id="cancel" onclick="check()"  href="cancelOrderServlet?orderId=${myAllOrders.getOrderModel().getOrderId()}&quantity=${myAllOrders.getQuantity()}
							&totalPrice=${myAllOrders.getTotalPrice()} &points=${myAllOrders.getProduct().getPoints()}&productId=${myAllOrders.getProduct().getProductId()}">Cancel Order</a>
					</button>
					<br>
				</div>
				 </c:if> 
				
			</div>
		
		<br>
		<br>
		</c:forEach>

	</div>

	</div>
	<div id="footer"></div>


</body>

<script>
function check(){
    var result = confirm("if you want to cancel 10% cancellation charge will be detected on your total price");

    if(result==false){
        event.preventDefault();
    }
}
</script>

</html>
