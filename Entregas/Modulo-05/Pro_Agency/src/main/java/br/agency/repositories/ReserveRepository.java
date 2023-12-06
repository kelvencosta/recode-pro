package br.agency.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.agency.models.Reserve;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long>{

	List<Reserve> findByClient_Id(Long clientId);

	List<Reserve> findByDestiny_Id(Long destinyId);

}
