package com.arquitetura.infra.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EDI_EDITORA")
@SequenceGenerator(name = "SEQ_EDI_EDITORA", sequenceName = "SEQ_EDI_EDITORA", allocationSize = 1)
public class EditoraEntityDb {
		
	@Id
	@GeneratedValue(generator = "SEQ_EDI_EDITORA", strategy = GenerationType.SEQUENCE)
	@Column(name="EDI_ID")
	private Long id;
	
	@Column(name = "EDI_NAME")
	private String name;
	
	public EditoraEntityDb() {
		
	}
	
	public EditoraEntityDb(Long id) {
		this.id = id;
	}
	
	public EditoraEntityDb(String name) {
		this.name = name;
	}

	public EditoraEntityDb(Long id, String name) {
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
		EditoraEntityDb other = (EditoraEntityDb) obj;
		return Objects.equals(id, other.id);
	}
	
}
