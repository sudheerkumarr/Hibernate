package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.entity.Address;
import com.example.entity.Employee;

public class AddressRepositoryImpl {
	
	Address addAddress(Address addr) {
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Address.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();

		// begin transaction
		Transaction tx = session.beginTransaction();

		// Save emp to db
		session.save(addr);

		// commit changes
		tx.commit();

		System.out.println("address added successfully!");

		// Close factory & session
		factory.close();
		session.close();

		return addr;

	}
	
		public Address addAddressAndMapEmp(Address addr, int empId) {
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Address.class);
		cfg.addAnnotatedClass(com.example.entity.Employee.class);
		cfg.addAnnotatedClass(com.example.entity.Login.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();

		// begin transaction
		Transaction tx = session.beginTransaction();

		// Save emp to db
		session.save(addr);
		
		// logic to add address with existing employee
		// Get Employee from db using empId
		Employee emp = session.get(Employee.class, empId);
		
		// Create ArrayList and add address obj
		List<Address> addrList = new ArrayList<>();
		addrList.add(addr);
		
		// Update existing employee address details
		//emp.setAddr(addrList);
		List<Address> addrList1= emp.getAddr();
		addrList1.add(addr);
		
		//emp.getAddr().add(addr);
		
		// save employee in db
		session.save(emp);

		// commit changes
		tx.commit();

		System.out.println("address added successfully!");

		// Close factory & session
		factory.close();
		session.close();

		return addr;

	}

}
