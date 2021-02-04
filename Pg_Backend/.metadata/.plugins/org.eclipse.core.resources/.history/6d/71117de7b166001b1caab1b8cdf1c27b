package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "pg_tbl")
@JsonInclude(Include.NON_DEFAULT)
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pg 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pg_id")
	private Integer pgId;             
	
	@Column(nullable = true)	
	private String pgName;
	
	@Column(nullable = true)
	private int roomCapacity;   
	
	@Column(nullable = true)
	private int pgRent;      
	
	@Column(nullable = true)
	private String pgFacilities; 
	
	@Column(nullable = true)
	private int nacRooms; 
	
	@Column(nullable = true)
	private int acRooms;    
	
	@Column(nullable = true)
	private int acAvail;
	
	@Column(nullable = true)
	private int nacAvail;
	
	@Column(nullable = true)
	private int pgDeposit;  
	
	@Column(nullable = true)
	private String status;

	@Column(length = 20)
	private String city;
	
	@Column(length = 20)
	private String state;
	
	@Column(length = 20)
	private String country;
	
	@Column(length = 10, unique = true)
	private String phoneNo;
	
	@Column(length = 20)
	private String landmark;
	
	@Column(length = 30)
	private String address;
	
	@Column(length = 30, unique = true)
	private String zipCode;
	
	@Column(nullable = true)
	private int noOfCustomers;
	
	@Column(nullable = true)
	private int totalBusiness;

	public Pg() 
	{
		System.out.println("In Constr Of Pg POJO");
	}

	public Pg( int roomCapacity, int pgRent, String pgFacilities, int nacRooms, int acRooms, int acAvail,
			int nacAvail, int pgDeposit, String status, String city, String state, String country, String phoneNo,
			String landmark, String address, int noOfCustomers, int totalBusiness) {
		super();
		this.roomCapacity = roomCapacity;
		this.pgRent = pgRent;
		this.pgFacilities = pgFacilities;
		this.nacRooms = nacRooms;
		this.acRooms = acRooms;
		this.acAvail = acAvail;
		this.nacAvail = nacAvail;
		this.pgDeposit = pgDeposit;
		this.status = status;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNo = phoneNo;
		this.landmark = landmark;
		this.address = address;
		this.noOfCustomers = noOfCustomers;
		this.totalBusiness = totalBusiness; 
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner_id",nullable = true)
	@JsonIgnore		//Uncomment If Required
	private Owner owner;
	
	
	@OneToMany(mappedBy = "bookedPg",cascade = CascadeType.ALL,orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	@JsonIgnore
	private List<Booking> allbookings = new ArrayList<>();
	
	public List<Booking> getAllbookings() {
		return allbookings;
	}

	public void setAllbookings(List<Booking> allbookings) {
		this.allbookings = allbookings;
	}
	
		public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPgId() {
		return pgId;
	}

	public void setPgId(Integer pgId) {
		this.pgId = pgId;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public int getPgRent() {
		return pgRent;
	}

	public void setPgRent(int pgRent) {
		this.pgRent = pgRent;
	}

	public String getPgFacilities() {
		return pgFacilities;
	}

	public void setPgFacilities(String pgFacilities) {
		this.pgFacilities = pgFacilities;
	}

	public int getNacRooms() {
		return nacRooms;
	}

	public void setNacRooms(int nacRooms) {
		this.nacRooms = nacRooms;
	}

	public int getAcRooms() {
		return acRooms;
	}

	public void setAcRooms(int acRooms) {
		this.acRooms = acRooms;
	}

	public int getAcAvail() {
		return acAvail;
	}

	public void setAcAvail(int acAvail) {
		this.acAvail = acAvail;
	}

	public int getNacAvail() {
		return nacAvail;
	}

	public void setNacAvail(int nacAvail) {
		this.nacAvail = nacAvail;
	}

	public int getPgDeposit() {
		return pgDeposit;
	}

	public void setPgDeposit(int pgDeposit) {
		this.pgDeposit = pgDeposit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPgName() {
		return pgName;
	}

	public void setPgName(String pgName) {
		this.pgName = pgName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public void addBooking(Booking b)
	{
		//p ---> c
		allbookings.add(b);
		b.setBookedPg(this);//c ---> p
	}
	
	public void removeBooking(Booking b)
	{
		allbookings.remove(b);
		b.setBookedPg(null);
	}
	
	public int getNoOfCustomers() {
		return noOfCustomers;
	}

	public void setNoOfCustomers(int noOfCustomers) {
		this.noOfCustomers = noOfCustomers;
	}

	public int getTotalBusiness() {
		return totalBusiness;
	}

	public void setTotalBusiness(int totalBusiness) {
		this.totalBusiness = totalBusiness;
	}

	@Override
	public String toString() {
		return "Pg [pgId=" + pgId + ", pgName=" + pgName + ", roomCapacity=" + roomCapacity + ", pgRent=" + pgRent
				+ ", pgFacilities=" + pgFacilities + ", nacRooms=" + nacRooms + ", acRooms=" + acRooms + ", acAvail="
				+ acAvail + ", nacAvail=" + nacAvail + ", pgDeposit=" + pgDeposit + ", status=" + status + ", city="
				+ city + ", state=" + state + ", country=" + country + ", phoneNo=" + phoneNo + ", landmark=" + landmark
				+ ", address=" + address + ", zipCode=" + zipCode +", noOfCustomers=" + noOfCustomers +", totalBusiness=" + totalBusiness + "]";
	}
	

}
