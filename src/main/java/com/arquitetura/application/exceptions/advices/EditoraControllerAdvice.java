package com.arquitetura.application.exceptions.advices;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.arquitetura.application.exceptions.EditoraErroDTO;
import com.arquitetura.application.exceptions.EditoraNotFoundException;

public class EditoraControllerAdvice {
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EditoraNotFoundException.class)
	public EditoraErroDTO handleEditoraNotFound(EditoraNotFoundException EditoraNotFoundException) {
		return new EditoraErroDTO("Editora não encontrada", HttpStatus.NOT_FOUND.value(), new Date());
	}
}
