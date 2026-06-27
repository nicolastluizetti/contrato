package com.contratos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.Conflict;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.client.HttpServerErrorException.BadGateway;

@ControllerAdvice
public class ExceptionHandler {

   
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Erro internalServerError(Exception e) {
        return new Erro("Erro interno do servidor", e.getMessage());
    }

    
    @org.springframework.web.bind.annotation.ExceptionHandler(BadGateway.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ResponseBody
    public Erro portaErrada(BadGateway e) {
        return new Erro("Porta errada", e.getMessage());
    }

 
    @org.springframework.web.bind.annotation.ExceptionHandler(Conflict.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody 
    public Erro conflito(Conflict e) {
        return new Erro("Conflito detectado", e.getMessage());
    }

   
    @org.springframework.web.bind.annotation.ExceptionHandler(Forbidden.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public Erro proibido(Forbidden e) {
        return new Erro("Proibido", e.getMessage());
    }
}


