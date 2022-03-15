package com.www.hotelreservationsystem.Repository;
//import java.util.Optional;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.www.hotelreservationsystem.Entity.Admin;
//import com.www.hotelreservationsystem.Entity.User;

public interface AdminRepository extends JpaRepository<Admin,Long> {

	
	List<Admin> findAll();

	List<Admin> findAdminByUserName(String userName);

	List<Admin> findAdminId(List<Long> id);

	List<Admin> findAdminByPassword(String password);

	

	
	

}

