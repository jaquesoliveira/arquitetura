package com.arquitetura.application.exceptions;

import java.util.Date;

import lombok.Data;

@Data
public class EditoraErroDTO {

	private String mensagem;
	private Integer status;
	private Date date;
	
	
	public EditoraErroDTO(String mensagem, Integer status, Date date) {
		this.mensagem = mensagem;
		this.status = status;
		this.date = date;
	}
}
