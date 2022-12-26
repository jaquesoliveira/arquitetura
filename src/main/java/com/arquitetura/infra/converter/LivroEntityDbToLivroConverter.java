package com.arquitetura.infra.converter;

import com.arquitetura.domain.entity.Livro;
import com.arquitetura.infra.entities.LivroEntityDb;

public class LivroEntityDbToLivroConverter {
	
	private LivroEntityDb livroEntityDb;
	
	public LivroEntityDbToLivroConverter(LivroEntityDb livroEntityDb) {
		this.livroEntityDb = livroEntityDb;
	}
	
	public Livro toLivro() {
		
		Livro livro = new Livro();
		livro.setId(livroEntityDb.getId());
		livro.setTitle(livroEntityDb.getTitle());
		livro.setAutor(new AutorEntityDbToAutorConverter(livroEntityDb.getAutorEntityDb()).toAutor() );
		livro.setEditora(new EditoraEntityDbToEditoraConverter( livroEntityDb.getEditoraEntityDb()).toEditora());
		
		return livro;
	}
}
