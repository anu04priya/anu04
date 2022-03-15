package com.www.hotelreservationsystem.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String RoomNo;
	@Column(name="room_type")
	private String RoomType;
	@Column(name="room_price")
	private String RoomPrice;
	@Column(name="hotel_name")
	private String HotelName;
	public long getId() {
		return id;
	}
	public String getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(String roomno) {
		this.RoomNo = roomno;
	}
	public String getRoomType() {
		return RoomType;
	}
	public void setRoomType(String roomtype) {
		this.RoomType = roomtype;
	}
	public String getRoomPrice() {
		return RoomPrice;
	}
	public void setRoomPrice(String roomprice) {
		this.RoomPrice = roomprice;
	}
	public String getHotelName() {
		return HotelName;
	}
	public void setHotelName(String hotelname) {
		this.HotelName = hotelname;
	}
	 
}

