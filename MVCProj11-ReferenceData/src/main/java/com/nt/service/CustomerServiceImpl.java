package com.nt.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repository.IHumanActivitiesRepo;

@Service("custService")
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private IHumanActivitiesRepo humanRepo;

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

}// class
