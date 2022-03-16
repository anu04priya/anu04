package com.www.hotelreservationsystem.Repository;

import java.util.List;

//import java.util.List;
//import java.util.Optional;

//import java.util.List;
//import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.www.hotelreservationsystem.Entity.Room;


	public interface RoomRepository extends JpaRepository<Room,Long> {

		List<Room> findRoomByRoomNo(String roomNo);

		List<Room> findRoomByRoomType(String roomType);

		List<Room> findRoomByRoomPrice(String roomPrice);




	
	
}
