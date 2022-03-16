package com.www.hotelreservationsystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.www.hotelreservationsystem.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long> {

	List<Admin> findAdminByCustomerInfo(String customerInfo);

	List<Admin> findAdminByHotelInfo(String hotelInfo);

	List<Admin> findAdminByReservationRecord(String reservationRecord);

	

}
