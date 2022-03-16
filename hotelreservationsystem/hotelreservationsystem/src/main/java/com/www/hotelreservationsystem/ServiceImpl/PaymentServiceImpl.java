package com.www.hotelreservationsystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.www.hotelreservationsystem.Entity.Booking;
import com.www.hotelreservationsystem.Entity.Payment;
//import com.www.hotelreservationsystem.Entity.User;
import com.www.hotelreservationsystem.Exception.ResourceNotFound;
import com.www.hotelreservationsystem.Repository.BookingRepository;
import com.www.hotelreservationsystem.Repository.PaymentRepository;
//import com.www.hotelreservationsystem.Repository.UserRepository;
import com.www.hotelreservationsystem.Service.BookingService;
import com.www.hotelreservationsystem.Service.PaymentService;
//import com.www.hotelreservationsystem.Service.UserService;


@Service
public class PaymentServiceImpl  implements PaymentService{
	
	private PaymentRepository paymentRepository;
	
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		super();
		this.paymentRepository = paymentRepository;
	}
	
	@Override
	public Payment savePayment(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	
	@Override
	public List<Payment>getAllPayment(){
		return paymentRepository.findAll();
	}
	
	@Override
	public Payment getPaymentById(long id) {
		Optional<Payment>payment = paymentRepository.findById(id);
		if(payment.isPresent()) {
			return payment.get();
		}
		else {
			throw new ResourceNotFound("Payment","Id",id);
			
		}
	}

	@Override
	public Payment updatePayment(Payment payment,long id) {
		Payment pay = new Payment();
		try {
			pay = paymentRepository.findById(id).orElseThrow(   ()->  new ResourceNotFound("Payment","Id",id));
		} catch(ResourceNotFound e) {
			e.printStackTrace();
		}
		
		pay.setRoomCharge(payment.getRoomCharge());
		pay.setPaymentDate(payment.getPaymentDate());
		pay.setCreditcardNo(payment.getCreditcardNo());
		paymentRepository.save(pay);
		return pay;
		

}

	@Override
	public List<Payment> getPaymentByRoomCharge(String roomCharge) {
		return paymentRepository.findPaymentByRoomCharge(roomCharge) ;
	}

	@Override
	public List<Payment> gePaymentByPaymentDate(String paymentDate) {
		return paymentRepository.findPaymentByPaymentDate(paymentDate);
	}

	@Override
	public List<Payment> gePaymentByCreditcardNo(String creditcardNo) {
		return paymentRepository.findPaymentByCreditcardNo(creditcardNo);
	}
	
	
}





