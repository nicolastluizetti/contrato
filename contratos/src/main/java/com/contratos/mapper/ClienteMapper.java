package com.contratos.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.contratos.dto.ClienteDTO;
import com.contratos.model.Cliente;



@Mapper(componentModel = "spring")
public interface ClienteMapper {

  
    @Mapping(source = "cliente.id", target = "clienteId")
    ClienteDTO toDTO(Cliente clientes);


    @Mapping(source = "clienteId", target = "cliente.id")
    Cliente toEntity(ClienteDTO clientesdto);
    
    @Mapping(source = "clienteId", target = "cliente.id")
    List<ClienteDTO> toDTO(List<Cliente> clientes);
}

