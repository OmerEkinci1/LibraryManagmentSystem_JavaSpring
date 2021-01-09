package com.jrp.lmo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jrp.lmo.entities.Kitap;

public interface KitapRepository extends CrudRepository<Kitap, Long> {

	@Override
	public List<Kitap> findAll();
}
