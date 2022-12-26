package com.arquitetura.infra.adapter;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.domain.entity.Livro;
import com.arquitetura.infra.converter.LivroEntityDbToLivroConverter;
import com.arquitetura.infra.entities.AutorEntityDb;
import com.arquitetura.infra.entities.EditoraEntityDb;
import com.arquitetura.infra.entities.LivroEntityDb;

class LivroEntityDbToLivroAdapterTest {

	@Test
	void test() {
		LivroEntityDb livroEntityDb = new LivroEntityDb();
		livroEntityDb.setAutorEntityDb(new AutorEntityDb());
		livroEntityDb.setEditoraEntityDb(new EditoraEntityDb());
		
		assertInstanceOf(Livro.class, 
				new LivroEntityDbToLivroConverter(livroEntityDb).toLivro());
	}
}
