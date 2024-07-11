function validate()
{
	var a=name_validate();
	var b=mob_validate();
	var c=email_validate();
	var d=pwd_validate();
	var e=cpwd_validate();
	var f=key_validate();
	if(a & b & c & d & e & f)
	 return false;
	else
	 return true;
}
function clear_name()
{
	document.getElementById("id1").innerHTML="";
}
function clear_mob()
{
	document.getElementById("id2").innerHTML="";
}
function clear_email()
{
	document.getElementById("id3").innerHTML="";
}
function clear_pwd()
{
	document.getElementById("id4").innerHTML="";
}
function clear_cpwd()
{
	document.getElementById("id5").innerHTML="";
}
function clear_key()
{
	document.getElementById("id6").innerHTML="";
}
function name_validate()
{
	var pat1=/^[a-zA-Z]+$/;
	var nam1=document.form1.name.value;
	if(nam1=="")
	{	document.getElementById("id1").innerHTML="Please enter the name";
	    return 1;
    }
	else if(!pat1.test(nam1))
	{
		document.getElementById("id1").innerHTML="Please enter valid name";
        return 1;
	}
	else 
    return 0;	
}
function mob_validate()
{
	var patt2=/^[1-9]{1}[0-9]{9}$/;
	var mob1=document.form1.mob.value;
	if(mob1=="")
	{
		document.getElementById("id2").innerHTML="mob number has to be entered";
		return 1;
	}
	else if(!patt2.test(mob1))
	{
		document.getElementById("id2").innerHTML="enter 10digit mobile number";
		return 1;
	}
	else
		return 0;
}
function email_validate()
{
	var pat3 = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var emailid=document.form1.email.value;
	if(emailid=="")
	{
		document.getElementById("id3").innerHTML="email id has to be entered";
		return 1;
	}	
	else if(!pat3.test(emailid))
	{
		document.getElementById("id3").innerHTML="invalid email id enetered";
		return 1;
	}
	else
		return 0;
}

function pwd_validate()
{
	if(document.form1.pwd.value=="")
	{
		document.getElementById("id4").innerHTML="password has to be entered";
	return 1;
	}
	else if(document.form1.pwd.value.length <8)
	{
		document.getElementById("id4").innerHTML="enter password 8 characters long";
	return 1;
	}
	else
		return 0;
}

function cpwd_validate()
{
	var pwd1=document.form1.pwd.value;
	var pwd2=document.form1.cpwd.value;
	if(pwd2=="")
	{
		document.getElementById("id5").innerHTML="password has to be entered";
		return 1;
	}
	else if(pwd2!=pwd1)
	{
		document.getElementById("id5").innerHTML="password doesnt match!";
		return 1;
	}
	else
		return 0;
	
}
function key_validate()
{
	var key=document.form1.code.value;
	if(key=="")
	{
		document.getElementById("id6").innerHTML="secret key cannot be empty";
		return 1;
	}
	else
		return 0;
}