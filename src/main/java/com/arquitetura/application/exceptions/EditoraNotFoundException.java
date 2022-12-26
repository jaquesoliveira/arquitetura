package com.arquitetura.application.exceptions;

public class EditoraNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6626543250892795502L;
	
	public EditoraNotFoundException() {
		super("Editora não localizada");
	}

}
