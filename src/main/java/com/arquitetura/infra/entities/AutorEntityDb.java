package com.arquitetura.infra.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.arquitetura.domain.entity.AutorEntity;

@Entity
@Table(name="AUT_AUTOR")
@SequenceGenerator(name = "SEQ_AUT_AUTOR", allocationSize = 1, initialValue = 1)
public class AutorEntityDb implements AutorEntity, Serializable {
	
	private static final long serialVersionUID = -5365041273345444159L;

	@Id
	@GeneratedValue(generator = "SEQ_AUT_AUTOR", strategy = GenerationType.SEQUENCE)
	@Column(name="AUT_ID")
	private Long id;
	
	@Column(name="AUT_NOME")
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
		AutorEntityDb other = (AutorEntityDb) obj;
		return Objects.equals(id, other.id);
	}
}
