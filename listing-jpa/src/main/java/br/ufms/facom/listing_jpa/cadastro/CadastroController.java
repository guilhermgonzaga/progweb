package br.ufms.facom.listing_jpa.cadastro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufms.facom.listing_jpa.alunos.Aluno;
import br.ufms.facom.listing_jpa.alunos.AlunoRepository;

@Controller
public class CadastroController {

	@GetMapping({"/", "/lista"})
	public ModelAndView lista() {
		List<Aluno> alunos = new ArrayList<>();
		repository.findAll().forEach(alunos::add);

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
	public String cadastro(Aluno aluno) {
		repository.save(aluno);

		return "redirect:/lista";
	}

	@Autowired
	AlunoRepository repository;
}
