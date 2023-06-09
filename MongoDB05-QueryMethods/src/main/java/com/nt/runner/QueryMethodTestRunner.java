package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.service.ICustomerMgmtService;

@Component
public class QueryMethodTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		try {

			// 1. Get Customers info by address.
			/*service.searchCustomerInfoByAddr("TS").forEach(objArray -> {
				for (Object obj : objArray) {
					System.out.println(obj);
				}
			});*/
//			service.searchCustomerInfoByAddr("TS").forEach(System.out::println);

			// 2. Get Customers by address.
//			service.searchCustomerByAddr("TS").forEach(objArray -> {
//				for (Object obj : objArray) {
//					System.out.println(objArray[0]);
//				}
//			});
//			service.searchCustomerByAddr("UP").forEach(System.out::println);

			// 3. Get Customer info by name & address.
			/*service.searchCustomerInfoByNameAndAddr("Sri Rama", "UP").forEach(objArray -> {
				System.out.println(objArray[0]);
			});*/

			// 4. Get Customers info by name or address.
			/*service.searchCustomerInfoByNameOrAddr("Durga", "UP").forEach(objArray -> {
				System.out.println(objArray[0]);
			});*/

			// 5. Get Customers Info by billAmt range.
			/*service.searchCustomerInfoByBillAmtRange(4000, 5000).forEach(objArray -> {
				for (Object obj : objArray) {
					System.out.println(obj);
				}
			});*/

			// 6. Get Customers count by billAmt range. (Aggregate function)
//			System.out.println("Customer Count : " + service.findCustomerCountByBillAmtRange(3000, 6000));

			// 7. Get Customers by any char of addr.
//			service.searchCustomerByAnyCharOfAddr("^T").forEach(System.out::println);
//			service.searchCustomerByAnyCharOfAddr("P$").forEach(System.out::println);
//			service.searchCustomerByAnyCharOfAddr("a").forEach(System.out::println);

			// 8. Get Customers in ascending order of billAmt.
//			service.fetchCustomerInAscOrderOfBillAmt().forEach(System.out::println);

			// 9. Get Customers in descending order of billAmt.
//			service.fetchCustomerInDescOrderOfBillAmt().forEach(System.out::println);

			// 10. Get Customers info who have billAmt & no phoneNo.
//			service.searchCustomerHavingBillAmtAndNoPhoneNo().forEach(System.out::println);

			// 11. Delete Customers with no billAmt.
//			System.out.println("No. of Customers deleted : " + service.removeCustomerWithNoBillAmt());

			// 12. Check whether Customers exists in billAmt range.
			/*System.out.println("Does Customers exists in billAmt range : "
					+ service.checkCustomerExistsInBillAmtRange(3000, 4000));*/

		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("----------dae----------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------e----------");
		}
	}// run(-)

}// class
