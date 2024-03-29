package com.instituto.galton.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.instituto.galton.dtos.GenerarFacturaDTO;
import com.instituto.galton.models.Usuario;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class JasperReportsServiceImpl implements JasperReportsService{

	@Override
	public byte[] generarFactura(GenerarFacturaDTO generarFacturaDTO, String nombreReporte) throws JRException, IOException {
		
		ClassPathResource resource = new ClassPathResource("reports/" + nombreReporte + ".jasper");
		
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(resource.getInputStream());
        
        Date date = new Date();
        
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("programa", generarFacturaDTO.getPrograma());
        params.put("periodo", generarFacturaDTO.getPeriodo());
        params.put("nombrePagador", generarFacturaDTO.getNombrePagador());
        params.put("documentoPagador", generarFacturaDTO.getDocumentoPagador());
        params.put("fechaRecibo", date.toString());
        params.put("numeroRecibo", "15");
        params.put("concepto", generarFacturaDTO.getConcepto());
        params.put("observaciones", generarFacturaDTO.getObservaciones());
        params.put("medioPago", generarFacturaDTO.getMedioPago());
        params.put("valorLetra", generarFacturaDTO.getValorLetra());
        params.put("valorRecaudado", generarFacturaDTO.getValorRecaudado());
        params.put("banco", generarFacturaDTO.getBanco());
        params.put("email", "galton@gmail.com");
        params.put("telefono", "3152634565");
        
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(List.of(params));

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);
	}

}
