package com.www.hotelreservationsystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.www.hotelreservationsystem.Entity.Guest;
import com.www.hotelreservationsystem.Entity.Hotel;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {

	
	List<Guest> findGuestByFirstNameAndLastName(String firstName, String lastName);

	List<Guest> findGuestByFirstNameOrLastName(String firstName, String lastName);

	List<Guest> findGuestById(String id);

	List<Guest> findGuestByFirstName(String firstName);

	List<Guest> findGuestByLastName(String lastName);

	List<Guest> findGuestByPhoneNo(String phoneNo);

	List<Guest> findGuestByEmail(String email);

	List<Guest> findGuestByPassword(String password);
	
//	List<Guest> getAllGuest();


}



