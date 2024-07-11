function validateForm()
{
	var name=validateName();
	var father=validateFatherName();
	var gender=validateGender();
	var email=emailValidation();
	var number=validateNumber();
	var address=validateAddress();
	var qualification=validateQualification();
	if(name && father && gender && email && number && address && qualification)
	{
		return true;
	}
	else
		return false;
	
	
}

function validateGender()
{
	var count=0;
document.getElementById("text3").innerHTML="";
for(var i=0;i<document.form1.gender.length;i++)
{
	if(document.form1.gender[i].checked)
		count++;
}
if (count == 0)
	document.getElementById("text2").innerHTML = "Gender should be selected";
	else
		return true;

}



function validateName()
{   
	    var pattern1=/^[a-zA-Z][a-zA-Z]{2,9}$/;
	    
        txtname1=document.form1.name1.value;
        
        if(txtname1 == "" || txtname1 == null)
        	{
        	document.getElementById("text1").innerHTML="Username cannot be blank";
        	return false;
        	}
        else if(!pattern1.test(txtname1))
        	{
        	document.getElementById("text1").innerHTML="Enter name field correctly";
        	return false;
        	}
        else 
        	return true;


  }
function validateQualification()
{
	var collegename1=document.form1.school1.value;
	var collegename2=document.form1.school2.value;
	var percentage1=document.form1.per1.value;
	var percentage2=document.form1.per2.value;
	var year1=document.form1.year1.value;
	var year2=document.form1.year2.value;
	if(collegename1==""||collegename1==null||collegename2==""||collegename2==null||
			percentage1==""||percentage1==null||percentage2==""||percentage2==null||
			year1==""||year1==null||year2==null||year2=="")
	{
		document.getElementById("text8").innerHTML="Enter qualification details";
		return false;
	}
	else
		return true;
}
function dobClear()
	{	
			var count=0;
			document.getElementById("text3").innerHTML="";
			for(var i=0;i<document.form1.gender.length;i++)
			{
				if(document.form1.gender[i].checked)
					count++;
			}
			if (count == 0)
				document.getElementById("text2").innerHTML = "Gender should be selected";
				else
					return (1);
	}
function validateFatherName()
{
		var pattern1=/^[a-zA-Z][a-zA-Z]{2,9}$/;
		txtname1=document.form1.father.value;
		if(txtname1 == "" || txtname1 == null)
			{
			document.getElementById("text4").innerHTML="Name field cannot be blank";
		
			return false;
			}
	
	else if(!pattern1.test(txtname1))
	    {
		document.getElementById("text4").innerHTML="Enter name field correctly";
		return false;
	    }
	else 
		return true;
}


function emailValidation()
	{
		var emailfilter=/^\w+[\+\.\w-]*@([\w-]+\.)*\w+[\w-]*\.([a-z]{2,4}|\d+)$/i;
		var b=emailfilter.test(document.form1.email.value);
		if(b==false)
		{
			document.getElementById("text5").innerHTML="Please Enter a valid Mail ID";
			return false;
		}
}
function validateNumber()
{
	var pattern=/^[7-9][0-9]{9}$/;
	var number=document.form1.phoneNo.value;
	if(number==""||number==null)
	{
		document.getElementById("text6").innerHTML="Mobile no. not entered";
		return false;
	}
	else if(!pattern.test(number))
	{
		document.getElementById("text6").innerHTML="Invalid Mobile number format ";
		return false;
	}
	else
		return true;
	
}
function validateAddress()
{
	var addresslength=document.form1.address.value.length;
	if(addresslength==0)
	{
		document.getElementById("text7").innerHTML="Enter address";
		return false;
	}
	if(addresslength<20)
	{
		document.getElementById("text7").innerHTML="Address too short";
		return false;
	}
	else if(addresslength>40)
	{
		document.getElementById("text7").innerHTML="Address too long";
		return false;
	}
	else
		return true;
}
function validateDob()
	{
	return true;
	}
v

function addressClear()
	{
	document.getElementById("text7").innerHTML="";
	
	}

function numberClear()
	{
	document.getElementById("text6").innerHTML="";
	}

function fathernameClear()
	{
	document.getElementById("text4").innerHTML="";
	
	}
function nameClear()
	{
	document.getElementById("text1").innerHTML="";
	
	}
function radioClear()
	{
	document.getElementById("text2").innerHTML="";
	
	}