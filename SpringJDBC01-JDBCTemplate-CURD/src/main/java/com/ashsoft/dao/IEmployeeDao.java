package com.ashsoft.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface IEmployeeDao {
	
	public int getEmployeesCount();
	public float getEmployeeSalaryByEno(int eno);
	public Map<String,Object> getEmployeeDetailsByEno(int eno);
	public List<Map<String, Object>> getEmployeesByDesg(String desg);
	public SqlRowSet getEmployeesBySalRange(float startSal,float endSal);
	public int insertEmployee(String ename, String desg, float sal);
	public int updateEmployee(int eno,float newSalary);
	public int deleteEmployeeByEno(int eno);
}
