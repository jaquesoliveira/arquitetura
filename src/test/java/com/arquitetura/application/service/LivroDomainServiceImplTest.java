package com.arquitetura.application.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.arquitetura.domain.entity.Livro;


class LivroDomainServiceImplTest {
	
	
	LivroDomainServiceImpl domainServiceImpl;
	
	@BeforeEach
	public void init() {
		this.domainServiceImpl = new LivroDomainServiceImpl();  
	}

	@Test
	void deveRetornarUmaException_QuandoLivroForNulo() {
		//Livro livro = new Livro();
		
		Exception exception = assertThrows(RuntimeException.class, 
				() -> { domainServiceImpl.validarSaveLivro(null); });
		
		String mensagemEsperada = "Livro não pode ser nulo!";
		String mensagemRecebida = exception.getMessage();		
		assertTrue(mensagemRecebida.contains(mensagemEsperada));
	}
	
	@Test
	void deveRetornarUmaException_QuandoTituloDoLivroForNulo() {
		Livro livro = new Livro(null);
		
		Exception exception = assertThrows(RuntimeException.class, 
				() -> { domainServiceImpl.validarSaveLivro(livro); });
				
		String mensagemEsperada = "Título não pode ser nulo!";
		String mensagemRecebida = exception.getMessage();
		
		assertTrue(mensagemRecebida.contains(mensagemEsperada));
	}
	
	@Test
	void deveRetornarUmaException_QuandoTituloDoLivroForVazio() {
		Livro livro = new Livro("");
		
		Exception exception = assertThrows(RuntimeException.class, 
				() -> { domainServiceImpl.validarSaveLivro(livro); });
		
		String mensagemEsperada = "Título não pode ser vazio!";
		String mensagemRecebida = exception.getMessage();
		
		assertTrue(mensagemRecebida.contains(mensagemEsperada));
	}
	
	@Test
	void deveRetornarUmaException_QuandoIdDoLivroForNulo() {
		Livro livro = new Livro(null, "jaksdjaksdjalk");
		
		Exception exception = assertThrows(RuntimeException.class, 
				() -> { domainServiceImpl.validarEditLivro(livro); });
		
		String mensagemEsperada = "Id não pode ser nulo!";
		String mensagemRecebida = exception.getMessage();
		
		assertTrue(mensagemRecebida.contains(mensagemEsperada));
	}
	
	@Test
	void deveRetornarUmaException_QuandoTitleDoLivroForNulo() {
		Livro livro = new Livro(1L, null);
		
		Exception exception = assertThrows(RuntimeException.class, 
				() -> { domainServiceImpl.validarEditLivro(livro); });
		
		String mensagemEsperada = "Título não pode ser nulo!";
		String mensagemRecebida = exception.getMessage();
		
		assertTrue(mensagemRecebida.contains(mensagemEsperada));
	}
	
	@Test
	void deveRetornarUmaException_QuandoTitleDoLivroForVazio() {
		Livro livro = new Livro(1L, "");
		
		Exception exception = assertThrows(RuntimeException.class, 
				() -> { domainServiceImpl.validarEditLivro(livro); });
		
		String mensagemEsperada = "Título não pode ser vazio!";
		String mensagemRecebida = exception.getMessage();
		
		assertTrue(mensagemRecebida.contains(mensagemEsperada));
	}
}
