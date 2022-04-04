package com.www.hotelreservationsystem.ServiceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.www.hotelreservationsystem.Entity.Room;
//import com.www.hotelreservationsystem.Entity.User;
import com.www.hotelreservationsystem.Exception.ResourceNotFound;
//import com.www.hotelreservationsystem.Repository.AdminRepository;
import com.www.hotelreservationsystem.Repository.RoomRepository;
//import com.www.hotelreservationsystem.Repository.UserRepository;
//import com.www.hotelreservationsystem.Service.AdminService;
import com.www.hotelreservationsystem.Service.RoomService;
//import com.www.hotelreservationsystem.Service.UserService;


@Service
public class RoomServiceImpl  implements RoomService{
	
	private RoomRepository roomRepository;
	
	public RoomServiceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}
	
	@Override
	public Room saveRoom(Room room) {
		return roomRepository.save(room);
	}
	
	
	@Override
	public List<Room>getAllRoom(){
		return roomRepository.findAll();
	}
	
	@Override
	public Room getRoomById(long id) {
		Optional<Room>room = roomRepository.findById(id);
		if(room.isPresent()) {
			return room.get();
		}
		else {
			throw new ResourceNotFound("Room","Id",id);
			
		}
	}
	@Override
	public Room updateRoom(Room room,long id) {
		Room rom = new Room();
		try {
			rom = roomRepository.findById(id).orElseThrow(   ()->  new ResourceNotFound("Room","Id",id));
		} catch(ResourceNotFound e) {
			e.printStackTrace();
		}
		
		rom.setRoomNo(room.getRoomNo());
		rom.setRoomType(room.getRoomType());
		rom.setRoomPrice(room.getRoomPrice());
		roomRepository.save(rom);
		return rom;
		
	}


	@Override
	public List<Room> getRoomByRoomNo(String roomNo) {
		return roomRepository.findRoomByRoomNo(roomNo);
	}

	@Override
	public List<Room> getRoomByRoomType(String roomType) {
		return roomRepository.findRoomByRoomType(roomType);
	}

	@Override
	public List<Room> getRoomByRoomPrice(String roomPrice) {
		return roomRepository.findRoomByRoomPrice(roomPrice);
	}

	
}




