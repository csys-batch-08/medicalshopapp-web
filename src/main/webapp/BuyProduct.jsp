<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.medHub.model.Product"%>
<%@page import="com.medHub.dao.ProductDaoImpl"%>
<%@page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel = "icon" type = "" href = "Assets/medhublogo.png">



<title>BuyProduct</title>
<style>

/* Nav is named as List
 */
 
 * {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}
 
.list{
background: linear-gradient(to right, rgb(200, 47, 58) 0%,rgb(44, 169, 207) 100%);
   position: fixed;
   width: 100%;
   z-index: 1;
}
.list ul li {
	list-style: none;
	display: inline-block;
}

.list li {
	float: right;
	padding: 20px;
	transition: transform 0.4s;
	color: white;
	
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
	color: white;
	padding-right: 0px;
	
}


.list ul, .list li, .list a {
	text-decoration: none;
	color: black;
	font-family: monospace;
	font-size: 25px;
	font-weight: 500;
	/* margin-right: 20px; */
	color: white;
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
	background-image: url(Assets/homepage_img.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}

.logo img {
	height: 60px;
	width: 60px;
	margin-left: 20px;
}

.buyProduct {
	position: absolute;
	top: 150px;
	left: 170px;
}

.buyProduct{
background-color: rgba(158, 202, 207,0.5);
width: 900px;
height: 300px;
border-radius: 5px;
}

.buyProduct img {
	position:relative;
	left:-30px;
	height: 220px;
	width: 220px;
}

#qty {
	position: relative;
	left: 20px;
	top: 74px;
}

#qty button {
	position: relative;
	left: 80px;
}

#qty input {
	width: 40px;
	position: relative;
}

#qty #qtyBox {
	position: relative;
	left:30px;
}

.buyProduct td p{
padding-top: 30px;
position: relative;
left:-100px;
}

#addToCart a{
background-color: green;
text-decoration: none;
}

#buyNow a{
background-color: green;
color: white;
text-decoration: none;
}

#addToCart:hover{
cursor: pointer;
}

#buyNow:hover{
cursor: pointer;
}

#price{
position: relative;
left: -100px;
outline: none;
border: none;
background-color: rgba(158, 202, 207,0.1); 
color: black;
}

#pImg{
position: relative;
height: 200px;
width: 170px;
left:10px;
}

#pDesc{
position: relative;
left: 110px;
bottom: 15px;
}

#TotalPriceLabel{
position: relative;
top:-150px;
right: 50px;
}

#offer{
position: relative;
left: -100px;
top:30px;
outline: none;
border:none;
background-color: rgba(158, 202, 207,0.1); 
color: black;
font-size: 15px;
}

#totalprice{
position: relative;
top:-190px;
left:100px;
outline: none;
border: none;
background-color: rgba(158, 202, 207,0.1); 
color: black;
font-weight: 700;
font-size: 17px;
}

#totalPriceDiv{
position: relative;
top:20px;
}

#cartForm #addToCart{
position: relative;
left:-150px;
}

#ErrorMsg{
visibility: hidden;
}

#cartQuantity{
visibility: hidden;
}

#cartTotalPrice{
visibility: hidden;
}

#detail{
position: relative;
left:50px;
bottom:15px;
}

#detail p:nth-child(1) {
  position: relative;
  bottom: 29px;
}

#detail p:nth-child(2) {
  position: relative;
  bottom: 29px;
}

#detail p:nth-child(3) {
  position: relative;
  bottom: 29px;
}

#detail p:nth-child(4) {
  position: relative;
  bottom: -50px;
}

.payNow button{
height: 28px;
width: 80px;
background-color: yellowgreen;
outline: none;
border: none;
border-radius: 5px;
}

.payNow{
position: relative;
right: 22px;
}

.addToCart button{
height: 28px;
width: 80px;
position: relative;
background-color:rgb(43, 180, 235);
outline: none;
border: none;
border-radius: 5px;
}

.addToCart{
position: relative;
bottom: 47px;
left:100px;
}

.payNow button:hover{
box-shadow: 0 0 5px black;
transition-duration:0.2s;
cursor: pointer;
}

.addToCart button:hover{
box-shadow: 0 0 5px black;
transition-duration:0.2s;
}

#rs{
position: relative;
right: 240px;
}

#percentage{
position: relative;
top:30px;
right:275px;
}

</style>
</head>
<body>

