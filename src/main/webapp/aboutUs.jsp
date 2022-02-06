<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/Images/medhublogo.png">
<meta name="theme-color" content="#ba8f88">
<link rel="stylesheet" href="Assets/css/aboutUs.css">
<title>About Us</title>

<!-- <style>
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

.nav {
	background: linear-gradient(to right, rgb(200, 47, 58) 0%,
		rgb(44, 169, 207) 100%);
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

.list li:hover {
	transition-duration: 0.2s;
	transform: translateY(-10px);
}

body {
 	background-repeat: no-repeat;
	overflow-x: hidden;
	background-size: 100% 100%;
	background-image: url(Assets/homepage_img.jpg);
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



#copyrights {
	text-align: center;
	color: yellow;
}




.aboutUs {
	background: linear-gradient(to right, rgb(255,105,99) 0%,
		rgb(255,123,100)100%);
	border-radius: 5px;
	height: 800px;
	width: 950px;
	position: absolute;
	top: 150px;
	left: 200px;
	background-size: cover;
	box-shadow: 0 0 15px black;
}

.aboutUs p{
text-indent: 150px;
line-height: 1.5;
text-align: justify;
margin: 20px;
color: white;
}

.aboutUs h1{
text-align: center;

}
</style> -->
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
						<li><a href="myOrdersServlet?orderId=0&totalPrice=0&quantity=0&points=0&productId=0"><label>MyOrders</label></a></li>
						<li><a href="aboutUs.jsp"><label>About-Us</label></a></li>
						<li><a href="userHomeServlet"><label>Home</label></a></li>
					</ul>
						<div class="logo">
							<img src="Assets/Images/medhublogo.png" alt="logo">
							</div>
				</nav>
			</div>

			<div class="aboutUs">
				<h1>Our Story</h1>
				<p>Our Company was founded in 2021 by Karthick kannan N R,
					our Managing Director and Chief Executive Officer, with the vision
					to set up a trusted pharmacy retail brand that offers genuine
					medicines and delivers better value to the customer by reducing
					inefficiencies in the supply chain using technology. The founder,
					Managing Director and Chief Executive Officer of our Company,
					Gangadi Madhukar Reddy, both a doctor and an entrepreneur, plays an
					instrumental role in the strategic direction and growth of our
					business. Our Company's shareholders include marquee investors,
					including Lavender Rose, belonging to the Warburg Pincus group, and
					affiliates of Premji Invest, and we maintain strong corporate
					governance and internal controls. <br><br> 
					
					 <P>We operate 2,165 stores in 242
					cities distributed across Tamil Nadu, Andhra Pradesh, Telangana,
					Karnataka, Odisha, West Bengal and Maharashtra as of June 30, 2021.
					We have a total of 14,762 permanent full-time in-house employees
					working for us in a range of business activities.</p>  
					<br><br>
					
					<p>Our operations
					include the manufacturing and contract manufacturing of private
					label pharmaceutical, wellness and FMCG products, wholesale and
					retail sale, import, distribution, and pathology diagnostic
					laboratory testing.</p> 
					<br><br>
					
					<P>
					Our omni-channel platform enables us to service
					our customers through our stores as well as our online channels,
					thereby enabling us to leverage our strong offline channel to
					establish and grow our online presence.</p>
					<br><br>
					
					<p> Our 'click and pick'
					service allows customers to place orders directly online for
					collection at their preferred store at a convenient time. Our
					customers also have the option to return any items purchased
					through our online channel at their preferred stores, subject to
					the standard terms and conditions. Through our 'door-to-door'
					delivery service, in the cities of Hyderabad and Bangalore, our
					customers can place orders over the telephone, through our website
					or our mobile application</p>
			</div>
	</div>
		</div>
		<div id="footer"></div>
</body>

</html>
