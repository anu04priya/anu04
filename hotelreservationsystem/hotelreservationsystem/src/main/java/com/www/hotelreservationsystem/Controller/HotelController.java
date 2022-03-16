package com.www.hotelreservationsystem.Controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.www.hotelreservationsystem.Entity.Hotel;
//import com.www.hotelreservationsystem.Entity.User;
import com.www.hotelreservationsystem.Service.HotelService;
//import com.www.hotelreservationsystem.Service.UserService;

@RestController
//@Controller
@RequestMapping("api/hotel")
public class HotelController {
	private HotelService hotelService;
	
	
	public HotelController(HotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}
	
	
	@PostMapping
	public ResponseEntity<Hotel>saveHotel(@RequestBody Hotel hotel){
		return new ResponseEntity<Hotel>(hotelService.saveHotel(hotel),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping
	public ResponseEntity<Hotel>gethotelById(@PathVariable("id")long id){
		return new ResponseEntity<Hotel>(hotelService.getHotelById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Hotel>updateHotel(@PathVariable("id")long id,@RequestBody Hotel hotel){
		return new ResponseEntity<Hotel>(hotelService.updateHotel(hotel,id),HttpStatus.OK);
	}
	
	/*
	@GetMapping
	public List<User>getAllUser()
	{
		return userService.getUserById();
	}
	*/
	
	@GetMapping("/hotelByHotelName/{hotelName}")
	public List<Hotel>getHotelByHotelName(@PathVariable("hotelName")String hotelName){
		return hotelService.getHotelByHotelName(hotelName);
	}

	@GetMapping("/hotelByAddress/{address}")
	public List<Hotel>getHotelByAddress(@PathVariable("address")String address){
		return hotelService.getHotelByAddress(address);
	}
	@GetMapping("/hotelByCity/{city}")
	public List<Hotel>getHotelByCity(@PathVariable("city")String city){
		return hotelService.getHotelByCity(city);
	}
	
	@GetMapping("/hotelByCountry/{country}")
	public List<Hotel>getHotelByCountry(@PathVariable("country")String country){
		return hotelService.getHotelByCountry(country);
	}
	
	@GetMapping("/hotelByState/{state}")
	public List<Hotel>getHotelByState(@PathVariable("state")String state){
		return hotelService.getHotelByState(state);
	}
	/*
	@GetMapping("/userByFirstNameAndLastName")
	public List<User>getUserByFirstNameAndLastName(@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName){
		
		return userService.getUserByFirstNameAndLastName(firstName,lastName);
	}

	@GetMapping("/userByFirstNameOrLastName")
	public List<User>getUserByFirstNameOrLastName(@RequestParam(name = "firstName")String firstName, @RequestParam(name = "lastName") String lastName){
		
		return userService.getUserByFirstNameOrLastName(firstName,lastName);
	}
	
	@GetMapping("/userByIds")
	public List<User>getUserByIds(@RequestParam(value = "id")List<Long>id){
		return userService.getUserById(id);
		
	}
	*/
	
}




