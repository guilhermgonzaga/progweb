package br.ufms.facom.listing_jpa.alunos;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Aluno implements Serializable {
	public Aluno() {}

	public Aluno(String nome, String matricula, String curso) {
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getCurso() {
		return curso;
	}

	public Date getMatriculadoEm() {
		return matriculadoEm;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setMatriculadoEm(Date matriculadoEm) {
		this.matriculadoEm = matriculadoEm;
	}

	@Id //@Column
	private String matricula;
	// @Column
	private String nome;
	// @Column
	private String curso;
	private Date matriculadoEm = new Date();
}
