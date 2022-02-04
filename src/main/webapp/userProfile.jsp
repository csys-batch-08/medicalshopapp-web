<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.medhub.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

 <link rel = "icon" type = "" href = "Assets/Images/medhublogo.png">
 <link rel="stylesheet" href="Assets/css/userProfile.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
<meta name="theme-color" content="#ba8f88" >
<title>User Profile</title>

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
	transform:translatey(-10px);
}
.list{
   background: linear-gradient(to right, rgb(200, 47, 58) 0%,rgb(44, 169, 207) 100%);
}
body {
	background-image: url(Assets/Images/homepage_img.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	overflow-x:hidden; 
	background-color: rgb(107,119,146,0.5);
	
}

.logo img {
	height: 60px;
	width: 60px;
	margin-left: 20px;
}
#userProfile{
position: absolute;
left:90px;
background-color: rgb(107,119,146,0.5);
top:90px;

}

#userProfile td,tr{
padding: 20px;
}

#userProfile input{
margin-top: 42.5px;
}

#userProfile label{
margin-top: 50px;
}

#userProfile input{
height: 30px;
width: 250px;
}

#walletMoneyUpdateForm{
position: absolute;
left: 600px;
bottom: 464px;
}

#walletMoneyUpdateForm button{
position: relative;
left:30px;
height: 30px;
border: none;
outline: none;
border-radius: 2px;
background-color: yellowgreen;
box-shadow: 0 0 2px black;
width: 110px;
}

#walletMoneyUpdateForm button:hover{
box-shadow: 0 0 5px black;
transition-duration:0.2s;
color:white;
}

textarea {
  resize: none;
  outline: none;
  border: none;
  border-radius: 3px;
  box-shadow: 0 0 5px black;
  
  }

#pointMoney{
position: relative;
top:190px;
left:600px;
}

#pointMoney button{
position: relative;
left:30px;
height: 30px;
border: none;
outline: none;
border-radius: 2px;
background-color: yellowgreen;
box-shadow: 0 0 2px black;
padding: 5px;
}

#pointMoney button:hover{
box-shadow: 0 0 5px black;
transition-duration:0.2s;
color:white;

}

#saveChangesBtn{
background-color: yellowgreen;
position: relative;
left:160px;
width: 100px;
height: 30px;
outline: none;
border: none;
border-radius: 3px;
}

#saveChangesBtn:hover{
box-shadow: 0 0 5px black;
transition-duration:0.2s;
color:white;
}

#updatedName{
position: relative;
bottom:20px;
}

#updatedPassword{
position: relative;
bottom:20px;
}

#UpdatedMobNum{
position: relative;
bottom:20px;
}

input{
outline: none;
border: none;
box-shadow: 0 0 5px black;
border-radius: 2px;
}

#userProfile{
color:white;
}

input:hover{
box-shadow: 5px 5px 5px black;
transition-duration:0.2s;
}

textarea:hover {
box-shadow: 5px 5px 5px black;
transition-duration:0.2s;	
}

.InsuffiendMoney{
position: absolute;
left:780px;
top:170px;
color:red;
z-index: 1;
}

.addressNull{
position: relative;
top:430px;
left:100px;
color: red;
z-index: 2;
}

.cartOrder{
position: absolute;
left:780px;
top:170px;
color:red;
z-index: 1;
}

#pointsMsg{
position: absolute;
left:760px;
top:280px;
color: red;
z-index: 1;

}

label{
font-weight: 600;
}

#space{
width:700px;
}
</style>
</head>
<body>


<%
String InsuffiendMoney = (String)session.getAttribute("InsuffientMoney");
String AddressNotFound = (String)session.getAttribute("AddressNotFound");
String cartOrderMOney = (String)session.getAttribute("notEnoughAmt");
String NegativePoints = (String)session.getAttribute("negativePoints"); 
String AddressNotFoundFromCart = (String)session.getAttribute("AddressNotFoundFromCart");
%>

<div class="nav">

		<nav class="list" class="container-fluid p-0">
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
	
	<c:if test="${InsuffientMoney!=null}">
		<div class="InsuffiendMoney" >
		<h3>${InsuffientMoney}</h3>
		</div>
	</c:if>	
	<c:remove var="InsuffientMoney"  scope="session"/>
	
	<c:if test="${AddressNotFound!=null}">
		<div class="addressNull">
		<h3>${AddressNotFound}</h3>
		</div>
	</c:if>	
	<c:remove var="AddressNotFound"  scope="session"/>
		
	<c:if test="${notEnoughAmt!=null}">
		<div class="cartOrder">
		<h3>${notEnoughAmt}</h3>
		</div>
	</c:if>	
	<c:remove var="notEnoughAmt"  scope="session"/>
	
	
       <% if(NegativePoints!=null)
     {%>
			<h3 id="pointsMsg"><%=NegativePoints%></h3>
			<%} session.removeAttribute("negativePoints");%>
			
	 <% if(AddressNotFoundFromCart!=null)
     {%>
			<h3 class="addressNull"><%=AddressNotFoundFromCart%></h3>
			<%} session.removeAttribute("AddressNotFoundFromCart");%>			
	
	

	
	<!-- User Profile -->
	<div id="userProfile">
	<form action="ProfileUpdate" method="get">
			<table  aria-describedby="UserProfile">
			<th></th>
			 <tr>
				<td><label>Name :</label>
				<td><input id="updatedName" name="updatedName" pattern="[A-Za-z ]{3,}" title="name should be minimum 3 letters and maximum 30 letters" required min="3" max="10" value="${currentUser.getUserName()}"><br></td>
				<td id="space" rowspan="2" colspan="2">
				</td>
		    </tr>
		
			<tr>
				<td><label>Password :</label></td>
				<td><input id="updatedPassword" name="updatedPassword"  required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%?&]{8,15}$"
				title="Minimum eight and Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character" value="${currentUser.getUserPassword()}"><br></td>
			</tr>
	
	
			<tr>
				<td><label>Mobile No :</label></td>
				<td><input id="UpdatedMobNum" name="UpdatedMobNum"  pattern="[6-9][0-9]{9}" title="MObile Number Must Have 10 Digits" required  value="${currentUser.getUserMobile()}"></td>
	    		<td rowspan="2" colspan="2"></td>
			</tr>	
	
			<tr>
				<td><label>Delivery Address :</label></td>
				<td><textarea   id="UpdateDeliveryAddress"   name="UpdateDeliveryAddress" required rows="5" cols="33" style="max-width: 300px;max-height: 100px;">${currentUser.getAddress()}</textarea><br></td>
			</tr>	
			<tr>
				<td colspan="2"> 
				<button id="saveChangesBtn">Save Changes</button>
				</td>
			</tr>		
		</form>
		</div>
		
		
		<div id="walletMoneyUpdateForm">
	<form action="walletUpdate" method="get">
		<label> Wallet : </label>
		<input type="number" name="UpdateWallet" "UpdateWallet" min="200" max="5000" title="" value="${currentUser.getWallet()}" >
		<button>Add Money</button>
	</form>
	</div>
	
	<div id="pointMoney">
	<form action="ConvertMoney" method="get">
	<label> points : </label>
	<input type="number" name="pointsMoney" "UpdateWallet" min="500" max="5000" value="${currentUser.getPoints()}" title="You need to reach 500 points to convert" readonly>
		<button>Convert To Cash</button>
	</form>
	</div>
	
	
		</table>
</div>

	
</body>
</html>