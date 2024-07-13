package br.ufms.facom.listing_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.ufms.facom.listing_jpa.alunos.Aluno;
import br.ufms.facom.listing_jpa.alunos.AlunoRepository;

@Component
public class DatabaseInitializer implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		Aluno a1 = new Aluno("Guilherme", "20240101", "Engenharia de Computação");
		repository.save(a1);

		Aluno a2 = new Aluno("Maria", "20240102", "Engenharia de Software");
		repository.save(a2);

		Aluno a3 = new Aluno("João", "20240103", "Ciência da Computação");
		repository.save(a3);
	}

	@Autowired
	AlunoRepository repository;
}
