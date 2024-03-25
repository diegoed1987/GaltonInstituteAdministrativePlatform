package com.instituto.galton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instituto.galton.models.Programa;


public interface ProgramaRepository extends JpaRepository<Programa, Integer>{
	
	public List<Programa> findAll();
	public Programa findByIdPrograma(int idPrograma);
	public boolean existsByPrograma(int idPrograma);
	
	public Programa findByNombrePrograma(String nombrePrograma);
	public boolean existsByNombrePrograma(String nombrePrograma);
	
	public Programa findByEstadoPrograma(String estadoPrograma);
	public boolean existsByEstadoPrograma(String estadoPrograma);

}
