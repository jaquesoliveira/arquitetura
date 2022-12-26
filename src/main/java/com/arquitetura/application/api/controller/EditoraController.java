package com.arquitetura.application.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.arquitetura.application.exceptions.EditoraNotFoundException;
import com.arquitetura.application.service.EditoraDomainServiceImpl;
import com.arquitetura.domain.entity.Autor;
import com.arquitetura.domain.entity.Editora;
import com.arquitetura.infra.repository.EditoraDomainRepositoryImpl;

@RestController
@RequestMapping("editora")
public class EditoraController {

	private EditoraDomainRepositoryImpl editoraRepositoryImpl;	
	private EditoraDomainServiceImpl editoraDomainServiceImpl;
			
	public EditoraController(EditoraDomainRepositoryImpl editoraRepositoryImpl) {
		editoraDomainServiceImpl = new EditoraDomainServiceImpl();
		this.editoraRepositoryImpl = editoraRepositoryImpl;
	}
	
	@GetMapping
	public List<Editora> listAll(){
		return editoraRepositoryImpl.listarTodos();
	}	
	
	@PostMapping
	public Editora save(@RequestBody Editora Editora) {
		editoraDomainServiceImpl.validarSaveEditora(Editora);
		return editoraRepositoryImpl.salvar(Editora);
	}
	
	@PutMapping
	public Editora edit(@RequestBody Editora Editora) {
		editoraDomainServiceImpl.validarEditEditora(Editora);
		return editoraRepositoryImpl.alterar(Editora);
	}
	
	@DeleteMapping("/{id}")
	public void ecluir(@PathVariable Long id) {
		editoraRepositoryImpl.excluir(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> consultarPorId(@PathVariable Long id) {
		
		Editora result = editoraRepositoryImpl.consultarPorId(id);
		//Autor result = autorFacade.consultarPorId(id);
		if (result == null) {
			throw new EditoraNotFoundException();
		}
		
		return ResponseEntity.ok()
				.body(result);
	}
}
