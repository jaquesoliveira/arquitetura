package com.arquitetura.infra.adapter;

import com.arquitetura.domain.entity.Livro;
import com.arquitetura.infra.entity.LivroEntityDb;

public class LivroEntityDbToLivro {
	
	private LivroEntityDb livroEntityDb;
	
	public LivroEntityDbToLivro(LivroEntityDb livroEntityDb) {
		this.livroEntityDb = livroEntityDb;
	}
	
	public Livro toLivro() {
		
		Livro livro = new Livro();
		livro.setId(livroEntityDb.getId());
		livro.setTitle(livroEntityDb.getTitle());
		livro.setAutor(new AutorEntityDbAdapterToAutor(livroEntityDb.getAutorEntityDb()).toAutor() );
		livro.setEditora(new EditoraEntityDbToEditora( livroEntityDb.getEditoraEntityDb()).toEditora());
		
		return livro;
	}

}
