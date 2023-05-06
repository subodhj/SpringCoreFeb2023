package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.CustomerBO;

public final class CustomerMySQLDAOImpl implements ICustomerDAO {

	private static final String CUSTOMER_INSERT_QUERY = "INSERT INTO SBI_HOME_LOAN(CUSTOMERNAME,CUSTOMERADDRESS,PRINCIPALAMOUNT,RATE,TIME,INTEREST) VALUES(?,?,?,?,?,?)";
	private DataSource dataSource;
	private String osName;
	private String osVersion;
	private String userName;
	private String pathData;

	public CustomerMySQLDAOImpl(DataSource dataSource) {
		System.out.println("CustomerMySQLDAOImpl : 1-param constructor");
		this.dataSource = dataSource;
	}
	
	public void setOsName(String osName) {
		this.osName = osName;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPathData(String pathData) {
		this.pathData = pathData;
	}

	@Override
	public int insertCustomer(CustomerBO customerBO) throws Exception {
		System.out.println("OSName: "+osName);
		System.out.println("OSVersion: "+osVersion);
		System.out.println("OS User Name: "+userName);
		System.out.println("OS Path Data : "+pathData);
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			// get pooled jdbc connection
			con = dataSource.getConnection();
			// create PreparedStatement object
			ps = con.prepareStatement(CUSTOMER_INSERT_QUERY);
			// set query param values
			ps.setString(1, customerBO.getCustomerName());
			ps.setString(2, customerBO.getCustomerAddress());
			ps.setFloat(3, customerBO.getPrincipalAmount());
			ps.setFloat(4, customerBO.getRate());
			ps.setFloat(5, customerBO.getTime());
			ps.setFloat(6, customerBO.getInterest());
			// send & and execute sql query
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// close PreparedStatement object
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			// close Connection object
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		} // finally

		return result;
	}// insertCustomer(-)

}// class
