package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.SportsPerson;
import com.nt.repository.ISportsPersonRepo;

@Service("samService")
public class SportsAuthorityMgmtServiceImpl implements ISportsAuthorityMgmtService {

	@Autowired
	private ISportsPersonRepo sportsPersonRepo;

	@Override
	public String registerSportsPerson(SportsPerson sportsPerson) {
		SportsPerson person = sportsPersonRepo.save(sportsPerson);
		return person == null ? "SportsPerson doc not saved" : "SportsPerson doc saved with Id: " + person.getId();
	}

	@Override
	public List<SportsPerson> getSportsPerson() {
		return sportsPersonRepo.findAll();
	}

}
