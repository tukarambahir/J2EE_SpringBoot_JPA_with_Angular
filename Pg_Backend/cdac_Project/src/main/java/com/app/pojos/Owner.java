package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "owners_tbl")
@JsonInclude(Include.NON_DEFAULT)
@CrossOrigin

public class Owner 
{
	public Owner() 
	{
	System.out.println("In Constr Of Owner POJO");
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ownerId;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 10)
	private String phone;
	
	@Column(length = 20)
	private String email;
	
	@Column(length = 20)
	private String password;
	
	private String city;
	
	private String address;

	@OneToMany(mappedBy = "owner",cascade = CascadeType.ALL,orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	@JsonIgnore
	private List<Pg> pglist = new ArrayList<>();
	
	
	public Owner(String name, String phone, String email, String password, String city, String address) 
	{
		super();
		System.out.println("In constr Of Owner");
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.city = city;
		this.address = address;
	}
	

	public List<Pg> getPglist() {
		return pglist;
	}

	public void setPglist(List<Pg> pglist) {
		this.pglist = pglist;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void addPg(Pg p)
	{
		// bi dir association
		pglist.add(p);//adding parent --> child
		p.setOwner(this);//child ----> parent
		
	}
	//remove student details : bi dir
	public void removeStudent(Pg p)
	{
		// bi dir association
		pglist.remove(p);//removing parent --> child
		p.setOwner(null);//removing child ----> parent
		
	}


	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", name=" + name + ", phone=" + phone + ", email=" + email + ", password="
				+ password + ", city=" + city + ", address=" + address + "]";
	}

	
	
	
	
}
