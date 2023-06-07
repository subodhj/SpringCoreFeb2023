package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Citizen;
import com.nt.document.DrivingLicence;
import com.nt.repository.CitizenRepo;
import com.nt.repository.DrivingLicenceRepo;

@Service("rtaService")
public class RTAMgmtServiceImpl implements IRTAMgmtService {

	@Autowired
	private CitizenRepo citizenRepo;

	@Autowired
	private DrivingLicenceRepo licenceRepo;

	@Override
	public String registerCitizenWithDrivingLicence(Citizen citizen) {
		return "Citizen registered with Id: " + citizenRepo.save(citizen).getCid();
	}

	@Override
	public String registerDrivingLicenceWithCitizen(DrivingLicence licence) {
		return "DrivingLicence registered with Id: " + licenceRepo.save(licence).getLid();
	}

	@Override
	public List<Citizen> getCitizen() {
		return citizenRepo.findAll();
	}

	@Override
	public List<DrivingLicence> getDrivingLicence() {
		return licenceRepo.findAll();
	}

}
