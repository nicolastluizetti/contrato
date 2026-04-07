package com.contratos.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record contratosDTO(
		Integer id,

		@NotNull
		@Positive
		Double valor,

		@NotNull
		LocalDate datainicio,

		@NotNull
		LocalDate datafinal,

		Boolean status,

		@NotNull
		Long clienteId
		    
	    ) {

}
