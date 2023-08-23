package com.teste.escriba.testeEscriba.service;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.teste.escriba.testeEscriba.dto.AtribuicoesDto;
import com.teste.escriba.testeEscriba.entity.AtribuicoesCartorio;
import com.teste.escriba.testeEscriba.repository.AtribuicaoRepository;
import com.teste.escriba.testeEscriba.request.AtribuicoesRequest;

@Service
public class AtribuicaoService {

	@Autowired
	private AtribuicaoRepository atribuicaoRepository;

	public Optional<AtribuicoesCartorio> buscarAtribuicaoPorId(int id) {
		Optional<AtribuicoesCartorio> response = atribuicaoRepository.findById(id);
		return response;
	}

	public Page<AtribuicoesDto> buscarTodos(Pageable pageable) {
		Page<AtribuicoesCartorio> p = atribuicaoRepository.findAll(pageable);

		Page<AtribuicoesDto> employeeDtoPage = p.map(entity -> {
			AtribuicoesDto dto = employeeEntityToDto(entity);
			return dto;
		});

		return employeeDtoPage;
	}

	public AtribuicoesDto employeeEntityToDto(AtribuicoesCartorio entity) {
		AtribuicoesDto employeeDto = new AtribuicoesDto();
		employeeDto.setNome(entity.getNome_atribuicao());
		employeeDto.setSituacao(entity.getSituacao());
		return employeeDto;
	}

	public void salvarAtribuicao(AtribuicoesRequest request) {

		AtribuicoesCartorio AtribuicoesCartorio = com.teste.escriba.testeEscriba.entity.AtribuicoesCartorio.builder()
				.nome_atribuicao(request.getNome()).situacao(request.getSituacao()).build();

		atribuicaoRepository.save(AtribuicoesCartorio);
	}

	private AtribuicoesCartorio findByid(int id) {
		Optional<AtribuicoesCartorio> response = atribuicaoRepository.findById(id);
		return response.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + AtribuicoesCartorio.class.getName(), null));
	}

	public void updateAtribuicao(int id, AtribuicoesRequest request) {
		AtribuicoesCartorio newSituacao = findByid(id);

		newSituacao.setNome_atribuicao(request.getNome());
		newSituacao.setSituacao(request.getSituacao());

		atribuicaoRepository.save(newSituacao);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	public void deleteById(int id) {

		try {
			atribuicaoRepository.deleteById(id);
		} catch (ConstraintViolationException e) {
			throw new ConstraintViolationException(null);
		}
	}

}
