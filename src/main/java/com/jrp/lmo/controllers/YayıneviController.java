package com.jrp.lmo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.lmo.dao.YayineviRepository;
import com.jrp.lmo.entities.Yayınevi;

@Controller
@RequestMapping("/yayınevi")
public class YayıneviController {
	
	@Autowired
	YayineviRepository yayıneviRepo;
	
	@GetMapping("/list")
	public String displayYayınevi(Model model) {
		List<Yayınevi> yayınevi = (List<Yayınevi>) yayıneviRepo.findAll();
		model.addAttribute("yayınevi", yayınevi);
		
		return "/yayınevi/list-yayınevi";
	}
	
	@GetMapping("/new")
	public String displayYayıneviForm(Model model) {
		
		Yayınevi aYayınevi = new Yayınevi();
		model.addAttribute("yayınevi", aYayınevi);
		
		return "/yayınevi/new-yayınevi";
	}
	
	@PostMapping("/save")
	public String createBook(Model model, Yayınevi yayınevi) {
		// save to database using employee crud repos.
		yayıneviRepo.save(yayınevi);
		
		return "redirect:/yayınevi/new";
	}

}
