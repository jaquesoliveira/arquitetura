package com.arquitetura.application.api.responseDTO;

import com.arquitetura.domain.entity.Autor;

import lombok.Data;

@Data
public class AutorResponseDTO {
	
	private String mensagem;
	private Autor data;
	private Integer status;
	
	public AutorResponseDTO(String mensagem, Autor data, Integer status) {
		this.mensagem = mensagem;
		this.data = data;
		this.status = status;
	}
}
