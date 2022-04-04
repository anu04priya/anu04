package com.www.hotelreservationsystem.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="roomTbl")
public class Room {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="room_no")
	private String roomNo;
	@Column(name="room_type")
	private String roomType;
	@Column(name="room_price")
	private String roomPrice;
	public long getId() {
		return id;
	}
	
	@ManyToOne
	@JoinTable(name="room_booking",joinColumns = { @JoinColumn(name = "hotel_id")},inverseJoinColumns = {@JoinColumn(name="payment_id")})
	private Payment paymentId;
	public Room(long id, String roomNo, String roomType, String roomPrice, Payment paymentId) {
		super();
		this.id = id;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.paymentId = paymentId;
	}
	
	public Room() {
		
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}

	public Payment getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Payment paymentId) {
		this.paymentId = paymentId;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	
}