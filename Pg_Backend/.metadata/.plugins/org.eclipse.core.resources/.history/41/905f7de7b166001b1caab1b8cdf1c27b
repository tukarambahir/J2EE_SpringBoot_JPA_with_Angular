package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "booking_tbl")
public class Booking 
{
	public Booking() 
	{
		System.out.println("In Constr Of Booking");
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Integer bookingId;         
	/*int CustomerId;*/            
	/*int PgId;*/             
	
	private String confirmationStatus;
	
	private LocalTime checkInTime;       
	
	private LocalDate checkInDate;       
	
	private LocalTime checkOutTime;     
	
	private LocalDate checkOutDate;      
	
	private String roomType;
	
	private int noOfBookings;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id",nullable = true)
	@JsonIgnore		//If uncommented gets Lazy Init for Pg
	private Customer cust;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pg_booked_id",nullable = true)
	private Pg bookedPg;
	
	public Booking(int bookingId, String confirmationStatus, LocalTime checkInTime, LocalDate checkInDate,
			LocalTime checkOutTime, LocalDate checkOutDate, String roomType, int noOfBookings) 
	{
		super();
		this.bookingId = bookingId;
		this.confirmationStatus = confirmationStatus;
		this.checkInTime = checkInTime;
		this.checkInDate = checkInDate;
		this.checkOutTime = checkOutTime;
		this.checkOutDate = checkOutDate;
		this.roomType = roomType;
		this.noOfBookings = noOfBookings;
	}

	public Pg getBookedPg() {
		return bookedPg;
	}

	public void setBookedPg(Pg bookedPg) {
		this.bookedPg = bookedPg;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getConfirmationStatus() {
		return confirmationStatus;
	}

	public void setConfirmationStatus(String confirmationStatus) {
		this.confirmationStatus = confirmationStatus;
	}

	public LocalTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public int getNoOfBookings() {
		return noOfBookings;
	}

	public void setNoOfBookings(int noOfBookings) {
		this.noOfBookings = noOfBookings;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", confirmationStatus=" + confirmationStatus + ", checkInTime="
				+ checkInTime + ", checkInDate=" + checkInDate + ", checkOutTime=" + checkOutTime + ", checkOutDate="
				+ checkOutDate + ", roomType=" + roomType + ", noOfBookings=" + noOfBookings + "]";
	}

	

		
}
