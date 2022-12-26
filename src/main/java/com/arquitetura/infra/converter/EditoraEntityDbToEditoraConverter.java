package com.arquitetura.infra.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.arquitetura.domain.entity.Editora;
import com.arquitetura.infra.entities.EditoraEntityDb;

public class EditoraEntityDbToEditoraConverter {

	private EditoraEntityDb editoraEntityDb;

	private List<EditoraEntityDb> listEditoraEntityDb;

	public EditoraEntityDbToEditoraConverter(EditoraEntityDb editoraEntityDb) {
		this.editoraEntityDb = editoraEntityDb;
	}

	public EditoraEntityDbToEditoraConverter(List<EditoraEntityDb> listEditoraEntityDb) {
		this.listEditoraEntityDb = listEditoraEntityDb;
	}

	public Editora toEditora() {
		Editora editora = new Editora();
		editora.setId(editoraEntityDb.getId());
		editora.setName(editoraEntityDb.getName());

		return editora;
	}

	public List<Editora> toListEditora() {

		List<Editora> editoras = listEditoraEntityDb.stream()
				.map(edi -> new Editora(edi.getId(), edi.getName()))
				.collect(Collectors.toList());

		return editoras;
	}
}
