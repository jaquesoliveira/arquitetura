package com.arquitetura.infra.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.domain.entity.Editora;
import com.arquitetura.infra.entities.EditoraEntityDb;

public class EditoraToEditoraEntityDbConverter {

    private Editora editora;

    private List<EditoraEntityDb> listEditoraEntityDb;
	
	public EditoraToEditoraEntityDbConverter(Editora editora) {
		this.editora = editora;
	}
	
	public EditoraToEditoraEntityDbConverter(List<EditoraEntityDb> listEditoraEntityDb) {
		this.listEditoraEntityDb = listEditoraEntityDb;
	}
		
	public EditoraEntityDb toEditoraEntityDb() {		
		EditoraEntityDb editoraEntityDb = new EditoraEntityDb();		
		editora.setId(editora.getId());
		editora.setName(editora.getName());
		
		return editoraEntityDb;
	}
	
	public List<Editora> toListEditora(){
		
		List<Editora> editoras = listEditoraEntityDb.stream()
				.map(edi -> new Editora(edi.getId(), edi.getName()))
				.collect(Collectors.toList());
		
		return editoras;
	}
}
