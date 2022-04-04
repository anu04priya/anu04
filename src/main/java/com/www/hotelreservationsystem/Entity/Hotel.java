package com.www.hotelreservationsystem.Entity;
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
import lombok.Data;

@Data
@Entity
@Table(name="hotelTbl")
public class Hotel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="hotel_name")
	private String hotelName;
	@Column(name="address")
	private String address;
	@Column
	private String city;
	@Column(name="country")
	private String country;
	@Column(name="state")
	private String state;
	

	@OneToOne
	@JoinColumn(name="room_id")
	private Room roomId ;
	
	
	
	public Hotel(long id, String hotelName, String address, String city, String country, String state, Room roomId) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.state = state;
		this.roomId = roomId;
	}

	public Hotel() {
		
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Room getRoomId() {
		return roomId;
	}

	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}

	
	
}


