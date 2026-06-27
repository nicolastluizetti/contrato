package com.contratos.demo.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.contratos.demo.Enums.ContratoStatus;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ContratosDTO(
        Integer id,

        @NotNull
        @Positive
        BigDecimal valor,

        @NotNull
        LocalDate dataInicio,

        @NotNull
        LocalDate dataFinal,

        @NotNull
        ContratoStatus status,

        @NotNull
        Integer clienteId
) {
}
