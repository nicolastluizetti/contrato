package com.contratos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.contratos.dto.clientesDTO;
import com.contratos.model.clientes;



@Mapper(componentModel = "spring")
public interface ClienteMapper {

    // Entity → DTO
    @Mapping(source = "cliente.id", target = "clienteId")
    clientesDTO toDTO(clientes clientes);

    // DTO → Entity
    @Mapping(source = "clienteId", target = "cliente.id")
    clientes toEntity(clientesDTO clientesdto);
}

