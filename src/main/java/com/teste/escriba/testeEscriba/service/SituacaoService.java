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

import com.teste.escriba.testeEscriba.dto.SituacaoDto;
import com.teste.escriba.testeEscriba.entity.SituacaoCartorio;
import com.teste.escriba.testeEscriba.repository.SituacaoRepository;
import com.teste.escriba.testeEscriba.request.SituacaoRequest;

@Service
public class SituacaoService {

	@Autowired
	private SituacaoRepository situacaoRepository;

	public Optional<SituacaoCartorio> buscarSituacaoPorId(int id) {
		Optional<SituacaoCartorio> response = situacaoRepository.findById(id);
		return response;
	}

	public Page<SituacaoDto> buscarTodos(Pageable pageable) {
		Page<SituacaoCartorio> p = situacaoRepository.findAll(pageable);

		Page<SituacaoDto> employeeDtoPage = p.map(entity -> {
			SituacaoDto dto = employeeEntityToDto(entity);
			return dto;
		});

		return employeeDtoPage;
	}

	public SituacaoDto employeeEntityToDto(SituacaoCartorio entity) {
		SituacaoDto employeeDto = new SituacaoDto();
		employeeDto.setNome(entity.getNome_situacao());
		employeeDto.setSituacao(entity.getSituacao());
		return employeeDto;
	}

	public void salvarSituacao(SituacaoRequest request) {

		SituacaoCartorio situacaoCartorio = SituacaoCartorio.builder().nome_situacao(request.getNome())
				.situacao(request.getSituacao()).build();

		situacaoRepository.save(situacaoCartorio);
	}

	private SituacaoCartorio findByid(int id) {
		Optional<SituacaoCartorio> response = situacaoRepository.findById(id);
		return response.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + SituacaoCartorio.class.getName(), null));
	}

	public void updateSituacao(int id, SituacaoRequest request) {
		SituacaoCartorio newSituacao = findByid(id);

		newSituacao.setNome_situacao(request.getNome());
		newSituacao.setSituacao(request.getSituacao());

		situacaoRepository.save(newSituacao);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	public void deleteById(int id) {

		try {
			situacaoRepository.deleteById(id);
		} catch (ConstraintViolationException e) {
			throw new ConstraintViolationException(null);
		}
	}

}
