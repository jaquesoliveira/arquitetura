package com.arquitetura.infra.converter;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.domain.entity.AutorEntity;
import com.arquitetura.infra.entities.AutorEntityDb;

public class AutorToAutorEntityDBConverter {
	
	private AutorEntity autor;
	
	public AutorToAutorEntityDBConverter(Autor autor) {
		this.autor = autor;
	}

	public AutorEntityDb toAutorEntityDb() {
		AutorEntityDb autorEntityDb = new AutorEntityDb();
		
		autorEntityDb.setId( autor.getId() );
		autorEntityDb.setName( autor.getName() );
		
		return autorEntityDb;
	}
}
