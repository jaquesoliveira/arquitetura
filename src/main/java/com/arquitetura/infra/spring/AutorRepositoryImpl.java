package com.arquitetura.infra.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.domain.repository.AutorDomainRepository;
import com.arquitetura.infra.adapter.AutorEntityAdapter;
import com.arquitetura.infra.entity.AutorEntityDb;

public class AutorRepositoryImpl implements AutorDomainRepository{
	
	@Autowired
	private AutorRepositorySpring repositorySpring;

	@Override
	public Autor salvar(Autor autor) {
		AutorEntityDb entityDbSalvo = repositorySpring.save(new AutorEntityAdapter(autor).toAutorEntityDb());
		return new AutorEntityAdapter(entityDbSalvo).toAutor();
	}

	@Override
	public Autor alterar(Autor autor) {
		return new AutorEntityAdapter(autor).toAutor();
	}

	@Override
	public void excluir(Long id) {
		repositorySpring.deleteById(id);
	}

	@Override
	public List<Autor> listarAutores() {
		List<AutorEntityDb> listResult = repositorySpring.findAll();		
		return new AutorEntityAdapter(listResult).toListAutor();
	}

	@Override
	public Autor consultarPorId(Long id) {
		Optional<AutorEntityDb> result = repositorySpring.findById(id);
		if (result.isPresent()) {
			return new AutorEntityAdapter(result.get()).toAutor() ;
		}
		return null;
	}
}
