package com.arquitetura.infra.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="LIV_LIVRO")
@SequenceGenerator(name = "SEQ_LIV_LIVRO", allocationSize = 1, initialValue = 1)
public class LivroEntityDb {
	
	@Id
	@GeneratedValue(generator = "SEQ_LIV_LIVRO", strategy = GenerationType.SEQUENCE)
	@Column(name="LIV_ID")	
	private Long id;
	
	@Column(name="LIV_TITLE")	
	private String title;

	@ManyToOne(fetch = FetchType.LAZY)
	private AutorEntityDb autorEntityDb;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private EditoraEntityDb editoraEntityDb;
		
	public LivroEntityDb() { }
	
	public LivroEntityDb(String title) {
		this.title = title;
	}
	
	public LivroEntityDb(Long id, String title) {
		this.id = id;
		this.title = title;
	}
		
	public LivroEntityDb(Long id, String title, AutorEntityDb autor, EditoraEntityDb editora) {
		this.id = id;
		this.title = title;
		this.autorEntityDb = autor;
		this.editoraEntityDb = editora;
	}

	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public AutorEntityDb getAutorEntityDb() {
		return autorEntityDb;
	}

	public void setAutorEntityDb(AutorEntityDb autorEntityDb) {
		this.autorEntityDb = autorEntityDb;
	}

	public EditoraEntityDb getEditoraEntityDb() {
		return editoraEntityDb;
	}

	public void setEditoraEntityDb(EditoraEntityDb editoraEntityDb) {
		this.editoraEntityDb = editoraEntityDb;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroEntityDb other = (LivroEntityDb) obj;
		return Objects.equals(id, other.id);
	}

}
