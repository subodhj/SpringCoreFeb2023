package com.nt.repo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE COMPANY = ? */
	/* SELECT REG_NO,COMPANY,COUNTRY,DOSES,NAME,PRICE FROM CORONA_VACCINE WHERE COMPANY = 'PizerLtd'; */
	// SELECT * FROM CORONA_VACCINE WHERE COMPANY = 'PizerLtd'
	/* SELECT
	     *
	 FROM
	     corona_vaccine
	 WHERE
	     corona_vaccine.company = 'PizerLtd' */

	List<CoronaVaccine> findByCompany(String company);

	List<CoronaVaccine> findByCompanyEquals(String company);

	List<CoronaVaccine> findByCompanyIs(String company1);

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE PRICE < ? */
	List<CoronaVaccine> findByPriceLessThan(double price);

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE PRICE BETWEEN  ? AND ? */
	List<CoronaVaccine> findByPriceBetween(double startPrice, double endPrice);

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE NAME LIKE ? */
	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE NAME LIKE 'M%' */
	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE NAME LIKE '____' */
	List<CoronaVaccine> findByNameLike(String initChars);

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE NAME LIKE 'P%' */
	List<CoronaVaccine> findByNameStartingWith(String startLetters); // (not working)

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE NAME LIKE '%a' */
	List<CoronaVaccine> findByNameEndingWith(String endLetters); // (not working)

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE NAME LIKE '%e%' */
	List<CoronaVaccine> findByNameContaining(String letters);

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE COUNTRY IN ('INDIA','RUSSIA') */
	List<CoronaVaccine> findByCountryIn(List<String> country);

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE COUNTRY NOT IN ('USA') */
	List<CoronaVaccine> findByCountryNotIn(List<String> country);

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE PRICE > ? ORDER BY PRICE ASC */
	List<CoronaVaccine> findByPriceGreaterThanOrderByPriceAsc(double price);

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE COUNTRY <> ? */
	List<CoronaVaccine> findByCountryIsNot(String country);

	List<CoronaVaccine> findByCountryNot(String country);

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE REG_NO = ? */
	Optional<CoronaVaccine> findByRegNo(long regNo);

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE NAME = ? AND COUNTRY = ? */
	List<CoronaVaccine> findByNameAndCountry(String coronaVaccineName, String country);

	List<CoronaVaccine> findByNameEqualsAndCountryEquals(String coronaVaccineName, String country);

	List<CoronaVaccine> findByNameIsAndCountryIs(String coronaVaccineName, String country);

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE NAME LIKE 'P%' OR PRICE BETWEEN ? AND ? */
	List<CoronaVaccine> findByNameLikeOrPriceBetween(String initChars, double startPrice, double endPrice);

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE COUNTRY IN ('INDIA','RUSSIA') AND PRICE BETWEEN ? AND ? */
	List<CoronaVaccine> findByCountryInAndPriceBetween(Collection<String> countries, double startPrice,
			double endPrice);

	/* SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, DOSES FROM CORONA_VACCINE WHERE (COUNTRY IN ('INDIA','RUSSIA') AND NAME IN (?,?,?)) OR PRICE >= ? */
	List<CoronaVaccine> findByCountryInAndNameInOrPriceGreaterThanEqual(Collection<String> countries,
			Collection<String> names, double price);

}
