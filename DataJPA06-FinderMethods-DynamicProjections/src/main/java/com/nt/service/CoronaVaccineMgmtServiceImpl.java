package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repo.ICoronaVaccineRepo;
import com.nt.type.View;

@Service("cvmService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	public <T extends View> List<T> searchCoronaVaccinesByCompanyInDescOrder(String company, Class<T> viewType) {
		// Invoke Repository method.
		return repo.findByCompanyOrderByCompanyDesc(company, viewType);
	}

	@Override
	public <T extends View> List<T> searchCoronaVaccinesByCompanyWithDescOrderOfRegNo(String company,
			Class<T> viewType) {
		// Invoke Repository method.
		return repo.findByCompanyOrderByRegNoDesc(company, viewType);
	}

	@Override
	public <T extends View> List<T> searchCoronaVaccinesByCompanyInPriceDescOrder(String company, Class<T> viewType) {
		// Invoke Repository method.
		return repo.findByCompanyOrderByPriceDesc(company, viewType);
	}

}// class
