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
		Aluno guilherme = new Aluno("Guilherme", "20240101", "Engenharia de Computação");
		repository.save(guilherme);

		Aluno maria = new Aluno("Maria", "20240102", "Engenharia de Software");
		repository.save(maria);

		Aluno joao = new Aluno("João", "20240103", "Ciência da Computação");
		repository.save(joao);
	}

	@Autowired
	AlunoRepository repository;
}
