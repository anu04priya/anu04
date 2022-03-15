package com.www.hotelreservationsystem.ServiceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.www.hotelreservationsystem.Entity.Hotel;
//import com.www.hotelreservationsystem.Entity.User;
import com.www.hotelreservationsystem.Exception.ResourceNotFound;
import com.www.hotelreservationsystem.Repository.HotelRepository;
//import com.www.hotelreservationsystem.Repository.UserRepository;
import com.www.hotelreservationsystem.Service.HotelService;
//import com.www.hotelreservationsystem.Service.UserService;


@Service
public class HotelServiceImpl  implements HotelService{
	
	private HotelRepository hotelRepository;
	
	public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}
	
	@Override
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	
	@Override
	public List<Hotel>getAllHotel(){
		return hotelRepository.findAll();
	}
	
	@Override
	public Hotel getHotelById(long id) {
		Optional<Hotel>hotel = hotelRepository.findById(id);
		if(hotel.isPresent()) {
			return hotel.get();
		}
		else {
			throw new ResourceNotFound("Hotel","Id",id);
			
		}
	}
	@Override
	public Hotel updateHotel(Hotel hotel,long id) {
		Hotel hot = new Hotel();
		try {
			hot = hotelRepository.findById(id).orElseThrow(   ()->  new ResourceNotFound("Hotel","Id",id));
		} catch(ResourceNotFound e) {
			e.printStackTrace();
		}
		
		hot.setHotelname(hotel.getHotelname());
		hot.setAddress(hotel.getAddress());
		hot.setCity(hotel.getCity());
		hot.setCountry(hotel.getCountry());
		hot.setState(hotel.getState());
		hotelRepository.save(hot);
		return hot;
		
	}

	@Override
	public List<Hotel> getHotelByHotelName(String hotelName) {
		return hotelRepository.findHotelByHotelName(hotelName);
	}

	@Override
	public List<Hotel> geHotelByAddress(String address) {
		return  hotelRepository.findHotelByAddress(address);
	}

	@Override
	public List<Hotel> geHotelByCity(String city) {
		return hotelRepository.findHotelByCity(city) ;
	}

	@Override
	public List<Hotel> geHotelByCountry(String country) {
		return hotelRepository.findHotelByCountry(country);
	}

	@Override
	public List<Hotel> geHotelByState(String state) {
		return hotelRepository.findHotelByState(state);
	}

}


