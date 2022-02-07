<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.medhub.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

<link rel="icon" type="" href="Assets/Images/medhublogo.png">
<link rel="stylesheet" href="Assets/css/userProfile.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<meta name="theme-color" content="#ba8f88">
<title>User Profile</title>
</head>
<body>

	<div class="nav">

		<nav class="list" class="container-fluid p-0">
			<ul>
				<li><a href="index.jsp"><label class="nav">SignOut</label></a></li>
				<li><a href="showCartServlet"><label class="nav">Cart</label></a></li>
				<li><a href="showUserProfile"><label class="nav">MyProfile</label></a></li>
				<li><a
					href="myOrdersServlet?orderId=0&totalPrice=0&quantity=0&points=0&productId=0"><label
						class="nav">MyOrders</label></a></li>
				<li><a href="aboutUs.jsp"><label class="nav">About-Us</label></a></li>
				<li><a href="userHomeServlet"><label class="nav">Home</label></a></li>
			</ul>
			<div class="logo">
				<img
					src="https://uxwing.com/wp-content/themes/uxwing/download/21-medical-science-lab/healthcare.png"
					alt="logo">
			</div>
		</nav>
	</div>

	<%-- 	<c:if test="${InsuffientMoney!=null}">
		<div class="InsuffiendMoney" >
		<h3>${InsuffientMoney}</h3>
		</div>
	</c:if>	
	<c:remove var="InsuffientMoney"  scope="session"/> --%>

	<c:if test="${AddressNotFound!=null}">
		<div class="addressNull">
			<h3>${AddressNotFound}</h3>
		</div>
	</c:if>
	<c:remove var="AddressNotFound" scope="session" />

	<c:if test="${notEnoughAmt!=null}">
		<div class="cartOrder">
			<h3>${notEnoughAmt}</h3>
		</div>
	</c:if>
	<c:remove var="notEnoughAmt" scope="session" />


	<!-- User Profile -->
	<div id="userProfile">
		<form action="ProfileUpdate" method="get">
			<table aria-describedby="UserProfile">
			
				<tr>
					<td><label>Name :</label>
					<td><input id="updatedName" name="updatedName"
						pattern="[A-Za-z ]{3,}"
						title="name should be minimum 3 letters and maximum 30 letters"
						required min="3" max="10" value="${currentUser.getUserName()}"><br></td>
					<td id="space" rowspan="2" colspan="2"></td>
				</tr>
				
				<tr>
					<td><label>Password :</label></td>
					<td><input id="updatedPassword" name="updatedPassword"
						required
						pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%?&]{8,15}$"
						title="Minimum eight and Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character"
						value="${currentUser.getUserPassword()}"><br></td>
				</tr>


				<tr>
					<td><label>Mobile No :</label></td>
					<td><input id="UpdatedMobNum" name="UpdatedMobNum"
						pattern="[6-9][0-9]{9}" title="MObile Number Must Have 10 Digits"
						required value="${currentUser.getUserMobile()}"></td>
					<td rowspan="2" colspan="2"></td>
				</tr>

				<tr>
					<td><label>Delivery Address :</label></td>
					<td><textarea id="UpdateDeliveryAddress"
							name="UpdateDeliveryAddress" required rows="5" cols="33"
							style="max-width: 300px; max-height: 100px;">${currentUser.getAddress()}</textarea><br></td>
				</tr>
				<tr>
					<td colspan="2">
						<button id="saveChangesBtn">Save Changes</button>
					</td>
				</tr>
				</table>
				</form>
				</div>


				<div id="walletMoneyUpdateForm">
					<form action="walletUpdate" method="get">
						<label> Wallet : </label> <input type="number" name="UpdateWallet"
							 min="200" max="5000" title=""
							value="${currentUser.getWallet()}">
						<button>Add Money</button>
					</form>
				</div>

				<div id="pointMoney">
					<form action="ConvertMoney" method="get">
						<label> points : </label> <input type="number" name="pointsMoney"
							min="500" max="5000"
							value="${currentUser.getPoints()}"
							title="You need to reach 500 points to convert" readonly>
						<button>Convert To Cash</button>
					</form>
				</div>


			
	</div>


</body>
</html>