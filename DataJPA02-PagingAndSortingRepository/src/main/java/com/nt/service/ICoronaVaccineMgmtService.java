package com.nt.service;

public interface ICoronaVaccineMgmtService {

	// Iterable<T> findAll(Sort sort);
	void searchAllCoronaVaccinesBySortingOrder(boolean asc, String... properties);

	// Page<T> findAll(Pageable pageable);
	void searchAllCoronaVaccinesByPagination(int pageNo, int pageSize, boolean asc, String... properties);

	// Page<T> findAll(Pageable pageable);
	void searchAllCoronaVaccinesByPagination(int pageSize);

	// Page<T> findAll(Pageable pageable);
	void searchAllCoronaVaccinesByGivenPage();

}
