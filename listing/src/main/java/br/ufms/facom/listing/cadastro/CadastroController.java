package br.ufms.facom.listing.cadastro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufms.facom.listing.model.Aluno;

@Controller
public class CadastroController {

	List<Aluno> alunos = new ArrayList<>();

	@GetMapping({"/", "/lista"})
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("lista");
		mv.addObject("alunos", alunos);
		return mv;
	}

	@GetMapping("/cadastro")
	public String cadastro(Model model) {
		model.addAttribute("aluno", new Aluno("", "", ""));
		return "cadastro";
	}

	@PostMapping("/cadastro")
	public String cadastro(Aluno a) {
		alunos.add(new Aluno(a.getNome(), a.getMatricula(), a.getCurso()));
		return "redirect:/lista";
	}
}
