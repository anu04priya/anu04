package com.www.hotelreservationsystem.Service;
import java.util.List;

import com.www.hotelreservationsystem.Entity.Room;



public interface RoomService {

	
	Room updateAdmin = null;
	Room updateUser = null;
	Room updateRoom = null;
	
	Room saveRoom(Room room);
	List<Room>getAllRoom();
	Room updateRoom(Room room,long id);
	Room getRoomById(long id);

}

