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
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.www.hotelreservationsystem.Entity.Payment;
//import com.www.hotelreservationsystem.Entity.User;
import com.www.hotelreservationsystem.Service.PaymentService;
//import com.www.hotelreservationsystem.Service.UserService;

@RestController
//@Controller
@RequestMapping("api/payment")
public class PaymentController {
	private PaymentService paymentService;
	
	
	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	
	@PostMapping
	public ResponseEntity<Payment>savePayment(@RequestBody Payment payment){
		return new ResponseEntity<Payment>(paymentService.savePayment(payment),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping
	public ResponseEntity<Payment>getPaymentById(@PathVariable("id")long id){
		return new ResponseEntity<Payment>(paymentService.getPaymentById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Payment>updatePayment(@PathVariable("id")long id,@RequestBody Payment payment){
		return new ResponseEntity<Payment>(PaymentService.updatePayment,HttpStatus.OK);
	}

}