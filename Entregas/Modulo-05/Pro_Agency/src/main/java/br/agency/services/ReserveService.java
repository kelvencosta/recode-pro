package br.agency.services;


import br.agency.models.Reserve;

public interface ReserveService {

	Reserve saveReserve(Reserve reserve);

	void deleteReserveByClient(Long id);

	void deleteReserveByDestiny(Long id);
}