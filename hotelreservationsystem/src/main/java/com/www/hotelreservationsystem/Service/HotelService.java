package com.www.hotelreservationsystem.Service;
import java.util.List;

import com.www.hotelreservationsystem.Entity.Hotel;



public interface HotelService {

	
	Hotel saveHotel(Hotel hotel);
	List<Hotel>getAllHotel();
	Hotel updateHotel(Hotel hotel,long id);
	Hotel getHotelById(long id);
	List<Hotel> getHotelByHotelName(String hotelName);
	List<Hotel> geHotelByAddress(String address);
	List<Hotel> geHotelByCity(String city);
	List<Hotel> geHotelByCountry(String country);
	List<Hotel> geHotelByState(String state);
}

