package com.www.hotelreservationsystem.Service;
import java.util.List;

import com.www.hotelreservationsystem.Entity.Booking;

public interface BookingService {
	Booking saveBooking(Booking Booking);
	List<Booking>getAllBooking();
	Booking updateBooking(Booking booking,long id);
	Booking getBookingById(long id);
	List<Booking> getBookingByBookingDate(String bookingDate);
	List<Booking> getBookingByBookingTime(String bookingTime);
	List<Booking> getBookingByNumAdults(String numAdults);
	List<Booking> getBookingByNumChildren(String numChildren);
	


}
