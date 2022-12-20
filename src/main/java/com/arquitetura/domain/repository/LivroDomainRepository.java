package com.arquitetura.domain.repository;

import java.util.List;

import com.arquitetura.domain.entity.Livro;


public interface LivroDomainRepository extends BasicCrudRepository<Livro>{
	public List<Livro> consultarPorTitulo(String titulo);
	public List<Livro> consultarPorAutor(String nomeAutor);
	public List<Livro> consultarPorEditora(String nomeEditora);
}
