package com.arquitetura.infra.adapter;

import java.util.List;
import java.util.stream.Collectors;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.domain.entity.AutorEntity;
import com.arquitetura.infra.entity.AutorEntityDb;

public class AutorEntityAdapter {
	
	private List<AutorEntityDb> listAutorEntityDb;
	
	private AutorEntity autor;
	
	public AutorEntityAdapter(AutorEntityDb autorEntityDb) {
		this.autor = autorEntityDb;
	}
	
	public AutorEntityAdapter(Autor autor) {
		this.autor = autor;
	}
	
	public AutorEntityAdapter(List<AutorEntityDb> listAutorEntity) {
		this.listAutorEntityDb = listAutorEntity;
	}

	public Autor toAutor() {
		return (Autor) autor;
	}
	
	public AutorEntityDb toAutorEntityDb() {
		return (AutorEntityDb) autor;
	}
	
	public List<Autor> toListAutor(){
		List<Autor> autores = listAutorEntityDb.stream()
				.map(aut -> new Autor(aut.getId(), aut.getName()))
				.collect(Collectors.toList());
		
		return autores;
	}
}
