package com.www.hotelreservationsystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.www.hotelreservationsystem.Entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {

	
	List<Guest> findGuestByFirstNameAndLastName(String firstName, String lastName);

	List<Guest> findGuestByFirstNameOrLastName(String firstName, String lastName);

	List<Guest> findGuestById(String id);

	List<Guest> findGuestByFirstName(String firstName);

	List<Guest> findGuestByLastName(String lastName);

	List<Guest> findAllGuests(String guests);

	//List<Guest> findGuestByPasword(String password);

	List<Guest> findGuestByPhoneNo(String phoneNo);

	List<Guest> findGuestByEmail(String email);

	List<Guest> findGuestByGuests(String guests);

	
	
}



