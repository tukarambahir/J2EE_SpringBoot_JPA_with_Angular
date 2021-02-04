package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "customer_tbl")
@JsonInclude(Include.NON_DEFAULT)
public class Customer 
{
	public Customer() 
	{
		System.out.println("In Constr Of Customer POJO");
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@Column(length = 50)
	private String name;            
	
	@Column(unique = true,length = 30)
	private String email;            
	
	@Column(length = 10)
	private String phone;          
	
	private String gender;               
	
	private LocalDate dob;             
	
	private String address;          
	
	@Column(unique = true, length = 16)
	private String password; 
	
	private String role;

	@OneToMany(mappedBy = "cust",cascade = CascadeType.ALL,orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	private List<Booking> bookings = new ArrayList<>();
	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
