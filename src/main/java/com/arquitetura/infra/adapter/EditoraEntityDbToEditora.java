package com.arquitetura.infra.adapter;

import com.arquitetura.domain.entity.Editora;
import com.arquitetura.infra.entity.EditoraEntityDb;

public class EditoraEntityDbToEditora {
	
	private EditoraEntityDb editoraEntityDb;
	
	public EditoraEntityDbToEditora(EditoraEntityDb editoraEntityDb) {
		this.editoraEntityDb = editoraEntityDb;
	}
		
	public Editora toEditora() {		
		Editora editora = new Editora();		
		editora.setId(editoraEntityDb.getId());
		editora.setName(editoraEntityDb.getName());
		
		return editora;
	}
}
