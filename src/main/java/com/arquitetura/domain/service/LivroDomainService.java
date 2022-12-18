package com.arquitetura.domain.service;

import com.arquitetura.domain.entity.Livro;

public interface LivroDomainService {
	public void validarInclusaoLivro(Livro livro);
	public void validarAlteracaoLivro(Livro livro);
}
