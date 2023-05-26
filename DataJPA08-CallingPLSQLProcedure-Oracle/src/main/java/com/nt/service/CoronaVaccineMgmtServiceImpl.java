package com.nt.service;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Service("cvmService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;
	@Autowired
	private EntityManager entityManager;

	/*create or replace PROCEDURE P_GET_VACCINES_BY_PRICERANGE	(
	  STARTPRICE IN FLOAT, 
	  ENDPRICE IN FLOAT,
	  DETAILS OUT SYS_REFCURSOR 
	) AS 
	
	BEGIN
	  OPEN DETAILS FOR
	    SELECT REG_NO,NAME,COMPANY,COUNTRY,PRICE,DOSES
	      FROM CORONA_VACCINE WHERE PRICE>=STARTPRICE AND PRICE<=ENDPRICE;
	      
	END P_GET_VACCINES_BY_PRICERANGE;*/

	@Override
	public List<CoronaVaccine> getCoronaVaccinesByPriceRange(double minPrice, double maxPrice) {
		StoredProcedureQuery query = null;
		List<CoronaVaccine> list = null;

		// Create StoredProcedureQuery object representing the given PL/SQL Procedure.
		query = entityManager.createStoredProcedureQuery("P_GET_VACCINES_BY_PRICERANGE", CoronaVaccine.class);
//		query = entityManager.createStoredProcedureQuery("P_GET_VACCINES_BY_PRICERANGE");

		// Create StoredProcedureQuery object representing the given PL/SQL Procedure.
//		query = entityManager.createNamedStoredProcedureQuery("CoronaVaccine.getVaccinesByPriceRange");

		// Register PL/SQL Procedure params.
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, List.class, ParameterMode.REF_CURSOR);

		// Set values to parameters.
		query.setParameter(1, minPrice);
		query.setParameter(2, maxPrice);

		// Call PL/SQL Procedure.
		list = query.getResultList();

		return list;
	}

	@Override
	@Transactional
	public List<CoronaVaccine> fetchCoronaVaccinesByPriceRange(double priceMin, double priceMax) {
		return repo.searchCoronaVaccinesByPriceRange(priceMin, priceMax);
	}

	/*CREATE OR REPLACE PROCEDURE P_AUTHENTICATION 
	(
	  UNAME IN VARCHAR2 
	, PWD IN VARCHAR2 
	, RESULT OUT VARCHAR2 
	) AS 
	CNT NUMBER(5);
	BEGIN
	
	   SELECT COUNT(*) INTO CNT FROM USERSLIST WHERE USERNAME=UNAME AND PASSWORD=PWD;
	   IF (CNT<>0) THEN 
	     RESULT := 'VALID CREDENTIALS';
	   ELSE
	     RESULT := 'INVALID CREDENTIALS';
	   END IF;
	  
	END P_AUTHENTICATION;*/

	@Override
	public String authenticate(String uname, String pwd) {
		StoredProcedureQuery query = null;
		String result = null;

		// Create StoredProcedureQuery object representing PL/SQL Procedure.
		query = entityManager.createStoredProcedureQuery("P_AUTHENTICATION");

		// Register in & out params of PL/SQL Procedure.
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);

		// Set values to in params.
		query.setParameter(1, uname);
		query.setParameter(2, pwd);

		// Call PL/SQL Procedure.
		query.execute();

		// Gather result from output param.
		result = (String) query.getOutputParameterValue(3);

		return result;
	}

	/*CREATE OR REPLACE FUNCTION FX_GET_EMP_DETAILS 
	(
	  ENO IN NUMBER 
	, NAME OUT VARCHAR2 
	, DESIGN OUT VARCHAR2 
	, SALARY OUT NUMBER 
	) RETURN NUMBER 
	AS
	   DNO NUMBER(3);
	BEGIN
	
	  SELECT ENAME,JOB,SAL,DEPTNO INTO NAME,DESIGN,SALARY,DNO FROM EMP WHERE EMPNO=ENO; 
	  RETURN DNO;
	  
	END FX_GET_EMP_DETAILS;*/

	@Override
	public Object[] getEmpDetailsByEno(int eno) {
		Session ses = null;
		Object[] empDetails = null;

		// Get SessionObject from EntityManager.
		ses = entityManager.unwrap(Session.class);

		// Get employee details.
		empDetails = ses.doReturningWork(con -> {

			CallableStatement cs = null;
			Object[] results = null;

			// Get CallableStatement object from Connection object
			cs = con.prepareCall("{?=call fx_get_emp_details(?,?,?,?)}");

			// Register return & out params of PL/SQL Function.
			cs.registerOutParameter(1, Types.INTEGER); // return param (?1) dno
			cs.registerOutParameter(3, Types.VARCHAR); // out param (?3) name
			cs.registerOutParameter(4, Types.VARCHAR); // out param (?4) design
			cs.registerOutParameter(5, Types.INTEGER); // out param (?5) salary

			// Set value to in param.
			cs.setInt(2, eno);

			// Call PL/SQL Function.
			cs.execute();

			// Create Object array of length 4.
			results = new Object[4];

			// Gather results from return & out params and store in obj array .
			results[0] = cs.getInt(1);
			results[1] = cs.getString(3);
			results[2] = cs.getString(4);
			results[3] = cs.getFloat(5);

			return results;

		}); // ses.doReturningWork(-)

		return empDetails;

	}// getEmpDetailsByEno(-)

}// class
