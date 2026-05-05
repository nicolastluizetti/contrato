package com.contratos.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.contratos.demo.DTO.ClienteDTO;
import com.contratos.demo.service.ClienteService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	public ClienteService clienteservice;


	    @GetMapping
	    public ResponseEntity<List<ClienteDTO>> listar() {
	        return ResponseEntity.ok(clienteservice.listar());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer id) {
	        return ResponseEntity.ok(clienteservice.buscarPorId(id));
	    }

	    @PostMapping
	    public ResponseEntity<ClienteDTO> criar(@RequestBody @Valid ClienteDTO dto) {

	        ClienteDTO clienteCriado = clienteservice.criar(dto);

	        URI uri = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(clienteCriado.getId())
	                .toUri();

	        return ResponseEntity.created(uri).body(clienteCriado);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ClienteDTO> atualizar( @PathVariable Integer id, @RequestBody @Valid ClienteDTO dto) {

	        return ResponseEntity.ok(clienteservice.atualizar(id, dto));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletar(@PathVariable Integer id) {

	        clienteservice.deletar(id);
	        
	        return ResponseEntity.noContent().build();
	    }	

}
