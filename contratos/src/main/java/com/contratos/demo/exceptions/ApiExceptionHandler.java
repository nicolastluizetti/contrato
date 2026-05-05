package com.contratos.demo.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.contratos.demo.exceptions.Erro.FieldViolation;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<Erro> handleNotFound( ClienteNaoEncontradoException ex, HttpServletRequest request) {

        Erro error = Erro.of(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

   
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Erro> handleBusiness(NegocioException ex, HttpServletRequest request) {

        Erro error = Erro.of(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.badRequest().body(error);
    }

    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Erro> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {

        List<Erro.FieldViolation> violations =
                ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(err -> new Erro.FieldViolation(
                                err.getField(),
                                err.getDefaultMessage()))
                        .toList();

        Erro error = Erro.of(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error",
                "Erro de validação nos campos",
                request.getRequestURI(),
                violations
        );

        return ResponseEntity.badRequest().body(error);
    }


}


