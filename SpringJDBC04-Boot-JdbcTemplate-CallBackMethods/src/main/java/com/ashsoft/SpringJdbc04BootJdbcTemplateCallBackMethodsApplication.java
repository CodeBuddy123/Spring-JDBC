package com.ashsoft;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ashsoft.dto.EmployeeDTO;
import com.ashsoft.service.IEmployeeService;

@SpringBootApplication
public class SpringJdbc04BootJdbcTemplateCallBackMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringJdbc04BootJdbcTemplateCallBackMethodsApplication.class, args);
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
