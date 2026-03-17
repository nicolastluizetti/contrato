package com.contratos.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contratos.demo.exception.NegocioException;
import com.contratos.demo.model.contratos;
import com.contratos.demo.repository.contratosrepository;

import jakarta.transaction.Transactional;

@Service
public class contratoservice {
	
	private  contratosrepository contratoRepository;

    
    public List<contratos> listarTodos() {
        return contratoRepository.findAll();
    }

    public contratos buscarPorId(Integer id) {
        return contratoRepository.getReferenceById(id);
    }

    @Transactional
    public contratos salvar(contratos contrato) {

        if (contratoRepository.existsById(contrato.getId())) {
            throw new NegocioException("Já existe um contrato com esse CNPJ.");
        }

        return contratoRepository.save(contrato);
    }

    @Transactional
    public contratos atualizar(Integer id, contratos contratoAtualizado) {

        contratos contratoExistente = contratoRepository.getReferenceById(id);

        contratoExistente.setStatus(contratoAtualizado.getStatus());
        contratoExistente.setDatainicio(contratoAtualizado.getDatainicio());
        contratoExistente.setDatafinal(contratoAtualizado.getDatafinal());
    
        

        return contratoRepository.save(contratoExistente);
    }

    @Transactional
    public void excluir(Integer id) {

        contratos contrato = contratoRepository.getReferenceById(id);

        contratoRepository.deleteById(id);

}}
