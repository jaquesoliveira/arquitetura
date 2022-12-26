package com.arquitetura.infra.adapter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.arquitetura.domain.entity.Editora;
import com.arquitetura.infra.converter.EditoraEntityDbToEditoraConverter;
import com.arquitetura.infra.entities.EditoraEntityDb;

class EditoraEntityDbToEditoraAdapterTest {

	@Test
	void deveRetornarUmaIntanciaDeEditora() {
		EditoraEntityDb editoraEntityDb = new EditoraEntityDb();
		
		assertInstanceOf(Editora.class, 
				new EditoraEntityDbToEditoraConverter(editoraEntityDb).toEditora());   
	}
}
