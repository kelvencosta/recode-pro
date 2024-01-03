package br.agency.servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.agency.models.Client;
import br.agency.repositories.ClientRepository;
import br.agency.services.ClientService;
import jakarta.transaction.Transactional;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	@Transactional
	public Client getClientById(Long id) {
		
		return clientRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Client saveClient(Client client) {
		
		return clientRepository.save(client);
	}

	@Override
	public Client updateClient(Long id, Client clientUpdate) {
		Client client = clientRepository.findById(id).orElse(null);
		
		if(client != null) {
			client.setName(clientUpdate.getName());
			client.setRg(clientUpdate.getRg());
			client.setTel(clientUpdate.getTel());
			client.setEmail(clientUpdate.getEmail());

			return clientRepository.save(clientUpdate);
		} else {
			throw new RuntimeException("Client with ID" + id + "Not found");
		}
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
	}

}
