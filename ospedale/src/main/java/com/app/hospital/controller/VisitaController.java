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

import com.app.hospital.model.Visita;
import com.app.hospital.service.VisitaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Visita")
public class VisitaController {
	
	@Autowired
	VisitaService visitaService;
	
	@GetMapping(value = "/listaVisite", produces = "application/json")
		public String listaVisite() throws JsonProcessingException {
			List<Visita> listaVisite = visitaService.getAllVisite();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaVisiteJson = objectMapper.writeValueAsString(listaVisite);
			return listaVisiteJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String VisitaById(@PathVariable Long id) throws JsonProcessingException {
		Visita Visita = visitaService.getVisitaById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String VisitaJson = objectMapper.writeValueAsString(Visita);
		return VisitaJson;
	}	
	
	@PostMapping(value = "/addVisita", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Visita> addVisita(@RequestBody Visita Visita) {
	    Visita nuovoVisita = visitaService.saveOrUpdate(Visita);
	    return ResponseEntity.ok(nuovoVisita);
	}
	
	@PutMapping(value = "/editVisita/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Visita> editVisita(@RequestBody Visita Visita) {
	    Visita nuovoVisita = visitaService.saveOrUpdate(Visita);
	    return ResponseEntity.ok(nuovoVisita);
	}
	
	@DeleteMapping(value = "/deleteVisita/{id}")
	public ResponseEntity<Void> deleteVisita(@PathVariable Long id) {
	    visitaService.deleteVisita(id);
	    return ResponseEntity.noContent().build();
	}
}