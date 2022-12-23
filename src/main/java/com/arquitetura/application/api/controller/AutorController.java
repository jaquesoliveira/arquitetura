package com.arquitetura.application.api.controller;

import java.util.List;

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
	
	@GetMapping
	public List<Autor> listAll(){
		return autorFacade.listAll();
	}	
	
	@PostMapping
	public Autor save(@RequestBody Autor autor) {
		return autorFacade.salvar(autor);
	}
	
	@PutMapping
	public Autor edit(@RequestBody Autor autor) {
		return autorFacade.edit(autor);
	}
	
	@DeleteMapping("/{id}")
	public void ecluir(@PathVariable Long id) {
		autorFacade.excluir(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> consultarPorId(@PathVariable Long id) {
		
		Autor result = autorFacade.consultarPorId(id);
		if (result == null) {
			throw new AutorNotFoundException();
		}
		
		return ResponseEntity.ok()
				.body(result);
	}
}
