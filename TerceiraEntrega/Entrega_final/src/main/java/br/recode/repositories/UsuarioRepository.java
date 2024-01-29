package br.recode.repositories;

import org.springframework.stereotype.Repository;

import br.recode.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByNomeUsuario(String nomeUsuario);
}
