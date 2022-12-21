package com.arquitetura.domain.entity;

import java.util.Objects;

public class Livro {
	
	private Long id;
	private String title;	
	private Autor autor;
	private Editora editora;
	
	public Livro() {
		
	}
	
	public Livro(String title) {
		this.title = title;
	}
	
	public Livro(Long id, String title) {
		this.id = id;
		this.title = title;
	}
		
	public Livro(Long id, String title, Autor autor, Editora editora) {
		this.id = id;
		this.title = title;
		this.autor = autor;
		this.editora = editora;
	}

	public Autor getAutor() {
		return autor;
	}
	public Editora getEditora() {
		return editora;
	}
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
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
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}
	
}
