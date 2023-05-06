package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO empDAO;

	@Override
	public List<EmployeeDTO> getEmpsByDesign(String[] designations) throws Exception {
		StringBuilder builder = null;
		String condition = null;
		List<EmployeeBO> listBO = null;

		// create condition for query in EmployeeDAO
		builder = new StringBuilder("(");
		for (int i = 0; i < designations.length; ++i) {
			if (i == designations.length - 1) {
				builder.append("'"+designations[i] + "')");
			} else {
				builder.append("'"+designations[i] + "',");
			}
		} // for
		condition = builder.toString();

		// use EmployeeDAO
		listBO = empDAO.fetchEmpsByDesign(condition);
		List<EmployeeDTO> listDTO = new ArrayList<>();

		// prepare EmployeeDTO and add to List
		listBO.forEach(empBO -> {
			EmployeeDTO empDTO = new EmployeeDTO();
			BeanUtils.copyProperties(empBO, empDTO);
			empDTO.setSrNo(listDTO.size()+1);
			listDTO.add(empDTO);
		});

		return listDTO;
	}// getEmpsByDesign(-)

}// class
