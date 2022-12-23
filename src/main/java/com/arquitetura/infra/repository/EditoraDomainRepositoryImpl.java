package com.arquitetura.infra.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.arquitetura.domain.entity.Editora;
import com.arquitetura.domain.repository.EditoraDomainRepository;
import com.arquitetura.infra.adapter.EditoraEntityDbToEditoraAdapter;
import com.arquitetura.infra.adapter.EditoraToEditoraEntityDbAdapter;
import com.arquitetura.infra.entity.EditoraEntityDb;
import com.arquitetura.infra.spring.EditoraRepositorySpring;

public class EditoraDomainRepositoryImpl implements EditoraDomainRepository {
	
	@Autowired
	private EditoraRepositorySpring repositorySpring;

	@Override
	public Editora salvar(Editora entity) {
		EditoraEntityDb editoraEntityDb = new EditoraToEditoraEntityDbAdapter(entity).toEditoraEntityDb();
		
		return new EditoraEntityDbToEditoraAdapter(
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
		
		return new EditoraEntityDbToEditoraAdapter(listEditoraEntityDb).toListEditora();
	}

	@Override
	public Editora consultarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
