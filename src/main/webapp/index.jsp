<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="" href="assets/images/medhublogo.png">
<link rel="stylesheet" href="assets/css/index.css">
<title>Home</title>
<script>
    history.forward();
</script>
</head>

<body id="body">

	
	<div id="container">

		<div class="nav">

			<nav class="list">
				<ul>

					<li><a href="registration.jsp" id="register">SignUp</a></li>
					<li><a href="index.jsp" id="login">Login</a></li>
				</ul>
			</nav>
			<div class="logo">
				<img src="assets/images/medhublogo.png" alt="logo">

				<div id="companyname">
					<img
						src="https://d1hbpr09pwz0sk.cloudfront.net/logo_url/medhub-f6c08b33"
						alt="logo">
				</div>
			</div>
		</div>
		
		<div class="loginscreen" id="loginform">
			<c:if test="${InvalidUser!=null}">
				<h3 id="errorMsg">${InvalidUser}</h3>
			</c:if>
			<c:remove var="InvalidUser" scope="session" />


			<form action="LoginController" class="formcontent" method="post">
				<h1 class="loginHere">Login Here</h1>
				<label class="label" for="fullName">Email*</label><br> <input
					type="email" name="loginMail" id="mail" required
					placeholder="Enter Email" autofocus 
					pattern="[A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}"
					onkeyup="hideMsg()" ><br> <br> <br>
				<label class="label" for="password">Password *</label><br> <input
					type="password" name="loginPassword" id="password"
					placeholder="Password" value="" required
					pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%?&]{8,15}$"
					title="Minimum 8 and maximum 15 characters Allowed, at least one uppercase letter, one lowercase letter, one number and one special character"
					onmouseover="hideMsg()"><br> <br>
				<button type="submit" id="loginbtn">Login</button>
				<br> <br> <br> <a href="registration.jsp"
					id="register">Not Registered Yet ?</a>
			</form>
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
}
 function hideMsg()
{
	document.getElementById("errorMsg").style.visibility="hidden";
	
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


</body>
</html>