package com.jrp.lmo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@DeleteMapping("kitap/{kitapId}")
	public Map<String, Boolean> deleteBook(@PathVariable(value="kitapId") long kitapId) throws Exception {
		Kitap kitap = kitapRepo.findById(kitapId).orElseThrow(() -> new Exception("Book not found for this id ::"+ kitapId));
		
		kitapRepo.delete(kitap);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@PostMapping("/save")
	public String createBook(Model model, Kitap kitap) {
		// save to database using employee crud repos.
		kitapRepo.save(kitap);
		
		return "redirect:/kitap/list";
	}
}
