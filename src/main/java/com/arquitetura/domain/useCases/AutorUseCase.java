package com.arquitetura.domain.useCases;

import com.arquitetura.domain.entity.Autor;

public interface AutorUseCase {
	public void validarSaveAutor(Autor autor) ;
	public void validarEditAutor(Autor autor) ;
}
