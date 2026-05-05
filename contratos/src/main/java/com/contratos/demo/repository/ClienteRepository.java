package com.contratos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contratos.demo.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
