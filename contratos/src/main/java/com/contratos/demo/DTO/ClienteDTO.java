package com.contratos.demo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
	   private Integer id;

	    @NotBlank
	    private String nome;

	    @NotBlank
	    @Pattern(regexp = "\\d{14}", message = "CNPJ deve conter 14 dígitos")
	    private String cnpj;

	    @NotBlank
	    @Email
	    private String email;

	    @NotBlank
	    @Size(min = 10, max = 15)
	    private String telefone;   
}
