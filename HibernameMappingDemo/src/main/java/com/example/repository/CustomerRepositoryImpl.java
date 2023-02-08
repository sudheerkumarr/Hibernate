package com.example.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.entity.Customer;

public class CustomerRepositoryImpl {

	// Insert/Add Customer into db
	public Customer addCustomer(Customer customer) {
		// Create SessionFactory Obj from Configuration Obj
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Customer.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();

		// begin transaction
		Transaction tx = session.beginTransaction();

		// Save emp to db
		session.save(customer);

		// commit changes
		tx.commit();

		System.out.println("Customer added successfully!");

		// Close factory & session
		factory.close();
		session.close();

		return customer;
	}

	// Delete customer by id
	public void deleteCustomerById(int custId) {
		// Create SessionFactory Obj from Configuration Obj
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Customer.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();

		// begin transaction
		Transaction tx = session.beginTransaction();

		// Create query
		Query query = session.createQuery("delete from Customer where custId=:cId");
		query.setParameter("cId", custId);

		// Execute query
		int i = query.executeUpdate();

		// commit changes
		tx.commit();

		System.out.println("Customer deleted successfully!");

		// Close factory & session
		factory.close();
		session.close();
	}

	// Get customer by id
	public Customer getCustomerById(int custId) {
		// Create SessionFactory Obj from Configuration Obj
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Customer.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();

		// Get customer by id
		Customer customer = session.get(Customer.class, custId);

		session.close();
		factory.close();

		return customer;
	}

	// Get all customers
	public List<Customer> getAllCustomers() {
		// Create SessionFactory Obj from Configuration Obj
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Customer.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();

		// Get all customers
		Query query = session.createQuery("from Customer");
		List<Customer> customerList = query.getResultList();

		session.close();
		factory.close();

		return customerList;
	}

	// Update
	public Customer updateCustomer(Customer customer) {

		// Create SessionFactory Obj from Configuration Obj
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Customer.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();
		
		// Get customer by id
		// Get customer by id
		Customer dbCustomer = session.get(Customer.class, customer.getCustId());
		
		// begin transaction
		Transaction tx = session.beginTransaction();
		
		// Update customer details if given customer is present
//		if(dbCustomer!=null) {
//			session.save(customer);
//		}
		//session.save(customer);
		session.merge(customer);
		
		// commit changes to db
		tx.commit();
		
		// close session & factory
		session.close();
		factory.close();
		
		return null;
	}
}
