package com.arquitetura.domain.repository;

import java.util.List;

import com.arquitetura.domain.entity.Autor;

public interface AutorDomainRepository {
	public Autor salvar(Autor autor);
	public Autor alterar(Autor autor);
	public void excluir(Long id);
	public List<Autor> listarAutores();
	public Autor consultarPorId(Long id);
}
