<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="assets/images/medhublogo.png">
<meta name="theme-color" content="#ba8f88">
<link rel="stylesheet" href="assets/css/aboutUs.css">
<title>About Us</title>
</head>
<body>


	<%-- <%User currentUser = (User)session.getAttribute("user");
	session.setAttribute("userNotFound", null);
	%>
	 --%>
	<div id="container">
		<div class="container-fluid p-0">
			<div class="nav">

				<nav class="list">
					<ul>
						<li><a href="index.jsp"><label>SignOut</label></a></li>
						<li><a href="showCartServlet"><label>Cart</label></a></li>
						<li><a href="showUserProfile"><label>MyProfile</label></a></li>
						<li><a
							href="myOrdersServlet?orderId=0&totalPrice=0&quantity=0&points=0&productId=0"><label>MyOrders</label></a></li>
						<li><a href="aboutUs.jsp"><label>About-Us</label></a></li>
						<li><a href="userHomeServlet"><label>Home</label></a></li>
					</ul>
					<div class="logo">
						<img src="assets/images/medhublogo.png" alt="logo">
					</div>
				</nav>
			</div>

			<div class="aboutUs">
				<h1>Our Story</h1>
				<p>
					Our Company was founded in 2021 by Karthick kannan N R, our
					Managing Director and Chief Executive Officer, with the vision to
					set up a trusted pharmacy retail brand that offers genuine
					medicines and delivers better value to the customer by reducing
					inefficiencies in the supply chain using technology. The founder,
					Managing Director and Chief Executive Officer of our Company,
					Gangadi Madhukar Reddy, both a doctor and an entrepreneur, plays an
					instrumental role in the strategic direction and growth of our
					business. Our Company's shareholders include marquee investors,
					including Lavender Rose, belonging to the Warburg Pincus group, and
					affiliates of Premji Invest, and we maintain strong corporate
					governance and internal controls. <br> <br>
				<P>We operate 2,165 stores in 242 cities distributed across
					Tamil Nadu, Andhra Pradesh, Telangana, Karnataka, Odisha, West
					Bengal and Maharashtra as of June 30, 2021. We have a total of
					14,762 permanent full-time in-house employees working for us in a
					range of business activities.</p>
				<br> <br>

				<p>Our operations include the manufacturing and contract
					manufacturing of private label pharmaceutical, wellness and FMCG
					products, wholesale and retail sale, import, distribution, and
					pathology diagnostic laboratory testing.</p>
				<br> <br>

				<P>Our omni-channel platform enables us to service our customers
					through our stores as well as our online channels, thereby enabling
					us to leverage our strong offline channel to establish and grow our
					online presence.</p>
				<br> <br>

				<p>Our 'click and pick' service allows customers to place orders
					directly online for collection at their preferred store at a
					convenient time. Our customers also have the option to return any
					items purchased through our online channel at their preferred
					stores, subject to the standard terms and conditions. Through our
					'door-to-door' delivery service, in the cities of Hyderabad and
					Bangalore, our customers can place orders over the telephone,
					through our website or our mobile application</p>
			</div>
		</div>
	</div>
	<div id="footer"></div>
</body>

</html>
