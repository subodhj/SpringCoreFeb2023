package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;
import com.nt.vo.EmployeeVO;

@Controller("ctrl")
public class MainController {

	@Autowired
	private IEmployeeMgmtService empService;

	public List<EmployeeVO> retriveEmpsByDesign(String[] designations) throws Exception {
		List<EmployeeDTO> listDTO = null;

		// use EmployeeMgmtService
		listDTO = empService.getEmpsByDesign(designations);
		List<EmployeeVO> listVO = new ArrayList<>();

		// prepare EmployeeVO and add to List
		listDTO.forEach(empDTO -> {
			EmployeeVO empVO = new EmployeeVO();
			empVO.setSrNo(String.valueOf(empDTO.getSrNo()));
			empVO.setEmpNo(String.valueOf(empDTO.getEmpNo()));
			empVO.setEname(empDTO.getEname());
			empVO.setJob(empDTO.getJob());
			empVO.setSal(String.valueOf(empDTO.getSal()));
			empVO.setDeptNo(String.valueOf(empDTO.getDeptNo()));
			empVO.setMgr(String.valueOf(empDTO.getMgr()));
			listVO.add(empVO);
		});

		return listVO;
	}// retriveEmpsByDesign(-)

}// class
