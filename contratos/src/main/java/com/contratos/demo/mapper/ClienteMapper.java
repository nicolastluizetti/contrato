package com.contratos.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.contratos.demo.DTO.ClienteDTO;
import com.contratos.demo.model.Cliente;



@Mapper(componentModel = "spring")
public interface ClienteMapper {

  
    @Mapping(source = "cliente.id", target = "clienteId")
    ClienteDTO toDTO(Cliente clientes);


    @Mapping(source = "clienteId", target = "cliente.id")
    Cliente toEntity(ClienteDTO clientesdto);
    
    @Mapping(source = "clienteId", target = "cliente.id")
    List<ClienteDTO> toDTO(List<Cliente> clientes);
    
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ClienteDTO dto, @MappingTarget Cliente entity);
}

