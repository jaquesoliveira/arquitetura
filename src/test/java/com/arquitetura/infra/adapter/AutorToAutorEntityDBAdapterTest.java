package com.arquitetura.infra.adapter;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.infra.converter.AutorToAutorEntityDBConverter;
import com.arquitetura.infra.entities.AutorEntityDb;

class AutorToAutorEntityDBAdapterTest {

	@Test
	void deveRetornarUmaIntanciaDeAutorEntityDb() {
		Autor autor = new Autor();		
		
		assertInstanceOf(AutorEntityDb.class, 
				new AutorToAutorEntityDBConverter(autor).toAutorEntityDb());
	}
}
