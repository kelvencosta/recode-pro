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
import br.agency.services.ClientService;
import br.agency.services.ReserveService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ReserveService reserveService;

	//lista perfil do client
	@GetMapping("/perfil")
	public String showPerfilClient(Model model, HttpSession session) {

		Long clientId = (Long) session.getAttribute("clientId");
		
		    if (clientId == null) {
		        return "redirect:/client/register";
		    }

            Optional<Client> clientOptional = Optional.ofNullable(clientService.getClientById(clientId));

            if (clientOptional.isPresent()) {
                model.addAttribute("client", clientOptional.get());
                return "client/perfil";
            } else {
            	return "redirect:/client/register";
            }
            
    }

	//retornar pag de registro
	@GetMapping("/register")
	public String showFormAdd(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);
		return "client/register";
	}

	// Persistencia da criação
	@PostMapping("/save")
	public String saveClient(@ModelAttribute("client") Client client, HttpSession sessio) {

		clientService.saveClient(client);

		sessio.setAttribute("clientId", client.getId());

		return "redirect:/client/perfil";
	}

	// Formulário de edição
	@GetMapping("/edit/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		Client client = clientService.getClientById(id);
		model.addAttribute("client", client);
		return "client/edit";
	}

	// Persistencia da edição
	@PostMapping("/edit/{id}")
	public String updateClient(@PathVariable Long id, @ModelAttribute("client") Client client) {
		clientService.updateClient(id, client);

		return "redirect:/client/perfil";
	}

	// Excluir categoria
	@GetMapping("/delete/{id}")
	public String deleteClient(@PathVariable Long id, HttpSession session) {

		session.setAttribute("clientId", null);

		reserveService.deleteReserveByClient(id);

		clientService.deleteClient(id);
		return "redirect:/";
	}
}