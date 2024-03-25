package com.instituto.galton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instituto.galton.models.Banco;


public interface BancoRepository extends JpaRepository<Banco, Integer>{

	public List<Banco> findAll();
	public Banco findByIdBanco(int id);
	public boolean existsByBanco(int id);
	
	public Banco findByNombreBanco(String nombreBanco);
	public boolean existsByNombreBanco(String nombreBanco);
	
	public Banco findByEstadoBanco(String estadoBanco);
	public boolean existsByEstadoBanco(String estadoBanco);
}
