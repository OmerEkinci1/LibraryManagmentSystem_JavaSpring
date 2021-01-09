package com.jrp.lmo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jrp.lmo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Override
	public List<User> findAll();
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email);
}
