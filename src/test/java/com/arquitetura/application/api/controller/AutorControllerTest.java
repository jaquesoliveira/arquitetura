package com.arquitetura.application.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.infra.spring.AutorDomainRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class AutorControllerTest {
	
	@Autowired
	private AutorDomainRepositoryImpl autorRepositoryImpl;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper objectMapper;
    
    @Test
	public void deveInserirUmAutor() throws Exception {
    	Autor autor = new Autor("Teste Inclusão");
    	
    	mockMvc.perform(post("/autor")
    		.contentType(MediaType.APPLICATION_JSON_VALUE)
    		.content(objectMapper.writeValueAsString(autor)))
    	.andExpect(status().isOk());
	}
    
    @Test
   	public void deveEditarUmAutor() throws Exception {
       	Autor autor = new Autor(1L, "Teste Alteração");
       	
       	mockMvc.perform(put("/autor")
       		.contentType(MediaType.APPLICATION_JSON_VALUE)
       		.content(objectMapper.writeValueAsString(autor)))
       	.andExpect(status().isOk());
       	       	
       	Autor autorRet = autorRepositoryImpl.consultarPorId(1L);
       	
       	assertEquals(autor.getName(), autorRet.getName());
   	}
	
	
	@Test
	public void deveRetornarUmaLista_QuandoRealizarConsulta() throws Exception {
    	
    	boolean compRes = false;
    	    	
    	mockMvc.perform(get("/autor"))
    	.andExpectAll(
			status().isOk(),
			content().contentType(MediaType.APPLICATION_JSON));
		
    	List<Autor> listResult = autorRepositoryImpl.listarTodos();
    	
    	if (!listResult.isEmpty()) {
    		compRes = true;
		}
    	Assertions.assertEquals(compRes, true);
	}
}


