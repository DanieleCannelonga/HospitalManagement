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

import com.app.hospital.model.Reparto;
import com.app.hospital.service.RepartoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Reparto")
public class RepartoController {
	
	@Autowired
	RepartoService repartoService;
	
	@GetMapping(value = "/listaReparti", produces = "application/json")
		public String listaReparti() throws JsonProcessingException {
			List<Reparto> listaReparti = repartoService.getAllReparti();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaRepartiJson = objectMapper.writeValueAsString(listaReparti);
			return listaRepartiJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String RepartoById(@PathVariable Long id) throws JsonProcessingException {
		Reparto Reparto = repartoService.getRepartoById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String RepartoJson = objectMapper.writeValueAsString(Reparto);
		return RepartoJson;
	}	
	
	@PostMapping(value = "/addReparto", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Reparto> addReparto(@RequestBody Reparto Reparto) {
	    Reparto nuovoReparto = repartoService.saveOrUpdate(Reparto);
	    return ResponseEntity.ok(nuovoReparto);
	}
	
	@PutMapping(value = "/editReparto/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Reparto> editReparto(@RequestBody Reparto Reparto) {
	    Reparto nuovoReparto = repartoService.saveOrUpdate(Reparto);
	    return ResponseEntity.ok(nuovoReparto);
	}
	
	@DeleteMapping(value = "/deleteReparto/{id}")
	public ResponseEntity<Void> deleteReparto(@PathVariable Long id) {
	    repartoService.deleteReparto(id);
	    return ResponseEntity.noContent().build();
	}
}