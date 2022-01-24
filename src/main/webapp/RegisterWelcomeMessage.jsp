<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel = "icon" type = "" href = "Assets/medhublogo.png">

<title>Registeration</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}


.list li {
	list-style: none;
	display: inline-block;
	float: right;
	padding: 15px;
	transition: transform 0.4s;
}

.list li a{
	padding: -10px;
}


.list ul {
	/* background-color: #10847E;*/
	height: 70px;
	position: absolute;
	margin-right: 0%;
	position: absolute;
	top: 0;
	background-color: rgba(255, 255, 255, 0.603);
	box-shadow: 0  0 5px black;
	right: 0px;
	width: 1372px;
}

.list ul {
	padding-right: 60px;
}

.list ul, .list li, .list a {
	text-decoration: none;
	color: black;
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

body {
	background-image: url("Assets/homepage_img.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	overflow-x: hidden;
}

.logo img {
	height: 60px;
	width: 60px;
	margin-left: 20px;
}

/* login form */
#loginform {
	position: absolute;
	top: 200px;
	left: 490px;
	background-color:rgb(245,178,120);
	height: 400px;
	width: 400px;
	border-radius: 5px;
	visibility: hidden;
	box-shadow: 0 0 5px black;
}

.formcontent {
	position: relative;
	top: 110px;
	left: 75px;
}

.formcontent h3 {
	color: black;
	position: relative;
	top: -50px;
	left: 80px;
}

#loginbtn {
	position: relative;
	left: 90px;
	height: 25px;
	width: 90px;
	outline: none;
	border: 0;
	width: 80px;
	height: 30px;
	border-radius: 3px;
	font-weight: 500;
}

#loginbtn:hover {
	/* color: white; */
	font-weight: 800;
	background-color: yellowgreen;
	cursor: pointer;
}

.loginscreen .formcontent input {
	height: 25px;
	width: 60%;
	outline: none;
	border-radius: 3px;
	outline: none;
	border-top: none;
	border-left: none;
	border-right: none;
	background: transparent;
	font-size: 18px;
	color: white;
}

.loginscreen h2 {
	position: relative;
	top: -50px;
	left: 80px;
}

.loginscreen .formcontent a {
	text-decoration: none;
	color: white;
	font-size: larger;
	position: relative;
	left: -20px;
}

.loginscreen .formcontent a:hover {
	text-decoration: underline;
	color: black;
	cursor: pointer;
}

#loginbtn {
	position: relative;
	left: 90px;
	height: 25px;
	width: 90px;
	outline: none;
	border: 0;
	width: 80px;
	height: 30px;
	border-radius: 3px;
	font-weight: 500;
}

/* register screen */
#registerScreen {
	height: 450px;
	width: 400px;
	position: absolute;
	top: 120px;
	left: 490px;
	background-color: rgb(245,178,120);
	border-radius: 5px;
	visibility: visible;
}

#registerScreenContent {
	position: relative;
	text-align: center;
	top: 30px;
}

#registerScreenContent input {
	border-top: none;
	border-left: none;
	border-right: none;
	background: none;
	outline: none;
	width: 300px;
	color: white;
	font-size: 18px;
}

#register {
	position: relative;
	left: 60px;
}

#registerScreenContent button {
	height: 30px;
	width: 120px;
	outline: none;
	border: 0;
	border-radius: 3px;
	font-weight: 500;
	position: relative;
	bottom: 0;
}

#regbtn:hover {
	/* color: white; */
	font-weight: 800;
	background-color: yellowgreen;
	cursor: pointer;
}

#registerScreen {
	box-shadow: 0 0 5px black;
}

#address {
	font-size: 18px;
}

.forgetpassword {
	position: absolute;
	top: 200px;
	left: 490px;
	background-color: rgb(221, 187, 125);
	height: 400px;
	width: 400px;
	border-radius: 5px;
	visibility: visible;
	box-shadow: 0 0 5px black;
}

#companyname {
	position: absolute;
	text-align: center;
	left: 100px;
	top: 0px;
}

#companyname img {
	width: 120px;
}
#errorMsg{
position: relative;
left: 60px;
color:red;
top:20px;
}

.loginHere{
position: relative;
left:45px;
top: -60px;
}

.label{
font-weight: 600;
}

h1{
position: absolute;
left:410px;
top:200px;
font-size: 50px;
}

a{
color: black;
text-decoration: none;
}

h3{
position: absolute;
left:600px;
top:280px;
}

a:hover{
text-decoration: underline;
}
</style>
</head>

<body id="body">
	<div id="container">
		<!-- <div class="header">
        </div> -->

		<!-- Navigation Bar -->
		<div class="nav">

			<nav class="list">
				<ul>
					<!-- <li> <a>SignOut</a></li> -->
					<li><a href="Registration.jsp"  id="register">SignUp</a></li>
					<li><a href="Index.jsp"  id="login">Login</a></li>
				</ul>
			</nav>
			
			<div class="logo">
				<img src="Assets/medhublogo.png" alt="logo">

				<div id="companyname">
					<img
						src="https://d1hbpr09pwz0sk.cloudfront.net/logo_url/medhub-f6c08b33"
						alt="logo">
				</div>
			</div>
		</div>
		
		<h1 id="regMsg" >Registered Sucessfully</h1>
		<h3><a href="Index.jsp">Click Here To Login</a></h3>

										<!-- sign/register form -->
										
		
		</div>

		<div class="footer"></div>

	</div>
</body>
</html>