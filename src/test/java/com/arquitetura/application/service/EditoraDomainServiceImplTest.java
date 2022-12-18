package com.arquitetura.application.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.arquitetura.domain.entity.Editora;

class EditoraDomainServiceImplTest {
	
	EditoraDomainServiceImpl editoraDomainServiceImpl;

	@BeforeEach
	public void config() {
		editoraDomainServiceImpl = new EditoraDomainServiceImpl();
	}
	
	@Test
	public void deveRetornarException_QuandoEditoraForNula() {
		Editora editora = null;
		
		Exception exception = assertThrows(RuntimeException.class, 
				() -> {editoraDomainServiceImpl.validarSaveEditora(editora);});
		
		String mensagemEsperada = "Editora não pode ser nula!";
		String mensagemRecebida = exception.getMessage();
		
		assertTrue(mensagemRecebida.contains(mensagemEsperada));
	}
	
	@Test
	public void deveRetornarException_QuandoNomeVazioOuNulo() {
		
		Editora editora = new Editora();
		
		Exception exception = assertThrows(RuntimeException.class, 
				() -> {editoraDomainServiceImpl.validarSaveEditora(editora); });
		
		String mensagemEsperada = "O nome da editora é obrigatório!";
		String mensagemRecebida = exception.getMessage();
		
		assertTrue(mensagemRecebida.contains(mensagemEsperada));
	}
	
	@Test
	public void deveRetornarException_QuandoIdOuNomeForNulo_OuONomeForVazio() {
		Editora editora = new Editora(null, "sac");
		
		Exception exception = assertThrows(RuntimeException.class, 
				() -> { editoraDomainServiceImpl.validarEditEditora(editora); });
		
		String mensagemEsperada = "Id e Nome da Editora são obrigatórios!";
		String mensagemRecebida = exception.getMessage();
		
		assertTrue(mensagemRecebida.contains(mensagemEsperada));
	}

}
