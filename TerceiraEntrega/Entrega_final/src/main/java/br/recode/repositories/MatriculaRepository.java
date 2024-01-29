package br.recode.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.recode.models.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
	List<Matricula> findByCurso_Id(Long cursoId);
	List<Matricula> findByUsuario_Id(Long usuarioId);
}