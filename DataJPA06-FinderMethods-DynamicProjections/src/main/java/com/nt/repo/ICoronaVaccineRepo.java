package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CoronaVaccine;
import com.nt.type.View;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

	/* SELECT ?,? FROM CORONA_VACCINE WHERE COMPANY = ? ORDER BY COMPANY DESC */
	<T extends View> List<T> findByCompanyOrderByCompanyDesc(String company, Class<T> viewType);

	/* SELECT ?,? FROM CORONA_VACCINE WHERE COMPANY = ? ORDER BY REG_NO DESC */
	<T extends View> List<T> findByCompanyOrderByRegNoDesc(String company, Class<T> viewType);

	/* SELECT ?,? FROM CORONA_VACCINE WHERE COMPANY = ? ORDER BY PRICE DESC */
	<T extends View> List<T> findByCompanyOrderByPriceDesc(String company, Class<T> viewType);

}
