package com.contratos.demo.exception;

import org.springframework.http.HttpStatus;

public record Erro(String campo, String mensagem) {
	
	public static Erro badRequest(Exception e) {
        return new Erro(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
    }	
	
	public static Erro interno(Exception e) {
		return new Erro(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage());
	}
}
