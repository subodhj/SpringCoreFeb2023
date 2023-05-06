package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {

	List<EmployeeDTO> getEmpsByDesign(String[] designations) throws Exception;

}
