package com.www.hotelreservationsystem.Controller;


import java.util.List;

//import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.www.hotelreservationsystem.Entity.Admin;
//import com.www.hotelreservationsystem.Entity.User;
import com.www.hotelreservationsystem.Service.AdminService;
//import com.www.hotelreservationsystem.Service.UserService;

@RestController
//@Controller
@RequestMapping("api/admin")
public class AdminController {
	private AdminService adminService;
	
	
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	
	@PostMapping
	public ResponseEntity<Admin>saveAdmin(@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping
	public ResponseEntity<Admin>getAdminById(@PathVariable("id")long id){
		return new ResponseEntity<Admin>(adminService.getAdminById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Admin>updateAdmin(@PathVariable("id")long id,@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin,id),HttpStatus.OK);
	}
	
	
/*	@GetMapping
	public List<Admin>getAllAdmin()
	{
		return adminService.getAdminById();
	}
	*/
	
	@GetMapping("/adminByUserName/{userName}")
	public List<Admin>getAdminByFirstName(@PathVariable("userName")String userName){
		return adminService.getAdminByUserName(userName);
	}

	@GetMapping("/adminByPassword/{password}")
	public List<Admin>getAdminByPassword(@PathVariable("password")String password){
		return adminService.getAdminByPassword(password);
	}
	/*
	@GetMapping("/adminByFirstNameAndLastName")
	public List<Admin>getAdminByFirstNameAndLastName(@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName){
		
		return adminService.getAdminByFirstNameAndLastName(firstName,lastName);
	}

	@GetMapping("/adminByFirstNameOrLastName")
	public List<Admin>getAdminByFirstNameOrLastName(@RequestParam(name = "firstName")String firstName, @RequestParam(name = "lastName") String lastName){
		
		return adminService.getAdminByFirstNameOrLastName(firstName,lastName);
	}
	*/
	@GetMapping("/adminByIds")
	public List<Admin>getAdminByIds(@RequestParam(value = "id")List<Long>id){
		return adminService.getAdminById(id);
		
	}
	
	
}






