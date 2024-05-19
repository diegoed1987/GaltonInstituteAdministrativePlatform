package com.instituto.galton.controllers.contabilidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.instituto.galton.dtos.ActualizarUsuarioDTO;
import com.instituto.galton.dtos.GenerarEgresoDTO;
import com.instituto.galton.dtos.GenerarFacturaDTO;
import com.instituto.galton.models.Banco;
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

@Controller
public class InicioContabilidadController {
	
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
	
	private String numFactura = "";
	private String numEgreso = "";
	private Iterable<Banco> bancos = null;
	private Iterable<Programa> programas = null;
	private Iterable<Periodo> periodos = null;
	
	@GetMapping("/contabilidad")
	public String getContabilidad(Model model) {
		
		bancos = bancoService.getBancos();
		programas = programaService.getProgramas();
		periodos = periodoService.getPeriodos();
		numFactura = facturaService.getMaxFacturaId();
		numEgreso = egresoService.getMaxEgresoId();
		String numeroComprobante = "Egreso #"+ numEgreso;
		String numeroFactura = "Factura #"+ numFactura;
		
		model.addAttribute("generarFacturaDTO", new GenerarFacturaDTO());
		model.addAttribute("generarEgresoDTO", new GenerarEgresoDTO());
		model.addAttribute("bancos",bancos);
		model.addAttribute("programas",programas);
		model.addAttribute("periodos",periodos);
		model.addAttribute("maxId", numeroFactura);
		model.addAttribute("maxIdEgreso", numeroComprobante);
		return "contabilidad";
	}
}
