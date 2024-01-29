package br.recode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.recode.models.Usuario;
import br.recode.services.UsuarioService;
import br.recode.services.MatriculaService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/alunos")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private MatriculaService matriculaService;
	
	// Listar
	@GetMapping
	public String listAlunos(Model model) {
		List<Usuario> usuarios = usuarioService.getAllAlunos();
		model.addAttribute("alunos", usuarios);
		return "aluno/ListarAlunos";
	}
	@GetMapping("/cadastro")
	public String showFormForAdd(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("aluno", usuario);
		return "aluno/cadastro";
	}

	// Persistencia da criação
	@PostMapping("/save")
	public String saveAluno(@ModelAttribute("aluno") Usuario usuario, Model model, HttpSession session) {
		
		usuarioService.saveAluno(usuario);
		
		session.setAttribute("alunoId", usuario.getId());
		
		return "redirect:/alunos";
	}

	// Formulário de edição
	@GetMapping("/editar/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		Usuario usuario = usuarioService.getAlunoById(id);
		model.addAttribute("usuario", usuario);
		return "aluno/editarAluno";
	}

	// Persistencia da edição
	@PostMapping("/editar/{id}")
	public String updateAluno(@PathVariable Long id, @ModelAttribute("usuario") 
	Usuario usuario) {
		usuarioService.updateAluno(id, usuario);
		return "redirect:/alunos";
	}
	
	// Excluir categoria
	@GetMapping("/deletar/{id}")
	public String deleteAluno(@PathVariable Long id, HttpSession session) { 
		
		matriculaService.deleteMatriculasByUsuario(id);
		usuarioService.deleteAluno(id);

		session.setAttribute("alunoId", null);
	
		return "redirect:/alunos";
	}
}
