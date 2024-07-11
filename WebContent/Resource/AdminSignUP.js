function validateSignUP()
{
	var adminName=validateAdminName();
	var password=validatePassword();
	var confirmPassword=validateCPassword();
	var role=validateRole();
	var key=validateKey();
	
	if(adminName && password && confirmPassword && role && key )
	{
		return true;
	}
	else
	{
		return false;
	}
	
}

function validateAdminName()
{   
	    var pattern1=/^[a-zA-Z][a-zA-Z]{2,9}$/;
	    
        var txtname=document.sForm.adminName.value;
        
        if(txtname == "" || txtname == null)
        	{
        	document.getElementById("err1").innerHTML="Username cannot be blank";
        	return false;
        	}
        else if(!pattern1.test(txtname))
        	{
        	document.getElementById("err1").innerHTML="Enter name field correctly";
        	return false;
        	}
        else 
        	return true;


  }

function validatePassword()
{
	var password=document.sForm.password1.value;
	if(password == "" || password == null)
	{
		document.getElementById("err2").innerHTML="Password cannot be left blank";
    	return false;
	}
	else 
    	return true;
}



function validateCPassword()
{
	var checkPassword=document.sForm.password2.value;
	var password=document.sForm.password1.value;
	
	if(checkPassword == "" || checkPassword == null)
	{
		document.getElementById("err3").innerHTML="Password cannot be left blank";
    	return false;
	}
	else if(checkPassword != password )
	{
		document.getElementById("err3").innerHTML="Password does not match";
    	return false;
	}
	else 
    	return true;
}


function validateRole()
{ 
	var inRole=document.sForm.role.value;
	if(inRole="" || inRole== null)
	{
		document.getElementById("err4").innerHTML="Select your role.";
    	return false;
	}
	else 
    	return true;
	
}

function validateKey()
{
	var secretKey=document.sForm.key1.value;
	
	if(secretKey="" || secretKey== null)
	{
		document.getElementById("err5").innerHTML="Secret key should not be left blank ";
    	return false;
	}
	else if(!secretKey.matches("uas2014uas"))
	{
		document.getElementById("err5").innerHTML="Incorrect key.";
    	return false;
	}
	else 
    	return true;
}

function adminNameClear()
{
document.getElementById("err1").innerHTML="";

}

function passwordClear()
{
document.getElementById("err2").innerHTML="";

}

function cPasswordClear()
{
document.getElementById("err3").innerHTML="";

}

function roleClear()
{
document.getElementById("err4").innerHTML="";

}

function keyClear()
{
document.getElementById("err5").innerHTML="";

}







