package com.instituto.galton.services;

import com.instituto.galton.models.Municipio;

public interface MunicipioService {
	public Iterable<Municipio> getMunicipiosPorDepartamento(int idDepartamento);
}
