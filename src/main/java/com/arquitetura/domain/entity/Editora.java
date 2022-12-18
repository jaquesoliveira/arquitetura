package com.arquitetura.domain.entity;

import java.util.Objects;

public class Editora {
	private Long id;
	private String name;
	
	public Editora() {
		
	}
	
	public Editora(String name) {
		super();
		this.name = name;
	}

	public Editora(Long id) {
		this.id = id;
	}

	public Editora(Long id, String name) {
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
		Editora other = (Editora) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
