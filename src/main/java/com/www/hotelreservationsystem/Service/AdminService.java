package com.www.hotelreservationsystem.Service;

import java.util.List;

import com.www.hotelreservationsystem.Entity.Admin;

public interface AdminService {

	Admin saveAdmin(Admin admin);

	Admin getAdminById(long id);

	Admin updateAdmin(Admin admin, long id);

	List<Admin> getAllAdmin();

	List<Admin> getAdminByCustomerInfo(String customerInfo);

	List<Admin> getAdminByHotelInfo(String hotelInfo);

	List<Admin> getAdminByNumReservation(String numReservation);

}
