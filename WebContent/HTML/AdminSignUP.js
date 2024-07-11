
function validateSignUP() {
	var teacherId = validateTeacherId();
	var password = validatePassword();
	var confirmPassword = validateCPassword();
	
	if (teacherId && password && confirmPassword) {
		return true;
	} else {
		return false;
	}

}

function validateTeacherId() {
	var pattern1 = /^[a-zA-Z][a-zA-Z]{2,15}$/;

	var txtname = document.sForm.adminName.value;
	
	if (txtname == "" || txtname == null) {
		document.getElementById("errtid").innerHTML = "TeacherId cannot be blank";
		return false;
	} else if (!pattern1.test(txtname)) {
		document.getElementById("errtid").innerHTML = "Enter teacher id field correctly";
		return false;
	} else
		return true;

}

function validatePassword() {
	var password = document.sForm.password.value;
	if (password == "" || password == null) {
		document.getElementById("errpwd").innerHTML = "Password cannot be left blank";
		return false;
	} else
		return true;
}

function validateCPassword() {
	var checkPassword = document.sForm.confirmPassword.value;
	var password = document.sForm.password.value;

	if (checkPassword == "" || checkPassword == null) {
		document.getElementById("errpwd").innerHTML = "Password cannot be left blank";
		return false;
	} else if (checkPassword != password) {
		document.getElementById("errcpwd").innerHTML = "Password does not match";
		return false;
	} else
		return true;
}

function teacherIdClear() {
	document.getElementById("teacherId").innerHTML = "";
}

function passwordClear() {
	document.getElementById("err2").innerHTML = "";
}

function cPasswordClear() {
	document.getElementById("err3").innerHTML = "";
}
