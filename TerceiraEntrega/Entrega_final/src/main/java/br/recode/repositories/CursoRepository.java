package br.recode.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.recode.models.Curso;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
	
}

