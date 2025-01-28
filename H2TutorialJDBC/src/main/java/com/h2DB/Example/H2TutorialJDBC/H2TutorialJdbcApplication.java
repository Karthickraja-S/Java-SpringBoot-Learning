package com.h2DB.Example.H2TutorialJDBC;

import com.h2DB.Example.H2TutorialJDBC.model.Employee;
import com.h2DB.Example.H2TutorialJDBC.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class H2TutorialJdbcApplication {

	public static void main(String[] args) {

		// learn about h2 database : https://www.baeldung.com/spring-boot-h2-database

		// The below one is just a inMemory DB case and this is not a web App once main function ends
		// program terminates and data will be gone !
		ApplicationContext context = SpringApplication.run(H2TutorialJdbcApplication.class, args);

		Employee employee = context.getBean(Employee.class);
		employee.setEmpId(4);
		employee.setName("Mahesh");
		employee.setAge(56);
		employee.setSalary(100000);

		EmployeeService service = context.getBean(EmployeeService.class);

		System.out.println(service.getAllEmployees());

		service.addEmployee(employee);

		System.out.println(service.getAllEmployees());


	}

}
