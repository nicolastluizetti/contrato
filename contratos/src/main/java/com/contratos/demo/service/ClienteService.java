package com.contratos.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contratos.demo.DTO.ClienteDTO;
import com.contratos.demo.exceptions.ClienteNaoEncontradoException;
import com.contratos.demo.mapper.ClienteMapper;
import com.contratos.demo.model.Cliente;
import com.contratos.demo.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
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

        Cliente clienteExistente = clienterepository.getReferenceById(id);

        clientemapper.updateEntityFromDto(dto, clienteExistente);

        return clientemapper.toDTO(clienterepository.save(clienteExistente));
    }

    public void deletar(Integer id) {
    	if (!clienterepository.existsById(id)) {
    	    throw new ClienteNaoEncontradoException("Cliente não encontrado com ID: " + id);
    	}

    	clienterepository.deleteById(id);
    }
    

}
	 


