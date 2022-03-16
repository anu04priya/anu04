package com.www.hotelreservationsystem.ServiceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.www.hotelreservationsystem.Entity.Booking;
import com.www.hotelreservationsystem.Exception.ResourceNotFound;
import com.www.hotelreservationsystem.Repository.BookingRepository;
import com.www.hotelreservationsystem.Service.BookingService;


@Service
public class BookingServiceImpl  implements BookingService{
	
	private BookingRepository bookingRepository;
	
	
	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}


	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	
	
	@Override
	public List<Booking>getAllBooking(){
		return bookingRepository.findAll();
	}
	
	@Override
	public Booking getBookingById(long id) {
		Optional<Booking>booking = bookingRepository.findById(id);
		if(booking.isPresent()) {
			return booking.get();
		}
		else {
			throw new ResourceNotFound("Booking","Id",id);
			
		}
	}

	@Override
	public Booking updateBooking(Booking booking,long id) {
		Booking book = new Booking();
		try {
			book = bookingRepository.findById(id).orElseThrow(   ()->  new ResourceNotFound("Booking","Id",id));
		} catch(ResourceNotFound e) {
			e.printStackTrace();
		}
		
		book.setBookingDate(booking.getBookingDate());
		book.setBookingTime(booking.getBookingTime());
		book.setNumAdults(booking.getNumAdults());
		book.setNumChildren(booking.getNumChildren());
		bookingRepository.save(book);
		return book;
		

}

	@Override
	public List<Booking> getBookingByBookingDate(String bookingDate) {
		return bookingRepository.findBookingByBookingDate(bookingDate);
	}

	@Override
	public List<Booking> getBookingByBookingTime(String bookingTime) {
		return bookingRepository.findBookingByBookingTime(bookingTime);
	}

	/*@Override
	public List<Booking> getBookingById(List<Long> id) {
		return bookingRepository.findBookingById(id);
	}
*/
	@Override
	public List<Booking> getBookingByNumAdults(String numAdults) {
		return bookingRepository.findBookingByNumAdults(numAdults);
	}

	@Override
	public List<Booking> getBookingByNumChildren(String numChildren) {
		return bookingRepository.findBookingByNumChildren(numChildren);
	}

	
	
}
