function checkMail() {
	
	let email=document.getElementById("regMail").value;
    console.log("called");
    $.ajax({
		type:'POST',
    url:'checkEmail',

data:'email='+email,    
cache:false,
    success:function(response){
       document.getElementById("existsMsg").innerHTML=response;
       document.getElementById("existsMsg").style.color = "red";
       document.getElementById("existsMsg").style.visibility = "visible";
    }
	  	
    }
);
}

function mobileNum() {
	
	let number=document.getElementById("mobile").value;
    console.log("mobcalled");
console.log(number);
    $.ajax({
		type:'POST',
    url:'checkNumber',

data:'number='+number,    
cache:false,
    success:function(response){
       document.getElementById('numberExists').innerHTML=response;
    	document.getElementById("numberExists").style.color = "red";
    	document.getElementById("numberExists").style.visibility = "visible";
    }

    }
);
}