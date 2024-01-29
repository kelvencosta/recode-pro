package br.recode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.recode.models.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByAuthority(String authority);
}