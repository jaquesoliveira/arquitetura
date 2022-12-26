package com.arquitetura.application.exceptions;


import java.util.Date;

import com.arquitetura.domain.entity.Autor;

import lombok.Data;

@Data
public class AutorErroDTO {

	private String mensagem;
	private Integer status;
	private Date date;
	
	
	public AutorErroDTO(String mensagem, Integer status, Date date) {
		this.mensagem = mensagem;
		this.status = status;
		this.date = date;
	}
}
