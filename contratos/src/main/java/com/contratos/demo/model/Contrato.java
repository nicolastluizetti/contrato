package com.contratos.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.contratos.demo.Enums.ContratoStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Contrato {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @EqualsAndHashCode.Include
	    private Integer id;

	    @NotNull
	    @Positive
	    @Column(nullable = false, precision = 10, scale = 2)
	    private BigDecimal valor;

	    @NotNull
	    @Column(nullable = false)
	    private LocalDate dataInicio;

	    @NotNull
	    @Column(nullable = false)
	    private LocalDate dataFinal;

	    @NotNull
	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private ContratoStatus status;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "cliente_id", nullable = false)
	    @JsonIgnore
	    private Cliente cliente;

	    @AssertTrue(message = "Data final deve ser após a data inicial")
	    public boolean isDataValida() {
	        if (dataInicio == null || dataFinal == null) return true;
	        return dataFinal.isAfter(dataInicio);
	    }


    
}
