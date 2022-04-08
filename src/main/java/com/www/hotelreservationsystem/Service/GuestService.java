package com.www.hotelreservationsystem.Service;

import java.util.List;

import com.www.hotelreservationsystem.Entity.Guest;

public interface GuestService {

	Guest saveGuest(Guest guest);

	Guest getGuestById(long id);

	List<Guest> getGuestByFirstName(String firstName);

	List<Guest> getGuestByLastName(String lastName);

	List<Guest> getGuestByFirstNameAndLastName(String firstName, String lastName);

	List<Guest> getGuestByFirstNameOrLastName(String firstName, String lastName);

	Guest updateGuest(Guest guest, long id);

	void deleteGuest(long id);

	List<Guest> getGuestById(String id);


	//List<Guest> getGuestByPassword(String password);

	List<Guest> getGuestByPhoneNo(String phoneNo);

	List<Guest> getGuestByEmail(String email);

	//List<Guest> getAllGuest();

	List<Guest> getGuestByPassword(String password);

	List<Guest> getAllGuest();

	//List<Guest> getGuestByGuests(String guests);

	//List<Guest> getAllGuests();

	
	
	

	
	
}
