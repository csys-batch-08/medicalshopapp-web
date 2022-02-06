<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel = "icon" type = "" href = "Assets/Images/medhublogo.png">
<link rel="stylesheet" href="Assets/css/buyProduct.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<title>BuyProduct</title>

</head>
<body>


	<div class="nav">

		<nav class="list" >
			<ul>
					<li><a href="showCartServlet">Cart</a></li>
					<li><a href="index.jsp">SignOut</a></li>
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
	
	
	<script src="Assets/javascript/popupMessages.js"></script>	
	
	<c:set var="InsufficientMoney" scope="request" value="${InsuffientMoney}"></c:set>
	<c:if test="${InsufficientMoney!=null}">
	<script type="text/javascript"> showMessage('${InsufficientMoney}')</script>
	<c:remove var="InsufficientMoney"  scope="request" />
	</c:if>
	
	<c:set var="AddressNotFound" scope="request" value="${AddressNotFound}"></c:set>
	<c:if test="${AddressNotFound!=null}">
	<script type="text/javascript"> showMessage('${AddressNotFound}')</script>
	<c:remove var="AddressNotFound"  scope="request" />
	</c:if>
	
	<table class="buyProduct" aria-describedby="buy Products">
		<tbody>

			<tr>
			<th id="th"></th>
				<td> 
				<div id="pDesc">
					<p>
						<strong>Product category:</strong>
					</p>
					<p>
						<strong>Product Name:</strong>
					</p>
					<p>
						<strong>Description:</strong>
					</p>
					<p>
						<strong>Price:</strong>
					</p>
					<p>
						<strong>Available Quantity:</strong>
					</p>
					<p>
						<strong>Points:</strong>
					</p>
					<p>
						<strong>Offer:</strong>
					</p>
					</td>
			
			
				<td id="detail">
					<p name="pCategory">${currentProduct.getProductCategory()}</p>
					<p name="pName">${currentProduct.getProductName()}</p>
					<p name="pDescription">${currentProduct.getDescription()}</p>
					<input name="pUnitPrice" id="price" value="${currentProduct.getUnitPrice()}" disabled>
					<label id="rs">Rs</label>
					<p name="pQuantity">${currentProduct.getQuantity()}</p>
					<p name="pgetPoints">${currentProduct.getPoints()}</p>
					<input name="pOffer" id="offer" value="${currentProduct.getOffer()}" disabled>
					<span id="percentage">%</span></td>
				<td>
					<div id="qty">
						<div id="qtyBox">	
						<form action="prod1" onsubmit="return chechQuantity()">
							<label for="">Quantity</label> 
							<input type="number" id="quantity" title="Please Check The Available Quantity" name="quantity" min="1"  max="${currentProduct.getQuantity()}" onkeyup="calculateamt()" onclick="calculateamt()" >
						</div>
						<h3 id="TotalPriceLabel">Total price : Rs </h3>
						<div id="totalPriceDiv">
						<input name="totalPrice" id="totalprice">
						</div>
						<p name="message" id="message"></p>
						<div class="payNow">
						<button type="submit" >Buy Now</button>
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
 	 totalAmt=Math.round((amount * quanty)-(amount * quanty)*dis/100);
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