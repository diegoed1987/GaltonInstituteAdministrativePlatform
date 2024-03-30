package com.instituto.galton.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.instituto.galton.dtos.GenerarFacturaDTO;
import com.instituto.galton.helpers.Alert;
import com.instituto.galton.models.Banco;
import com.instituto.galton.models.Factura;
import com.instituto.galton.models.Periodo;
import com.instituto.galton.models.Programa;
import com.instituto.galton.services.BancoService;
import com.instituto.galton.services.FacturaService;
import com.instituto.galton.services.JasperReportsService;
import com.instituto.galton.services.PeriodoService;
import com.instituto.galton.services.ProgramaService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private JasperReportsService jasperReportService;
	
	@Autowired
	private BancoService bancoService;
	
	@Autowired
	private ProgramaService programaService;
	
	@Autowired
	private PeriodoService periodoService;
	
	@Autowired
	private FacturaService facturaService;
	
	private String numFactura = "";
	private Iterable<Banco> bancos = null;
	private Iterable<Programa> programas = null;
	private Iterable<Periodo> periodos = null;
	
	@GetMapping("/")
	public String paginaAdministrador() {
		return "inicio";
	}
	
	@GetMapping("/reportes")
	public String reportesPage() {
		return "reportes";
	}
	
	@GetMapping("/administracion")
	public String administracion() {
		return "administracion";
	}
	
	@PostMapping("/crearUsuario")
	public Alert creaUsuarioModal() {
		Alert alert = new Alert();
		alert.setTitle("Registro de Usuario");
		alert.setText("El usuario ha sido registrado existosamente.");
		alert.setIcon("success");
		return alert;
	}
	
	@GetMapping("/contabilidad")
	public String getContabilidad(Model model) {
		
		bancos = bancoService.getBancos();
		programas = programaService.getProgramas();
		periodos = periodoService.getPeriodos();
		numFactura = facturaService.getMaxFacturaId();
		String numeroFactura = "Factura #"+ numFactura;
		
		model.addAttribute("generarFacturaDTO", new GenerarFacturaDTO());
		model.addAttribute("bancos",bancos);
		model.addAttribute("programas",programas);
		model.addAttribute("periodos",periodos);
		model.addAttribute("maxId", numeroFactura);
		return "contabilidad";
	}
	
	@PostMapping("/generarFactura")
	public ResponseEntity<String> generarFactura(@ModelAttribute("generarFacturaDTO") GenerarFacturaDTO generarFacturaDTO, HttpServletResponse response, Model model) throws IOException{
		
		String nombreReporte = "recibo_caja";
		String mensaje = "Factura generada con éxito";
		
		Date date = new Date();
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String fechaRecibo = simpleDateFormat.format(date);

		Factura factura = new Factura();
		factura.setIdBanco(Integer.parseInt(generarFacturaDTO.getBanco()));
		factura.setConcepto(generarFacturaDTO.getConcepto());
		factura.setFechaFactura(date);
		factura.setIdPagador(Integer.parseInt(generarFacturaDTO.getDocumentoPagador()));
		factura.setIdPeriodo(Integer.parseInt(generarFacturaDTO.getPeriodo()));
		factura.setIdPrograma(Integer.parseInt(generarFacturaDTO.getPrograma()));
		factura.setMediosPago(generarFacturaDTO.getMedioPago());
		factura.setNombrePagador(generarFacturaDTO.getNombrePagador());
		factura.setObservaciones(generarFacturaDTO.getObservaciones());
		factura.setValorLetra(generarFacturaDTO.getValorLetra());
		
		if(generarFacturaDTO.getValorRecaudado().contains(",")) {
			factura.setValorRecaudado(Float.parseFloat(generarFacturaDTO.getValorRecaudado().replace(",", ".")));
		}else {
			factura.setValorRecaudado(Float.parseFloat(generarFacturaDTO.getValorRecaudado()));
		}
		
		facturaService.crearFactura(factura);

		generarFacturaDTO.setFechaRecibo(fechaRecibo);
		generarFacturaDTO.setNumeroRecibo(String.valueOf(numFactura));
		generarFacturaDTO.setEmail("galton@gmail.com");
		generarFacturaDTO.setTelefono("3165987589");
		generarFacturaDTO.setBanco(bancoService.getNombreBanco(bancos, Integer.parseInt(generarFacturaDTO.getBanco())));
		generarFacturaDTO.setPeriodo(periodoService.getNombrePeriodo(periodos, Integer.parseInt(generarFacturaDTO.getPeriodo())));
		generarFacturaDTO.setPrograma(programaService.getNombrePrograma(programas, Integer.parseInt(generarFacturaDTO.getPrograma())));
		
        try {
            byte[] reportBytes = jasperReportService.generarFactura(generarFacturaDTO, nombreReporte);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=recibo.pdf");
            response.setContentLength(reportBytes.length);
            response.getOutputStream().write(reportBytes);
            response.getOutputStream().flush();
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error generating report: " + e.getMessage());
        }
        
        model.addAttribute("mensaje", mensaje);
        
        return ResponseEntity.ok(mensaje);
	}
}
