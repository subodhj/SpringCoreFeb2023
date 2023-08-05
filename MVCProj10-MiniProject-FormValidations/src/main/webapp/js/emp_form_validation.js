function validate(frm) {
		
	alert("From JavaScript : Client side form validations");

	// Empty form validation error messages.
	document.getElementById("enameErr").innerHTML = "";
	document.getElementById("jobErr").innerHTML = "";
	document.getElementById("salErr").innerHTML = "";
	document.getElementById("deptnoErr").innerHTML = "";

	// Read form data.
	let name = frm.ename.value;
	let desg = frm.job.value;
	let salary = frm.sal.value;
	let dept = frm.deptno.value;
	let isValidated = true;

	// Client side form validation logic.

	// Required rule for ename.
	if (name == "") {
		document.getElementById("enameErr").innerHTML = "Name is required. (cs)";
		isValidated = false;
	}
	// Character rule for ename.
	else if (!isNaN(name)) {
		document.getElementById("enameErr").innerHTML = "Name must not be numeric. (cs)";
		isValidated = false;
	}
	// Minimum length rule for ename.
	else if (name.length < 5) {
		document.getElementById("enameErr").innerHTML = "Name must have min 5 characters. (cs)";
		isValidated = false;
	}

	// Required rule for job.
	if (desg == "") {
		document.getElementById("jobErr").innerHTML = "Designation is required. (cs)";
		isValidated = false;
	}
	// Character rule for job.
	else if (!isNaN(desg)) {
		document.getElementById("jobErr").innerHTML = "Designation must not be numeric. (cs)";
		isValidated = false;
	}
	// Minimum length rule for job.
	else if (desg.length < 5) {
		document.getElementById("jobErr").innerHTML = "Designation must have min 5 characters. (cs)";
		isValidated = false;
	}

	// Required rule for salary.
	if (salary == "") {
		document.getElementById("salErr").innerHTML = "Salary is required. (cs)";
		isValidated = false;
	}
	// Numeric rule for salary.
	else if (isNaN(salary)) {
		document.getElementById("salErr").innerHTML = "Salary must be numeric value. (cs)";
		isValidated = false;
	}
	// Range rule for salary.
	else if (salary < 10000 || salary > 1000000) {
		document.getElementById("salErr").innerHTML = "Salary must be in the range of 10000 to 1000000";
		isValidated = false;
	}

	// Required rule for deptno.
	if (dept == "") {
		document.getElementById("deptnoErr").innerHTML = "Department No. is required. (cs)";
		isValidated = false;
	}
	// Numeric rule for deptno.
	else if (isNaN(dept)) {
		document.getElementById("deptnoErr").innerHTML = "Department No. must be numeric value. (cs)";
		isValidated = false;
	}
	// Range rule for deptno.
	else if (dept < 10 || dept > 100) {
		document.getElementById("deptnoErr").innerHTML = "Department No. must be in the range of 10 to 100. (cs)";
		isValidated = false;
	}

	// frm.vflag.value = "yes";
	frm.isVerified.value = true;

	return isValidated;
} // validate(-)