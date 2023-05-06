package com.nt.dao;

import com.nt.bo.CustomerBO;

public interface ICustomerDAO {

	public abstract int insertCustomer(CustomerBO customerBO) throws Exception;

}
