package com.ashsoft.service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface IEmployeeServiceMgmtService {
	
	public int fetchEmployeesCount();
	public float fetchEmployeeSalaryByEno(int eno);
	public Map<String,Object> fetchEmployeeDetailsByEno(int eno);
	public List<Map<String, Object>> fetchEmployeesByDesg(String desg);
	public SqlRowSet fetchEmployeesBySalRange(float startSal,float endSal);
	public String registerEmployee(String ename, String desg, float sal);
	public String hikeEmployeeSal(int eno, float percentage);
	public String deleteEmployeeByEno(int eno);
}
