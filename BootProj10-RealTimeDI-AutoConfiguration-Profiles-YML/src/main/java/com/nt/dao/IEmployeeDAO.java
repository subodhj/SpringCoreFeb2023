package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface IEmployeeDAO {
	
	List<EmployeeBO> fetchEmpsByDesign(String condition) throws Exception;
	
	

}
