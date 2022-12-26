package com.arquitetura.infra.repository;

import java.util.List;

import com.arquitetura.domain.entity.Editora;
import com.arquitetura.domain.repository.EditoraDomainRepository;
import com.arquitetura.infra.converter.EditoraEntityDbToEditoraConverter;
import com.arquitetura.infra.converter.EditoraToEditoraEntityDbConverter;
import com.arquitetura.infra.entities.EditoraEntityDb;
import com.arquitetura.infra.spring.EditoraRepositorySpring;

public class EditoraDomainRepositoryImpl implements EditoraDomainRepository {
	
	private EditoraRepositorySpring repositorySpring;	
	
	public EditoraDomainRepositoryImpl(EditoraRepositorySpring repositorySpring) {
		this.repositorySpring = repositorySpring;
	}

	@Override
	public Editora salvar(Editora entity) {
		EditoraEntityDb editoraEntityDb = new EditoraToEditoraEntityDbConverter(entity).toEditoraEntityDb();
		
		return new EditoraEntityDbToEditoraConverter(
				repositorySpring.save(editoraEntityDb)).toEditora();
	}

	@Override
	public Editora alterar(Editora entity) {
		return this.salvar(entity);
	}

	@Override
	public void excluir(Long id) {
		repositorySpring.deleteById(id);
	}

	@Override
	public List<Editora> listarTodos() {
		List<EditoraEntityDb> listEditoraEntityDb = repositorySpring.findAll();
		
		return new EditoraEntityDbToEditoraConverter(listEditoraEntityDb).toListEditora();
	}

	@Override
	public Editora consultarPorId(Long id) {
		return null;
	}
}
