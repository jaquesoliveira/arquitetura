package com.arquitetura.infra.adapter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.arquitetura.domain.entity.Editora;
import com.arquitetura.infra.converter.EditoraToEditoraEntityDbConverter;
import com.arquitetura.infra.entities.EditoraEntityDb;

class EditoraToEditoraEntityDbAdapterTest {

	@Test
	void deveRetornarUmaIntanciaDeEditoraEntityDb() {
		Editora editora = new Editora();
		
		assertInstanceOf(EditoraEntityDb.class, 
				new EditoraToEditoraEntityDbConverter(editora).toEditoraEntityDb());   
	}

}
