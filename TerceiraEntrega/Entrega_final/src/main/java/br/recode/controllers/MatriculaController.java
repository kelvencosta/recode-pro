package br.recode.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.recode.models.Matricula;
import br.recode.services.MatriculaService;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/matricula")
public class MatriculaController {
	
	@Autowired
	private MatriculaService matriculaService;
	
		// Persistencia da criação
		@PostMapping("/save/")
		public String saveMatricula(@RequestParam Long cursoId, Matricula matricula, Model model, HttpSession session) {
			
			Long alunoId = (Long) session.getAttribute("alunoId");
			
			if(alunoId == null) {
				return "redirect:/alunos/cadastro";
			}
			
			matricula.setAlunoId(alunoId);
			matricula.setCursoId(cursoId);
			
			matriculaService.saveMatricula(matricula);
			
			return "redirect:/cursos";
		}
}