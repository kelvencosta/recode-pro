package br.recode.servicelmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.recode.models.Curso;
import br.recode.repositories.CursoRepository;
import br.recode.services.CursoService;
import jakarta.transaction.Transactional;

@Service
public class CursoServicesImpl implements CursoService{
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public List<Curso> getAllCursos() {
		return cursoRepository.findAll();
	}

	@Transactional
	public Curso getCursoById(Long id) {
		return cursoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Curso saveCurso(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public Curso updateCurso(Long id, Curso cursoAtualizado) {
		Curso cursoExistente = cursoRepository.findById(id).orElse(null);
		if (cursoExistente != null) { 
			cursoExistente.setTitulo(cursoAtualizado.getTitulo());
			cursoExistente.setImgUrl(cursoAtualizado.getImgUrl());
			cursoExistente.setDescricao(cursoAtualizado.getDescricao());
			cursoExistente.setDuracao(cursoAtualizado.getDuracao());
			return cursoRepository.save(cursoExistente);
		} else { 
			throw new RuntimeException("Curso com o ID" + id + "não encontrado.");
		}
	}

	@Override
	public void deleteCurso(Long id) {
		cursoRepository.deleteById(id);
	}
}
