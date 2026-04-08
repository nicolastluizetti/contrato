package com.contratos.exceptions;

public class ClienteNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ClienteNaoEncontradoException(Long estadoId) {
		this(String.format("Não foi encontrado um cliente com código %d", estadoId));
	}
	
}
