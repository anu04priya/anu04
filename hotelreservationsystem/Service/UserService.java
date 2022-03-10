package com.www.hotelreservationsystem.Service;

import java.util.List;

import com.www.hotelreservationsystem.Entity.User;



public interface UserService {

	
	User updateUser = null;
	User saveUser(User user);
	List<User>getAllUser();
	User updateUser(User user,long id);
	User getUserById(long id);
	
}
