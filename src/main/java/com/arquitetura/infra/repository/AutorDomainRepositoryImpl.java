package com.arquitetura.infra.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arquitetura.application.exceptions.AutorNotFoundException;
import com.arquitetura.domain.entity.Autor;
import com.arquitetura.domain.repository.AutorDomainRepository;
import com.arquitetura.infra.converter.AutorEntityDbToAutorConverter;
import com.arquitetura.infra.converter.AutorToAutorEntityDBConverter;
import com.arquitetura.infra.entities.AutorEntityDb;
import com.arquitetura.infra.spring.AutorRepositorySpring;

public class AutorDomainRepositoryImpl implements AutorDomainRepository{
	
	private AutorRepositorySpring repositorySpring;
	
	public AutorDomainRepositoryImpl(AutorRepositorySpring repositorySpring) {
		this.repositorySpring = repositorySpring;
	}

	@Override
	public Autor salvar(Autor autor) {
		AutorEntityDb entityDbSalvo = repositorySpring
				.save(new AutorToAutorEntityDBConverter(autor).toAutorEntityDb());
		
		return new AutorEntityDbToAutorConverter(entityDbSalvo).toAutor();
	}

	@Override
	public Autor alterar(Autor autor) {
		
		Autor autorFound = consultarPorId(autor.getId());		
		if(autorFound == null) {
			throw new AutorNotFoundException();
		}
		
		return salvar(autor);
	}

	@Override
	public void excluir(Long id) {
		repositorySpring.deleteById(id);
	}

	@Override
	public List<Autor> listarTodos() {
		List<AutorEntityDb> listResult = repositorySpring.findAll();		
		return new AutorEntityDbToAutorConverter(listResult).toListAutor();
	}

	@Override
	public Autor consultarPorId(Long id) {
		Optional<AutorEntityDb> result = repositorySpring.findById(id);
		if (!result.isPresent()) {
			return null; 
		}	
		
		return new AutorEntityDbToAutorConverter(result.get()).toAutor() ;
	}
}
