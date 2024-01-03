package br.agency.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.agency.models.Destiny;
import br.agency.repositories.DestinyRepository;
import br.agency.services.DestinyService;
import jakarta.transaction.Transactional;

@Service
public class DestinyServiceImpl implements DestinyService{
	
	@Autowired
	private DestinyRepository destinyRepository;

	@Override
	public List<Destiny> getAllDestinations() {
		
		return destinyRepository.findAll();
	}

	@Override
	public Destiny getDestinyById(Long id) {
		
		return destinyRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Destiny saveDestiny(Destiny destiny) {
		
		return  destinyRepository.save(destiny);
	}

	@Override
	public Destiny updateDestiny(Long id, Destiny destinyUpdate) {
		Destiny destiny = destinyRepository.findById(id).orElse(null);
		
		if(destiny != null) {
			destiny.setName(destinyUpdate.getName());
			destiny.setImgUrl(destinyUpdate.getImgUrl());
			destiny.setPrice(destinyUpdate.getPrice());
			return destinyRepository.save(destinyUpdate);
		} else {
			throw new RuntimeException("Destiny with ID" + id + "Not found");
		}
	}

	@Override
	public void deleteDestiny(Long id) {
		destinyRepository.deleteById(id);
	}

	@Override
	public List<Destiny> findByType(String type) {

		return destinyRepository.findByType(type);
	}

}