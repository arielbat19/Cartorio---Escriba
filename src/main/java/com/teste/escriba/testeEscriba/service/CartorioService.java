package com.teste.escriba.testeEscriba.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.teste.escriba.testeEscriba.dto.CartorioDto;
import com.teste.escriba.testeEscriba.entity.AtribuicoesCartorio;
import com.teste.escriba.testeEscriba.entity.Cartorio;
import com.teste.escriba.testeEscriba.entity.SituacaoCartorio;
import com.teste.escriba.testeEscriba.repository.CartorioRepository;
import com.teste.escriba.testeEscriba.request.CartorioRequest;

@Service
public class CartorioService {

	@Autowired
	private CartorioRepository cartorioRepository;

	public Optional<Cartorio> buscarCartorioPorId(int id) {
		Optional<Cartorio> response = cartorioRepository.findById(id);
		return response;
	}

	public Page<CartorioDto> buscarTodos(Pageable pageable) {
		Page<Cartorio> p = cartorioRepository.findAll(pageable);

		Page<CartorioDto> employeeDtoPage = p.map(entity -> {
			CartorioDto dto = employeeEntityToDto(entity);
			return dto;
		});

		return employeeDtoPage;
	}

	public CartorioDto employeeEntityToDto(Cartorio entity) {
		CartorioDto employeeDto = new CartorioDto();
		employeeDto.setId(entity.getId_cartorio());
		employeeDto.setNome(entity.getNome_cartorio());
		return employeeDto;
	}

	public void salvarRegistro(CartorioRequest request) throws Exception {

		List<Cartorio> listaCartorio = cartorioRepository.findByNOME_CARTORIO(request.getNome_cartorio());

		if (listaCartorio.size() > 0) {
			throw new Error();
		}

		AtribuicoesCartorio atribuicoesCartorio = AtribuicoesCartorio.builder()
				.nome_atribuicao(request.getAtribuicoesCartorio().getNome())
				.situacao(request.getAtribuicoesCartorio().getSituacao()).build();

		SituacaoCartorio situacaoCartorio = SituacaoCartorio.builder()
				.nome_situacao(request.getSituacaoCartorio().getNome())
				.situacao(request.getSituacaoCartorio().getSituacao()).build();

		Cartorio cartorio = Cartorio.builder().atribuicoesCartorio(atribuicoesCartorio)
				.situacaoCartorio(situacaoCartorio).nome_cartorio(request.getNome_cartorio())
				.observacao(request.getObservacao()).build();

		cartorioRepository.save(cartorio);
	}

	private Cartorio findByid(int id) {
		Optional<Cartorio> response = cartorioRepository.findById(id);
		return response.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CartorioRequest.class.getName(), null));
	}

	public void updateRegistro(int id, CartorioRequest request) {
		Cartorio newCartorio = findByid(id);
		newCartorio.getAtribuicoesCartorio().setNome_atribuicao(request.getAtribuicoesCartorio().getNome());
		newCartorio.getAtribuicoesCartorio().setSituacao(request.getAtribuicoesCartorio().getSituacao());
		newCartorio.getSituacaoCartorio().setNome_situacao(request.getSituacaoCartorio().getNome());
		newCartorio.getSituacaoCartorio().setSituacao(request.getSituacaoCartorio().getSituacao());
		newCartorio.setNome_cartorio(request.getNome_cartorio());
		newCartorio.setObservacao(request.getObservacao());

		cartorioRepository.save(newCartorio);
	}

	public void deleteById(int id) {
		cartorioRepository.deleteById(id);
	}

}
