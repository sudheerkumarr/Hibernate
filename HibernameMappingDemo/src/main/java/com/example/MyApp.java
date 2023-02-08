package com.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.entity.Customer;
import com.example.repository.CustomerRepositoryImpl;

public class MyApp {

	public static void main(String[] args) {

		// Create customer repository obj
		CustomerRepositoryImpl custRepo = new CustomerRepositoryImpl();
		
		
//		// Insert / Create customer obj
//		Customer customer = new Customer();
//		customer.setCustName("Sam");
//		customer.setEmail("sam@example.com");
//		customer.setPassword("abc.123");
//		
//		
//		Customer cust= custRepo.addCustomer(customer);
//		System.out.println(cust);
		
		
		// Add/Insert customer into db
		//custRepo.addCustomer(customer);

		// Delete customer by id
		// custRepo.deleteCustomerById(7);

		// Get customer by id
		// Customer customer = custRepo.getCustomerById(8);
		// System.out.println(customer);

		// Get all customers
//		List<Customer> customerList = custRepo.getAllCustomers();
//		for(Customer cust : customerList) {
//			System.out.println(cust);
//		}

		
//		// Delete customer by id
//		custRepo.deleteCustomerById(13);
		
//		// Get Customer by id
//		Customer customer = custRepo.getCustomerById(12);
//		System.out.println(customer);
//		
		
		Customer customer = new Customer();
		customer.setCustId(12);
		customer.setCustName("Ram.K");
		customer.setEmail("ram@example.com");
		customer.setPassword("abc.123");
		
		custRepo.updateCustomer(customer);
		
	}

}
