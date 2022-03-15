package com.www.hotelreservationsystem.Repository;

import java.util.List;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.www.hotelreservationsystem.Entity.Booking;
//import com.www.hotelreservationsystem.Entity.User;

public interface BookingRepository extends JpaRepository<Booking,Long> {

	

	List<Booking> findBookingByBookingDate(String bookingDate);

	List<Booking> findBookingByBookingTime(String bookingTime);

	List<Booking> findBookingById(List<Long> id);

	List<Booking> findBookingByNumAdults(String numAdults);

	List<Booking> findBookingByNumChildren(String numChildren);

	



}
