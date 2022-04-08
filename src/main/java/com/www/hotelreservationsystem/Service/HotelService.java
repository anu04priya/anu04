package com.www.hotelreservationsystem.Service;
import java.util.List;

import com.www.hotelreservationsystem.Entity.Hotel;



public interface HotelService {

	
	Hotel saveHotel(Hotel hotel);
	List<Hotel>getAllHotel();
	Hotel updateHotel(Hotel hotel,long id);
	Hotel getHotelById(long id);
	List<Hotel> getHotelByHotelName(String hotelName);
	List<Hotel> getHotelByAddress(String address);
	List<Hotel> getHotelByCity(String city);
	List<Hotel> getHotelByCountry(String country);
	List<Hotel> getHotelByState(String state);
	//List<Hotel> getAllHotel();
	//List<Hotel> getAllHotel(String hotels);
	
}

