package com.contratos.dto;

public class ClienteDTO {
	
	
   public Integer id;
   
   public String nome;
   
   public String cnpj;
   
   public String email;
   
   public Integer telefone;

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

   public void setNome(String nome) {
	this.nome = nome;
   }

   public void setCnpj(String cnpj) {
	this.cnpj = cnpj;
   }

   public void setEmail(String email) {
	this.email = email;
   }

   public void setTelefone(Integer telefone) {
	this.telefone = telefone;
   }
   
   

}
