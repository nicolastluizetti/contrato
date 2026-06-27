package com.contratos.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.contratos.demo.DTO.ContratosDTO;
import com.contratos.demo.model.Contrato;

@Mapper(componentModel = "spring")
public interface ContratosMapper {

    @Mapping(source = "cliente.id", target = "clienteId")
    ContratosDTO toDTO(Contrato contrato);

    @Mapping(source = "clienteId", target = "cliente.id")
    Contrato toEntity(ContratosDTO dto);

    List<ContratosDTO> toDTO(List<Contrato> contratos);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "clienteId", target = "cliente.id")
    void updateEntityFromDto(ContratosDTO dto, @MappingTarget Contrato contrato);
}
