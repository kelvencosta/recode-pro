package br.agency.services;

import br.agency.models.Client;

public interface ClientService {
	
	Client getClientById(Long id);
	
	Client saveClient(Client client);
	
	Client updateClient(Long id, Client clientUpdate);
	
	void deleteClient(Long id);
}
