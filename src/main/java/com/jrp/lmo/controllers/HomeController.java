package com.jrp.lmo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.jrp.lmo.dao.KitapRepository;
import com.jrp.lmo.dao.YayineviRepository;
import com.jrp.lmo.dao.YazarRepository;
import com.jrp.lmo.entities.Kitap;
import com.jrp.lmo.entities.Yayınevi;
import com.jrp.lmo.entities.Yazar;

@Controller
public class HomeController {
	
	@Autowired
	KitapRepository kitapRepo;
	
	@Autowired
	YazarRepository yazarRepo;
	
	@Autowired
	YayineviRepository yayıneviRepo;
	
	public String displayHome(Model model) {
		
		List<Kitap> books = (List<Kitap>) kitapRepo.findAll();
		model.addAttribute("booksList",books);
		
		List<Yazar> authors = (List<Yazar>) yazarRepo.findAll();
		model.addAttribute("authorsList",authors);
		
		List<Yayınevi> yayınevi = (List<Yayınevi>) yayıneviRepo.findAll();
		model.addAttribute("yayıneviList",yayınevi);
		
		return "main/home";
	}

}
