package com.arquitetura.application.exceptions;

public class AutorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8895958758365321865L;
	
	public AutorNotFoundException() {
		super("Autor não localizado");
	}
}
