package com.contratos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.contratos.dto.contratosDTO;
import com.contratos.model.contratos;



@Mapper(componentModel = "spring")
public interface ContratosMapper {

    // Entity → DTO
    @Mapping(source = "cliente.id", target = "clienteId")
    contratosDTO toDTO(contratos contrato);

    // DTO → Entity
    @Mapping(source = "clienteId", target = "cliente.id")
    contratosDTO toEntity(contratos dto);
}

