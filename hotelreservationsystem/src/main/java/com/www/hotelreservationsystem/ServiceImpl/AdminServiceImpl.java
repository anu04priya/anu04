package com.www.hotelreservationsystem.ServiceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.www.hotelreservationsystem.Entity.Admin;
//import com.www.hotelreservationsystem.Entity.User;
import com.www.hotelreservationsystem.Exception.ResourceNotFound;
import com.www.hotelreservationsystem.Repository.AdminRepository;
//import com.www.hotelreservationsystem.Repository.UserRepository;
import com.www.hotelreservationsystem.Service.AdminService;
//import com.www.hotelreservationsystem.Service.UserService;


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
		Admin adm = new Admin();
		try {
			adm = adminRepository.findById(id).orElseThrow(   ()->  new ResourceNotFound("Admin","Id",id));
		} catch(ResourceNotFound e) {
			e.printStackTrace();
		}
		
		adm.setUsername(admin.getUsername());
		adm.setPassword(admin.getPassword());
		adm.setConfirmPassword(admin.getConfirmPassword());
		adminRepository.save(adm);
		return adm;
		
	}

	@Override
	public List<Admin> getAdminByUserName(String userName) {
		return adminRepository.findAdminByUserName(userName);
	}

	@Override
	public List<Admin> getAdminById(List<Long> id) {
		return adminRepository.findAdminId(id);
	}

	/*@Override
	public List<Admin> getAdminById() {
		// TODO Auto-generated method stub
		return null;
	}
	*/

	@Override
	public List<Admin> getAdminByPassword(String password) {
		return adminRepository.findAdminByPassword(password);
	}

}


