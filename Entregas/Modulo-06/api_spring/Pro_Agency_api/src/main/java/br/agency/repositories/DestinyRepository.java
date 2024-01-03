package br.agency.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.agency.models.Destiny;

@Repository
public interface DestinyRepository extends JpaRepository<Destiny, Long>{

	List<Destiny> findByType(String type);
}