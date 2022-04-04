package com.www.hotelreservationsystem.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.www.hotelreservationsystem.Entity.Admin;
import com.www.hotelreservationsystem.Service.AdminService;


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
	public ResponseEntity<Admin>getadminById(@PathVariable("id")long id){
		return new ResponseEntity<Admin>(adminService.getAdminById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Admin>updateAdmin(@PathVariable("id")long id,@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin,id),HttpStatus.OK);
	}
	
	
	@GetMapping("/adminByCustomerInfo/{customerInfo}")
	public List<Admin>getAdminByCustomerInfo(@PathVariable("customerInfo")String customerInfo){
		return adminService.getAdminByCustomerInfo(customerInfo);
	}

	@GetMapping("/adminByHotelInfo/{hotelInfo}")
	public List<Admin>getAdminByHotelInfo(@PathVariable("hotelInfo")String hotelInfo){
		return adminService.getAdminByHotelInfo(hotelInfo);
	}
	@GetMapping("/adminByNumReservation/{numReservation}")
	public List<Admin>getAdminByReservationRecord(@PathVariable("numReservation")String numReservation){
		return adminService.getAdminByNumReservation(numReservation);
	}
	@DeleteMapping
	public ResponseEntity<String> deleteAdmin(@PathVariable("id")long id){
		return new ResponseEntity<String>("Admin record deleted",HttpStatus.OK);
	}
	

}
