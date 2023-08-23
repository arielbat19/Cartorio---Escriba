package com.teste.escriba.testeEscriba.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AtribuicoesDto {

	private String nome;
	private Boolean situacao = Boolean.TRUE; 
}
