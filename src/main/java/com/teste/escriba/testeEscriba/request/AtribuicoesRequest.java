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
public class AtribuicoesRequest {

	private String id_atribuicao;
	@NotNull(message = "O nome é obrigatório")
	@Size(max = 50, message = "O nome deverá ter no {max} caracteres")
	private String nome;
	@NotNull(message = "A situação é obrigatório")
	private Boolean situacao = Boolean.TRUE; 
}
