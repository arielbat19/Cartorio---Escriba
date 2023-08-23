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

import com.teste.escriba.testeEscriba.dto.CartorioDto;
import com.teste.escriba.testeEscriba.entity.Cartorio;
import com.teste.escriba.testeEscriba.request.CartorioRequest;
import com.teste.escriba.testeEscriba.service.CartorioService;

@RestController
@RequestMapping("api/v1/cartorio")
public class CartorioController {

	@Autowired
	private CartorioService service;

	@GetMapping("/buscarRegistro/{id}")
	public Optional<Cartorio> getById(@Valid @PathVariable int id) {
		Optional<Cartorio> response = service.buscarCartorioPorId(id);
		return response;
	}

	@GetMapping()
	public List<CartorioDto> getAll(@Valid @PageableDefault(value = 10) Pageable pageable) {
		Page<CartorioDto> response = service.buscarTodos(pageable);
		return response.getContent();
	}

	@PostMapping("/incluir-registro")
	public ResponseEntity<HttpStatus> incluirRegistro(@Valid @RequestBody CartorioRequest cartorioRequest) throws Exception {
		service.salvarRegistro(cartorioRequest);
		return ResponseEntity.ok().body(HttpStatus.CREATED);
	}

	@PutMapping("/atualizar-registro/{id}")
	public ResponseEntity<HttpStatus> atualizarRegistro(@Valid @PathVariable int id,
			@RequestBody CartorioRequest cartorioRequest) throws Exception {
		service.updateRegistro(id, cartorioRequest);
		return ResponseEntity.ok().body(HttpStatus.OK);
	}

	@DeleteMapping("/deletarRegistro/{id}")
	public ResponseEntity<HttpStatus> deleteById(@Valid @PathVariable int id) {
		service.deleteById(id);
		return ResponseEntity.ok().body(HttpStatus.OK);
	}

}
