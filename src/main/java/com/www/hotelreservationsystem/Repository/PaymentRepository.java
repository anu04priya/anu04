package com.www.hotelreservationsystem.Repository;

import java.util.List;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.www.hotelreservationsystem.Entity.Payment;
//import com.www.hotelreservationsystem.Entity.User;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

	List<Payment> findPaymentByRoomCharge(String roomCharge);

	List<Payment> findPaymentByPaymentDate(String paymentDate);

	List<Payment> findPaymentByCreditcardNo(String creditcardNo);

	



}
