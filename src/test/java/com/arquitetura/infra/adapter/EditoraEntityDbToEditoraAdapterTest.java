package com.arquitetura.infra.adapter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.arquitetura.domain.entity.Editora;
import com.arquitetura.infra.entity.EditoraEntityDb;

class EditoraEntityDbToEditoraAdapterTest {

	@Test
	void deveRetornarUmaIntanciaDeEditora() {
		EditoraEntityDb editoraEntityDb = new EditoraEntityDb();
		
		assertInstanceOf(Editora.class, 
				new EditoraEntityDbToEditoraAdapter(editoraEntityDb).toEditora());   
	}
}
