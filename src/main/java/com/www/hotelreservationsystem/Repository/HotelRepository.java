package com.www.hotelreservationsystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.www.hotelreservationsystem.Entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

	List<Hotel> findHotelByHotelName(String hotelName);

	List<Hotel> findHotelByAddress(String address);

	List<Hotel> findHotelByCity(String city);

	List<Hotel> findHotelByCountry(String country);

	List<Hotel> findHotelByState(String state);

	List<Hotel> findAllHotels(String hotels);

	

}


