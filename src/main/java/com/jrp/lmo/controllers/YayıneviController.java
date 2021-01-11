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

import com.jrp.lmo.dao.YayineviRepository;
import com.jrp.lmo.entities.Yayınevi;

@Controller
@RequestMapping("/publisher")
public class YayıneviController {
	
	@Autowired
	YayineviRepository yayıneviRepo;
	
	@GetMapping("/list")
	public String displayYayınevi(Model model) {
		List<Yayınevi> yayinevi = yayıneviRepo.findAll();
		model.addAttribute("yayinevi", yayinevi);
		
		return "/publishers/list-publisher";
	}
	
	@GetMapping("/new")
	public String displayYayıneviForm(Model model) {
		
		Yayınevi aYayinevi = new Yayınevi();
		model.addAttribute("yayinevi", aYayinevi);
		
		return "/publishers/new-publisher";
	}
	
//	@DeleteMapping("publisher/{yayineviId}")
//	public Map<String, Boolean> deleteBook(@PathVariable(value="yayineviId") long yayineviId) throws Exception {
//		Yayınevi yayinevi = yayıneviRepo.findById(yayineviId).orElseThrow(() -> new Exception("Publisher Home not found for this id ::"+ yayineviId));
//		
//		yayıneviRepo.delete(yayinevi);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return response;
//	}
	
	@PostMapping("/save")
	public String createBook(Model model, Yayınevi yayinevi) {
		yayıneviRepo.save(yayinevi);
		
		return "/publishers/list-publisher";
	}
	
	@GetMapping("/updatePublisher/{id}")
	public String updatePublisher(@PathVariable(value = "yayineviId") long yayineviId, Model model) {
		Optional<Yayınevi> yayinevi = yayıneviRepo.findById(yayineviId);
		model.addAttribute("kitap", yayinevi);
		return "/publishers/update-publisher";
	}
	
	
	@GetMapping("/deletePublisher/{id}")
	public String deletePublisher(@PathVariable (value = "yayineviId") long yayineviId) {
		this.yayıneviRepo.deleteById(yayineviId);
		return "/publishers/list-publisher";
	}

}
