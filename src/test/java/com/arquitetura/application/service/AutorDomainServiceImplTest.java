package com.arquitetura.application.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.arquitetura.application.useCases.AutorUsecaseImpl;
import com.arquitetura.domain.entity.Autor;

public class AutorDomainServiceImplTest {
	
	AutorUsecaseImpl autorDomainServiceImpl;
	
	@BeforeEach
	public void config() {
		autorDomainServiceImpl = new AutorUsecaseImpl();
	}

	@Test
	public void deveRetornarException_QuandoNomeVazioOuNulo() {
		
		Autor autor = new Autor();
		
		Exception exception = assertThrows(RuntimeException.class, 
				() -> {autorDomainServiceImpl.validarSaveAutor(autor);});
		
		String mensagemEsperada = "Nome do Autor é obrigatório!";
		String mensagemRecebida = exception.getMessage();
		
		assertTrue(mensagemRecebida.contains(mensagemEsperada));
	}
	
	@Test
	public void deveRetornarException_QuandoIdOuNomeForNulo_OuONomeForVazio() {
		Autor autor = new Autor(null, "sac");
		
		Exception exception = assertThrows(RuntimeException.class, 
				() -> { autorDomainServiceImpl.validarEditAutor(autor); });
		
		String mensagemEsperada = "Id e Nome do Autor são obrigatórios!";
		String mensagemRecebida = exception.getMessage();
		
		assertTrue(mensagemRecebida.contains(mensagemEsperada));
	}
}
