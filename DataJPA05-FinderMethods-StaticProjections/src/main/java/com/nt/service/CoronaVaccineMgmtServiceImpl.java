package com.nt.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repo.ICoronaVaccineRepo;
import com.nt.type.ResultView;

@Service("cvmService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public void searchCoronaVaccinesByPriceStartRangeAndInAscOrder(double startPrice) {
		System.out.println(repo.getClass() + " " + Arrays.toString(repo.getClass().getDeclaredMethods()));
		List<ResultView> resultViewList = null;
		// Invoke Repository method.
		resultViewList = repo.findByPriceGreaterThanEqualOrderByPrice(startPrice);
		resultViewList.forEach(resultView -> {
			System.out
					.println(resultView.getClass() + " " + Arrays.toString(resultView.getClass().getDeclaredMethods()));
			System.out.println(resultView.getName() + " " + resultView.getCountry());
//			System.out.println("ResultView : " +resultView);
		});

	}

}// class
