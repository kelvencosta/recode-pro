package br.recode.services;

import br.recode.models.Matricula;

public interface MatriculaService {
	
	Matricula saveMatricula(Matricula matricula);

	void deleteMatriculasByCurso(Long id);
	void deleteMatriculasByUsuario(Long id);
}
