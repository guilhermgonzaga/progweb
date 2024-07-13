package br.ufms.facom.listing_jpa.alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

	@GetMapping
	@ResponseBody
	public Iterable<Aluno> listar() {
		return repository.findAll();
	}

	@GetMapping("count-by-curso")
	@ResponseBody
	public long contarPorCurso(@RequestParam String curso) {
		return repository.countByCurso(curso);
	}

	@Autowired
	private AlunoRepository repository;
}
