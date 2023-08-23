package com.teste.escriba.testeEscriba.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.escriba.testeEscriba.dto.SituacaoDto;
import com.teste.escriba.testeEscriba.entity.SituacaoCartorio;
import com.teste.escriba.testeEscriba.request.SituacaoRequest;
import com.teste.escriba.testeEscriba.service.SituacaoService;

@RestController
@RequestMapping("api/v1/situacao")
public class SituacaoController {

	@Autowired
	private SituacaoService service;

	@GetMapping("/buscar-situacao/{id}")
	public Optional<SituacaoCartorio> getById(@Valid @PathVariable int id) {
		Optional<SituacaoCartorio> response = service.buscarSituacaoPorId(id);
		return response;
	}

	@GetMapping()
	public List<SituacaoDto> getAll(@Valid @PageableDefault(value = 10) Pageable pageable) {
		Page<SituacaoDto> response = service.buscarTodos(pageable);
		return response.getContent();
	}

	@PostMapping("/incluir-situacao")
	public ResponseEntity<HttpStatus> incluirSituacao(@RequestBody SituacaoRequest situacaoRequest) {
		service.salvarSituacao(situacaoRequest);
		return ResponseEntity.ok().body(HttpStatus.CREATED);
	}

	@PutMapping("/atualizar-situacao/{id}")
	public ResponseEntity<HttpStatus> atualizarSituacao(@Valid @PathVariable int id,
			@RequestBody SituacaoRequest situacaoRequest) throws Exception {
		service.updateSituacao(id, situacaoRequest);
		return ResponseEntity.ok().body(HttpStatus.OK);
	}

	@DeleteMapping("/deletar-situacao/{id}")
	public ResponseEntity<HttpStatus> deleteById(@Valid @PathVariable int id) {
		service.deleteById(id);
		return ResponseEntity.ok().body(HttpStatus.OK);
	}

}
