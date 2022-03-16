package com.www.hotelreservationsystem.Service;
import java.util.List;

import com.www.hotelreservationsystem.Entity.Room;



public interface RoomService {

	
	
	Room saveRoom(Room room);
	List<Room>getAllRoom();
	Room updateRoom(Room room,long id);
	Room getRoomById(long id);
	List<Room> getRoomByRoomNo(String roomNo);
	List<Room> getRoomByRoomType(String roomType);
	List<Room> getRoomByRoomPrice(String roomPrice);

}

