package com.arquitetura.domain.repository;

import java.util.List;


public interface BasicCrudRepository <T> {
	
	public T salvar(T entity);
	public T alterar(T entity);
	public void excluir(Long id);
	public List<T> listarTodos();
	public T consultarPorId(Long id);

}
