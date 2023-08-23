package com.teste.escriba.testeEscriba.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SituacaoRequest {
	private String id_situacao;
	@NotNull(message = "O nome é obrigatório")
	@Size(max = 50, message = "O nome deverá ter no {max} caracteres")
	private String nome;
	@NotNull(message = "A situação é obrigatório")
	private String situacao;
}
