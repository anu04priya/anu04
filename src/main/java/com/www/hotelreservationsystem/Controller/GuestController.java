package com.www.hotelreservationsystem.Controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.www.hotelreservationsystem.Entity.Guest;
import com.www.hotelreservationsystem.Service.GuestService;


@RestController
@RequestMapping("api/guest")
public class GuestController {
	private GuestService guestService;
	
	
	public GuestController(GuestService guestService) {
		super();
		this.guestService = guestService;
	}
	
	
	@PostMapping
	public ResponseEntity<Guest>saveGuest(@RequestBody Guest guest){
		return new ResponseEntity<Guest>(guestService.saveGuest(guest),HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Guest>getGuestById(@PathVariable("id")long id){
		return new ResponseEntity<Guest>(guestService.getGuestById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Guest>updateGuest(@PathVariable("id")long id,@RequestBody Guest guest){
		return new ResponseEntity<Guest>(guestService.updateGuest(guest,id),HttpStatus.OK);
	}
	
	@GetMapping("/guestByFirstName/{firstName}")
	public List<Guest>getGuestByFirstName(@PathVariable("firstName")String firstName){
		return guestService.getGuestByFirstName(firstName);
	}

	@GetMapping("/guestByLastName/{lastName}")
	public List<Guest>getGuestByLastName(@PathVariable("lastName")String lastName){
		return guestService.getGuestByLastName(lastName);
	}
	
	@GetMapping("/guestByFirstNameAndLastName")
	public List<Guest>getGuestByFirstNameAndLastName(@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName){
		
		return guestService.getGuestByFirstNameAndLastName(firstName,lastName);
	}

	@GetMapping("/guestByFirstNameOrLastName")
	public List<Guest>getGuestByFirstNameOrLastName(@RequestParam(name = "firstName")String firstName, @RequestParam( "lastName") String lastName){
		return guestService.getGuestByFirstNameOrLastName(firstName,lastName);
	}
	
	@GetMapping("/guestByPhoneNo/{phoneNo}")
	public List<Guest>getGuestByPhoneNo(@PathVariable("phoneNo")String phoneNo){
		return guestService.getGuestByPhoneNo(phoneNo);
	}
	@GetMapping("/guestByEmail/{email}")
	public List<Guest>getGuestByEmail(@PathVariable("email")String email){
		return guestService.getGuestByEmail(email);
	}
	@GetMapping("/guestByPassword/{password}")
	public List<Guest>getGuestByPassword(@PathVariable("password")String password){
		return guestService.getGuestByPassword(password);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteGuest(@PathVariable("id")long id){
		return new ResponseEntity<String>("Guest record deleted",HttpStatus.OK);
	}

}





