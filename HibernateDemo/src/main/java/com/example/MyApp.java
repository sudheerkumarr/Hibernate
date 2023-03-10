package com.example;
/*
 * 
 * Object States - 
 * 1. Tranactional
 *        | persist()/save()
 *        V
 * 2. Managed/Persisted
 * 		  | detach() 
 *        V
 * 3. Detached
 *        | remove() - remove data
 *        V
 * 4. Removed
 * 
 * HQL - create, update, delete, get -
 *  from Student; // list of students
 *  from Student where Student.rollNo=108; // specific student details
 *  from Student s where s.rollNo=108;//
 *  delete from Student where rollNo=108; // delete student
 * 
 * 
 *  getResultList()
 *  getFirstResult()
 *  
 * HCQL - Hibernate Crieteria Query Language 
 *  - Select operations
 *  
 *  - 
 * 
 * 
 */

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.example.entity.Student;

class MyApp {
	
	public static void main(String[] args) {
		// Create Session object
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg
				.addAnnotatedClass(com.example.entity.Student.class)
				.configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		
		
		// Insert
		//Student std1 = new Student("Raghav", 12, 87); // Transactional
//		Student std2 = new Student("Ramesh", 13, 76);  // Transactional
//		Student std3 = new Student("Rahul", 12, 47); // Transactional
//		Student std4 = new Student("Kumar", 13, 57); // Transactional 
		
		//Transaction tx = session.beginTransaction();
		// Save objects
		//session.save(std1); // Managed/Persisted
//		session.save(std2); // Managed/Persisted
//		session.save(std3); // Managed/Persisted
//		session.save(std4);  // Managed/Persisted
		
		//std1.setMarks(45);
		//std2.setMarks(35);
		
		//session.detach(std1); // Detached State
		//std1.setMarks(95); 
//		
//		session.remove(std1); // Removed, data will lost
		
		//tx.commit();
		

//		// Fetch all student records
//		Query query = session.createQuery("from Student");
//		List<Student> stdList = query.getResultList() ;//
//		for(Student std : stdList) {
//			System.out.println(std);
//		}
		
		
		
		// HCQL 
	
		Criteria c = session.createCriteria(Student.class);
		
//		// Get all students
//		List<Student> stdList= c.list(); // returns all student records
//		for(Student std : stdList) {
//			System.out.println(std);
//		}
		
		// Restrictions
		// gt, lt, eq, like, ilike, between
		// find specific user - rollNo
//		Criterion cr = Restrictions.eq("rollNo", 114 ); //select * from student where rollno=114
//		Student std = (Student)c.add(cr).uniqueResult();
//		System.out.println(std);
		
		// between - return students who got marks between 50 & 70
//		Criterion cr = Restrictions.between("marks", 50, 70 ); //select * from student where rollno=114
//		List<Student> stdList = c.add(cr).list();
//		for(Student std: stdList) {
//			System.out.println(std);
//		}
		
		// like
		//Criterion cr = Restrictions.like("name", "r%"); //select * from student where rollno=114
		Criterion cr = Restrictions.ilike("name", "r%");
		List<Student> stdList = c.add(cr).list();
		for(Student std: stdList) {
			System.out.println(std);
		}
		
		// Projections - select name, age from student;
		//              - max(), min(), sum(), avg()
		
		// rowCount
//		Criteria c1 = session.createCriteria(Student.class);
//		Projection proj = Projections.rowCount();
//		Criteria cr= c1.setProjection(proj);
//		System.out.println(cr.uniqueResult()); //8 - select count(*) from student;
		

		// Max Marks
//		Criteria c1 = session.createCriteria(Student.class);
//		Projection proj = Projections.max("marks");
//		Criteria cr = c1.setProjection(proj);
//		System.out.println(cr.uniqueResult()); // 87
	
		
		// min, avg
		// names
//		Criteria c1 = session.createCriteria(Student.class);
//		Projection proj = Projections.property("name"); // select name from student;
//		Criteria cr = c1.setProjection(proj);
//		List<String> nameList= c1.list();
//		for(String str: nameList) {
//			System.out.println(str);
//		}
		
		// names, marks - ProjectionList
		// Create Criteria Obj
		Criteria c1 = session.createCriteria(Student.class);
		
		// Create Projection for each column
		Projection proj1 = Projections.property("name");
		Projection proj2 = Projections.property("marks");
		
		// Create ProjectList and add Projections
		ProjectionList projList = Projections.projectionList();
		projList.add(proj1);
		projList.add(proj2);
		
		// Add ProjectionList to Criteria
		Criteria c2 = c1.setProjection(projList);
		List pList = c2.list();
		
		// Iterate ProjectionList
		Iterator itr = pList.iterator();
		while(itr.hasNext()) {
			Object[] obj= (Object[])itr.next();
			System.out.println("Name: "+ obj[0] + "\t"+ "Marks: "+ obj[1]);
		}
		
		
		session.close();
		factory.close();
		
	}
}
