package com.ashsoft.dao;

import java.util.List;

import com.ashsoft.bo.EmployeeBO;

public interface IEmployeeDao {
	
	public EmployeeBO getEmployeeByNo(int eno);
	public List<EmployeeBO> getEmployeesByDesgs(String desg1,String desg2,String desg3);
	
}
