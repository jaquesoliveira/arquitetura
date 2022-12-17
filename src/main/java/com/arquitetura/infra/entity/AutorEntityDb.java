package com.arquitetura.infra.entity;

import java.beans.Transient;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.arquitetura.domain.entity.Autor;
import com.arquitetura.domain.entity.AutorEntity;

@Entity
@Table
public class AutorEntityDb implements AutorEntity{
	private Long id;
	private String name;
	
	public AutorEntityDb() {

	}
	
	public AutorEntityDb(Long id, String name) {
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
	
	@Transient
    public Autor toAutor(AutorEntityDb autorEntityDb) {
		return new Autor(this.id, this.name);
	}
	
}
