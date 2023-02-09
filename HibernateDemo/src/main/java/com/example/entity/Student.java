package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.transaction.Transactional;

/*
 * HQL - Hibernate Query Language
 * - Objects
 *  
 *   from Student; // return all students info
 *   from Student where rollNo
 *
 * 
 * HCQL - Hibernate Criteria Query Language
 * 
 * SQL - Structured Query Language
 * - Tables
 */
@Entity
//@Table
public class Student {
	
	// Fields
	@Id
	@GeneratedValue
	private int rollNo;
	
	@Column(name="std_name", unique=true, length=25, nullable=false)
	private String name;
	
	// age column won't be created in db
	@Transient
	private int age;
	
	private int marks;
	
	
	// Constructors
	
	public Student() {
		super();
	}
	
	public Student(String name, int age, int marks) {
		super();
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
	
	
	// Getters & Setters
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", age=" + age + ", marks=" + marks + "]";
	}
	

}
