function main()
{
	var var1= validateProgramId();
	var var2= validateProgramName();
	var var3= validateLocation();
	var var4= validateSession();
	
	if(var1==0 || var2==0 || var3 == 0 || var4==0)
		return 0;
	else
		return 1;
}

function clear1()
{
	document.getElementById("programIdError").innerHTML="";
	
}

function clear2()
{
	document.getElementById("programNameError").innerHTML="";
	
}

function clear3()
{
	document.getElementById("locationError").innerHTML="";
}

function clear6()
{
	document.getElementById("sessionsPerWeekError").innerHTML="";
}

function validateProgramId()
{
	var exp=/^[A-Z]{1,3}[0-9]{2}$/;
	var programID= document.adminCourse.programId.value;
	
	if(adminCourse.programId.value=="")
	{
		document.getElementById("programIdError").innerHTML="Enter Program ID";
		return 1;
	}
	else if(!adminCourse.programId.value.match(exp))
	{
		document.getElementById("programIdError").innerHTML="Please enter appropriate Program ID.";
		return 1;
	}
	else
		return 0;	
}

function validateProgramName()
{
	var exp=/^[A-Za-z]{10,30}/;
	var programName= document.adminCourse.programName.value;
	
	if(adminCourse.programName.value=="")
	{
		document.getElementById("programNameError").innerHTML="Enter Program Name";
		return 1;
	}
	else if(!adminCourse.programName.value.match(exp))
	{
		document.getElementById("programNameError").innerHTML="Please enter Program Name max 30 characters.";
		return 1;
	}
	else
		return 0;	
}

function validateLocation()
{
	var exp=/^[A-Za-z]{3,15}$/;
	var location= document.adminCourse.location.value;
	
	if(adminCourse.location.value=="")
	{
		document.getElementById("locationError").innerHTML="Enter location";
		return 1;
	}
	else if(!adminCourse.location.value.match(exp))
	{
		document.getElementById("locationError").innerHTML="Please enter location max 15 characters.";
		return 1;
	}
	else
		return 0;	
}

function validateSession()
{
	var exp=/^[1-7]$/;
	var location= document.adminCourse.session.value;
	
	if(adminCourse.session.value=="")
	{
		document.getElementById("sessionsPerWeekError").innerHTML="Enter sessions per week";
		return 1;
	}
	else if(!adminCourse.session.value.match(exp))
	{
		document.getElementById("sessionsPerWeekError").innerHTML="Enter appropriate sessions per week max 7 sessions";
		return 1;
	}
	else
		return 0;	
}
