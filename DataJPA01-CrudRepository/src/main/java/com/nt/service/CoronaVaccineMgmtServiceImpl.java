package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;

@Service("cvmService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo coronaVaccineRepo;

	@Override
	public String registerCoronaVaccine(CoronaVaccine coronaVaccine) {
		System.out.println("InMemory Proxy Class : " + coronaVaccineRepo.getClass());
		CoronaVaccine savedCoronaVaccine = null;
		if (coronaVaccine != null)
			savedCoronaVaccine = coronaVaccineRepo.save(coronaVaccine);
		return savedCoronaVaccine != null
				? "Vaccine registered successfully with Registration No: " + savedCoronaVaccine.getRegNo()
				: "Vaccine registration failed.";
	}

}// class
