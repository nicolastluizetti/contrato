package com.contratos.dto;

import java.util.Date;

public class ContratosDTO {
	
	    private Integer id;
	    
	    private String nome;
	    
	    private Integer valor;

	    private Date datainicio;

	    private Date datafinal;

	    private Boolean status;

		public Integer getId() {
			return id;
		}
		
		public String getnome() {
			return nome;
		}

		public Integer getValor() {
			return valor;
		}

		public Date getDatainicio() {
			return datainicio;
		}

		public Date getDatafinal() {
			return datafinal;
		}

		public Boolean getStatus() {
			return status;
		}


		public void setValor(Integer valor) {
			this.valor = valor;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}

		public void setDatainicio(Date datainicio) {
			this.datainicio = datainicio;
		}

		public void setDatafinal(Date datafinal) {
			this.datafinal = datafinal;
		}

		public void setStatus(Boolean status) {
			this.status = status;
		}

	  
	    
	    
	    

}
