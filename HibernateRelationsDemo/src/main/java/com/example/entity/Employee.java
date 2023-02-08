package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	// Field
	@Id
	@GeneratedValue
	private int empId;
	
	private String empName;
	private String contactNo;

//	private String email;
//	private String password;
//	private String role;
	// Has A relationship
	// OneToOne - unidirectional
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="login_id")
	private Login login;
	
	// OneToMany - One employee - many addresses
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_addr_fk")
	private List<Address> addr;
	
	
	// ManyToMany
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinTable(name = "employee_skills", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = {
			@JoinColumn(name = "skill_id") })
	private List<Skill> skill;
	
	
	// Getters & Setters
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public List<Address> getAddr() {
		return addr;
	}
	public void setAddr(List<Address> addr) {
		this.addr = addr;
	}
	
	public List<Skill> getSkill() {
		return skill;
	}
	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", contactNo=" + contactNo + ", login=" + login
				+ ", addr=" + addr + ", skill=" + skill + "]";
	}
	
	
	
}
