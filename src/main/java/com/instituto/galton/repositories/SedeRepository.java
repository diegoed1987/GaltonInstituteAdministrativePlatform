package com.instituto.galton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instituto.galton.models.Sede;

public interface SedeRepository extends JpaRepository<Sede, String>{
	
	public List<Sede> findAll();
}
