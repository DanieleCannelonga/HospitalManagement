package com.app.hospital.controller;


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

import com.app.hospital.model.Ricovero;
import com.app.hospital.service.RicoveroService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Ricovero")
public class RicoveroController {
	
	@Autowired
	RicoveroService ricoveroService;
	
	@GetMapping(value = "/listaRicoveri", produces = "application/json")
		public String listaRicoveri() throws JsonProcessingException {
			List<Ricovero> listaRicoveri = ricoveroService.getAllRicoveri();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaRicoveriJson = objectMapper.writeValueAsString(listaRicoveri);
			return listaRicoveriJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String RicoveroById(@PathVariable Long id) throws JsonProcessingException {
		Ricovero Ricovero = ricoveroService.getRicoveroById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String RicoveroJson = objectMapper.writeValueAsString(Ricovero);
		return RicoveroJson;
	}	
	
	@PostMapping(value = "/addRicovero", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Ricovero> addRicovero(@RequestBody Ricovero Ricovero) {
	    Ricovero nuovoRicovero = ricoveroService.saveOrUpdate(Ricovero);
	    return ResponseEntity.ok(nuovoRicovero);
	}
	
	@PutMapping(value = "/editRicovero/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Ricovero> editRicovero(@RequestBody Ricovero Ricovero) {
	    Ricovero nuovoRicovero = ricoveroService.saveOrUpdate(Ricovero);
	    return ResponseEntity.ok(nuovoRicovero);
	}
	
	@DeleteMapping(value = "/deleteRicovero/{id}")
	public ResponseEntity<Void> deleteRicovero(@PathVariable Long id) {
	    ricoveroService.deleteRicovero(id);
	    return ResponseEntity.noContent().build();
	}
}