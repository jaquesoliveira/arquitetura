package com.arquitetura.application.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.arquitetura.application.service.EditoraDomainServiceImpl;
import com.arquitetura.domain.entity.Editora;
import com.arquitetura.infra.repository.EditoraDomainRepositoryImpl;

public class EditoraController {

	@Autowired
	private EditoraDomainRepositoryImpl EditoraRepositoryImpl;	
	
	private EditoraDomainServiceImpl EditoraDomainServiceImpl;
		
	public EditoraController() {
		EditoraDomainServiceImpl = new EditoraDomainServiceImpl();;
	}
	
	@GetMapping
	public List<Editora> listAll(){
		return EditoraRepositoryImpl.listarTodos();
	}	
	
	@PostMapping
	public Editora save(@RequestBody Editora Editora) {
		EditoraDomainServiceImpl.validarSaveEditora(Editora);
		return EditoraRepositoryImpl.salvar(Editora);
	}
	
	@PutMapping
	public Editora edit(@RequestBody Editora Editora) {
		EditoraDomainServiceImpl.validarEditEditora(Editora);
		return EditoraRepositoryImpl.alterar(Editora);
	}
	
	@DeleteMapping("/{id}")
	public void ecluir(@PathVariable Long id) {
		EditoraRepositoryImpl.excluir(id);
	}
}
