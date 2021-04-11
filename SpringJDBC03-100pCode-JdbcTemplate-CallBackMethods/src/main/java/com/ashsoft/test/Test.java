package com.ashsoft.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.ashsoft.config.AppConfig;
import com.ashsoft.dto.EmployeeDTO;
import com.ashsoft.service.IEmployeeService;

public class Test {

	public static void main(String[] args) throws DataAccessException {

		// create IOC container
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		// get service class object

		IEmployeeService service = ctx.getBean("empService", IEmployeeService.class);

		// invoke methods
		// System.out.println(service.fetchEmployeeByNo(7499));

		List<EmployeeDTO> listDTO = service.fetchEmployeesByDesgs("MANAGER", "CLERK", "SALESMAN");
		
		listDTO.forEach(System.out::println);

		// close the container
		((AbstractApplicationContext) ctx).close();

	}

}
