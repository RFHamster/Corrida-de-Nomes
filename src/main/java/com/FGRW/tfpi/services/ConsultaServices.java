package com.FGRW.tfpi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.FGRW.tfpi.entities.Consulta;
import com.FGRW.tfpi.exception.DatabaseException;
import com.FGRW.tfpi.exception.ResourceNotFoundException;
import com.FGRW.tfpi.repositories.ConsultaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ConsultaServices {
	@Autowired
	private ConsultaRepository repository;
	
	
	public List<Consulta> findAll(){
		return repository.findAll();
	}
	
	public Consulta findById(Long id) {
		Optional<Consulta> obj = repository.findById(id);
		return obj.get();
	}
	
	public Consulta insert(Consulta obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	private void updateData(Consulta entity, Consulta obj) {
		entity.setDataFinal(obj.getDataFinal());
		entity.setDataInicial(obj.getDataInicial());
		entity.setLocalidade(obj.getLocalidade());
		entity.setSession(obj.getSession());
		entity.setSexo(obj.getSexo());
	}
	
	public Consulta update(Long id, Consulta obj) {
		try {
			Consulta entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}
}
