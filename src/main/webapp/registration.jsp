<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="" href="assets/images/medhublogo.png">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="assets/css/registration.css">
<style type="text/css">
#passwordCheck {
	visibility: visible;
}
</style>
<script>
    history.forward();
</script>
<title>Registration</title>
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


		<div id="registerScreen">
			<div id="registerScreenContent">
				<form action="registerController" class="registerform" method="post">
					<label for="fullName" class="reglab">Full Name <span>
							class="required">*</span></label><br> <br> <input type="text"
						onkeyup="hideMsg()" onkeyup="hideUserExists()" name="regfullName"
						id="fullname" placeholder="Enter fullname" aria-label="fullname" required autofocus><br>

					<br> <label for="mail" class="reglab">Mail Id <span
						class="required">*</span></label><br> <br> <input type="email"
						onkeyup="checkMail()" onkeyup="hideMsg()"
						onkeyup="hideUserExists()" name="regMail" id="regMail"
						placeholder="Enter Mail Id"
						pattern="[A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}" required><br>
					<label id="existsMsg"></label><br> <label for="phone"
						class="reglab">Mobile Number <span class="required">*</span></label><br>
					<br> <input id="mobile" type="text" onkeyup="mobileNum()"
						onkeyup="hideMsg()" onkeyup="hideUserExists()" name="regMobile"
						required placeholder="Enter Mobile Number" pattern="[6-9][0-9]{9}"
						title="MObile Number Must Have 10 Digits" required min="3"
						max="10"><br> <label id="numberExists"></label> <br>
					<label for="password" class="reglab">Password <span
						class="required">*</span></label><br> <br> <input
						type="password" id="Password" onkeyup="hideMsg()"
						onkeyup="hideUserExists()" placeholder="Password"
						name="regPassword" value="" required
						pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%?&]{8,15}$"
						title="Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character"><br>
					<br> <br> <label for="Confirm password" class="reglab">Confirm
						Password <span class="required">*</span>
					</label><br> <input type="password" id="comfirmPassword"
						onkeyup="validatePassword()" placeholder="Password"
						name="regPassword" value="" required
						pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%?&]{8,15}$"
						title="Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character"><br>
					<p id="passwordCheck"></p>
					<br>
					<button id="regbtn" type="submit">Register</button>
					<br> <br>

					<c:if test="${notallow!=null}">
						<h4 id="notAllow">${notallow}</h4>
					</c:if>
					<c:remove var="notallow" scope="session" />

					<c:if test="${error!=null}">
						<h4 id="userExists">${error}</h4>
					</c:if>
					<c:remove var="error" scope="session" />
				</form>
			</div>

		</div>

		<div class="footer"></div>

	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="assets/javascript/registration.js"></script>
</body>
</html>