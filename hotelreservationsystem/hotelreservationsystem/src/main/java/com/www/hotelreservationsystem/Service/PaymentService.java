package com.www.hotelreservationsystem.Service;

import java.util.List;

import com.www.hotelreservationsystem.Entity.Payment;



public interface PaymentService {

	
	
	Payment savePayment(Payment payment);
	List<Payment>getAllPayment();
	Payment updatePayment(Payment payment,long id);
	Payment getPaymentById(long id);
	List<Payment> getPaymentByRoomCharge(String roomCharge);
	List<Payment> gePaymentByPaymentDate(String paymentDate);
	List<Payment> gePaymentByCreditcardNo(String creditcardNo);



}
