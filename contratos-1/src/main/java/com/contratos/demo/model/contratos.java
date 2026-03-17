package com.contratos.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class contratos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Positive
    private Integer valor;

    @NotNull
    private Date datainicio;

    @NotNull
    private Date datafinal;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @NotNull
    private clientes cliente;

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Date getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public Date getDatafinal() {
		return datafinal;
	}

	public void setDatafinal(Date datafinal) {
		this.datafinal = datafinal;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public clientes getCliente() {
		return cliente;
	}

	public void setCliente(clientes cliente) {
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	
    
    
}
