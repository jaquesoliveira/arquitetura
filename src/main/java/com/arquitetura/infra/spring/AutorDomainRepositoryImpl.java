package com.arquitetura.infra.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.domain.repository.AutorDomainRepository;
import com.arquitetura.infra.adapter.AutorEntityDbToAutorAdapter;
import com.arquitetura.infra.adapter.AutorToAutorEntityDBAdapter;
import com.arquitetura.infra.entity.AutorEntityDb;

@Repository
public class AutorDomainRepositoryImpl implements AutorDomainRepository{
	
	@Autowired
	private AutorRepositorySpring repositorySpring;

	@Override
	public Autor salvar(Autor autor) {
		AutorEntityDb entityDbSalvo = repositorySpring
				.save(new AutorToAutorEntityDBAdapter(autor).toAutorEntityDb());
		
		return new AutorEntityDbToAutorAdapter(entityDbSalvo).toAutor();
	}

	@Override
	public Autor alterar(Autor autor) {
		return salvar(autor);
	}

	@Override
	public void excluir(Long id) {
		repositorySpring.deleteById(id);
	}

	@Override
	public List<Autor> listarTodos() {
		List<AutorEntityDb> listResult = repositorySpring.findAll();		
		return new AutorEntityDbToAutorAdapter(listResult).toListAutor();
	}

	@Override
	public Autor consultarPorId(Long id) {
		Optional<AutorEntityDb> result = repositorySpring.findById(id);
		if (result.isPresent()) {
			return new AutorEntityDbToAutorAdapter(result.get()).toAutor() ;
		}
		return null;
	}
}
