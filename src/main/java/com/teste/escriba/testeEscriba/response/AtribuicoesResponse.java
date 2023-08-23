package com.teste.escriba.testeEscriba.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AtribuicoesResponse {

	private String id_atribuicao;
	private String nome;
	private Boolean situacao = Boolean.TRUE; 
}
