package com.nt.service;

import java.util.List;

import com.nt.document.Citizen;
import com.nt.document.DrivingLicence;

public interface IRTAMgmtService {

	String registerCitizenWithDrivingLicence(Citizen citizen);

	String registerDrivingLicenceWithCitizen(DrivingLicence licence);

	List<Citizen> getCitizen();

	List<DrivingLicence> getDrivingLicence();

}
