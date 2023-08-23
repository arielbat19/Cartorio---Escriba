package com.teste.escriba.testeEscriba.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SituacaoResponse {
	private String id_situacao;
	private String nome;
	private String situacao;
}
