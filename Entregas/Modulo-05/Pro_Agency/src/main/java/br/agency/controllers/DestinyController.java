package br.agency.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.agency.models.Destiny;
import br.agency.services.DestinyService;
import br.agency.services.ReserveService;


@Controller
@RequestMapping("/")
public class DestinyController {

	@Autowired
	private DestinyService destinyService;
	
	@Autowired
	private ReserveService reserveService;

	// Listar card home
	@GetMapping
	public String home(Model model) {
		
        List<Destiny> locaisNacionais = destinyService.findByType("Nacional");
        List<Destiny> locaisInternacionais = destinyService.findByType("Internacional");

        model.addAttribute("locaisNacionais", locaisNacionais);
        model.addAttribute("locaisInternacionais", locaisInternacionais);

        return "destiny/home";
    }
	
	//lista promoções
	@GetMapping("/promocoes")
	public String promocoes(Model model) {
        List<Destiny> locaisPromocionais = destinyService.findByType("Promocão");
        model.addAttribute("locaisPromocionais", locaisPromocionais);

        return "destiny/promocoes";
    }

	// Formulário de criação
	@GetMapping("/register/destiny")
	public String showFormForAdd(Model model) {
		Destiny destiny = new Destiny();
		model.addAttribute("destiny", destiny);
		return "destiny/register";
	}

	// Persistencia da criação
	@PostMapping("/register/destiny/save")
	public String saveCurso(@ModelAttribute("destiny") Destiny destiny) {
		destinyService.saveDestiny(destiny);
		return "redirect:/";
	}

	// Formulário de edição
	@GetMapping("/destiny/edit/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		Destiny destiny = destinyService.getDestinyById(id);
		model.addAttribute("destiny", destiny);
		return "destiny/edit";
	}

	// Persistencia da edição
	@PostMapping("destiny/edit/{id}")
	public String updateCurso(@PathVariable Long id, @ModelAttribute("destiny") 
	Destiny destiny) {
		destinyService.updateDestiny(id, destiny);
		return "redirect:/";
	}
	
	// Excluir categoria
	@GetMapping("destiny/delete/{id}")
	public String deleteCurso(@PathVariable Long id) { 
		
		reserveService.deleteReserveByDestiny(id);
		destinyService.deleteDestiny(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
}
