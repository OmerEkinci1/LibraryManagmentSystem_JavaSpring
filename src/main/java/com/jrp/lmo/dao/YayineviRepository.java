package com.jrp.lmo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jrp.lmo.entities.Yayınevi;

public interface YayineviRepository extends CrudRepository<Yayınevi, Long>{
	@Override
	public List<Yayınevi> findAll();
}
