package com.teste.escriba.testeEscriba.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultError {
	
	private int code;
	private String message;

}
