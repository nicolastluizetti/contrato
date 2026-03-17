package com.contratos.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contratos.demo.exception.NegocioException;
import com.contratos.demo.model.clientes;
import com.contratos.demo.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class clienteservice {
	
	private  ClienteRepository clienteRepository;

    
    public List<clientes> listarTodos() {
        return clienteRepository.findAll();
    }

    public clientes buscarPorId(Integer id) {
        return clienteRepository.getReferenceById(id);
    }

    @Transactional
    public clientes salvar(clientes cliente) {

        if (clienteRepository.existsById(cliente.getId())) {
            throw new NegocioException("Já existe um cliente com esse CNPJ.");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public clientes atualizar(Integer id, clientes clienteAtualizado) {

        clientes clienteExistente = clienteRepository.getReferenceById(id);

        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setTelefone(clienteAtualizado.getTelefone());
        clienteExistente.setEmail(clienteAtualizado.getEmail());

        return clienteRepository.save(clienteExistente);
    }

    @Transactional
    public void excluir(Integer id) {

        clientes cliente = clienteRepository.getReferenceById(id);

        if (!cliente.getContratos().isEmpty()) {
            throw new NegocioException("Cliente possui contratos vinculados.");
        }

        clienteRepository.delete(cliente);

}}
