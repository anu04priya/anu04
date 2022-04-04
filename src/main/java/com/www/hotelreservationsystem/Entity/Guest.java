package com.www.hotelreservationsystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="guestTbl")
public class Guest {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	/*@Column(name="password")
	private String password;*/
	@Column(name="phone_no")
	private String phoneNo;
	@Column(name="email")
	private String email;
	
	@OneToOne
	@JoinColumn(name="booking_id")
	private Booking bookingId ;
	

	public Guest(long id, String firstName, String lastName, String phoneNo, String email,
			Booking bookingId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		//this.password = password;
		this.phoneNo = phoneNo;
		this.email = email;
		this.bookingId = bookingId;
	}
	public Guest() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Booking getBookingId() {
		return bookingId;
	}
	public void setBooking(Booking bookingId) {
		this.bookingId = bookingId;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
/*	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}*/
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 
	

	
}
