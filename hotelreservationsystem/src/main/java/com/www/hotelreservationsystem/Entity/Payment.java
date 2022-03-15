package com.www.hotelreservationsystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Transient;

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
	@Column(name="room_service")
	private String roomService;
	@Column(name="payment_date")
	private String paymentDate;
	@Column(name="creditcard_no")
	private String creditcardNo;
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
	public String getRoomService() {
		return roomService;
	}
	public void setRoomService(String roomService) {
		this.roomService = roomService;
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
	




}
