package com.contratos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contratos.demo.model.clientes;


public interface ClienteRepository extends JpaRepository<clientes, Integer>{
	
	

}
