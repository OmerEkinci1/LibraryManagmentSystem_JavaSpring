package com.jrp.lmo.dao;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jrp.lmo.entities.Kitap;

@Repository
public interface KitapRepository extends CrudRepository<Kitap, Long> {

	@Override
	public List<Kitap> findAll();
	
}
