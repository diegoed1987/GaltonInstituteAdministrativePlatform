package com.instituto.galton.services;


import com.instituto.galton.models.Factura;

public interface FacturaService  {
	public void crearFactura(Factura factura);
	public boolean validarFactura(int idFactura);
	public Factura extraerFacturaPorIdFactura(int idFactura);

}
