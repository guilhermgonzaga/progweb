package br.ufms.facom.listing_jpa.alunos;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping({"/", "/alunos"})
@Tag(name = "Aluno", description = "Operações de listagem de alunos.")
public class AlunoController {

	@Autowired
	private AlunoService service;

	@Operation(summary = "Listar Alunos", description = "Retorna uma lista de todos os alunos.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso.",
		             content = @Content(mediaType = "application/json",
		             schema = @Schema(implementation = Aluno.class)))
	})
	@GetMapping
	public Iterable<Aluno> listar() {
		return service.listar();
	}

	@Operation(summary = "Contar Alunos por Curso",
	           description = "Conta o número de alunos cadastrados em um curso específico.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Contagem retornada com sucesso.",
		             content = @Content(mediaType = "application/json")),
		@ApiResponse(responseCode = "400", description = "Curso não reconhecido.",
		             content = @Content(mediaType = "text/plain"))
	})
	@GetMapping("/count-by-curso")
	public Map<String, Long> contarPorCurso(@RequestParam String curso) {
		return Map.of("count", service.contarPorCurso(curso));
	}

	@Operation(summary = "Criar Aluno", description = "Cria o cadastro de um aluno no sistema.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = "Aluno cadastrado com sucesso.",
		             content = @Content(mediaType = "application/json",
		             schema = @Schema(implementation = Aluno.class))),
		@ApiResponse(responseCode = "400", description = "Aluno já cadastrado ou erro ao cadastrar aluno.",
		             content = @Content(mediaType = "text/plain"))
	})
	@PostMapping
	public ResponseEntity<?> criar(@RequestBody Aluno aluno) {
		Optional<Aluno> resp = service.criar(aluno);
		if (resp.isEmpty()) {
			return ResponseEntity.badRequest().body("Aluno já cadastrado ou erro ao cadastrar aluno.");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(resp.get());
	}
}
