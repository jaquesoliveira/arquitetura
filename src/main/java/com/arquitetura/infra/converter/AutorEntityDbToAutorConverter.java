package com.arquitetura.infra.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.infra.entities.AutorEntityDb;

/**
 * @author Jaques Oliveira 
 *
 */
public class AutorEntityDbToAutorConverter {
	
	private AutorEntityDb autorEntityDb;	
	private List<AutorEntityDb> listAutorEntityDb;

	public AutorEntityDbToAutorConverter(AutorEntityDb autorEntityDb) {
		this.autorEntityDb = autorEntityDb;
	}
	
	public AutorEntityDbToAutorConverter(List<AutorEntityDb> listAutorEntityDb) {
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
