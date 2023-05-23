package com.nt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;

@Service("cvmService")
@Transactional
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	// <S extends T> List<S> findAll(Example<S> example, Sort sort);
	@Override
	public void searchAllCoronaVaccinesByData(CoronaVaccine coronaVaccine, boolean ascOrder, String... properties) {
		Example example = null;
		Sort sort = null;
		List<CoronaVaccine> coronaVaccines = null;

		// Create Example object.
		example = Example.of(coronaVaccine);

		// Create Sort object.
		sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC, properties);

		// Invoke JpaRepository method.
		coronaVaccines = repo.findAll(example, sort);

		// Display the resultant corona vaccine records.
		if (!coronaVaccines.isEmpty())
			coronaVaccines.forEach(System.out::println);
		else
			System.out.println("No record found.");
	}

	@Override
	public void getCoronaVaccineById(long regNo) { // T getReferenceById(ID id);
		CoronaVaccine coronaVaccine = null;

//		try {
		// Invoke JpaRepository method.
		coronaVaccine = repo.getReferenceById(regNo);
		System.out.println(coronaVaccine);

	} /*catch (EntityNotFoundException enfe) {
		System.out.println("Record not found with RegNo:" + regNo);
		
		}*/ // catch (LazyInitializationException lie) {
//			System.out.println("Record not found with RegNo:" + regNo);
//		}

	// void deleteAllByIdInBatch(Iterable<ID> ids);
	@Override
	public void removeAllCoronaVaccinesById(Iterable<Long> regNos) {
		List<CoronaVaccine> availableCoronaVaccines = null;
		int availableCoronaVaccinesCount = 0;
		int givenIDsCount = 0;

		// Invoke Repository method to find the availability of entities based on the
		// given IDs collection.
		availableCoronaVaccines = repo.findAllById(regNos);

		// Find the number of available entities.
		if (availableCoronaVaccines != null && !availableCoronaVaccines.isEmpty())
			availableCoronaVaccinesCount = availableCoronaVaccines.size();

		// Find the count of given IDs.
		if (regNos != null && !((List) regNos).isEmpty())
			givenIDsCount = ((List) regNos).size();

		// Invoke Repository method.
		if (givenIDsCount == availableCoronaVaccinesCount) {
			repo.deleteAllByIdInBatch(regNos);
			System.out.println(givenIDsCount + " Corona Vaccines deleted.");
		} else {
			// Create an empty List collection with initial capacity equal to the available
			// no. of entities.
			List<Long> availableCoronaVaccinesIDs = new ArrayList<>(availableCoronaVaccinesCount);

			// Add the IDs of available entities to the List collection.
			availableCoronaVaccines.forEach(cv -> availableCoronaVaccinesIDs.add(cv.getRegNo()));

			// Create List collection with initial size equal to given IDs count.
			List<Long> givenIDs = new ArrayList<>(givenIDsCount);
			givenIDs.addAll(0, (Collection) regNos);

			// Remove those elements from the List collection having given IDs that are also
			// there in the List collection having available entities' IDs.
			givenIDs.removeAll(availableCoronaVaccinesIDs);

			// Print the failure message having the ID value of the non-available entity.
			System.out.println("Corona Vaccines not deleted as " + (givenIDs.toString()) + " were not available.");
		} // else
	}

}// class
