package com.arquitetura.application.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitetura.application.service.AutorDomainServiceImpl;
import com.arquitetura.domain.entity.Autor;
import com.arquitetura.infra.spring.AutorRepositoryImpl;

@RestController
@RequestMapping("autor")
public class AutorController {

	@Autowired
	private AutorRepositoryImpl autorRepositoryImpl;	
	
	private AutorDomainServiceImpl autorDomainServiceImpl;
		
	public AutorController() {
		autorDomainServiceImpl = new AutorDomainServiceImpl();;
	}
	
	@GetMapping
	public List<Autor> listAll(){
		return autorRepositoryImpl.listarAutores();
	}	
	
	@PostMapping
	public Autor save(@RequestBody Autor autor) {
		autorDomainServiceImpl.validarSaveAutor(autor);
		return autorRepositoryImpl.salvar(autor);
	}
	
	@PutMapping()
	public Autor edit(@RequestBody Autor autor) {
		autorDomainServiceImpl.validarEditAutor(autor);
		return autorRepositoryImpl.salvar(autor);
	}
	
	@DeleteMapping("/{id}")
	public void ecluir(@PathVariable Long id) {
		autorRepositoryImpl.excluir(id);
	}
}
