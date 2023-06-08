package com.nt.service;

import java.util.List;

import com.nt.document.SportsPerson;

public interface ISportsAuthorityMgmtService {

	String registerSportsPerson(SportsPerson sportsPerson);

	List<SportsPerson> getSportsPerson();

}