<%
int pId=Integer.parseInt(request.getParameter("pid"));
ProductDaoImpl productDao = new ProductDaoImpl();
Product currentProduct = productDao.findProductByProductId(pId);
session.setAttribute("currentproduct", currentProduct);
%>
	<div class="nav">

		<nav class="list" >
			<ul>
					<li><a href="Cart.jsp">Cart</a></li>
					<li><a href="Index.jsp">SignOut</a></li>
					<li><a href="UserProfile.jsp">MyProfile</a></li>
					<li><a href="MyOrders.jsp?orderId=0&totalPrice=0&quantity=0&points=0&productId=0">MyOrders</a></li>
					<li><a href="MyOrders.jsp?orderId=0">About-Us</a></li>
					<li><a href="UserHome.jsp">Home</a></li>
					
			</ul>
			<div class="logo">
				<img
					src="https://uxwing.com/wp-content/themes/uxwing/download/21-medical-science-lab/healthcare.png"
					alt="logo">
		</nav>
	</div>
	<table class="buyProduct">
		<tbody>

			<tr>

					
				<td> 
				<div id="pDesc">
				<p>
						<b>Product category:</b>
					</p>
					<p>
						<b>Product Name:</b>
					</p>
					<p>
						<b>Description:</b>
					</p>
					<p>
						<b>Price:</b>
					</p>
					<p>
						<b>Available Quantity:</b>
					</p>
					<p>
						<b>Points:</b>
					</p>
					<p>
						<b>Offer:</b>
					</p>
					</td>
				<td id="detail">
					<p name="pCategory"><%=currentProduct.getProductCategory() %></p>
					<p name="pName"><%=currentProduct.getProductName() %></p>
					<p name="pDescription"><%=currentProduct.getDescription() %></p>
					<input name="pUnitPrice" id="price" value="<%=currentProduct.getUnitPrice()%>" disabled>
					<label id="rs">Rs</label>
					<p name="pQuantity"><%=currentProduct.getQuantity() %></p>
					<p name="pgetPoints"><%=currentProduct.getPoints() %></p>
					<input name="pOffer" id="offer" value="<%=currentProduct.getOffer()%>" disabled>
					<span id="percentage">%</span></td>
				<td>
					<div id="qty">
						<div id="qtyBox">	
						<form action="prod1" onsubmit="return chechQuantity()">
							<label for="">Quantity</label> 
							<input type="number" id="quantity" name="quantity" min="1"  max="<%=currentProduct.getQuantity()%>" onclick="calculateamt()">
						</div>
						<h3 id="TotalPriceLabel">Total price : Rs </h3>
						<div id="totalPriceDiv">
						<input name="totalPrice" id="totalprice">
						</div>
						<p name="message" id="message"></p>
						<div class="payNow">
						<button type="submit" >Paynow</button>
						</div>
						</form>
						
						
						<form action = "cartserv" id="cartForm" onsubmit="return chechQuantity()">
						<input name="cartQuanity" type = "text" id = "cartQuantity" required>
						<input name="cartTotalPrice" type = "text" id = "cartTotalPrice" >
						<div class="addToCart">
						<button type="submit" id="addToCart" >Add To Cart</button>
						</div>
						<h4 id="ErrorMsg" >Please Select Quantity</h4>
						</form>
					</div>
				</td>
			</tr>
			</div>
		</tbody>
	</table>
<tr>
<script>

function calculateamt(){
var price=document.getElementById("price");
	
	var amount=price.value;
	console.log("unitprice"+amount);
	var qty=document.getElementById("quantity");
	var quanty=qty.value;
	console.log(quanty);
	var discount=document.getElementById("offer");
	var dis=discount.value;
	console.log("discount"+dis);
	let totalAmt = 0;

 
 if(discount!=0){
 	 totalAmt=Math.round(amount * quanty)-(amount * quanty)*dis/100;
 	 console.log(totalAmt);
 	
	document.getElementById("totalprice").value=totalAmt;
 }else{

	document.getElementById("totalprice").value=totalAmt;
	
 }
 cartfn();
}


function cartfn(){
	let quant = document.getElementById("quantity").value;
	let totprice = document.getElementById("totalprice").value;
	let cartquant = document.getElementById("cartQuantity");
	let carttot = document.getElementById("cartTotalPrice");
cartquant.value = quant;
carttot.value = totprice;

}

function chechQuantity() {
	
	
	if(document.getElementById("quantity").value==0 || document.getElementById("cartQuanity").value==0)
		
	{
		
		document.getElementById("ErrorMsg").style.visibility="visible";
		
		return false;
		}
	return true; 	
}
function makeHidden() {
	document.getElementById("ErrorMsg").style.visibility="hidden";	
}

</script>
</body>
</html>