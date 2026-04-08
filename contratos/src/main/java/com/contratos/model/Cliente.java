package com.contratos.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Entity
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cnpj;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private Integer telefone;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contrato> contratos;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getEmail() {
		return email;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCnpj(String string) {
		this.cnpj = string;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	 
	

}
