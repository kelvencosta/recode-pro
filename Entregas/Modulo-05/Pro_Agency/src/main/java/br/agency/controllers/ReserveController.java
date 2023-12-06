package br.agency.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.agency.models.Client;
import br.agency.models.Destiny;
import br.agency.models.Reserve;
import br.agency.services.ClientService;
import br.agency.services.DestinyService;
import br.agency.services.ReserveService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reserve")
public class ReserveController {
	
	@Autowired
	private ReserveService reserveService;
	
	@Autowired
	private DestinyService destinyService;
	
	@Autowired
	private ClientService clientService;
	
	//retorna pag de reserva
	@GetMapping("/register/{id}")
	public String showFormAdd(Model model, @PathVariable Long id) {
		Reserve reserve = new Reserve();
		Destiny destiny = destinyService.getDestinyById(id);
		
		model.addAttribute("reserve", reserve);
		model.addAttribute("destiny", destiny);
		
		return "reserve/register";
	}
	
	//salva a reserva no banco
	@PostMapping("/save/{destinyId}")
	public String saveMatricula(@PathVariable Long destinyId,@ModelAttribute("reserve") Reserve reserve, HttpSession session) {
		
		Long clientId = (Long) session.getAttribute("clientId");

		
		if(clientId == null) {
			
			return "redirect:/client/register";
		}
		
		 Optional<Client> clientOptional = Optional.ofNullable(clientService.getClientById(clientId));

         if (clientOptional.isPresent()) {
        	 
        	 reserve.setClientId(clientId);
        	 reserve.setDestinyId(destinyId);
        	 
        	 reserveService.saveReserve(reserve);
     		return "redirect:/";
         } else {
         	return "redirect:/client/register";
         }
	}
}