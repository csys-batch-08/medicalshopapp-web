
function checkMail() {

	let email = document.getElementById("regMail").value;
	$.ajax({
		type: 'POST',
		url: 'checkEmail',

		data: 'email=' + email,
		cache: false,
		success: function(response) {
			document.getElementById("existsMsg").innerHTML = response;
			document.getElementById("existsMsg").style.color = "red";
			document.getElementById("existsMsg").style.visibility = "visible";
		}

	}
	);
}

function mobileNum() {

	let number = document.getElementById("mobile").value;
	$.ajax({
		type: 'POST',
		url: 'checkNumber',

		data: 'number=' + number,
		cache: false,
		success: function(response) {
			document.getElementById('numberExists').innerHTML = response;
			document.getElementById("numberExists").style.color = "red";
			document.getElementById("numberExists").style.visibility = "visible";
		}

	}
	);
}


function getLoginForm() {
	document.getElementById("loginform").style.visibility = "visible";
	document.getElementById("registerScreen").style.visibility = "hidden";
}

function getRegisterForm() {
	document.getElementById("registerScreen").style.visibility = "visible";
	document.getElementById("loginform").style.visibility = "hidden";
}

function hideMsg() {
	document.getElementById("notAllow").style.visibility = "hidden";
}

function hideUserExists() {
	document.getElementById("userExists").style.visibility = "hidden";
}

var regbtn = document.getElementById("regbtn");
function validatePassword() {
	console.log("validate");
	let Password = document.getElementById("Password").value;
	let comfirmPassword = document.getElementById("comfirmPassword").value;
	let passwordCheck = document.getElementById("passwordCheck");
	regbtn.disabled = false;
	if (Password == comfirmPassword) {
		passwordCheck.style.display = "none";
	} else {
		
		passwordCheck.style.display = "block";
		passwordCheck.style.display = "none";
		passwordCheck.innerHTML = "Password does not match";
		passwordCheck.style.color = "red";
		passwordCheck.style.fontSize = "17px";
		regbtn.disabled = true;
	}
}	