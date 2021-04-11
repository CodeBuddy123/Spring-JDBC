package com.ashsoft.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ashsoft.bo.EmployeeBO;

//@Repository("empDAO")
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private JdbcTemplate jt;

	private static final String GET_EMP_BY_ENO = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO = ?";

	@Override
	public EmployeeBO getEmployeeByNo(int eno) {

		EmployeeBO bo = jt.queryForObject(GET_EMP_BY_ENO, new EmployeeRowMapper(), eno);
		return bo;

	}

	// nested class
	private static class EmployeeRowMapper implements RowMapper<EmployeeBO> {
		@Override
		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println(rowNum);
			EmployeeBO bo = new EmployeeBO();

			bo.setEmpNo(rs.getInt("EMPNO"));
			bo.setEname(rs.getString("ENAME"));
			bo.setSal(rs.getFloat("SAL"));
			bo.setJob(rs.getString("JOB"));

			return bo;
		} // map row
	} // inner class

	@Override
	public List<EmployeeBO> getEmployeesByDesgs(String desg1, String desg2, String desg3) {
		
		return null;
	}

}
