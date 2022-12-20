package com.arquitetura.domain.service;

import com.arquitetura.domain.entity.Livro;

public interface LivroDomainService {
	public void validarSaveLivro(Livro livro);
	public void validarEditLivro(Livro livro);
	//public void validarExcluirLivro(User user);
}
