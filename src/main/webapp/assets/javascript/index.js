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
