package com.ashsoft.service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.ashsoft.dao.IEmployeeDao;

public class EmployeeMgmtServiceImpl implements IEmployeeServiceMgmtService {

	private IEmployeeDao dao;

	public EmployeeMgmtServiceImpl(IEmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	public int fetchEmployeesCount() {

		return  dao.getEmployeesCount();
	}

	@Override
	public float fetchEmployeeSalaryByEno(int eno) {
		
		return dao.getEmployeeSalaryByEno(eno);
	}
	
	@Override
	public Map<String,Object> fetchEmployeeDetailsByEno(int eno) {
		
		return dao.getEmployeeDetailsByEno(eno);
	}
	@Override
	public List<Map<String, Object>> fetchEmployeesByDesg(String desg) {
		
		return dao.getEmployeesByDesg(desg);
	}
	
	@Override
	public SqlRowSet fetchEmployeesBySalRange(float startSal, float endSal) {
		
		return dao.getEmployeesBySalRange(startSal, endSal);
	}
	
	@Override
	public String registerEmployee(String ename, String desg, float sal) {
		
		int count = dao.insertEmployee(ename, desg, sal);
		return count==0?"Employee Not Registered":"Employee is Registered";
	} 
	
	@Override
	public String hikeEmployeeSal(int eno, float percentage) {
		//get current salary
		float salary= fetchEmployeeSalaryByEno(eno);
		
		// calculate new salary
		float newSalary = salary + (salary*percentage/100);
		
		// use dao
		int count = dao.updateEmployee(eno, newSalary);
		
		return count==1?"Employee Salary Updated....":"Employee Salary Not Updated....";
	}
	
	@Override
	public String deleteEmployeeByEno(int eno) {
		int count = dao.deleteEmployeeByEno(eno);
		return count==1? "Employee Deleted":"Employee Not Deleted";
	}
}//class
