package com.arquitetura.infra.adapter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.infra.entity.AutorEntityDb;

class AutorToAutorEntityDBAdapterTest {

	@Test
	void test() {
		Autor autor = new Autor();		
		AutorEntityDb entityDb = new AutorToAutorEntityDBAdapter(autor).toAutorEntityDb();
		
		assertInstanceOf(AutorEntityDb.class, entityDb);
	}
}
