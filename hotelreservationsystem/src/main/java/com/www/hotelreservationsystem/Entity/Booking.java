package com.www.hotelreservationsystem.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="bookingTbl")
public class Booking {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="booking_date")
	private String bookingDate;
	@Column(name="booking_time")
	private String bookingTime;
	@Transient
	private String numAdults;
	@Transient
	private String numChildren;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getNumAdults() {
		return numAdults;
	}
	public void setNumAdults(String numAdults) {
		this.numAdults = numAdults;
	}
	public String getNumChildren() {
		return numChildren;
	}
	public void setNumChildren(String numChildren) {
		this.numChildren = numChildren;
	}
	
	



}
