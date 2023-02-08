package com.example;

import java.util.List;


import com.example.entity.Employee;
import com.example.repository.EmployeeRepositoryImpl;

public class MyApp {

	public static void main(String[] args) {
		
		EmployeeRepositoryImpl empRepo= new EmployeeRepositoryImpl();
		
		// Create/Insert obj into db
//		Employee emp1 = new Employee();
//		emp1.setEmpName("Kumar");
//		emp1.setPassword("abc.123");
//		emp1.setEmail("kumar@example.com");
//		
//		Employee emp2 = new Employee();
//		emp2.setEmpName("Bob");
//		emp2.setPassword("abc.123");
//		emp2.setEmail("bob@example.com");
//		
//		empRepo.addEmployee(emp1);
//		empRepo.addEmployee(emp2);
		
		// Get All employees
		
		List<Employee> empList= empRepo.getAllEmployees();
		for(Employee emp : empList) {
			System.out.println(emp);
		}
		
	
		
	}

}
