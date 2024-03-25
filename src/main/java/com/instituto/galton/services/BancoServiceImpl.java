package com.instituto.galton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.galton.models.Banco;
import com.instituto.galton.repositories.BancoRepository;

@Service
public class BancoServiceImpl implements BancoService{

	@Autowired
	private BancoRepository bancoRepository;
	
	@Override
	public void crearBanco(Banco banco) {
		bancoRepository.save(banco);
	}

	@Override
	public boolean validarBanco(int id) {
		return bancoRepository.existsByBanco(id);
	}

	@Override
	public Banco extraerBancoIdBanco(int id) {
		return bancoRepository.findByIdBanco(id);
	}

}
