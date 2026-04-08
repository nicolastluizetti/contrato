package com.contratos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contratos.dto.ClienteDTO;
import com.contratos.exceptions.ClienteNaoEncontradoException;
import com.contratos.mapper.ClienteMapper;
import com.contratos.model.Cliente;
import com.contratos.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienterepository;

    @Autowired
    private ClienteMapper clientemapper;

    public List<ClienteDTO> listar() {

        List<Cliente> clientes =
                clienterepository.findAll();

        return clientemapper.toDTO(clientes);
    }

    public ClienteDTO buscarPorId(Integer id) {

        Cliente cliente = clienterepository.findById(id)
                .orElseThrow(() ->
                        new ClienteNaoEncontradoException(
                                "Cliente não encontrado com ID: " + id));

        return clientemapper.toDTO(cliente);
    }

    public ClienteDTO criar(ClienteDTO dto) {

        Cliente cliente =
                clientemapper.toEntity(dto);

        Cliente clienteSalvo =
                clienterepository.save(cliente);

        return clientemapper.toDTO(clienteSalvo);
    }


    public ClienteDTO atualizar(Integer id, ClienteDTO dto) {

        Cliente clienteExistente =
                clienterepository.findById(id)
                        .orElseThrow(() ->
                                new ClienteNaoEncontradoException(
                                        "Cliente não encontrado com ID: " + id));

        
        clienteExistente.setNome(dto.getNome());
        clienteExistente.setCnpj(dto.getCnpj());
        clienteExistente.setEmail(dto.getEmail());
        clienteExistente.setTelefone(dto.getTelefone());

        Cliente clienteAtualizado =
                clienterepository.save(clienteExistente);

        return clientemapper.toDTO(clienteAtualizado);
    }

    public void deletar(Integer id) {

        Cliente cliente =
                clienterepository.findById(id)
                        .orElseThrow(() ->
                                new ClienteNaoEncontradoException(
                                        "Cliente não encontrado com ID: " + id));

        clienterepository.delete(cliente);
    }
}
	 


