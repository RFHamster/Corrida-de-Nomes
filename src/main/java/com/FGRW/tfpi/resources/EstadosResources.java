package com.FGRW.tfpi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.FGRW.tfpi.entities.Estados;
import com.FGRW.tfpi.services.EstadosServices;

@RestController
@RequestMapping(value="/estados")

public class EstadosResources {
	@Autowired
	EstadosServices service;
	
	@GetMapping
	public ResponseEntity<List<Estados>> findAll() {
		List<Estados> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Estados> findById(@PathVariable String id) {
		Estados obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Estados> createEstados(@RequestBody Estados Estados) {
	    Estados savedEstados = service.insert(Estados);
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEstados.getId()).toUri();
		return ResponseEntity.created(uri).body(savedEstados);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Estados> updateEstados(@PathVariable String id, @RequestBody Estados updatedEstados) {
	    Estados updated = service.update(id, updatedEstados);
	    return ResponseEntity.ok().body(updated);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletes(@PathVariable String id) {
	    service.delete(id);
	    return ResponseEntity.noContent().build();
	}
}
