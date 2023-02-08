package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.entity.Login;
import com.example.entity.Skill;
import com.example.repository.AddressRepositoryImpl;
import com.example.repository.EmployeeRepositoryImpl;
import com.example.repository.SkillRepositoryImpl;

/*
 * Types of Relationships
 * 1. OneToOne
 * 2. OneToMany
 *    ManyToOne
 * 3. ManyToMany
 * 
 * OneToOne: 
 * Customer-Profile - OneToOne
 * Custome- Login   - OneToOne
 * 
 * OneToMany: 
 * Customer-Address -
 *                  - OneToMany
 *                  - ManyToOne
 *                  
 * Customer - Vehicle - 
 *  Customer - OneToMany
 *  Vehicle  - ManyToOne
 *  
 * ManyToMany:
 * Book & Author - ManyToMany
 * Book - ManyToMany
 * Author - ManyToMany
 * 
 * Employee & Department - 
 *   Employee - OneToOne     - ManyToOne
 *   Department - OneToMany  - OneToMany 
 *   
 * Employee & Skill
 *  Employee - OneToMany     - ManyToMany
 *  Skill    - OneToMany     - ManyToMany
 *   
 *   
 * Uni directional / Bidirectional
 * 
 * 
 * 
 */
public class MyApp {

	public static void main(String[] args) {
	
		/*
		// OneToOne Example
		
	     EmployeeRepositoryImpl empRepo = new EmployeeRepositoryImpl();
	     AddressRepositoryImpl addrRepo = new AddressRepositoryImpl();
	     
	     
	     // Create Employee obj
	     Employee emp = new Employee();
	     emp.setEmpName("Jhon");
	     emp.setContactNo("9999933333");
	     
	     // Create login object
	     Login login = new Login();
	     login.setEmail("jhon@example.com");
	     login.setPassword("abc.123");
	     login.setRole("Employee");
	     
	     // update employee obj with login details
	     emp.setLogin(login);
	     
	     //System.out.println(emp);
	     
	     // empRepo.addEmployee(emp);
	     
	     
	     // OneToMany Example
	     Address addr1 = new Address();
	     Address addr2 = new Address();
	     Address addr3 = new Address();
	     
	     addr1.setCity("Chennai");
	     addr1.setState("Tamilnadu");
	     addr1.setZip(600001);
	     
	     addr2.setCity("Bangaluru");
	     addr2.setState("Karnataka");
	     addr2.setZip(500001);
	     
	     addr3.setCity("Pune");
	     addr3.setState("Maharashtra");
	     addr3.setZip(700001);
	     
	     List<Address> addrList = new ArrayList<>();
	     addrList.add(addr1);
	     addrList.add(addr2);
	     addrList.add(addr3);
	     
	     emp.setAddr(addrList);
	     
	     empRepo.addEmployee(emp);
	     

	     // adding address info at the time of creating emp obj
	     // address & employee objects are available in db - need to map
	     // Map emp while adding address object in db.
	     
	 
	     
	     Address addr4 = new Address();
	     addr4.setCity("Bangaluru");
	     addr4.setState("Karnataka");
	     addr4.setZip(500022);
	     
	     Address addr = addrRepo.addAddressAndMapEmp(addr4, 21);
	     System.out.println(addr);
	     
		
		 // Add Skill
		SkillRepositoryImpl skillRepo = new SkillRepositoryImpl();
		
		Skill skill = new Skill();
		skill.setSkillName("Oracle");
		
		skillRepo.addSkill(skill);
		*/
		 EmployeeRepositoryImpl empRepo = new EmployeeRepositoryImpl();
		 Employee emp = empRepo.mapEmpWithSkill(28, 47);
		 //System.out.println(emp);
	     
	}

}
