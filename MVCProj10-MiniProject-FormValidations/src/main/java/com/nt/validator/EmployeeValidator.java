package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
//		return Employee.class == clazz;
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee emp = null;

		// Typecasting.
		emp = (Employee) target;

		// Server side form validation logic.
		// Required rule for name.
		if (emp.getEname() == null || emp.getEname().isBlank())
			errors.rejectValue("ename", "emp.ename.required");
		// Minimum length rule for name.
		else if (emp.getEname().length() < 5)
			errors.rejectValue("ename", "emp.ename.minlength");

		// Required rule for job.
		if (emp.getJob() == null || emp.getJob().isBlank())
			errors.rejectValue("job", "emp.job.required");
		// Minimum length rule for job.
		else if (emp.getJob().length() < 5)
			errors.rejectValue("job", "emp.job.minlength");

		// Required rule for sal.
		if (emp.getSal() == null)
			errors.rejectValue("sal", "emp.sal.required");
		// Numeric rule for sal.
		/*else if (emp.getSal().isNaN())
			errors.rejectValue("sal", "emp.sal.numeric");*/
		// Range rule for sal.
		else if (emp.getSal() < 10000 || emp.getSal() > 1000000)
			errors.rejectValue("sal", "emp.sal.range");

		// Required rule for deptno.
		if (emp.getDeptno() == null)
			errors.rejectValue("deptno", "emp.deptno.required");
		// Numeric rule for deptno.
		/*else if (((Float) emp.getDeptno().floatValue()).isNaN())
			errors.rejectValue("deptno", "emp.deptno.numeric");*/
		// Range rule for deptno.
		else if (emp.getDeptno() < 10 || emp.getDeptno() > 100)
			errors.rejectValue("deptno", "emp.deptno.range");
	}

}// class
