package com.jrp.lmo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.lmo.dao.YayineviRepository;
import com.jrp.lmo.entities.Kitap;
import com.jrp.lmo.entities.Yayınevi;

@Controller
@RequestMapping("/publisher")
public class YayıneviController {
	
	@Autowired
	YayineviRepository yayıneviRepo;
	
	@GetMapping("/list")
	public String displayYayınevi(Model model) {
		List<Yayınevi> yayinevi = yayıneviRepo.findAll();
		model.addAttribute("yayınevi", yayinevi);
		
		return "/publishers/list-publisher";
	}
	
	@GetMapping("/new")
	public String displayYayıneviForm(Model model) {
		
		Yayınevi aYayinevi = new Yayınevi();
		model.addAttribute("yayinevi", aYayinevi);
		
		return "/publishers/new-publisher";
	}
	
	@DeleteMapping("publisher/{yayineviId}")
	public Map<String, Boolean> deleteBook(@PathVariable(value="yayineviId") long yayineviId) throws Exception {
		Yayınevi yayinevi = yayıneviRepo.findById(yayineviId).orElseThrow(() -> new Exception("Publisher Home not found for this id ::"+ yayineviId));
		
		yayıneviRepo.delete(yayinevi);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@PostMapping("/save")
	public String createBook(Model model, Yayınevi yayinevi) {
		yayıneviRepo.save(yayinevi);
		
		return "redirect:/publisher/list";
	}

}
