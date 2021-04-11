package com.ashsoft.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable{
	
	private int empNo;
	private String ename;
	private String job;
	private float sal;
}
