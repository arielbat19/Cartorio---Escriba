package com.teste.escriba.testeEscriba.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CartorioRequest {

	private int id;
	@NotNull(message = "O nome é obrigatório")
	@Size(max = 150, message = "O nome deverá ter no {max} caracteres")
	private String nome_cartorio;
	@Size(max = 250, message = "testetse")
	private String observacao;
	@NotNull(message = "A situação é obrigatório")
	private SituacaoRequest situacaoCartorio;
	@NotNull(message = "Aatribuição é obrigatório")
	private AtribuicoesRequest atribuicoesCartorio;
}
