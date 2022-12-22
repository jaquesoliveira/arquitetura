package com.arquitetura.infra.adapter;

import com.arquitetura.domain.entity.Livro;
import com.arquitetura.infra.entity.LivroEntityDb;

public class LivroEntityDbToLivroAdapter {
	
	private LivroEntityDb livroEntityDb;
	
	public LivroEntityDbToLivroAdapter(LivroEntityDb livroEntityDb) {
		this.livroEntityDb = livroEntityDb;
	}
	
	public Livro toLivro() {
		
		Livro livro = new Livro();
		livro.setId(livroEntityDb.getId());
		livro.setTitle(livroEntityDb.getTitle());
		livro.setAutor(new AutorEntityDbToAutorAdapter(livroEntityDb.getAutorEntityDb()).toAutor() );
		livro.setEditora(new EditoraEntityDbToEditoraAdapter( livroEntityDb.getEditoraEntityDb()).toEditora());
		
		return livro;
	}
}
