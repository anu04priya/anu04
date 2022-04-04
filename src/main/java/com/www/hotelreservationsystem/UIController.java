package com.www.hotelreservationsystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.www.hotelreservationsystem.Entity.Admin;
import com.www.hotelreservationsystem.Entity.Booking;
import com.www.hotelreservationsystem.Entity.Guest;
import com.www.hotelreservationsystem.Entity.Hotel;
import com.www.hotelreservationsystem.Entity.Payment;
import com.www.hotelreservationsystem.Entity.Room;
import com.www.hotelreservationsystem.Service.AdminService;
import com.www.hotelreservationsystem.Service.BookingService;
import com.www.hotelreservationsystem.Service.GuestService;
import com.www.hotelreservationsystem.Service.HotelService;
import com.www.hotelreservationsystem.Service.PaymentService;
import com.www.hotelreservationsystem.Service.RoomService;

@Controller
public class UIController {
	
	private GuestService guestService;
	private HotelService hotelService;
	private BookingService bookingService;
	private AdminService adminService;
	private RoomService roomService;
	private PaymentService paymentService;
	
@Autowired	
public UIController(GuestService guestService, HotelService hotelService,
			BookingService bookingService, AdminService adminService, RoomService roomService,PaymentService paymentService) {
		super();
		this.guestService = guestService;
		this.hotelService = hotelService;
		this.bookingService = bookingService;
		this.adminService = adminService;
		this.roomService = roomService;
		this.paymentService = paymentService;
		}

@GetMapping("/")
	
	public String index(Model model) {
		return "index";/// index.html
	}

// Guest 
@GetMapping("/registration")
public String gueRegistrationForm(Model model) {
	Guest guest = new Guest();
	model.addAttribute("guest", guest);
    return "add-guest";
}

@PostMapping("/saveGuest")
public String saveGuest(@Validated  Guest guest, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "/getGuests";
	else {
    guestService.saveGuest(guest);
	List<Guest> guests =  guestService.getAllGuest();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "/getGuests";
    
}

@GetMapping("/getGuests")
public String getAllGuest(Model model) {
	
	List<Guest> guests =  guestService.getAllGuest();
	
	model.addAttribute("guests", guests);
	
    return "list-guest";
    }



//Hotel
@GetMapping("/hotelRegister")
public String hotelRegistrationForm(Model model) {
	Hotel hotel = new Hotel();
	model.addAttribute("hotel", hotel);
    return "add-hotel";
}

@PostMapping("/savehotel")
public String addhotel(@Validated  Hotel hotel, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "add-hotel";
	else {
    hotelService.saveHotel(hotel);
    List<Hotel> hotels =  hotelService.getAllHotel();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/getHotels";
}
    @GetMapping("/gethotels")
    public String getAllHotel(Model model) {
    	
    	List<Hotel> hotels =  hotelService.getAllHotel();
    	
    	model.addAttribute("hotels", hotels);
    	
        return "list-hotel";
        }
    
    
  //booking  
    @GetMapping("/bookingRegister")
    public String bookingRegistrationForm(Model model) {
    	Booking booking = new Booking();
    	model.addAttribute("booking", booking);
        return "add-booking";
    }

    @PostMapping("/savebooking")
    public String addbooking(@Validated  Booking booking, Errors errors, Model model) {
    	if(null != errors && errors.getErrorCount() > 0)
    		return "add-booking";
    	else {
        bookingService.saveBooking(booking);
        model.addAttribute("successMessage", "Details are saved successfully");
    	}
        return "redirect:/getbookings";
    }
        @GetMapping("/getbookings")
        public String getAllBooking(Model model) {
        	
        	List<Booking> bookings =  bookingService.getAllBooking();
        	
        	model.addAttribute("bookings", bookings);
        	
            return "list-booking";
            }
        
 //admin       
        @GetMapping("/adminRegister")
        public String admRegistrationForm(Model model) {
        	Admin admin = new Admin();
        	model.addAttribute("admin", admin);
            return "add-admin";
        }

        @PostMapping("/saveadmin")
        public String addadmin(@Validated  Admin admin, Errors errors, Model model) {
        	if(null != errors && errors.getErrorCount() > 0)
        		return "add-admin";
        	else {
        		adminService.saveAdmin(admin);
        	    
        	    model.addAttribute("successMessage", "Details are saved successfully");
        	}
			return "redirct:/getadmins";
           
        }

        @GetMapping("/getAdmins")
        public String getAllAdmin(Model model) {
        	
        	List<Admin> admins =  adminService.getAllAdmin();
        	
        	model.addAttribute("admins", admins);
        	
            return "list-admin";
            }
        
//room           
       @GetMapping("/roomRegister")
        public String romRegistrationForm(Model model) {
        	Room room = new Room();
        	model.addAttribute("room", room);
            return "add-room";
        }

        @PostMapping("/saveRoom")
        public String saveRoom(@Validated  Room room, Errors errors, Model model) {
        	if(null != errors && errors.getErrorCount() > 0)
        		return "add-room";
        	else {
            roomService.saveRoom(room);
        	List<Room> rooms =  roomService.getAllRoom();
            model.addAttribute("successMessage", "Details are saved successfully");
        	}
            return "/getRooms";
            
        }

        @GetMapping("/getRooms")
        public String getAllRoom(Model model) {
        	
        	List<Room> rooms =  roomService.getAllRoom();
        	
        	model.addAttribute("rooms", rooms);
        	
            return "list-room";
            }

//payment
        @GetMapping("/paymentRegister")
        public String paymentRegistrationForm(Model model) {
        	Payment payment = new Payment();
        	model.addAttribute("payment", payment);
            return "add-payment";
        }

        @PostMapping("/savePayment")
        public String savePayment(@Validated  Payment payment, Errors errors, Model model) {
        	if(null != errors && errors.getErrorCount() > 0)
        		return "add-payment";
        	else {
            paymentService.savePayment(payment);
        	List<Payment> payments =  paymentService.getAllPayment();
            model.addAttribute("successMessage", "Details are saved successfully");
        	}
            return "redirect:/getPayments";
            
        }

        @GetMapping("/getPayments")
        public String getAllPayment(Model model) {
        	
        	List<Payment> payments =  paymentService.getAllPayment();
        	
        	model.addAttribute("payments", payments);
        	
            return "list-payment";
            }
    
}




