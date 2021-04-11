package com.ashsoft.service;

import java.util.List;

import com.ashsoft.dto.EmployeeDTO;

public interface IEmployeeService {
	
	public EmployeeDTO fetchEmployeeByNo(int eno);
	public List<EmployeeDTO> fetchEmployeesByDesgs(String desg1, String desg2, String desg3);
}
