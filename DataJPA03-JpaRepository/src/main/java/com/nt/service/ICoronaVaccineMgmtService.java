package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	// <S extends T> List<S> findAll(Example<S> example, Sort sort);
	void searchAllCoronaVaccinesByData(CoronaVaccine coronaVaccine, boolean ascOrder, String... properties);

	// T getReferenceById(ID id);
	void getCoronaVaccineById(long regNo);

	// void deleteAllByIdInBatch(Iterable<ID> ids);
	void removeAllCoronaVaccinesById(Iterable<Long> regNos);

}
