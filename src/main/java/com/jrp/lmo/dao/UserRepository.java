package com.jrp.lmo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrp.lmo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
