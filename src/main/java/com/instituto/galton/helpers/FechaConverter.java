package com.instituto.galton.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaConverter {
	
	public static Date convertirStringAFecha(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaDate = null;
		
		try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
		
		return fechaDate;
	}
}
