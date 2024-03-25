package com.instituto.galton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instituto.galton.models.Periodo;


public interface PeriodoRepository extends JpaRepository<Periodo, Integer>{

	
	public List<Periodo> findAll();
	public Periodo findByIdPeriodo(int id);
	public boolean existsByPeriodo(int id);
	
	public Periodo findByNombrePeriodo(String periodo);
	public boolean existsByNombrePeriodo(String periodo);
	
	public Periodo findByEstadoPeriodo(String estadoPeriodo);
	public boolean existsByEstadoPeriodo(String estadoPeriodo);

}
