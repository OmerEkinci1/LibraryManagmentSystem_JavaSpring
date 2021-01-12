package com.jrp.lmo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrp.lmo.dao.KitapRepository;
import com.jrp.lmo.entities.Kitap;

@Controller
@RequestMapping("/kitap")
public class KitapController {	
	
	@Autowired
	KitapRepository kitapRepo;
	
	
	@GetMapping("/list")
	public String displayBooks(Model model) {
		List<Kitap> kitap = kitapRepo.findAll();
		model.addAttribute("kitap", kitap);
		
		return "/kitap/list-book";
	}

	
	@GetMapping("/new")
	public String displayBookForm(Model model) {
		
		Kitap aBook = new Kitap();
		model.addAttribute("kitap", aBook);
		
		return "/kitap/new-book";
	}
	
	@PostMapping("/save")
	public String createBook(Model model,Kitap kitap) {
		// save to database using employee crud repos.
		kitapRepo.save(kitap);
		
		return "/kitap/list-book";
	}
	
	@GetMapping("/updateBook/{id}")
	public String updateBook(@PathVariable(value = "kitapId") long kitapId, Model model) {
		Optional<Kitap> kitap = kitapRepo.findById(kitapId);
		model.addAttribute("kitap", kitap);
		return "/kitap/update-book";
	}
	
	
	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable (value = "kitapId") long kitapId) {
		this.kitapRepo.deleteById(kitapId);
		return "/kitap/list-book";
	}
	
}
