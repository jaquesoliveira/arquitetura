package com.arquitetura.domain.entity;

import java.util.Objects;
import java.util.Set;

public class User {
	
	private Long id;
	
	private String userName;
	
	private String password;
	
	private Set<String> permissoes;
		
	public User() {
		
	}	

	public User(Long id, String userName, String password, Set<String> permissoes) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.permissoes = permissoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Set<String> permissoes) {
		this.permissoes = permissoes;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
}
