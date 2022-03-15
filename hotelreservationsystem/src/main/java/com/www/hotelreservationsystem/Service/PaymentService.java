package com.www.hotelreservationsystem.Service;

import java.util.List;

import com.www.hotelreservationsystem.Entity.Payment;



public interface PaymentService {

	
	Payment updatePayment = null;
	Payment savePayment(Payment payment);
	List<Payment>getAllPayment();
	Payment updatePayment(Payment payment,long id);
	Payment getPaymentById(long id);



}
