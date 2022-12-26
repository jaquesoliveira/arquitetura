package com.arquitetura.application.exceptions.advices;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.arquitetura.application.exceptions.AutorErroDTO;
import com.arquitetura.application.exceptions.AutorNotFoundException;

@ControllerAdvice(basePackages = "com.arquitetura.application.api.controller")
public class AutorControllerAdvice {
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(AutorNotFoundException.class)
	public AutorErroDTO handleAutorNotFound(AutorNotFoundException autorNotFoundException) {
		return new AutorErroDTO("Autor não encontrado", HttpStatus.NOT_FOUND.value(), new Date());
	}
}
