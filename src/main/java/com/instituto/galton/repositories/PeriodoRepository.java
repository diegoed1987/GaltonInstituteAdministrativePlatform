package com.instituto.galton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instituto.galton.models.Periodo;


public interface PeriodoRepository extends JpaRepository<Periodo, Integer>{

	
	public List<Periodo> findAll();
	public Periodo findById(int id);
	public boolean existsById(int id);
	
	public Periodo findByNombreCortoPeriodo(String periodo);
	public boolean existsByNombreCortoPeriodo(String periodo);
	
	public Periodo findByEstadoPeriodo(String estadoPeriodo);
	public boolean existsByEstadoPeriodo(String estadoPeriodo);

}
