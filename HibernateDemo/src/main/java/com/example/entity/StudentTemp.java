package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

@Entity
public class StudentTemp {
	
	// Fields/Variables
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rollNo;
	
	@Column(name="name", nullable=false, unique=true, length=50)
	@OrderBy
	private String name;
	
	//Column can't be created
	@Transient 
	private int age;
	private int marks;
	
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
