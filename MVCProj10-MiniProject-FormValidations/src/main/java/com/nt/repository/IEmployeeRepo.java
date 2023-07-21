package com.nt.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.nt.model.Employee;

public interface IEmployeeRepo
		extends ListCrudRepository<Employee, Integer>, ListPagingAndSortingRepository<Employee, Integer> {

}
