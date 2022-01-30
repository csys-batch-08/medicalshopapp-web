<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel = "icon" type = "" href = "Assets/medhublogo.png">
<script>
    history.forward();
</script>
<title>Registration</title>
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
	background-color: rgb(255,255,255);
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
	color: black;
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

#userExists{
position: relative;
top:20px;
color: red;
}

</style>
</head>

<body id="body">
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<div id="container">
	

		<!-- Navigation Bar -->
		<div class="nav">

			<nav class="list">
				<ul>
					<li><a href="registration.jsp"  id="register">SignUp</a></li>
					<li><a href="index.jsp"  id="login">Login</a></li>
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

										<!-- sign/register form -->
										
		<div id="registerScreen">
			<div id="registerScreenContent">
				<form action="RegisterController" class="registerform" method="post">
					<label for="fullName" class="reglab">FullName*</label><br>
					<br> <input type="text" onkeypress="hideMsg()" name="regfullName" id="fullname"
						placeholder="Enter fullname" required ><br>
						
					<br> <label for="mail" class="reglab">Mail Id</label><br>
					<br> <input type="email" onkeyup="checkMail()" name="regMail"
						id="regMail" placeholder="Enter Mail Id"  pattern="[A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}"  required ><br>
						<label id="existsMsg"></label><br>
					 <label for="phone" class="reglab">Mobile Number*</label><br>
					<br> <input id="mobile" type="text" onkeyup="mobileNum()" name="regMobile" required
						placeholder="Enter Mobile Number" pattern="[6-9][0-9]{9}"
						title="MObile Number Must Have 10 Digits" required min="3" max="10"><br>
						<label id="numberExists"></label>
					<br> <label for="password" class="reglab">Password*</label><br>
					<br> <input type="password" 
						placeholder="Password" name="regPassword" value="" required
						pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%?&]{8,15}$"
						title="Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character"><br>
				<br>
					<br>
					<button id="regbtn" type="submit">Register</button><br>
					<% String notallow=(String)session.getAttribute("notallow");
            if(notallow!=null) {%>
            <h4><%=session.getAttribute("notallow") %></h4>
           
            <%} session.removeAttribute("notallow"); %>
            
            <% String emailError=(String)session.getAttribute("error");
            if(emailError!=null) {%>
            <h4 id="userExists"><%=session.getAttribute("error") %></h4>
           
            <%} session.removeAttribute("error"); %>
            </form>
			</div>
			
		</div>

		<div class="footer"></div>

	</div>

	<script>
function getLoginForm()
{
    document.getElementById("loginform").style.visibility="visible";
    document.getElementById("registerScreen").style.visibility="hidden";
    
}
function getRegisterForm()
{
    document.getElementById("registerScreen").style.visibility="visible";
    document.getElementById("loginform").style.visibility="hidden";
    // document.getElementById("loginform").style.visibility="hidden";
}

function hideMsg()
{
	document.getElementById("userExists").style.visibility="hidden";
	
	}

</script>
<script>
function checkMail() {
	
	let email=document.getElementById("regMail").value;
	console.log(email);
    var url="chechEmail.jsp?email="+email;  
    if(window.XMLHttpRequest){  
    request=new XMLHttpRequest();  
    }  
    else if(window.ActiveXObject){  
    request=new ActiveXObject("Microsoft.XMLHTTP");  
    }  
    try  
    {  
    request.onreadystatechange=getInfo;  
    request.open("GET",url,true);  
    request.send();  
    }  
    catch(e)  
    {  
    alert("Unable to connect to server");  
    }
        
       }
    
    function getInfo(){  
    	if(request.readyState==4){  
    	var response =request.responseText; 
    	//console.log(response);
    	document.getElementById('existsMsg').innerHTML=response;
    	 document.getElementById("existsMsg").style.color = "red";
    	document.getElementById("existsMsg").style.visibility = "visible";
    	//console.log(response);

    	}  
    	
    	}
</script>
<script>
function mobileNum() {
	
	let number=document.getElementById("mobile").value;
	console.log(number);
    var url="checkMobile.jsp?mobile="+number;  
    if(window.XMLHttpRequest){  
    request=new XMLHttpRequest();  
    }  
    else if(window.ActiveXObject){  
    request=new ActiveXObject("Microsoft.XMLHTTP");  
    }  
    try  
    {  
    request.onreadystatechange=getInfoMobile;  
    request.open("GET",url,true);  
    request.send();  
    }  
    catch(e)  
    {  
    alert("Unable to connect to server");  
    }
        
       }
    
 function getInfoMobile(){  
    	if(request.readyState==4){  
    	var response =request.responseText; 
    	//console.log(response);
    	document.getElementById('numberExists').innerHTML=response;
    	 document.getElementById("numberExists").style.color = "red";
    	document.getElementById("numberExists").style.visibility = "visible";
    	//console.log(response);

    	}  
    	
    	}


</script>

</body>
</html>