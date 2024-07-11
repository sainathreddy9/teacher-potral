function validateStudentDetails() {
	var bool = true;

	bool = validateUsn() && bool;
	bool = validateFullName() && bool;
	bool = emailValidation() && bool;

	return bool;
}

function validateUsn() {
	var usn = document.studentForm.usn.value;
	if (usn == "") {
		document.getElementById("errUsn").innerHTML = "USN can't be empty";
		return false;
	} else {
		return true;
	}
}

function validateFullName() {
	var pattern1 = /^[a-zA-Z]{4,20} [a-zA-Z]{4,20}$/;

	var fullName = document.studentForm.fullName.value;

	if (fullName == "" || fullName == null) {
		document.getElementById("errFullName").innerHTML = "Student name cannot be blank";
		return false;
	} else {
		return true;
	}
}

function fullNameClear() {
	document.getElementById("fullName").innerHTML = "";
}

function emailValidation() {
	var emailfilter = /^\w+[\+\.\w-]*@([\w-]+\.)*\w+[\w-]*\.([a-z]{2,4}|\d+)$/i;
	var b = emailfilter.test(document.studentForm.emailId.value);
	if (b == false) {
		document.getElementById("errEmail").innerHTML = "Enter a valid Mail ID";
		return false;
	} else {
		return true;
	}
}

function emailClear() {
	document.getElementById("emailId").innerHTML = "";
}

function validateDob() {
	return true;
}
