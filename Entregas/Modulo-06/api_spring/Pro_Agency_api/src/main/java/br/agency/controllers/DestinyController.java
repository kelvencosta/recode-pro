package br.agency.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.agency.models.Destiny;
import br.agency.services.DestinyService;
import br.agency.services.ReserveService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class DestinyController {

    @Autowired
    private DestinyService destinyService;

    @Autowired
    private ReserveService reserveService;

    // Listar card home
    @GetMapping
    public ResponseEntity<List<Destiny>> getDestinies() {
        List<Destiny> destinies = destinyService.getAllDestinations();
        return new ResponseEntity<>(destinies, HttpStatus.OK);
    }
    
    @GetMapping("/destiny/{id}")
    public ResponseEntity<Destiny> getDestinie(@PathVariable Long id) {
        Destiny destinie = destinyService.getDestinyById(id);
        return new ResponseEntity<>(destinie, HttpStatus.OK);
    }

    // Formulário de criação
    @PostMapping("/register/destiny")
    public ResponseEntity<Void> createDestiny(@RequestBody Destiny destiny) {
        destinyService.saveDestiny(destiny);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Formulário de edição
    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> updateDestiny(@PathVariable Long id, @RequestBody Destiny destiny) {
        destinyService.updateDestiny(id, destiny);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Excluir destino
    @DeleteMapping("/destiny/{id}")
    public ResponseEntity<Void> deleteDestiny(@PathVariable Long id) {
        reserveService.deleteReserveByDestiny(id);
        destinyService.deleteDestiny(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}