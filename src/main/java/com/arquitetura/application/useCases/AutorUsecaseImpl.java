package com.arquitetura.application.useCases;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.domain.useCases.AutorUseCase;

public class AutorUsecaseImpl implements AutorUseCase {
	
	@Override
	public void validarSaveAutor(Autor autor) {
		if (autor.getName() == null || autor.getName().isEmpty()) {
			throw new RuntimeException("Nome do Autor é obrigatório!");
		}
	}

	@Override
	public void validarEditAutor(Autor autor) {
		if (autor.getId() == null 
				|| ( autor.getName() == null || autor.getName().isEmpty() ) ) {
			throw new RuntimeException("Id e Nome do Autor são obrigatórios!");
		}
	}
}
