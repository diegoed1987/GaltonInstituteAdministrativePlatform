package com.instituto.galton.controllers.administracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.instituto.galton.dtos.ActualizarBancoDTO;
import com.instituto.galton.dtos.ActualizarProgramaDTO;
import com.instituto.galton.dtos.ActualizarSedeDTO;
import com.instituto.galton.dtos.ActualizarUsuarioDTO;
import com.instituto.galton.dtos.CrearBancoDTO;
import com.instituto.galton.dtos.CrearSedeDTO;
import com.instituto.galton.dtos.CrearUsuarioDTO;
import com.instituto.galton.models.Banco;
import com.instituto.galton.models.Programa;
import com.instituto.galton.models.RolUsuario;
import com.instituto.galton.models.Sede;
import com.instituto.galton.models.Usuario;
import com.instituto.galton.services.BancoService;
import com.instituto.galton.services.ProgramaService;
import com.instituto.galton.services.RolUsuarioService;
import com.instituto.galton.services.SedeService;
import com.instituto.galton.services.UsuarioService;

@Controller
public class InicioAdministracionController {
	
	@Autowired
	private RolUsuarioService rolUsuarioService;
	
	@Autowired
	private SedeService sedeService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProgramaService programaService;
	
	@Autowired
	private BancoService bancoService;

	private Iterable<RolUsuario> rolesUsuario = null;
	private Iterable<Sede> sedes = null;
	private Iterable<Usuario> listaUsuarios = null;
	private Iterable<Programa> listaProgramas = null;
	private Iterable<Banco> listaBancos = null;
	private ActualizarUsuarioDTO actualizarUsuarioDTO = null;
	private ActualizarSedeDTO actualizarSedeDTO = null;
	private ActualizarProgramaDTO actualizarProgramaDTO = null;
	private ActualizarBancoDTO actualizarBancoDTO = null;
	private CrearUsuarioDTO crearUsuarioDTO = null;
	private CrearSedeDTO crearSedeDTO = null;
	private CrearBancoDTO crearBancoDTO = null;
	
	@GetMapping("/administracion")
	public String administracion(Model model) {
		crearUsuarioDTO = new CrearUsuarioDTO();
		model.addAttribute("crearUsuarioDTO", crearUsuarioDTO);
		model.addAttribute("crearSedeDTO", crearSedeDTO);
		model.addAttribute("crearBancoDTO", crearBancoDTO);
		rolesUsuario = rolUsuarioService.getRolesUsuarios();
		sedes = sedeService.getSedes();
		listaBancos = bancoService.getBancos();
		model.addAttribute("rolesUsuario", rolesUsuario);
		model.addAttribute("sedes", sedes);
		
		listaProgramas = programaService.getProgramas();
		listaUsuarios = usuarioService.consultarUsuarios();
		model.addAttribute("listaUsuarios", listaUsuarios);
		model.addAttribute("listaProgramas", listaProgramas);
		model.addAttribute("listaBancos", listaBancos);
		model.addAttribute("actualizarUsuarioDTO", actualizarUsuarioDTO);
		model.addAttribute("actualizarSedeDTO", actualizarSedeDTO);
		model.addAttribute("actualizarProgramaDTO", actualizarProgramaDTO);
		model.addAttribute("actualizarBancoDTO", actualizarBancoDTO);
		return "administracion";
	}
}
