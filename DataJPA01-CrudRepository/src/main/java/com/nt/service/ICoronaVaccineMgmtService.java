package com.nt.service;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	String registerCoronaVaccine(CoronaVaccine coronaVaccine); // <S extends T> S save(S entity);

	// <S extends T> Iterable<S> saveAll(Iterable<S> entities);
	void registerCoronaVaccinesInBatch(Iterable<CoronaVaccine> coronaVaccines);

	String getCoronaVaccinesCount(); // long count();

	String checkCoronaVaccineAvailability(Long regNo); // boolean existsById(ID id);

	void searchAllCoronaVaccines(); // Iterable<T> findAll();

	void searchAllCoronaVaccinesById(Iterable<Long> ids); // Iterable<T> findAllById(Iterable<ID> ids);

	void searchCoronaVaccineById(Long id); // Optional<T> findById(ID id);

	void deleteCoronaVaccineById(Long id); // void deleteById(ID id);

	String removeCoronaVaccineById(Long id); // void deleteById(ID id);

	String removeCoronaVaccineByEntity(CoronaVaccine coronaVaccine); // void delete(T entity);

	String removeAllCoronaVaccinesById(Iterable<Long> ids); // void deleteAllById(Iterable<? extends ID> ids);

	String removeAllCoronaVaccines(Iterable<CoronaVaccine> entities); // void deleteAll(Iterable<? extends T> entities);

	String removeAllCoronaVaccines(); // void deleteAll();
}
