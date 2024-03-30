package com.instituto.galton.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.instituto.galton.models.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {

	public List<Factura> findAll();
	public Factura findByIdFactura(int idFactura);
	public boolean existsByIdFactura(int idFactura);
	
	public Factura findByIdPagador(int idPagador);
	public boolean existsByIdPagador(int idPagador);
	
	public Factura findByNombrePagador(String nombrePagador);
	public boolean existsByNombrePagador(String nombrePagador);
	
	public Factura findByIdPeriodo(int idPeriodo);
	public boolean existsByIdPeriodo(int idPeriodo);
	
	public Factura findByIdPrograma(int idPrograma);
	public boolean existsByIdPrograma(int idPrograma);
	
	public Factura findByFechaFactura(Date fechaFactura);
	public boolean existsByFechaFactura(Date fechaFactura);
	
	@Query(value = "SELECT COALESCE(MAX(ID_FACTURA),0) + 1 FROM FACTURAS", nativeQuery = true)
	public int getMaxId();
	
	
}
