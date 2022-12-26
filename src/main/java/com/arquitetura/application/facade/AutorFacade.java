package com.arquitetura.application.facade;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.arquitetura.application.useCases.AutorUsecaseImpl;
import com.arquitetura.domain.entity.Autor;
import com.arquitetura.infra.repository.AutorDomainRepositoryImpl;

public class AutorFacade {
	
	private AutorDomainRepositoryImpl autorRepositoryImpl;	
	private AutorUsecaseImpl autorDomainServiceImpl;
		
	public AutorFacade(AutorDomainRepositoryImpl autorRepositoryImpl ) {
		this.autorRepositoryImpl = autorRepositoryImpl;
		this.autorDomainServiceImpl = new AutorUsecaseImpl();
	}
	
	public List<Autor> listAll(){
		return autorRepositoryImpl.listarTodos();
	}	
	
	public Autor salvar(Autor autor) {
		autorDomainServiceImpl.validarSaveAutor(autor);
		return autorRepositoryImpl.salvar(autor);
	}
	
	public Autor edit(Autor autor) {
		autorDomainServiceImpl.validarEditAutor(autor);
		return autorRepositoryImpl.alterar(autor);
	}
	
	public void excluir(Long id) {
		autorRepositoryImpl.excluir(id);
	}
	
	public Autor consultarPorId(@PathVariable Long id) {		
		return autorRepositoryImpl.consultarPorId(id);
	}
}
