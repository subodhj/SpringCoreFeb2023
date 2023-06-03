package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repo.IPersonRepo;

@Service("pmService")
public class PersonMgmtServiceImpl implements IPersonMgmtService {

	@Autowired
	private IPersonRepo personRepo;

	@Override
	public List<Object[]> fetchPhoneDataUsingJoins() {
		return personRepo.getPersonInfoUsingJoins();
	}

}
