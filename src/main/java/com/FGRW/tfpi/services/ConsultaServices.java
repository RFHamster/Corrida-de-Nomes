package com.FGRW.tfpi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.FGRW.tfpi.entities.Consulta;
import com.FGRW.tfpi.entities.Data;
import com.FGRW.tfpi.entities.Nome;
import com.FGRW.tfpi.entities.Ranking;
import com.FGRW.tfpi.exception.DatabaseException;
import com.FGRW.tfpi.exception.ResourceNotFoundException;
import com.FGRW.tfpi.repositories.ConsultaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ConsultaServices {
	@Autowired
	private ConsultaRepository repository;
	@Autowired
	EstadosServices estados;
	
	public List<Data> makeData(String dataInicial, String dataFinal, String localidade, String sexo) {
		List<Data> result = new ArrayList<Data>();
		String apiUrl = "https://servicodados.ibge.gov.br/api/v2/censos/nomes/ranking?";
		apiUrl += "localidade=" + estados.estadoNumber(localidade);
		if ("M".equals(sexo.toUpperCase()) || "F".equals(sexo.toUpperCase())) {
	        apiUrl += "&sexo=" + sexo + "&";
	    }
		
		RestTemplate restTemplate = new RestTemplate();
		for(int i = Integer.parseInt(dataInicial); i<=Integer.parseInt(dataFinal); i = i + 10) {
			String date = Integer.toString(i);
			String apiUrlAtual = apiUrl + "decada=" + Integer.toString(i);

			ResponseEntity<Ranking[]> responseEntity = restTemplate.getForEntity(
		            apiUrlAtual,
		            Ranking[].class
		        );
			
			Ranking[] rankings = responseEntity.getBody();
			
			if(rankings == null) {
				return result;
			}
			date += "-01-01";
	        for (Ranking ranking : rankings) {
	            for (Nome nome : ranking.getRes()) {
	                Data data = new Data(date, nome.getNome(), nome.getRanking(), nome.getFrequencia());
	                result.add(data);
	            }
	        }
		}
		return result;
	}
	
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
