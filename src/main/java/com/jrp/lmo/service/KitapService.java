package com.jrp.lmo.service;

import java.util.List;

import com.jrp.lmo.entities.*;

public interface KitapService {
	
	List<Kitap> getAllBooks();
	void saveBooks(Kitap kitap);
	Kitap getBookById();
}
