package com.contratos.demo.model;

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
public class clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	


	@NotBlank
	private String nome;
	
	@NotBlank
	private Integer cnpj;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private Integer telefone;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<contratos> contratos;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public List<contratos> getContratos() {
		return contratos;
	}

	public void setContratos(List<contratos> contratos) {
		this.contratos = contratos;
	}

	public Integer getId() {
		return id;
	}

	

}
