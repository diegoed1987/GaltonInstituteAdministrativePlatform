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

import com.instituto.galton.dtos.ActualizarUsuarioDTO;
import com.instituto.galton.dtos.GenerarEgresoDTO;
import com.instituto.galton.dtos.GenerarFacturaDTO;
import com.instituto.galton.models.Banco;
import com.instituto.galton.models.Egresos;
import com.instituto.galton.models.Factura;
import com.instituto.galton.models.Periodo;
import com.instituto.galton.models.Programa;
import com.instituto.galton.models.RolUsuario;
import com.instituto.galton.models.Sede;
import com.instituto.galton.models.Usuario;
import com.instituto.galton.services.BancoService;
import com.instituto.galton.services.DetalleUsuarioService;
import com.instituto.galton.services.EgresoService;
import com.instituto.galton.services.FacturaService;
import com.instituto.galton.services.JasperReportsService;
import com.instituto.galton.services.PeriodoService;
import com.instituto.galton.services.ProgramaService;
import com.instituto.galton.services.RolUsuarioService;
import com.instituto.galton.services.SedeService;
import com.instituto.galton.services.UsuarioService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReporteController {
	
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
	
	@Autowired
	private EgresoService egresoService;
	
	@Autowired
	private RolUsuarioService rolUsuarioService;
	
	@Autowired
	private SedeService sedeService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private DetalleUsuarioService detalleUsuarioService;
	
	private String numFactura = "";
	private String numEgreso = "";
	private Iterable<Banco> bancos = null;
	private Iterable<Programa> programas = null;
	private Iterable<Periodo> periodos = null;
	private String datePattern = "dd/MM/yyyy";
	private Iterable<RolUsuario> rolesUsuario = null;
	private Iterable<Sede> sedes = null;
	private Iterable<Usuario> listaUsuarios = null;
	private ActualizarUsuarioDTO actualizarUsuarioDTO = null;
	
	@GetMapping("/reportes")
	public String reportesPage() {
		return "reportes";
	}
	
	@PostMapping("/generarFactura")
	public ResponseEntity<String> generarFactura(@ModelAttribute("generarFacturaDTO") GenerarFacturaDTO generarFacturaDTO, HttpServletResponse response, Model model) throws IOException{
		
		String nombreReporte = "recibo_caja";
		String mensaje = "Factura generada con éxito";
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
		String fechaRecibo = simpleDateFormat.format(date);

		Factura factura = new Factura();
		if (!generarFacturaDTO.getBanco().isBlank()) {
			factura.setIdBanco(Integer.parseInt(generarFacturaDTO.getBanco()));
		}
		factura.setConcepto(generarFacturaDTO.getConcepto());
		factura.setFechaFactura(date);
		factura.setIdPagador(Integer.parseInt(generarFacturaDTO.getDocumentoPagador()));
		if (!generarFacturaDTO.getPeriodo().isBlank()) {
		    factura.setIdPeriodo(Integer.parseInt(generarFacturaDTO.getPeriodo()));
		}
		if (!generarFacturaDTO.getPrograma().isBlank()) {
		    factura.setIdPrograma(Integer.parseInt(generarFacturaDTO.getPrograma()));
		}
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
		if(!generarFacturaDTO.getBanco().isBlank()) {
		   generarFacturaDTO.setBanco(bancoService.getNombreBanco(bancos, Integer.parseInt(generarFacturaDTO.getBanco())));
		}
		if(!generarFacturaDTO.getPeriodo().isBlank()) {
		   generarFacturaDTO.setPeriodo(periodoService.getNombrePeriodo(periodos, Integer.parseInt(generarFacturaDTO.getPeriodo())));
		}
		if(!generarFacturaDTO.getPrograma().isBlank()) {
		   generarFacturaDTO.setPrograma(programaService.getNombrePrograma(programas, Integer.parseInt(generarFacturaDTO.getPrograma())));
		}
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
	
	@PostMapping("/generarEgreso")
	public ResponseEntity<String> generarEgreso(@ModelAttribute("generarEgresoDTO") GenerarEgresoDTO generarEgresoDTO, HttpServletResponse response, Model model) throws IOException{
		
		String nombreReporte = "comprobante_egreso";
		String mensaje = "Factura generada con éxito";
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
		String fechaEgreso = simpleDateFormat.format(date);

		Egresos egresos = new Egresos();

		if (!generarEgresoDTO.getIdBanco().isBlank()) {
			egresos.setIdBanco(Integer.parseInt(generarEgresoDTO.getIdBanco()));
		}
		
		egresos.setDescripcionEgreso(generarEgresoDTO.getDescripcionEgreso());
		egresos.setFechaEgreso(date);
		egresos.setIdBeneficiario(Integer.parseInt(generarEgresoDTO.getIdBeneficiario()));
		egresos.setMediosPago(generarEgresoDTO.getMedioPago());
		egresos.setNombreBeneficiario(generarEgresoDTO.getNombreBeneficiario());
		egresos.setObservacionesEgreso(generarEgresoDTO.getObservacionesEgreso());
		egresos.setValorLetra(generarEgresoDTO.getValorLetra());
		egresos.setDireccionBeneficiario(generarEgresoDTO.getDireccionBeneficiario());
		egresos.setCiudadBeneficiario(generarEgresoDTO.getCiudadBeneficiario());
		egresos.setTelefonoBeneficiario(generarEgresoDTO.getTelefonoBeneficiario());
		
		egresos.setValorLetra(generarEgresoDTO.getValorLetra());
		if(generarEgresoDTO.getValorEgreso().contains(",")) {
			egresos.setValorEgreso(Float.parseFloat(generarEgresoDTO.getValorEgreso().replace(",", ".")));
		}else {
			egresos.setValorEgreso(Float.parseFloat(generarEgresoDTO.getValorEgreso()));
		}
		
		egresoService.crearEgreso(egresos);

		generarEgresoDTO.setFechaEgreso(fechaEgreso);
		generarEgresoDTO.setNumeroComprobante(String.valueOf(numEgreso));
		generarEgresoDTO.setNit("913434489-0");
		generarEgresoDTO.setDireccion("CARRERA 11 # 12- 29");
		if(!generarEgresoDTO.getIdBanco().isBlank()) {
			generarEgresoDTO.setIdBanco(bancoService.getNombreBanco(bancos, Integer.parseInt(generarEgresoDTO.getIdBanco())));
		}
		
        try {
            byte[] reportBytes = jasperReportService.generarEgreso(generarEgresoDTO, nombreReporte);

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
