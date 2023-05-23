package com.nt.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;

@Service("cvmService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo coronaVaccineRepo;

//	Iterable<T> findAll(Sort sort);
	@Override
	public void searchAllCoronaVaccinesBySortingOrder(boolean asc, String... properties) {
		Direction direction = null;
		Sort sort = null;
		Iterable<CoronaVaccine> coronaVaccines = null;

		// Create Sort class object.

		if (asc == true)
			direction = Direction.ASC;
		else
			direction = Direction.DESC;

		sort = Sort.by(direction, properties);

//		sort = Sort.by(asc == true ? Direction.ASC : Direction.DESC, properties);

		// Invoke Repository method.
		coronaVaccines = coronaVaccineRepo.findAll(sort);

		// Display the resultant records.
		if (coronaVaccines != null)
			coronaVaccines.forEach(System.out::println);
	}

//	Page<T> findAll(Pageable pageable);
	@Override
	public void searchAllCoronaVaccinesByPagination(int pageNo, int pageSize, boolean asc, String... properties) {
		Pageable pageable = null;
		Page<CoronaVaccine> page = null;

		// Create PageRequest class object.
		pageable = PageRequest.of(pageNo, pageSize, asc == true ? Direction.ASC : Direction.DESC, properties);

		// Invoke Repository method.
		page = coronaVaccineRepo.findAll(pageable);

		// Display the resultant page having records.
		page.forEach(System.out::println);
	}

//	Page<T> findAll(Pageable pageable);
	@Override
	public void searchAllCoronaVaccinesByPagination(int pageSize) {
		long pagesCount = 0;
		long recordsCount = 0;
		Pageable pageable = null;
		Page<CoronaVaccine> page = null;
		List<CoronaVaccine> list = null;

		// Get the count of all the records available in DB s/w.
		recordsCount = coronaVaccineRepo.count();

		// Calculate pages count.
		pagesCount = recordsCount / pageSize;

		// Increment pagesCount by 1 incase of not exactly divisible.
		pagesCount = recordsCount % pageSize == 0 ? pagesCount : ++pagesCount;

		// Display pages one after another in a loop.
		for (int i = 0; i < pagesCount; ++i) {

			// Create Pageable object.
			pageable = PageRequest.of(i, pageSize);
//			pageable = PageRequest.of(i, pageSize, Direction.ASC, "price");

			// Invoke Repository method.
			page = coronaVaccineRepo.findAll(pageable);
//			list = page.getContent();

			// Display the page.
			page.forEach(System.out::println);
//			list.forEach(System.out::println);

			System.out.println(
					"----------- " + (page.getNumber() + 1) + " of " + (page.getTotalPages()) + " -----------");
		} // for

	}//searchAllCoronaVaccinesByPagination(-) 

	// Page<T> findAll(Pageable pageable);
	@Override
	public void searchAllCoronaVaccinesByGivenPage() {
		Scanner scan = null;
		int pageNo = 0;
//		int modifiedPageNo = 0;
		// Fixed the page size to 5.
		int pageSize = 5;

		// Create Scanner object
		scan = new Scanner(System.in);
		/*System.out.println("Records displayed 5 per page from 1 to " + getPagesCount(pageSize)
				+ " pages.\n Enter the page number:");*/
		System.out.println("Records displayed 5 per page from 1 to 4 pages.\nEnter the page number: ");
		pageNo = scan.nextInt();

		// Decrease the given page number as implicit pagination starts with 0.
//		modifiedPageNo = pageNo - 1;

		// Display the content of the given page number using a switch statement.
		switch (pageNo) {
		case 1: {
			displayPageContent(pageNo-1, pageSize);
			break;
		}
		case 2: {
			displayPageContent(pageNo-1, pageSize);
			break;
		}
		case 3: {
			displayPageContent(pageNo-1, pageSize);
			break;
		}
		case 4: {
			displayPageContent(pageNo-1, pageSize);
			break;
		}
		case 5: {
			displayPageContent(pageNo, pageSize);
			break;
		}
		default:
			throw new IllegalArgumentException("PageNo: " + pageNo + " doesn't exist.");
		}

	}// searchAllCoronaVaccinesByGivenPage()

	private int pageSize(int size) {
//		return size;
		return 5;
	}

	private long getPagesCount(int pageSize) {
		long pagesCount = 0;
		long recordsCount = 0;

		// Get the count of all the records available in DB s/w.
		recordsCount = coronaVaccineRepo.count();

		// Calculate pages count.
		pagesCount = (recordsCount / pageSize);

		// Increment pagesCount by 1 in case of not exactly divisible.
		pagesCount = (recordsCount % pageSize == 0) ? pagesCount : ++pagesCount;

		return pagesCount;
	}

	private void displayPageContent(int pageNo, int pageSize) {
		Pageable pageable = null;
		Page<CoronaVaccine> page = null;
		List<CoronaVaccine> list = null;

		// Create Pageable object.
		pageable = PageRequest.of(pageNo, pageSize);
//			pageable = PageRequest.of(i, pageSize, Direction.ASC, "price");

		// Invoke Repository method.
		page = coronaVaccineRepo.findAll(pageable);
//			list = page.getContent();

		// Display the page.
		page.forEach(System.out::println);
//			list.forEach(System.out::println);

		System.out.println("----------- " + (page.getNumber() + 1) + " of " + (page.getTotalPages()) + " -----------");

	}
	
}// class
