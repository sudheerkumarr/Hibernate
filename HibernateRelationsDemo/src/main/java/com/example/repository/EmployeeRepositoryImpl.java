package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.entity.Employee;
import com.example.entity.Skill;

public class EmployeeRepositoryImpl {

	public Employee addEmployee(Employee emp) {
		// Create SessionFactory Obj from Configuration Obj
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Employee.class);
		cfg.addAnnotatedClass(com.example.entity.Login.class);
		cfg.addAnnotatedClass(com.example.entity.Address.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();

		// begin transaction
		Transaction tx = session.beginTransaction();

		// Save emp to db
		session.save(emp);

		// commit changes
		tx.commit();

		System.out.println("employee added successfully!");

		// Close factory & session
		factory.close();
		session.close();

		return emp;
	}

	// Map Emp with skill
	public Employee mapEmpWithSkill(int empId, int skillId) {
		// Create SessionFactory Obj from Configuration Obj
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Employee.class);
		cfg.addAnnotatedClass(com.example.entity.Login.class);
		cfg.addAnnotatedClass(com.example.entity.Address.class);
		cfg.addAnnotatedClass(com.example.entity.Skill.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();

		// begin transaction
		Transaction tx = session.beginTransaction();

		// Logic to map emp with skill
		// get emp using empid
		Employee emp = session.get(Employee.class, empId);
		
		// Get skill using skillid
		Skill skill = session.get(Skill.class, skillId);
		
		// Update emp skills
		List<Skill> skillList= emp.getSkill();
		skillList.add(skill);
		
		// persist employee
		session.save(emp);
		
		// commit changes
		tx.commit();

		System.out.println("employee skills updated successfully!");

		// Close factory & session
		factory.close();
		session.close();

		return emp;

	}

}
