package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String> {

//	@Query(fields = "{ cname :1, billAmt : 1 }", value = "{ cadd : ?0 }")
//	@Query(fields = "{ cno : 1, cname : 1, billAmt : 1 }", value = "{ cadd : ?0 }")
	@Query(fields = "{ id : 0, cno : 1, cname : 1, cadd : 1, billAmt : 1 }", value = "{ cadd : ?0 }")
	List<Object[]> getCustomerInfoByAddr(String addr);
//	List<Customer> getCustomerInfoByAddr(String addr);

//	@Query(fields = "{ }", value = "{ cadd : ?0 }")
	@Query(value = "{ cadd : ?0 }")
	List<Object[]> getCustomerByAddr(String addr);
//	List<Customer> getCustomerByAddr(String addr);

	@Query(fields = "{ id : 1, cno : 1, cname : 1, cadd : 1 }", value = "{ cname : ?0, cadd : ?1 }")
	List<Object[]> getCustomerInfoByNameAndAddr(String name, String addr);

//	@Query(fields = "{ id : 0, cno : 1, cname : 1, cadd : 1 }", value = "{ $or : [ { cname : ?0, cadd : ?1 } ] }")
	@Query(fields = "{ id : 0, cno : 1, cname : 1, cadd : 1 }", value = "{ $or : [ { cname : ?0 }, { cadd : ?1 } ] }")
	List<Object[]> getCustomerInfoByNameOrAddr(String name, String addr);

//	@Query(fields = "{ cno : 1, cname : 1, billAmt : 1 }", value = "{ billAmt : { $gte : ?0 }, { $lte : ?1 } }")
	@Query(fields = "{ cno : 1, cname : 1, billAmt : 1 }", value = "{ billAmt : { $gte : ?0, $lte : ?1 } }")
	List<Object[]> getCustomerInfoByBillAmtRange(double minAmt, double maxAmt);

//	@Query(fields = "{ cno : 1, cname : 1, billAmt : 1 }", value = "{ billAmt : { $gt : ?0, $lt : ?1 } }", count = true)
	@Query(value = "{ billAmt : { $gt : ?0, $lt : ?1 } }", count = true)
	int getCustomerCountByBillAmtRange(double minAmt, double maxAmt);

	@Query(value = "{ cadd : { $regex : ?0 } }")
	List<Customer> getCustomerByAnyCharOfAddr(String charOfAddr);

	@Query(value = "{ }", sort = "{ billAmt : 1 }") // order by billAmt ascending.
	List<Customer> getCustomerInAscOrderOfBillAmt();

	@Query(value = "{ }", sort = "{ billAmt : -1 }") // order by billAmt descending.
	List<Customer> getCustomerInDescOrderOfBillAmt();

	@Query(value = "{ billAmt : { $ne : null }, phoneNo : null }")
	List<Customer> getCustomerHavingBillAmtAndNoPhoneNo();

	@Query(value = "{ billAmt : null }", delete = true)
	int deleteCustomerWithNoBillAmt();

//	@Query(value = "{ billAmt : { $gte : ?0 }, { $lte : ?1 } }", exists = true)
	@Query(value = "{ billAmt : { $gte : ?0, $lte : ?1 } }", exists = true)
	boolean doesCustomerExistInBillAmtRange(double minAmt, double maxAmt);

}
