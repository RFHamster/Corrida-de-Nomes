package com.FGRW.tfpi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.FGRW.tfpi.entities.Estados;
import com.FGRW.tfpi.exception.DatabaseException;
import com.FGRW.tfpi.exception.ResourceNotFoundException;
import com.FGRW.tfpi.repositories.EstadosRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EstadosServices {
	@Autowired
	private EstadosRepository repository;
	
	public void consumirAPIEArmazenarNoBanco() {
		String apiUrl = "https://servicodados.ibge.gov.br/api/v1/localidades/estados?orderBy=nome";

        RestTemplate restTemplate = new RestTemplate();

        Estados[] estados = restTemplate.getForObject(apiUrl, Estados[].class);

        for (Estados estado : estados) {
        	repository.save(estado);
        }
        Estados est = new Estados("BR", "0", "Brasil");
        repository.save(est);
    }
	
	public List<Estados> findAll(){
		return repository.findAll();
	}
	
	public Estados findById(String id) {
		Optional<Estados> obj = repository.findById(id);
		return obj.get();
	}
	
	public String estadoNumber(String id) {
		Optional<Estados> estado = repository.findById(id);
		return estado.get().getId();
	}
	
	public Estados insert(Estados obj) {
		return repository.save(obj);
	}
	
	public void delete(String id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	private void updateData(Estados entity, Estados obj) {
		entity.setSigla(obj.getSigla());
		entity.setId(obj.getId());
		entity.setNome(obj.getNome());

	}
	
	public Estados update(String id, Estados obj) {
		try {
			Estados entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}
}
