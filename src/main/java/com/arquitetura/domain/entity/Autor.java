package com.arquitetura.domain.entity;

import java.io.Serializable;
import java.util.Objects;

public class Autor implements AutorEntity, Serializable{
	
	private static final long serialVersionUID = 2372677270268422121L;
	
	private Long id;
	private String name;
	
	public Autor() {
		
	}
	
	public Autor(String name) {		
		this.name = name;
	}

	public Autor(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		Autor other = (Autor) obj;
		return Objects.equals(id, other.id);
	}	
}
