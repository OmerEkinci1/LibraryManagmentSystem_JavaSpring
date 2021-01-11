package com.jrp.lmo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jrp.lmo.entities.Yayınevi;

@Repository
public interface YayineviRepository extends CrudRepository<Yayınevi, Long>{
	@Override
	public List<Yayınevi> findAll();
}
