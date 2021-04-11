package com.ashsoft.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class EmployeeDaoImpl implements IEmployeeDao {

	private JdbcTemplate jt;

	private static final String GET_EMPS_COUNT = "SELECT COUNT(*) FROM EMP";
	private static final String GET_EMPS_SAL_BY_ENO = "SELECT SAL FROM EMP WHERE EMPNO = ?";
	private static final String GET_EMPS_DTL_BY_ENO = "SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE EMPNO = ?";
	private static final String GET_EMPS_DTL_BY_DESG = "SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE JOB = ?";
	private static final String GET_EMPS_BY_SAL_RANGE = "SELECT EMPNO, ENAME,SAL,JOB FROM EMP WHERE SAL BETWEEN ? AND ?";
	private static final String INSERT_EMP_QUERY = "INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(EMPNO_SEQ.NEXTVAL,?,?,?)";
	private static final String UPDATE_EMP_QUERY = "UPDATE EMP SET SAL= SAL+? WHERE EMPNO=?";
	private static final String DELETE_EMP_QUERY = "DELETE FROM EMP WHERE EMPNO = ?";
	public EmployeeDaoImpl(JdbcTemplate jt) {
		System.out.println("EmployeeDaoImpl:1 Param Con");
		this.jt = jt;
	}

	@Override
	public int getEmployeesCount() {
		int count = jt.queryForObject(GET_EMPS_COUNT, Integer.class);
		return count;
	}

	@Override
	public float getEmployeeSalaryByEno(int eno) {
		float sal = jt.queryForObject(GET_EMPS_SAL_BY_ENO, Float.class, eno);
		return sal;
	}

	@Override
	public Map<String, Object> getEmployeeDetailsByEno(int eno) {
		Map<String, Object> map = jt.queryForMap(GET_EMPS_DTL_BY_ENO, eno);
		return map;
	}

	@Override
	public List<Map<String, Object>> getEmployeesByDesg(String desg) {

		return jt.queryForList(GET_EMPS_DTL_BY_DESG, desg);
	}
	
	@Override
	public SqlRowSet getEmployeesBySalRange(float startSal, float endSal) {
		
		return jt.queryForRowSet(GET_EMPS_BY_SAL_RANGE,startSal,endSal);
	}
	
	//Non Select Operations
	
	@Override
	public int insertEmployee(String ename, String desg, float sal) {
		int count = jt.update(INSERT_EMP_QUERY,ename,desg,sal);
		return count;
	}
	
	@Override
	public int updateEmployee(int eno, float newSalary) {
		int count = jt.update(UPDATE_EMP_QUERY,newSalary,eno);
		return count;
	}
	
	@Override
	public int deleteEmployeeByEno(int eno) {
		int count = jt.update(DELETE_EMP_QUERY,eno);
		return count;
	}
}
