package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CoronaVaccine;
import com.nt.type.ResultView;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

	/* SELECT NAME, COUNTRY FROM CORONA_VACCINE WHERE PRICE >= ? ORDER BY PRICE ASC */
	List<ResultView> findByPriceGreaterThanEqualOrderByPrice(double startPrice);

}
