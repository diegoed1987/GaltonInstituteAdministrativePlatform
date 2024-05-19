package com.instituto.galton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instituto.galton.models.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Integer>{
	public List<Municipio> findByCodigoDepartamento(int codigoDepartamento);
}
