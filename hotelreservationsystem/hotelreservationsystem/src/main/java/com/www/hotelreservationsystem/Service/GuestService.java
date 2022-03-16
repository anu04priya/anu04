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

//	List<Guest> getGuestById(List<Long> id);

	Guest updateGuest(Guest guest, long id);

	List<Guest> getAllGuest();

	void deleteGuest(long id);

	List<Guest> getGuestById(String id);

	
	

	
	
}
