package com.arquitetura.infra.adapter;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.domain.entity.Livro;
import com.arquitetura.infra.entity.AutorEntityDb;
import com.arquitetura.infra.entity.EditoraEntityDb;
import com.arquitetura.infra.entity.LivroEntityDb;

class LivroEntityDbToLivroAdapterTest {

	@Test
	void test() {
		LivroEntityDb livroEntityDb = new LivroEntityDb();
		livroEntityDb.setAutorEntityDb(new AutorEntityDb());
		livroEntityDb.setEditoraEntityDb(new EditoraEntityDb());
		
		assertInstanceOf(Livro.class, 
				new LivroEntityDbToLivroAdapter(livroEntityDb).toLivro());
	}
}
