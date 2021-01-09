package com.jrp.lmo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jrp.lmo.entities.Yazar;

public interface YazarRepository extends CrudRepository<Yazar, Long> {

	@Override
	public List<Yazar> findAll();
}
