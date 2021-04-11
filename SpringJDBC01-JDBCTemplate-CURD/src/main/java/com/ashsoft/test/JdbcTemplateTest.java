package com.ashsoft.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.ashsoft.service.IEmployeeServiceMgmtService;

public class JdbcTemplateTest {
	
	public static void main(String[] args)  throws DataAccessException{
		
		//create IOC container
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ashsoft/cfgs/applicationContext.xml");
		
		//get target class object
		
		IEmployeeServiceMgmtService service = context.getBean("empService",IEmployeeServiceMgmtService.class);
		
		//Invoke methods
		/*
		System.out.println("Employees Count: "+service.fetchEmployeesCount());
		System.out.println("============================");
		
		System.out.println("Employee Salary : "+service.fetchEmployeeSalaryByEno(7902));
		
		System.out.println("============================");
		System.out.println("Employee Details with ENO 7902: "+service.fetchEmployeeDetailsByEno(7902));
		
		System.out.println("==============================");
		System.out.println("Employee Details with Desg Clerk : "+service.fetchEmployeesByDesg("CLERK"));
		
		System.out.println("==============================");
		
		SqlRowSet rs = service.fetchEmployeesBySalRange(1000, 50000);
		
		System.out.println("ENO\tENAME\tESAL\tEJOB");
		System.out.println("===============================");
		while(rs.next())
		{
			System.out.println(rs.getInt("EMPNO")+"\t"+rs.getString("ENAME")+"\t"+rs.getFloat("SAL")+"\t"+rs.getString("JOB"));
			System.out.println();
		}
		
		*/
		
		//NON SELECT OPERATIONS
		
		//System.out.println(service.registerEmployee("Raja", "CLERK", 7000));
		
		System.out.println();
		
		//System.out.println(service.hikeEmployeeSal(7499, 10.0f));
		
		System.out.println(service.deleteEmployeeByEno(2));
		
		((AbstractApplicationContext) context).close();
	}
}
