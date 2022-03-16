package com.www.hotelreservationsystem.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="adminTbl")
public class Admin {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="cus_info")
	private String customerInfo;
	@Column(name="hotel_info")
	private String hotelInfo;
	@Column(name="reservation_record")
	private String reservationRecord;

	public long getId() {
		return id;
	}
	
@OneToOne
@JoinColumn(name="guest_id")
private Guest guest;
public String getCustomerInfo() {
	return customerInfo;
}

public void setCustomerInfo(String customerInfo) {
	this.customerInfo = customerInfo;
}




public String getHotelInfo() {
	return hotelInfo;
}

public void setHotelInfo(String hotelInfo) {
	this.hotelInfo = hotelInfo;
}

public String getReservationRecord() {
	return reservationRecord;
}

public void setReservationRecord(String reservationRecord) {
	this.reservationRecord = reservationRecord;
}


public Guest getGuest() {
	return guest;
}

public void setGuest(Guest guest) {
	this.guest = guest;
}

public void setId(long id) {
	this.id = id;
}

	
	



}
