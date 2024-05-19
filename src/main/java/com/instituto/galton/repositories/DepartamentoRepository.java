package com.instituto.galton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instituto.galton.models.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
	public List<Departamento> findAll();
}
