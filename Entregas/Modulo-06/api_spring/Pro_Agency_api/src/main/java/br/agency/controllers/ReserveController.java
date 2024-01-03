package br.agency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.agency.models.Client;
import br.agency.models.Destiny;
import br.agency.models.Reserve;
import br.agency.services.ClientService;
import br.agency.services.DestinyService;
import br.agency.services.ReserveService;

@RestController
@RequestMapping("/reserve")
@CrossOrigin(origins = "http://localhost:3000")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private DestinyService destinyService;

    // Salva a reserva no banco
    @PostMapping("/save/{clientId}/{destinyId}")
    public ResponseEntity<?> saveReserve(
            @PathVariable Long clientId,
            @PathVariable Long destinyId,
            @RequestBody Reserve reserve) {

        // Verifica se o cliente e o destino existem
        Client client = clientService.getClientById(clientId);
        Destiny destiny = destinyService.getDestinyById(destinyId);

        if (client == null || destiny == null) {
            return ResponseEntity.notFound().build();
        }

        // Configura a reserva com os IDs do cliente e destino
        reserve.setClientId(clientId);
        reserve.setDestinyId(destinyId);

        reserveService.saveReserve(reserve);

        return ResponseEntity.ok().build();
    }
}
