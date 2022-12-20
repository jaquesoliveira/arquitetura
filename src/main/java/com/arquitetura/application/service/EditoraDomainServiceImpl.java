package com.arquitetura.application.service;

import com.arquitetura.domain.entity.Editora;
import com.arquitetura.domain.service.EditorDomainService;

public class EditoraDomainServiceImpl implements EditorDomainService{

	@Override
	public void validarSaveEditora(Editora editora) {
		
		verificarSeEditoraEhNula(editora);
		
		if ( editora.getName() == null || editora.getName().isEmpty() ) {
			throw new RuntimeException("O nome da editora é obrigatório!");
		}
	}

	@Override
	public void validarEditEditora(Editora editora) {
		verificarSeEditoraEhNula(editora);
		
		if ( editora.getId() == null 
				|| (editora.getName() == null || editora.getName().isEmpty()) ) {
			throw new RuntimeException("Id e Nome da Editora são obrigatórios!");
		}
	}

	private void verificarSeEditoraEhNula(Editora editora) {
		if ( editora == null ) {
			throw new RuntimeException("Editora não pode ser nula!");
		}
	}
}
