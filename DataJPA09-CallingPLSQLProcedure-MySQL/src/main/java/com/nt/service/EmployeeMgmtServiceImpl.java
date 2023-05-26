package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("emService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private EntityManager entityManager;

	/*USE `ntspbms714db`;
	DROP procedure IF EXISTS `GET_EMPDETAILS_BY_DESIGS`;
	
	DELIMITER $$
	USE `ntspbms714db`$$
	CREATE PROCEDURE `GET_EMPDETAILS_BY_DESIGS` (IN DESIG1 varchar(10), IN DESIG2 varchar(10))
	BEGIN
	  SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGR FROM EMP WHERE JOB IN (DESIG1,DESIG2) ORDER BY JOB;
	END$$
	
	DELIMITER ;*/

	@Override
	public List<Employee> searchEmpsByDesigs(String desig1, String desig2) {
		StoredProcedureQuery query = null;
		List<Employee> empsList = null;

		// Create StoredProcedureQuery object.
		query = entityManager.createStoredProcedureQuery("GET_EMPDETAILS_BY_DESIGS", Employee.class);

		// Register in params.
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

		// Set values to params.
		query.setParameter(1, desig1);
		query.setParameter(2, desig2);

		// Call PL/SQL Procedure.
		empsList = query.getResultList();

		return empsList;
	}

}// class
