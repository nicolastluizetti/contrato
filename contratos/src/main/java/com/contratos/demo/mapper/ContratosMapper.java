package com.contratos.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.contratos.demo.DTO.ContratosDTO;
import com.contratos.demo.model.Contrato;



@Mapper(componentModel = "spring")
public interface ContratosMapper {


    @Mapping(source = "cliente.id", target = "clienteId")
    ContratosDTO toDTO(Contrato contrato);

    
    @Mapping(source = "clienteId", target = "cliente.id")
    Contrato toEntity(ContratosDTO dto);
    
    @Mapping(source = "clienteId", target = "cliente.id")
    List<ContratosDTO> toDTOlist(List<Contrato> contrato);
}

