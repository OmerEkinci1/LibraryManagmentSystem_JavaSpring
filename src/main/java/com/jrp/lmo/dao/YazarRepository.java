package com.jrp.lmo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrp.lmo.entities.Yazar;

@Repository
public interface YazarRepository extends JpaRepository<Yazar, Long> {

	@Override
	public List<Yazar> findAll();
	
}
