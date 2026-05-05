package com.contratos.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class Cliente {
	
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @EqualsAndHashCode.Include
	    private Integer id;

	    @NotBlank
	    @Column(nullable = false)
	    private String nome;

	    @NotBlank
	    @Pattern(regexp = "\\d{14}", message = "CNPJ deve conter 14 dígitos")
	    @Column(nullable = false, unique = true, length = 14)
	    private String cnpj;

	    @NotBlank
	    @Email
	    @Column(nullable = false, unique = true)
	    private String email;

	    @NotBlank
	    @Size(min = 10, max = 15)
	    @Column(nullable = false)
	    private String telefone;

	    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonIgnore
	    private List<Contrato> contratos;

	 	

}
