package com.jrp.lmo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.lmo.dao.YazarRepository;
import com.jrp.lmo.entities.Yazar;

@Controller
@RequestMapping("/yazar")
public class YazarController {
	
	@Autowired
	YazarRepository yazarRepo;
	
	@GetMapping("/list")
	public String displayAuthor(Model model) {
		List<Yazar> yazar = yazarRepo.findAll();
		model.addAttribute("yazar", yazar);
		
		return "/yazar/list-author";
	}
	
	@GetMapping("/new")
	public String displayAuthorForm(Model model) {
		
		Yazar aYazar = new Yazar();
		model.addAttribute("yazar", aYazar);
		
		return "/yazar/new-author";
	}
	
	@DeleteMapping("yazar/{yazarId}")
	public Map<String, Boolean> deleteBook(@PathVariable(value="yazarId") long yazarId) throws Exception {
		Yazar yazar = yazarRepo.findById(yazarId).orElseThrow(() -> new Exception("Author not found for this id ::"+ yazarId));
		
		yazarRepo.delete(yazar);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@PostMapping("/save")
	public String createAuthor(Model model, Yazar yazar) {
		// save to database using employee crud repos.
		yazarRepo.save(yazar);
		
		return "/yazar/list-author";
	}
	
	@GetMapping("/updateAuthor/{id}")
	public String updateAuthor(@PathVariable(value = "yazarId") long yazarId, Model model) {
		Optional<Yazar> yazar = yazarRepo.findById(yazarId);
		model.addAttribute("kitap", yazar);
		return "/yazar/update-author";
	}
	
	
	@GetMapping("/deleteAuthor/{id}")
	public String deleteAuthor(@PathVariable (value = "yazarId") long yazarId) {
		this.yazarRepo.deleteById(yazarId);
		return "/yazar/list-author";
	}

}
