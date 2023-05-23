package com.nt.service;

public interface ICoronaVaccineMgmtService {

	// List<ResultView> findByPriceGreaterThanEqualOrderByPrice(double startPrice);
	void searchCoronaVaccinesByPriceStartRangeAndInAscOrder(double startPrice);
}
