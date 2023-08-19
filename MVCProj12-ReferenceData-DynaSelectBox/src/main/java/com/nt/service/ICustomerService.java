package com.nt.service;

import java.util.List;
import java.util.Set;

public interface ICustomerService {

	Set<String> getCountries();
	
	List<String> getStates(String country);

	Set<String> getLanguages();

	Set<String> getHobbies();
}
