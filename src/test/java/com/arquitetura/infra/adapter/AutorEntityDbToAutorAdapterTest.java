package com.arquitetura.infra.adapter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.infra.entity.AutorEntityDb;

class AutorEntityDbToAutorAdapterTest {

	@Test
	void deveRetornarUmaIntanciaDeAutor() {
		AutorEntityDb autorEntityDb = new AutorEntityDb();		
		
		assertInstanceOf(Autor.class, 
				new AutorEntityDbToAutorAdapter(autorEntityDb).toAutor());
	}
	
	@Test
	void deveRetornarUmaListaDeAutor_OTipoDosItensDaListaDevemSerIguais() {
		List<Autor> listExpected = new ArrayList<>();
		listExpected.add(new Autor());

		List<AutorEntityDb> listAutorEntityDb = new ArrayList<AutorEntityDb>();	
		listAutorEntityDb.add(new AutorEntityDb());
		
		assertInstanceOf(
				listExpected.get(0).getClass(), 
				new AutorEntityDbToAutorAdapter(listAutorEntityDb).toListAutor().get(0));
	}
}
