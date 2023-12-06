package br.agency.services;

import java.util.List;

import br.agency.models.Destiny;

public interface DestinyService {

	List<Destiny> getAllDestinations();

	Destiny getDestinyById(Long id);

	Destiny saveDestiny(Destiny destiny);

	Destiny updateDestiny(Long id, Destiny destinyUpdate);

	void deleteDestiny(Long id);

	List<Destiny> findByType(String type);
}