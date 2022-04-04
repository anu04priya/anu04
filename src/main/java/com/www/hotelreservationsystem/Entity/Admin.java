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
	@Column(name="num_reservation")
	private String numReservation;

	public long getId() {
		return id;
	}
	
@OneToOne
@JoinColumn(name="guest_id")
private Guest guest;


public Admin(long id, String customerInfo, String hotelInfo, String numReservation, Guest guest) {
	super();
	this.id = id;
	this.customerInfo = customerInfo;
	this.hotelInfo = hotelInfo;
	this.numReservation= numReservation;
	this.guest = guest;
}

public Admin() {
	
}

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

public String getNumReservation() {
	return numReservation;
}

public void setNumReservation(String numReservation) {
	this.numReservation = numReservation;
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
