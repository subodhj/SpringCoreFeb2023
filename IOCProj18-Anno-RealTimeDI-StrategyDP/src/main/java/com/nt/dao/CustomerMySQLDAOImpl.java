package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;

@Repository("mySqlDAO")
public final class CustomerMySQLDAOImpl implements ICustomerDAO {

	private static final String CUSTOMER_INSERT_QUERY = "INSERT INTO SBI_HOME_LOAN(CUSTOMERNAME,CUSTOMERADDRESS,PRINCIPALAMOUNT,RATE,TIME,INTEREST) VALUES(?,?,?,?,?,?)";
    @Autowired
	private DataSource dataSource;
    @Value("${os.name}")
	private String osName;
    @Value("${os.version}")
	private String osVersion;
	@Value("${user.name}")
	private String userName;
    @Value("${Path}")
	private String pathData;

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
