package com.contratos.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.contratos.dto.ContratosDTO;
import com.contratos.model.Contrato;



@Mapper(componentModel = "spring")
public interface ContratosMapper {

    // Entity → DTO
    @Mapping(source = "cliente.id", target = "clienteId")
    ContratosDTO toDTO(Contrato contrato);

    // DTO → Entity
    @Mapping(source = "clienteId", target = "cliente.id")
    Contrato toEntity(ContratosDTO dto);
    
    @Mapping(source = "clienteId", target = "cliente.id")
    List<ContratosDTO> toDTOlist(List<Contrato> contrato);
}

