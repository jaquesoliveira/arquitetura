package com.arquitetura.application.api.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitetura.application.exceptions.AutorNotFoundException;
import com.arquitetura.application.facade.AutorFacade;
import com.arquitetura.domain.entity.Autor;

@RestController
@RequestMapping("autor")
public class AutorController {
		
	AutorFacade autorFacade;
		
	public AutorController(AutorFacade autorFacade) {
		this.autorFacade = autorFacade;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Autor> listAll(){
		return autorFacade.listAll();
	}	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Autor save(@RequestBody Autor autor) {
		return autorFacade.salvar(autor);
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Autor edit(@RequestBody Autor autor) {
		return autorFacade.edit(autor);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		autorFacade.excluir(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping( "/{id}")
	public ResponseEntity<Object> consultarPorId(@PathVariable Long id) {
		
		Autor result = autorFacade.consultarPorId(id);
		if (result == null) {
			throw new AutorNotFoundException();
		}
		
		return ResponseEntity.ok()
				.body(result);
	}
}
