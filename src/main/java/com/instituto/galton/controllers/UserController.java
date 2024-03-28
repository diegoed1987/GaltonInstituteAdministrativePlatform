package com.instituto.galton.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instituto.galton.dtos.GenerarFacturaDTO;
import com.instituto.galton.helpers.Alert;
import com.instituto.galton.models.Banco;
import com.instituto.galton.models.Periodo;
import com.instituto.galton.models.Usuario;
import com.instituto.galton.models.Programa;
import com.instituto.galton.repositories.BancoRepository;
import com.instituto.galton.repositories.PeriodoRepository;
import com.instituto.galton.repositories.ProgramaRepository;
import com.instituto.galton.repositories.UsuarioRepository;
import com.instituto.galton.services.JasperReportsService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private JasperReportsService jasperReportService;
	
	@Autowired
	private BancoRepository bancoRepository;
	
	@Autowired
	private PeriodoRepository periodoRepository;
	
	@Autowired
	private ProgramaRepository programasRepository;
	
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
		Iterable<Banco> bancos = bancoRepository.findAll();
		Iterable<Programa> programas = programasRepository.findAll();
		Iterable<Periodo> periodos = periodoRepository.findAll();
		
		model.addAttribute("generarFacturaDTO", new GenerarFacturaDTO());
		model.addAttribute("bancos",bancos);
		model.addAttribute("programas",programas);
		model.addAttribute("periodos",periodos);
		return "contabilidad";
	}
	
	@PostMapping("/generarFactura")
	public ResponseEntity<String> generarFactura(@ModelAttribute("generarFacturaDTO") GenerarFacturaDTO generarFacturaDTO, HttpServletResponse response, Model model) throws IOException{
		
		String nombreReporte = "recibo_caja";
		String mensaje = "Factura generada con éxito";
		
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
