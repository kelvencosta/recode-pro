package br.agency.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.agency.models.Reserve;
import br.agency.repositories.ReserveRepository;
import br.agency.services.ReserveService;
import jakarta.transaction.Transactional;

@Service
public class ReserveServiceImpl implements ReserveService {

	@Autowired
	private ReserveRepository reserveRepository;

	@Override
	public Reserve saveReserve(Reserve reserve) {

		return reserveRepository.save(reserve);
	}

	@Override
	@Transactional
	public void deleteReserveByClient(Long clientId) {
		List<Reserve> resrvetions = reserveRepository.findByClient_Id(clientId);

		reserveRepository.deleteAll(resrvetions);
	}

	@Override
	@Transactional
	public void deleteReserveByDestiny(Long destinyId) {
		List<Reserve> resrvetions = reserveRepository.findByDestiny_Id(destinyId);

		reserveRepository.deleteAll(resrvetions);
	}

}
