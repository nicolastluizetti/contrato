package com.contratos.demo.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public record Erro(int status, String error, String message, String path, LocalDateTime timestamp, List<FieldViolation> violations ) {

	    public static Erro of(int status,String error, String message,String path) {
	    	return new Erro(
	                status,
	                error,
	                message,
	                path,
	                LocalDateTime.now(),
	                null
	        );
	    }

	    public static Erro of(int status, String error, String message,  String path, List<FieldViolation> violations) {
	    	
	    	return new Erro(
	                status,
	                error,
	                message,
	                path,
	                LocalDateTime.now(),
	                violations
	        );
	    }

	    public record FieldViolation(
	            String field,
	            String message
	    ) {}
	}
