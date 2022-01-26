<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@page import="java.util.List"%>
<%@page import="com.medHub.model.*"%>
<%@page import="com.medHub.dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel = "icon" type = "" href = "Assets/medhublogo.png">

<title>My Orders</title>
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
	/* background: linear-gradient(rgba(26,176,156,0.7),rgba(239,78,28,0.5)) ,url(Images/homepage_img.jpg); */
	background-image: url(Assets/homepage_img.jpg);
	background-size: cover;
	overflow-x:hidden; 
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
/* progress */
.products {
	margin-top: 330px;
	border-spacing: 0 200px;
}

.slide img {
	box-shadow: 0 0 10px black;
}

.products tr td {
	padding-left: 220px;
}

img {
	box-shadow: 0 0 10px black;
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
}

</style>
</head>

<body>


	<%
	OrderItemsDaoImpl myOrder= new OrderItemsDaoImpl();
	User currentUser = (User)session.getAttribute("user");
	List<OrderItems> myOrderList = myOrder.ViewMyOrders(currentUser);
	OrderDaoImpl currentCancelOrder = new OrderDaoImpl();
	OrderItemsDaoImpl orderItem = new OrderItemsDaoImpl();
	ProductDaoImpl productDao = new ProductDaoImpl();
	UserDaoImpl userDao = new UserDaoImpl();
/* 	LocalDate date =  orderItem.getCurrentDate().toLocaleString();
	Date localDepartureDate = java.sql.Date.valueOf(date); */
	%>
	<div id="container">

		<div class="nav" class="container-fluid p-0">

			<nav class="list">
				<ul>
					<li><a href="Index.jsp">SignOut</a></li>
					<li><a href="Cart.jsp">Cart</a></li>
					<li><a href="UserProfile.jsp">MyProfile</a></li>
					<li><a href="MyOrders.jsp?orderId=0&totalPrice=0&quantity=0&points=0&productId=0">MyOrders</a></li>
					<li><a href="AboutUs.jsp">About-Us</a></li>
					<li><a href="UserHome.jsp">Home</a></li>
					
				</ul>
				<div class="logo">
					<img
						src="https://uxwing.com/wp-content/themes/uxwing/download/21-medical-science-lab/healthcare.png"
						alt="logo">
			</nav>
		</div>
		<!-- slideshow -->

<%-- 		<h2 id="userName">welcome <%=currentUser.getName()%></h2>
 --%>		</div>

		<% 
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		int orderId=Integer.parseInt(request.getParameter("orderId"));
		OrderDaoImpl orderDao=new OrderDaoImpl();	
		boolean deleteStatus=currentCancelOrder.deleteProduct(orderId);
		
		double totalAmt= Double.parseDouble(request.getParameter("totalPrice"));
		double returnAmt = Math.round(totalAmt-(totalAmt*10/100));
		double availableWallet= currentUser.getWallet()+returnAmt;
		int quanity = Integer.parseInt(request.getParameter("quantity"));
		int points = Integer.parseInt(request.getParameter("points"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		userDao.updateWalletMoney(availableWallet, currentUser);
		currentUser.setWallet(availableWallet);
		int availablePoints = currentUser.getPoints()-points;
		userDao.updateUserPoints(availablePoints, currentUser);
		currentUser.setPoints(availablePoints);
		Product cancelledProduct;
		if(productId>0)
		{
			 cancelledProduct = productDao.findProductByProductId(productId);
			 int updatedQty = cancelledProduct.getQuantity()+quanity;
			cancelledProduct.setQuantity(updatedQty);
			productDao.updateProductQuantity(cancelledProduct, updatedQty);
		}
		
		
		
		
		if(deleteStatus)
		{%>
			<script>
			alert("Ordered Cancelled Sucessfully");
			</script>
			response.sendRedirect("MyOrders.jsp");
			
		<% }%>
		

		
		/* orderDao.deleteProduct(myAllOrders.getOrderModel().getOrderId()); */
				
		
	
		<% boolean flag;
		for(OrderItems myAllOrders : myOrderList)
			 {
			flag = orderDao.checkStatus(myAllOrders.getOrderModel().getOrderId());
			System.out.println(myAllOrders.getOrderdate());
			boolean cancel = orderItem.cancelDate(myAllOrders.getOrderdate(),myAllOrders.getOrderModel().getOrderId());
			 %>
			
			<div id="product">
				<div id="img">
					<img src="Assets/<%=myAllOrders.getProduct().getProductImg()%>" alt="horlicks">
					<h3><%=myAllOrders.getProduct().getProductName() %></h3>
				</div>
				<div id="details">
					<h3>
						Order Date :
						<%=myAllOrders.getOrderdate().format(format)%></h3>
					<h3>
					Description :
					<%=myAllOrders.getProduct().getDescription()%>
					</h3>
					<h3>
						price :<%=myAllOrders.getUnitPrice()+ "rs"%></h3>
					<h3>
						Offer Applied:
						<%=myAllOrders.getProduct().getOffer() %>%
					</h3>
					
					<h3 name="points">
						Points :
						<%=myAllOrders.getProduct().getPoints() %></h3>
						
						<h3 name="quantity">
						Total Quantity:
						<%=myAllOrders.getQuantity() %></h3>
					<h3 name="totalPrice">
						Total Amt :
						<%=myAllOrders.getTotalPrice() + "rs"%></h3>
					<h3>
						Order Status :
						<%=myAllOrders.getOrderModel().getOrderStatus()%></h3>	
						
						<h3 name="productId" id="productId">
						Order Date :
						<%=myAllOrders.getProduct().getProductId()%></h3>
					<h3>
		
						
				</div>
				<% if(flag && cancel)
				{%>
					<!-- <h3>Ordered Cancelled</h3> -->
				<div id="btn">
					<button>
						<a id="cancel" onclick="check()"  href="MyOrders.jsp?orderId=<%=myAllOrders.getOrderModel().getOrderId()%>&quantity=<%=myAllOrders.getQuantity()%>
							&totalPrice=<%=myAllOrders.getTotalPrice()%>&points=<%=myAllOrders.getProduct().getPoints()%>&productId=<%=myAllOrders.getProduct().getProductId()%>">Cancel Order</a>
					</button>
					<br>
					</button>
				</div>
				<% }%>
			</div>
		
		<br>
		<br>
		<%}%>
		
	
<!-- 		<h2 id="copyrights">© 2021 MedHub.com. All rights reserved.</h2>
 -->
	</div>

	</div>
	<div id="footer"></div>


</body>

<script>
function check(){
    var result = confirm("if you want to cancel 10% cancelation charge will be detected on your total price");

    if(result==false){
        event.preventDefault();
    }
}
</script>

</html>
