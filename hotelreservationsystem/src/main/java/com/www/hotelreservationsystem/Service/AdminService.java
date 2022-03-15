package com.www.hotelreservationsystem.Service;
import java.util.List;

import com.www.hotelreservationsystem.Entity.Admin;



public interface AdminService {
	
	Admin saveAdmin(Admin admin);
	List<Admin>getAllAdmin();
	Admin updateAdmin(Admin admin,long id);
	List<Admin> getAdminByUserName(String userName);
	List<Admin> getAdminById(List<Long> id);
	List<Admin> getAdminByPassword(String password);
	Admin getAdminById(long id);

}