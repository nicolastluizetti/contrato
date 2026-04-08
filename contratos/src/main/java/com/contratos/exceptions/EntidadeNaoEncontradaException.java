package com.contratos.exceptions;

import org.jspecify.annotations.Nullable;

public class EntidadeNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public @Nullable Object getMessage(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
