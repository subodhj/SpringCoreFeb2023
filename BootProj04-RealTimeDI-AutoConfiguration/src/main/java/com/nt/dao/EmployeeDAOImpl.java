package com.nt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
@PropertySource("com/nt/commons/inputs.properties")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMP_BY_DESIGN_QUERY = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO, MGR FROM EMP WHERE JOB IN";

	@Autowired
	private DataSource ds;

	@Override
	public List<EmployeeBO> fetchEmpsByDesign(String condition) throws Exception {
		System.out.println("DataSource : "+ds.getClass());
		List<EmployeeBO> listBO = null;
		EmployeeBO empBO = null;
		try (Connection con = ds.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(GET_EMP_BY_DESIGN_QUERY + condition);) {
			// create an ArrayList object to store EmployeeBO objects
			listBO = new ArrayList<>();
			// process the ResultSet
			while (rs.next()) {
				empBO = new EmployeeBO();
				empBO.setEmpNo(rs.getInt(1));
				empBO.setEname(rs.getString(2));
				empBO.setJob(rs.getString(3));
				empBO.setSal(rs.getDouble(4));
				empBO.setDeptNo(rs.getInt(5));
				empBO.setMgr(rs.getInt(6));
				listBO.add(empBO);
			} // while

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listBO;
	}// fetchEmpsByDesign(-)

}// class
