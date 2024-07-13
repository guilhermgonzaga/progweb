package br.ufms.facom.listing_jpa.alunos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	public Iterable<Aluno> listar() {
		return repository.findAll();
	}

	public long contarPorCurso(String curso) {
		return repository.countByCurso(curso);
	}

	public Optional<Aluno> criar(Aluno aluno) {
		if (repository.existsById(aluno.getMatricula())) {
			return Optional.empty();
		}
		return Optional.of(repository.save(aluno));
	}
}
