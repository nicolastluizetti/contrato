package com.contratos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contratos.dto.ContratosDTO;
import com.contratos.mapper.ContratosMapper;
import com.contratos.model.Contrato;
import com.contratos.repository.ContratoRepository;

@Service
public class ContratoService {

	@Autowired
	public ContratoRepository contratorepository;
	
	@Autowired
	public ContratosMapper contratomapper;
	
	
	public List<ContratosDTO> listar(){
		List<Contrato> contratos = contratorepository.findAll();
		List<ContratosDTO> contratodto = contratomapper.toDTOlist(contratos);
		return contratodto;
	}
	
	public ContratosDTO buscarporid(Integer id) {
	Contrato contrato = contratorepository.getReferenceById(id);
	ContratosDTO contratodto = contratomapper.toDTO(contrato);
		return contratodto;
	}
	
	 public ContratosDTO criar(Contrato contrato) {

	       ContratosDTO contratodto = contratomapper.toDTO(contrato);

	        Contrato contratoSalvo = contratorepository.save(contrato);

	        return contratomapper.toDTO(contratoSalvo);
	    }
	 
	    public ContratosDTO atualizar(Integer id,ContratosDTO dto) {

	    	Contrato contratoExistente = contratorepository.findById(id)
	                .orElseThrow(() -> 
	                        new RuntimeException("contrato não encontrado com ID: " + id));

	        
	    	
	    	contratoExistente.setValor(dto.getValor());
	    	contratoExistente.setDatainicio(dto.getDatainicio());
	    	contratoExistente.setDatafinal(dto.getDatafinal());
	    	

	        Contrato contratoAtualizado = contratorepository.save(contratoExistente);

	        return contratomapper.toDTO(contratoAtualizado);
	    }


	    public void deletar(Integer id) {

	    	Contrato contrato = contratorepository.findById(id)
	                .orElseThrow(() -> 
	                        new RuntimeException("Cliente não encontrado com ID: " + id));

	    	contratorepository.delete(contrato);
	    }
	
	
}
