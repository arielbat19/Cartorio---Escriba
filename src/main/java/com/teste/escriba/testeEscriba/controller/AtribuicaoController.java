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

import com.teste.escriba.testeEscriba.dto.AtribuicoesDto;
import com.teste.escriba.testeEscriba.entity.AtribuicoesCartorio;
import com.teste.escriba.testeEscriba.request.AtribuicoesRequest;
import com.teste.escriba.testeEscriba.service.AtribuicaoService;

@RestController
@RequestMapping("api/v1/atribuicao")
public class AtribuicaoController {

	@Autowired
	private AtribuicaoService service;

	@GetMapping("/buscar-atribuicao/{id}")
	public Optional<AtribuicoesCartorio> getById(@Valid @PathVariable int id) {
		Optional<AtribuicoesCartorio> response = service.buscarAtribuicaoPorId(id);
		return response;
	}

	@GetMapping()
	public List<AtribuicoesDto> getAll(@Valid @PageableDefault(value = 10) Pageable pageable) {
		Page<AtribuicoesDto> response = service.buscarTodos(pageable);
		return response.getContent();
	}

	@PostMapping("/incluir-atribuicao")
	public ResponseEntity<HttpStatus> incluirAtribuicao(@Valid @RequestBody AtribuicoesRequest atribuicoesRequest) {
		service.salvarAtribuicao(atribuicoesRequest);
		return ResponseEntity.ok().body(HttpStatus.CREATED);
	}

	@PutMapping("/atualizar-atribuicao/{id}")
	public ResponseEntity<HttpStatus> atualizarAtribuicao(@Valid @PathVariable int id,
			@RequestBody AtribuicoesRequest atribuicoesRequest) throws Exception {
		service.updateAtribuicao(id, atribuicoesRequest);
		return ResponseEntity.ok().body(HttpStatus.OK);
	}

	@DeleteMapping("/deletar-atribuicao/{id}")
	public ResponseEntity<HttpStatus> deleteById(@Valid @PathVariable int id) {
		service.deleteById(id);
		return ResponseEntity.ok().body(HttpStatus.OK);
	}

}
