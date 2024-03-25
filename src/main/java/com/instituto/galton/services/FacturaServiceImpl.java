package com.instituto.galton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.galton.models.Factura;
import com.instituto.galton.repositories.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService{

	@Autowired
	private FacturaRepository facturaRepository;
	
	@Override
	public void crearFactura(Factura factura) {
		facturaRepository.save(factura);
		
	}

	@Override
	public boolean validarFactura(int idFactura) {
		return facturaRepository.existsByIdFactura(idFactura);
	}

	@Override
	public Factura extraerFacturaPorIdFactura(int idFactura) {
		return facturaRepository.findByIdFactura(idFactura);
	}

}
