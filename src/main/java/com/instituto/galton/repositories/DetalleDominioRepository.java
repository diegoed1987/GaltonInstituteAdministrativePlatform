package com.instituto.galton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instituto.galton.models.DetalleDominio;

public interface DetalleDominioRepository extends JpaRepository<DetalleDominio, String>{
	public DetalleDominio findByIdDominioAndNombreDetalle(String idDominio, String nombreDetalle);
}
