package com.contratos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contratos.demo.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Integer>{

}
