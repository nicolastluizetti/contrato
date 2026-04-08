package com.contratos.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.contratos.dto.ClienteDTO;
import com.contratos.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteControler {
	
	@Autowired 
	public ClienteService service;
	
	 	@GetMapping
	    @ResponseStatus(HttpStatus.OK)
	    public List<ClienteDTO> listar() {

	      List<ClienteDTO> clientes = service.listar();
	      
	      return clientes;
	    }

	 
	    @GetMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public ClienteDTO buscarPorId(@PathVariable Integer id) {

	       ClienteDTO cliente = service.buscarPorId(id);
	        
	        return cliente;
	    }


	    @PostMapping
	    public ResponseEntity<ClienteDTO> criar(@RequestBody ClienteDTO cliente) {

	        ClienteDTO clienteSalvo = service.criar(cliente);

	        return ResponseEntity
	                .status(HttpStatus.CREATED)
	                .body(clienteSalvo);
	    }

	
	    @PutMapping("/{id}")
	    public ResponseEntity<ClienteDTO> atualizar(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {

	        ClienteDTO clienteAtualizado =
	                service.atualizar(id, clienteDTO);

	        return ResponseEntity
	                .ok(clienteAtualizado);
	    }


	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletar(
	            @PathVariable Integer id) {

	        service.deletar(id);

	        return ResponseEntity
	                .noContent()
	                .build();
	    }

}
