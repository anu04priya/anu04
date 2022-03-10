package com.www.hotelreservationsystem.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.www.hotelreservationsystem.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
