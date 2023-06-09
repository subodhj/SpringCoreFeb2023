package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.document.Customer;
import com.nt.generator.CustomIDGenerator;
import com.nt.service.ICustomerMgmtService;

@Component
public class MongoRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		try {

			// 1. Save Customer document.
			/*Customer cust = new Customer();
			cust.setCno(3006);
			cust.setCname("Paramesh");
			cust.setCadd("TS");
			cust.setBillAmt(3500.0);
			System.out.println(service.registerCustomer(cust));*/

			// 2.Save Customer document with a new property.
			/*Customer cust = new Customer();
			cust.setCno(1002);
			cust.setCname("Sri Krishna");
			cust.setCadd("UP");
			cust.setBillAmt(2500.0);
			cust.setPhoneNo(9291256944L);
			System.out.println(service.registerCustomer(cust));*/

			// 3. Update Customer document.
			/*Customer cust = new Customer();
			cust.setId("647db2e829e212515296d551");
			cust.setCno(1002);
			cust.setCname("Sri Krishna");
			cust.setCadd("UP");
			cust.setBillAmt(2500.0);
			cust.setPhoneNo(9291256955L);
			System.out.println(service.registerCustomer(cust));*/

			/*Customer cust = new Customer();
			cust.setId("647e8f23b466e617cf86ad2b");
			cust.setCno(2003);
			cust.setCname("Madhusudan");
			cust.setCadd("Kerala");
			System.out.println(service.registerCustomer(cust));*/

			// 4. Save Customer document using customer id generator.
			/*Customer cust = new Customer();
			cust.setId(CustomIDGenerator.generateId());
			cust.setCno(1004);
			cust.setCname("Shiva");
			cust.setCadd("UK");
			cust.setBillAmt(1500.0);
			cust.setPhoneNo(8801969944L);
			System.out.println(service.registerCustomer(cust));*/

			// 6. Select all Customer documents.
//			service.getCustomer().forEach(System.out::println);

			// 7. Delete Customer document by Id.
//			System.out.println(service.deleteCustomer("647db2e829e212515296d551"));

			// 8. saveAll(Iterable<S>) <S extends T> : List<S>
			// 10. insert(Iterable<S>) <S extends T> : List<S>
			/*Customer cust1 = new Customer(2001, "Madhav");
			Customer cust2 = new Customer(2002, "Keshav");
			Customer cust3 = new Customer(2003, "Madhusudan");
			System.out.println(service.saveAllCustomers(List.of(cust1, cust2, cust3)));*/

			// 9. findAll(Sort) : List<S>
//			service.getCustomersInSortingOrder(true, "cname").forEach(System.out::println);

			// 11. findAll(Example<S>) <S extends T> : List<S>
			/*Customer customer = new Customer();
			customer.setCadd("UP");
			service.fetchCustomersByInfo(customer).forEach(System.out::println);*/

			// 12. findAll(Example<S>, Sort) <S extends T> : List<S>
			/*Customer customer = new Customer();
			customer.setCadd("UP");
			service.fetchCustomersByInfoInSortOrder(customer, true, "billAmt").forEach(System.out::println);*/

			// ----------------Finder Methods-----------------------
//			service.searchCustomersHavingPhoneNoByBillAmtRange(2000.0, 5000.0).forEach(System.out::println);
//			service.searchCustomersByAddress("UK","UP").forEach(System.out::println);

		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("----------dae----------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------e----------");
		}

	}// run(-)

}// class
