package com.www.hotelreservationsystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//import com.www.hotelreservationsystem.Entity.Booking;
import com.www.hotelreservationsystem.Entity.Guest;
//import com.www.hotelreservationsystem.Entity.Payment;
//import com.www.hotelreservationsystem.Entity.User;
import com.www.hotelreservationsystem.Exception.ResourceNotFound;
//import com.www.hotelreservationsystem.Repository.BookingRepository;
import com.www.hotelreservationsystem.Repository.GuestRepository;
//import com.www.hotelreservationsystem.Repository.PaymentRepository;
//import com.www.hotelreservationsystem.Repository.UserRepository;
//import com.www.hotelreservationsystem.Service.BookingService;
import com.www.hotelreservationsystem.Service.GuestService;
//import com.www.hotelreservationsystem.Service.PaymentService;
//import com.www.hotelreservationsystem.Service.UserService;


@Service
public class GuestServiceImpl  implements GuestService{
	
	private GuestRepository guestRepository;
	
	public GuestServiceImpl(GuestRepository guestRepository) {
		super();
		this.guestRepository = guestRepository;
	}
	
	@Override
	public Guest saveGuest(Guest guest) {
		return guestRepository.save(guest);
	}
	
	
	@Override
	public List<Guest>getAllGuest(){
		return guestRepository.findAll();
	}
	
	@Override
	public Guest getGuestById(long id) {
		Optional<Guest>guest = guestRepository.findById(id);
		if(guest.isPresent()) {
			return guest.get();
		}
		else {
			throw new ResourceNotFound("Guest","Id",id);
			
		}
	}

	@Override
	public Guest updateGuest(Guest guest,long id) {
		Guest gue = new Guest();
		try {
			gue = guestRepository.findById(id).orElseThrow(   ()->  new ResourceNotFound("Guest","Id",id));
		} catch(ResourceNotFound e) {
			e.printStackTrace();
		}
		
		gue.setFirstName(guest.getFirstName());
		gue.setLastName(guest.getLastName());
		gue.setPassword(guest.getPassword());
		gue.setPhoneNo(guest.getPhoneNo());
		gue.setEmail(guest.getEmail());
		guestRepository.save(gue);
		return gue;
		

}
	
	@Override
	public void deleteGuest(long id) {
		
		guestRepository.findById(id).orElseThrow(
				()->new ResourceNotFound("Guest","Id",id));
		guestRepository.deleteById(id);
		
	}

	/*@Override
	public List<Guest> getGuestById() {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public List<Guest> getGuestByFirstName(String firstName) {
		return guestRepository.findGuestByFirstName(firstName);
	}

	@Override
	public List<Guest> getGuestByLastName(String lastName) {
		return guestRepository.findGuestByLastName(lastName); 
	}

	@Override
	public List<Guest> getGuestByFirstNameAndLastName(String firstName, String lastName) {
		return guestRepository.findGuestByFirstNameAndLastName(firstName,lastName);
	}

	@Override
	public List<Guest> getGuestByFirstNameOrLastName(String firstName, String lastName) {
		return  guestRepository.findGuestByFirstNameOrLastName(firstName,lastName);
	}
/*
	@Override
	public List<Guest> getGuestById(List<Long> id) {
		return guestRepository.findGuestById(id);
	}
*/
	@Override
	public List<Guest> getGuestById(String id) {
		return guestRepository.findGuestById(id);
	}

}