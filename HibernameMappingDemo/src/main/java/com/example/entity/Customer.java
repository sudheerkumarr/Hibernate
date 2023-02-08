package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cust")
public class Customer { // customer
	
	// Fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custId;
	
	@Column(name="cust_name")
	private String custName;
	
	@Column(name="mail")
	private String email;
	
	@Column(name="pass")
	private String password;
	
	
	// Getters & Setters
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// toString method
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", email=" + email + ", password=" + password
				+ "]";
	}

	
}
