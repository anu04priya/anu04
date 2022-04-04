package com.www.hotelreservationsystem.Controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.www.hotelreservationsystem.Entity.Guest;
//import com.www.hotelreservationsystem.Entity.Admin;
import com.www.hotelreservationsystem.Entity.Room;
//import com.www.hotelreservationsystem.Entity.User;
//import com.www.hotelreservationsystem.Service.AdminService;
import com.www.hotelreservationsystem.Service.RoomService;

@RestController
@RequestMapping("api/room")
public class RoomController {
	private RoomService roomService;
	
	
	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	
	
	@PostMapping
	public ResponseEntity<Room>saveRoom(@RequestBody Room room){
		return new ResponseEntity<Room>(roomService.saveRoom(room),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping
	public ResponseEntity<Room>getRoomById(@PathVariable("id")long id){
		return new ResponseEntity<Room>(roomService.getRoomById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Room>updateRoom(@PathVariable("id")long id,@RequestBody Room room){
		return new ResponseEntity<Room>(roomService.updateRoom(room,id),HttpStatus.OK);
	}
	
	
	@GetMapping("/roomByRoomNo/{roomNo}")
	public List<Room>getRoomByRoomNo(@PathVariable("roomNo")String roomNo){
		return roomService.getRoomByRoomNo(roomNo);
	}

	@GetMapping("/roomByRoomType/{roomType}")
	public List<Room>getRoomByRoomType(@PathVariable("roomType")String roomType){
		return roomService.getRoomByRoomType(roomType);
	}
	@GetMapping("/roomByRoomPrice/{roomPrice}")
	public List<Room>getRoomByRoomPrice(@PathVariable("roomPrice")String roomPrice){
		return roomService.getRoomByRoomPrice(roomPrice);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteRoom(@PathVariable("id")long id){
		return new ResponseEntity<String>("Room record deleted",HttpStatus.OK);
	}
	
}








