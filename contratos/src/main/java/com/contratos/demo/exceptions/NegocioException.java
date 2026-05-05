package com.contratos.demo.exceptions;

public class NegocioException extends RuntimeException{
	
static final long serialVersionUID = 1L;

public NegocioException(String mensagem) {
	super(mensagem);
	}
	
public NegocioException(String mensagem, Throwable causa) {
	super(mensagem, causa);
}


}
