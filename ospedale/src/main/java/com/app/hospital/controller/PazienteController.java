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

import com.app.hospital.model.Paziente;
import com.app.hospital.service.PazienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Paziente")
public class PazienteController {
	
	@Autowired
	PazienteService pazienteService;
	
	@GetMapping(value = "/listaPazienti", produces = "application/json")
		public String listaPazienti() throws JsonProcessingException {
			List<Paziente> listaPazienti = pazienteService.getAllPazienti();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaPazientiJson = objectMapper.writeValueAsString(listaPazienti);
			return listaPazientiJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String PazienteById(@PathVariable Long id) throws JsonProcessingException {
		Paziente Paziente = pazienteService.getPazienteById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String PazienteJson = objectMapper.writeValueAsString(Paziente);
		return PazienteJson;
	}	
	
	@PostMapping(value = "/addPaziente", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Paziente> addPaziente(@RequestBody Paziente Paziente) {
	    Paziente nuovoPaziente = pazienteService.saveOrUpdate(Paziente);
	    return ResponseEntity.ok(nuovoPaziente);
	}
	
	@PutMapping(value = "/editPaziente/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Paziente> editPaziente(@RequestBody Paziente Paziente) {
	    Paziente nuovoPaziente = pazienteService.saveOrUpdate(Paziente);
	    return ResponseEntity.ok(nuovoPaziente);
	}
	
	@DeleteMapping(value = "/deletePaziente/{id}")
	public ResponseEntity<Void> deletePaziente(@PathVariable Long id) {
	    pazienteService.deletePaziente(id);
	    return ResponseEntity.noContent().build();
	}
}