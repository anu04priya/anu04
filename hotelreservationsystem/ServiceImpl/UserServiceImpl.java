package com.www.hotelreservationsystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.www.hotelreservationsystem.Entity.User;
import com.www.hotelreservationsystem.Exception.ResourceNotFound;
import com.www.hotelreservationsystem.Repository.UserRepository;
import com.www.hotelreservationsystem.Service.UserService;


@Service
public class UserServiceImpl  implements UserService{
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	
	@Override
	public List<User>getAllUser(){
		return userRepository.findAll();
	}
	
	@Override
	public User getUserById(long id) {
		Optional<User>user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			throw new ResourceNotFound("User","Id",id);
			
		}
	}
	@Override
	public User updateUser(User user,long id) {
		User usr = new User();
		try {
			usr = userRepository.findById(id).orElseThrow(   ()->  new ResourceNotFound("User","Id",id));
		} catch(ResourceNotFound e) {
			e.printStackTrace();
		}
		
		usr.setFirstname(user.getFirstname());
		usr.setLastname(user.getLastname());
		usr.setEmail(user.getEmail());
		userRepository.save(usr);
		return usr;
		
	}
	

}
