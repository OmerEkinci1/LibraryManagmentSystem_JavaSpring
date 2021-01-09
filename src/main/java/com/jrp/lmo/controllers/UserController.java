package com.jrp.lmo.controllers;

import java.util.List;

import com.jrp.lmo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.lmo.dao.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	@GetMapping("list-users")
	public String viewUsersList(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers",listUsers);
		
		return "users/list_users";
	}
}
