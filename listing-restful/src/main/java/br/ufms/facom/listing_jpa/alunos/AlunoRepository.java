package br.ufms.facom.listing_jpa.alunos;

import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<Aluno, String> {
	long countByCurso(String curso);
}
