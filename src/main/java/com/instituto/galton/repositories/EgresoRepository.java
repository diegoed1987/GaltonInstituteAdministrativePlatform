package com.instituto.galton.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.instituto.galton.models.Egresos;

public interface EgresoRepository extends JpaRepository<Egresos, Integer>  {

	public List<Egresos> findAll();
	public Egresos findByIdEgreso(int idEgreso);
	public boolean existsByIdEgreso(int idEgreso);
	
	public Egresos findByIdBeneficiario(int idBeneficiario);
	public boolean existsByIdBeneficiario(int idBeneficiario);
	
	public Egresos findByNombreBeneficiario(String nombreBeneficiario);
	public boolean existsByNombreBeneficiario(String nombreBeneficiario);
	

	public Egresos findByFechaEgreso(Date fechaEgreso);
	public boolean existsByFechaEgreso(Date fechaEgreso);
	
	@Query(value = "SELECT COALESCE(MAX(ID_EGRESO),0) + 1 FROM EGRESOS", nativeQuery = true)
	public int getMaxId();
	
}
