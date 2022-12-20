package com.arquitetura.infra.adapter;

import java.util.List;
import java.util.stream.Collectors;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.infra.entity.AutorEntityDb;

/**
 * @author Jaques Oliveira 
 *
 */
public class AutorEntityDbAdapterToAutor {
	
	private AutorEntityDb autorEntityDb;	
	private List<AutorEntityDb> listAutorEntityDb;

	public AutorEntityDbAdapterToAutor(AutorEntityDb autorEntityDb) {
		this.autorEntityDb = autorEntityDb;
	}
	
	public AutorEntityDbAdapterToAutor(List<AutorEntityDb> listAutorEntityDb) {
		this.listAutorEntityDb = listAutorEntityDb;
	}
		
	public Autor toAutor() {		
		Autor autor = new Autor(
				autorEntityDb.getId(),
				autorEntityDb.getName());
		
		return autor;
	}
	
	public List<Autor> toListAutor(){
		List<Autor> autores = listAutorEntityDb.stream()
				.map(aut -> new Autor(aut.getId(), aut.getName()))
				.collect(Collectors.toList());
		
		return autores;
	}
}
