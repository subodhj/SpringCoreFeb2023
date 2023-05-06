package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;

@Repository("oracleDAO")
public final class CustomerOracleDAOImpl implements ICustomerDAO {

	private static final String CUSTOMER_INSERT_QUERY = "INSERT INTO SBI_HOME_LOAN VALUES(SBI_HOME_LOAN_SEQ.NEXTVAL,?,?,?,?,?,?)";
	@Autowired
//	@Qualifier("dmds")
	private DataSource dataSource;

	public CustomerOracleDAOImpl() {
		System.out.println("CustomerOracleDAOImpl : 0-param constructor");
	}

	@Override
	public int insertCustomer(CustomerBO customerBO) throws Exception {
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
