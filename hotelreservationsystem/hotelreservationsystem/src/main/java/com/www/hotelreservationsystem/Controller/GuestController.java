package com.www.hotelreservationsystem.Controller;
import java.util.List;

//import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.www.hotelreservationsystem.Entity.Guest;
//import com.www.hotelreservationsystem.Entity.User;
import com.www.hotelreservationsystem.Service.GuestService;
//import com.www.hotelreservationsystem.Service.UserService;

@RestController
//@Controller
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
/*	
	@GetMapping("/guestByIds")
	public List<Guest>getGuestByIds(@RequestParam(value = "id")List<Long>id){
		return guestService.getGuestById(id);
		
	}
	
	*/
}





