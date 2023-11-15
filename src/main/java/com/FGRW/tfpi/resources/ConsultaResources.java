package com.FGRW.tfpi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.FGRW.tfpi.entities.Consulta;
import com.FGRW.tfpi.services.ConsultaServices;

@RestController
@RequestMapping(value="/consulta")
public class ConsultaResources {
	@Autowired
	ConsultaServices service;
	
	@GetMapping
	public ResponseEntity<List<Consulta>> findAll() {
		List<Consulta> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Consulta> findById(@PathVariable Long id) {
		Consulta obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Consulta> createConsulta(@RequestBody Consulta Consulta) {
	    Consulta savedConsulta = service.insert(Consulta);
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedConsulta.getId()).toUri();
		return ResponseEntity.created(uri).body(savedConsulta);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Consulta> updateConsulta(@PathVariable Long id, @RequestBody Consulta updatedConsulta) {
	    Consulta updated = service.update(id, updatedConsulta);
	    return ResponseEntity.ok().body(updated);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
	    service.delete(id);
	    return ResponseEntity.noContent().build();
	}
}
