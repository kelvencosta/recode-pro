package br.recode.servicelmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.recode.models.Matricula;
import br.recode.repositories.MatriculaRepository;
import br.recode.services.MatriculaService;
import jakarta.transaction.Transactional;

@Service
public class MatriculaServiceImpl implements MatriculaService{
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	
	@Override
	@Transactional
	public Matricula saveMatricula(Matricula matricula) {	
		return matriculaRepository.save(matricula);
	}

	@Override
	@Transactional
	public void deleteMatriculasByCurso(Long cursoId) {
		
		List<Matricula> matriculas = matriculaRepository.findByCurso_Id(cursoId);

	    matriculaRepository.deleteAll(matriculas);
	}
	
	@Override
	@Transactional
	public void deleteMatriculasByUsuario(Long usuarioId) {
		
		List<Matricula> matriculas = matriculaRepository.findByUsuario_Id(usuarioId);

	    matriculaRepository.deleteAll(matriculas);
	}
}