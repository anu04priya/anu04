package com.www.hotelreservationsystem.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="paymentTbl")
public class Payment {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="room_charge")
	private String roomCharge;
	@Column(name="payment_date")
	private String paymentDate;
	@Column(name="creditcard_no")
	private String creditcardNo;
	
	
	@ManyToOne
	@JoinTable(name="payment_guest",joinColumns = { @JoinColumn(name = "guest_id")},inverseJoinColumns = {@JoinColumn(name="booking_id")})
	private Booking booking;


	public Payment(long id, String roomCharge, String paymentDate, String creditcardNo, Booking booking) {
		super();
		this.id = id;
		this.roomCharge = roomCharge;
		this.paymentDate = paymentDate;
		this.creditcardNo = creditcardNo;
		this.booking = booking;
	}
	
	
	public Payment() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getRoomCharge() {
		return roomCharge;
	}


	public void setRoomCharge(String roomCharge) {
		this.roomCharge = roomCharge;
	}


	public String getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}


	public String getCreditcardNo() {
		return creditcardNo;
	}


	public void setCreditcardNo(String creditcardNo) {
		this.creditcardNo = creditcardNo;
	}


	public Booking getBooking() {
		return booking;
	}


	public void setBookingId(Booking booking) {
		this.booking = booking;
	}
	
	
	
	
}