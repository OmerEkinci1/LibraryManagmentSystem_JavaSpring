package com.jrp.lmo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jrp.lmo.dao.KitapRepository;
import com.jrp.lmo.entities.Kitap;

public class KitapServiceImp implements KitapService {
	
	@Autowired
	KitapRepository kitapRepo;
	
	@Override
	public List<Kitap> getAllBooks() {
		return kitapRepo.findAll();
	}

	@Override
	public void saveBooks(Kitap kitap) {
		this.kitapRepo.save(kitap);
		
	}

	@Override
	public Kitap getBookById() {
		// TODO Auto-generated method stub
		return null;
	}

//	public Kitap getBookById(long kitapId) {
//		Optional<Kitap> optional = kitapRepo.findById(kitapId);
//		Kitap kitap = null;
//		if(optional.isPresent()) {
//			kitap = optional.get();
//		}else {
//			throw new RuntimeException("Book not found for id ::"+kitapId);
//		}
//		return kitap;
	}

