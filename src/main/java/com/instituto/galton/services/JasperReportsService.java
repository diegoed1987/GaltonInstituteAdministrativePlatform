package com.instituto.galton.services;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.instituto.galton.dtos.GenerarEgresoDTO;
import com.instituto.galton.dtos.GenerarFacturaDTO;
import com.instituto.galton.models.Usuario;

import net.sf.jasperreports.engine.JRException;

public interface JasperReportsService {
	public byte[] generarFactura(GenerarFacturaDTO generarFacturaDTO, String nombreReporte) throws JRException, IOException;
	public byte[] generarEgreso(GenerarEgresoDTO generarEgresoDTO, String nombreReporte) throws JRException, IOException;
}
