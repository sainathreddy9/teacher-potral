function validateForm()
{
	var name=validateName();
	var marks1=validateMarks();
	var email=emailValidation();

	var address=validateAddress();
	var qualification=validateQualification();
	if(name &&  email && address && qualification && marks1)
	{
		return true;
	}
	else
		return false;
	
	
}



function validateProgram()
{
	var programName=document.form1.program.value;
	if(document.form1.program.value.length=="-----------Select One-----------")
	{
		document.getElementById("text10").innerHTML="Program must be selected"; 
		return false;
	}
	else
		return true;
}
function validateName()
{   
	    var pattern1=/^[a-zA-Z][a-zA-Z]{2,9}$/;
	    
        var txtname1=document.form1.name1.value;
        
        if(txtname1 == "" || txtname1 == null)
        	{
        	document.getElementById("text1").innerHTML="ApplicantName cannot be blank";
        	return false;
        	}
        else if(!pattern1.test(txtname1))
        	{
        	document.getElementById("text1").innerHTML="Enter name in the format [Firstname Lastname] less than 20 characters";
        	return false;
        	}
        else 
        	return true;


  }

function dobClear()
	{	
			
			document.getElementById("text3").innerHTML="";			
	}

function emailValidation()
	{
		var emailfilter=/^\w+[\+\.\w-]*@([\w-]+\.)*\w+[\w-]*\.([a-z]{2,4}|\d+)$/i;
		var b=emailfilter.test(document.form1.email.value);
		if(b==false)
		{
			document.getElementById("text5").innerHTML="Enter a valid Mail ID";
			return false;
		}
}

function validateAddress()
{
	var addresslength=document.form1.Goals.value.length;
	if(addresslength==0)
	{
		document.getElementById("text7").innerHTML="Enter goals";
		return false;
	}
	
	else if(addresslength>20)
	{
		document.getElementById("text7").innerHTML="goals too long";
		return false;
	}
	else
		return true;
}
function validateDob()
	{
	return true;
	}




function validateQualification()
{
	var length=document.form1.qualification.value.length;
	if(document.form1.qualification.value.length=="-----------Select One-----------")
	{
		document.getElementById("text6").innerHTML="Qualification must be selected"; 
		return false;
	}
	else
		return true;
}


function addressClear()
	{
	document.getElementById("text7").innerHTML="";
	
	}

function emailClear()
{
	document.getElementById("text5").innerHTML="";
	
}




function nameClear()
	{
	document.getElementById("text1").innerHTML="";
	
	}
function qualificationClear()
	{
	document.getElementById("text6").innerHTML="";
	
	}



function qualificationClear()
{
document.getElementById("text6").innerHTML="";

}



function validateMarks()
{
	var mark=document.form1.marks.value;
	if(mark<0 || mark>100)
	{
		return false;
	}
	else
		return true;
}


function marksClear()
	{
	document.getElementById("text8").innerHTML="";
	
	}





