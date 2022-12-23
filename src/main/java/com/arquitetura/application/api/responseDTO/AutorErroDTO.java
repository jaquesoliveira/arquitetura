package com.arquitetura.application.api.responseDTO;


import java.util.Date;

import com.arquitetura.domain.entity.Autor;

import lombok.Data;

@Data
public class AutorErroDTO {

	private String mensagem;
	private Autor content;
	private Integer status;
	private Date date;
	
	
	public AutorErroDTO(String mensagem, Autor data, Integer status, Date date) {
		this.mensagem = mensagem;
		this.content = data;
		this.status = status;
		this.date = date;
	}
}
