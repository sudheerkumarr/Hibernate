package com.example.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.entity.Skill;

public class SkillRepositoryImpl {
	
	public Skill addSkill(Skill skill) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Skill.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();

		// begin transaction
		Transaction tx = session.beginTransaction();

		// Save emp to db
		session.save(skill);

		// commit changes
		tx.commit();

		System.out.println("Skill added successfully!");

		// Close factory & session
		factory.close();
		session.close();

		return skill;
	}

}
