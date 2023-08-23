package com.teste.escriba.testeEscriba.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CartorioResponse {

	private String nome_cartorio;
	private String observacao;
	private SituacaoResponse situacaoCartorio;
	private AtribuicoesResponse atribuicoesCartorio;
}
