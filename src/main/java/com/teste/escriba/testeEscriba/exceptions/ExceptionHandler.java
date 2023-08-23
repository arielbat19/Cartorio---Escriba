package com.teste.escriba.testeEscriba.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.teste.escriba.testeEscriba.exceptions.dto.DefaultError;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
	public ResponseEntity handlerException(Exception e) {
		
		DefaultError error = new DefaultError(HttpStatus.NOT_FOUND.value(), "Registro não encontradao na base de dados!");
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity handlerExceptions(Exception e) {
		
		DefaultError error = new DefaultError(HttpStatus.UNAUTHORIZED.value(), "Registro utilizado em outro cadastro!");
		return new ResponseEntity(error, HttpStatus.UNAUTHORIZED);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Error.class)
	public ResponseEntity exceptions(Exception e) {
		
		DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.value(), "Registro já cadastro!");
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

}
