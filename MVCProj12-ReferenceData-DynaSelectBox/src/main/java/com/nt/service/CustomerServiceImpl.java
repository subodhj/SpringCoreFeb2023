package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.nt.model.Country;
import com.nt.model.State;
import com.nt.repository.ICountryRepo;
import com.nt.repository.IHumanActivitiesRepo;

@Service("custService")
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private IHumanActivitiesRepo humanRepo;

	@Autowired
	private ICountryRepo countryRepo;

	@Autowired
	private Environment environment;

	@Override
	public Set<String> getCountries() {
		Locale[] locales = null;
		Set<String> countriesSet = null;
		// Get all the available Locales.
		locales = Locale.getAvailableLocales();
		// Create object of Set.
		countriesSet = new TreeSet<>();
		// Add each Locale to Set collection.
		for (Locale l : locales) {
			countriesSet.add(l.getDisplayCountry());
		}
		// Return Set collection having all countries.
		return countriesSet;
	}

	@Override
	public Set<String> getLanguages() {
		Locale[] locales = null;
		Set<String> languagesSet = null;
		// Get all the available Locales.
		locales = Locale.getAvailableLocales();
		// Create object of Set.
		languagesSet = new TreeSet<>();
		// Add each Language to Set collection.
		for (Locale l : locales) {
			languagesSet.add(l.getDisplayLanguage());
		}
		// Return Set collection having all languages.
		return languagesSet;
	}

	@Override
	public Set<String> getHobbies() {
		Set<String> hobbiesSet = null;
		// Create Set Collection.
		hobbiesSet = new TreeSet<>();
		// Use Repository
		hobbiesSet = humanRepo.getHobbies();
		// Return Set collection.
		return hobbiesSet;
	}

	@Override
	public List<String> getStates(String country) {
		String statesInfo = null;
		List<String> statesList = null;
		System.out.println(environment);
		// Get all the states of given country.
		statesInfo = environment.getProperty(country);
		System.out.println(statesInfo);
		// Add each state into List collection.
		statesList = Arrays.asList(statesInfo.split(","));
		System.out.println(statesList);
		// Sort the states in the List collection.
		Collections.sort(statesList);
		// Return the List collection.
		return statesList;
	}

	@Override
	public List<String> searchStates(String country) {
		Country cntry = countryRepo.getCountry(country);
		System.out.println(cntry);
		List<State> states = cntry.getStates();
		List<String> statesList = new ArrayList<>();
		states.forEach(state -> statesList.add(state.getName()));
		Collections.sort(statesList);
		System.out.println(statesList);
		return statesList;
	}

}// class
