package br.recode.services;

import java.util.List;

import br.recode.models.Usuario;


public interface UsuarioService {
	List<Usuario> getAllAlunos();
	
	Usuario getAlunoById(Long id);
	
	Usuario saveAluno(Usuario Usuario);
	
	Usuario updateAluno(Long id, Usuario AlunoAtualizado);
	
	void deleteAluno(Long id);

	Usuario findByNomeUsuario(String nomeUsuario);
}
