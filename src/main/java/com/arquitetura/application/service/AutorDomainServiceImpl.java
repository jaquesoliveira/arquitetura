package com.arquitetura.application.service;

import org.springframework.stereotype.Service;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.domain.service.AutorDomainService;

@Service
public class AutorDomainServiceImpl implements AutorDomainService {

	@Override
	public void validarSaveAutor(Autor autor) {
		if (autor.getName() == null) {
			throw new RuntimeException("Nome do Autor é obrigatório!");
		}
	}

	@Override
	public void validarEditAutor(Autor autor) {
		if (autor.getId() == null || autor.getName() == null) {
			throw new RuntimeException("Id e Nome do Autor são obrigatórios!");
		}
	}
}
