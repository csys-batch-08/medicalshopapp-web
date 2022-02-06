<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel = "icon" type = "" href = "Assets/Images/medhublogo.png">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="Assets/css/registration.css">

<script>
    history.forward();
</script>
<title>Registration</title>
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
				<img src="Assets/Images/medhublogo.png" alt="logo">

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
				<form action="RegisterController" class="registerform" method="get" >
					<label for="fullName" class="reglab">Full Name <span- class="required">*</span></label><br>
					<br> <input type="text" onkeyup="hideMsg()"  onkeyup="hideUserExists()"  name="regfullName" id="fullname"
						placeholder="Enter fullname" required autofocus><br>
						
					<br> <label for="mail" class="reglab">Mail Id <span class="required">*</span></label><br>
					<br> <input type="email" onkeyup="checkMail()"  onkeyup="hideMsg()" onkeyup="hideUserExists()"  name="regMail"
						id="regMail" placeholder="Enter Mail Id"  pattern="[A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}" required  ><br>
						<label id="existsMsg"></label><br>
					 <label for="phone" class="reglab">Mobile Number <span class="required">*</span></label><br>
					<br> <input id="mobile" type="text" onkeyup="mobileNum()" onkeyup="hideMsg()" onkeyup="hideUserExists()"  name="regMobile" required
						placeholder="Enter Mobile Number" pattern="[6-9][0-9]{9}"
						title="MObile Number Must Have 10 Digits" required min="3" max="10"><br>
						<label id="numberExists"></label>
					<br> <label for="password" class="reglab">Password <span class="required">*</span></label><br>
					<br> <input type="password" id="Password" onkeyup="hideMsg()" onkeyup="hideUserExists()" 
						placeholder="Password" name="regPassword" value="" required
						pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%?&]{8,15}$"
						title="Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character"><br>
					<br>
						<br> <label for="Confirm password" class="reglab">Confirm Password <span class="required">*</span></label><br>
						<input type="password" id="comfirmPassword"  onkeyup="passwordCheck()" 
						placeholder="Password" name="regPassword" value="" required
						pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%?&]{8,15}$"
						title="Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character" ><br>
						<span id="passwordCheck" style="visibility: hidden">Confirm password Not Matches</span>
					<br>
					<button id="regbtn" type="submit">Register</button><br>
					<br>
		
            <c:if test="${notallow!=null}">	
            <h4 id="notAllow">${notallow}</h4>
           	</c:if>
			<c:remove var="notallow" scope="session"/>
         
              <c:if test="${error!=null}">	
            <h4 id="userExists">${error}</h4>
           	</c:if>
			<c:remove var="error" scope="session"/>
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
	document.getElementById("notAllow").style.visibility="hidden";
	
	}

function hideUserExists()
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