package br.agency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.agency.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
