package com.contratos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contratos.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Integer>{

}
