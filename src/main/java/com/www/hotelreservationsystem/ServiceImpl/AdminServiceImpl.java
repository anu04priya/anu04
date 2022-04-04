package com.www.hotelreservationsystem.ServiceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.www.hotelreservationsystem.Entity.Admin;
import com.www.hotelreservationsystem.Exception.ResourceNotFound;
import com.www.hotelreservationsystem.Repository.AdminRepository;
import com.www.hotelreservationsystem.Service.AdminService;

@Service
public class AdminServiceImpl  implements AdminService{
	
	private AdminRepository adminRepository;
	
	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}
	
	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	
	@Override
	public List<Admin>getAllAdmin(){
		return adminRepository.findAll();
	}
	
	@Override
	public Admin getAdminById(long id) {
		Optional<Admin>admin = adminRepository.findById(id);
		if(admin.isPresent()) {
			return admin.get();
		}
		else {
			throw new ResourceNotFound("Admin","Id",id);
			
		}
	}

	@Override
	public Admin updateAdmin(Admin admin,long id) {
		Admin ad = new Admin();
		try {
			ad = adminRepository.findById(id).orElseThrow(   ()->  new ResourceNotFound("Admin","Id",id));
		} catch(ResourceNotFound e) {
			e.printStackTrace();
		}
		
		ad.setCustomerInfo(admin.getCustomerInfo());
		ad.setHotelInfo(admin.getHotelInfo());
		ad.setNumReservation(admin.getNumReservation());
		adminRepository.save(ad);
		return ad;
		

}

	@Override
	public List<Admin> getAdminByCustomerInfo(String customerInfo) {
		return adminRepository.findAdminByCustomerInfo(customerInfo);
	}

	@Override
	public List<Admin> getAdminByHotelInfo(String hotelInfo) {
		return adminRepository.findAdminByHotelInfo(hotelInfo);
	}
	@Override

	public List<Admin> getAdminByNumReservation(String numReservation) {
		return adminRepository.findAdminByNumReservation(numReservation);
	}

	
	

	
	
}




