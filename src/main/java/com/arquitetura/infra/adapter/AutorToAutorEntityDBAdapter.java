package com.arquitetura.infra.adapter;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.domain.entity.AutorEntity;
import com.arquitetura.infra.entity.AutorEntityDb;

public class AutorToAutorEntityDBAdapter {
	
	private AutorEntity autor;
	
	public AutorToAutorEntityDBAdapter(Autor autor) {
		this.autor = autor;
	}

	public AutorEntityDb toAutorEntityDb() {
		AutorEntityDb autorEntityDb = new AutorEntityDb();
		
		autorEntityDb.setId( autor.getId() );
		autorEntityDb.setName( autor.getName() );
		
		return autorEntityDb;
	}
}
