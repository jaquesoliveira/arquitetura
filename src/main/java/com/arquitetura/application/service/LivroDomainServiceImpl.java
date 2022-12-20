package com.arquitetura.application.service;

import com.arquitetura.domain.entity.Livro;
import com.arquitetura.domain.service.LivroDomainService;

public class LivroDomainServiceImpl implements LivroDomainService {

	@Override
	public void validarSaveLivro(Livro livro) {
		
		verificaSeLivroEhNulo(livro);		
		verificaSeTituloDoLivroEhNulo(livro);		
		verificaSeTituloDoLivroEhVazio(livro);
	}
	
	private void verificaSeLivroEhNulo(Livro livro) {
		if (livro == null) {
			throw new RuntimeException("Livro não pode ser nulo!");
		}
	}
	
	private void verificaSeTituloDoLivroEhNulo(Livro livro) {
		if (livro.getTitle() == null) {
			throw new RuntimeException("Título não pode ser nulo!");
		}
	}

	private void verificaSeTituloDoLivroEhVazio(Livro livro) {
		if (livro.getTitle().isEmpty()) {
			throw new RuntimeException("Título não pode ser nulo!");
		}
	}

	@Override
	public void validarEditLivro(Livro livro) {		
		verificaSeLivroEhNulo(livro);		
		verificaSeTituloDoLivroEhNulo(livro);		
		verificaSeTituloDoLivroEhVazio(livro);
		verificarSeIdEhNulo(livro);
		
	}

	private void verificarSeIdEhNulo(Livro livro) {
		if (livro.getId() == null) {
			throw new RuntimeException("Id não pode ser nulo!");
		}
	}
}
