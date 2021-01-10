package com.jrp.lmo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrp.lmo.dao.KitapRepository;
import com.jrp.lmo.dao.UserRepository;
import com.jrp.lmo.dao.YayineviRepository;
import com.jrp.lmo.dao.YazarRepository;
import com.jrp.lmo.entities.Kitap;
import com.jrp.lmo.entities.User;
import com.jrp.lmo.entities.Yayınevi;
import com.jrp.lmo.entities.Yazar;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {
	
	@Autowired
	KitapRepository kitapRepo;
	
	@Autowired
	YazarRepository yazarRepo;
	
	@Autowired
	YayineviRepository yayıneviRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		
		List<Kitap> books = kitapRepo.findAll();
		model.addAttribute("booksList",books);
		
		List<Yazar> authors = yazarRepo.findAll();
		model.addAttribute("authorsList",authors);
		
		List<Yayınevi> yayinevi = yayıneviRepo.findAll();
		model.addAttribute("yayineviList",yayinevi);
		
		return "main/home";
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		
		return "users/register";
	}
	
	@PostMapping("/process_register")
	public String processRegisteration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		return "users/register_success";
	}
	

}
