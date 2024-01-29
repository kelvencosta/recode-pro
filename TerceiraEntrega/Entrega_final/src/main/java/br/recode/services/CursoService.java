package br.recode.services;

import java.util.List;
import br.recode.models.Curso;

public interface CursoService {
	List<Curso> getAllCursos();
	
    Curso getCursoById(Long id);
	
    Curso saveCurso(Curso curso);
	
    Curso updateCurso(Long id, Curso cursoAtualizado);
	
	void deleteCurso(Long id);
}
