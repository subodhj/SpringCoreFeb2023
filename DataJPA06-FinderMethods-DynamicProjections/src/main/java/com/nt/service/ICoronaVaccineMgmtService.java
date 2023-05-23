package com.nt.service;

import java.util.List;

import com.nt.type.View;

public interface ICoronaVaccineMgmtService {

	/* <T extends View> List<T> findByCompanyOrderByCompanyDesc(String company, Class<T> viewType); */
	<T extends View> List<T> searchCoronaVaccinesByCompanyInDescOrder(String company, Class<T> viewType);

	/* <T extends View> List<T> findByCompanyOrderByRegNoDesc(String company, Class<T> viewType); */
	<T extends View> List<T> searchCoronaVaccinesByCompanyWithDescOrderOfRegNo(String company, Class<T> viewType);

	/* <T extends View> List<T> findByCompanyOrderByPriceDesc(String company, Class<T> viewType); */
	<T extends View> List<T> searchCoronaVaccinesByCompanyInPriceDescOrder(String company, Class<T> viewType);
}
