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

import com.app.hospital.model.Fornitore;
import com.app.hospital.service.FornitoreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Fornitore")
public class FornitoreController {
	
	@Autowired
	FornitoreService fornitoreService;
	
	@GetMapping(value = "/listaFornitori", produces = "application/json")
		public String listaFornitori() throws JsonProcessingException {
			List<Fornitore> listaFornitori = fornitoreService.getAllFornitori();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaFornitoriJson = objectMapper.writeValueAsString(listaFornitori);
			return listaFornitoriJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String FornitoreById(@PathVariable Long id) throws JsonProcessingException {
		Fornitore Fornitore = fornitoreService.getFornitoreById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String FornitoreJson = objectMapper.writeValueAsString(Fornitore);
		return FornitoreJson;
	}	
	
	@PostMapping(value = "/addFornitore", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Fornitore> addFornitore(@RequestBody Fornitore Fornitore) {
	    Fornitore nuovoFornitore = fornitoreService.saveOrUpdate(Fornitore);
	    return ResponseEntity.ok(nuovoFornitore);
	}
	
	@PutMapping(value = "/editFornitore/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Fornitore> editFornitore(@RequestBody Fornitore Fornitore) {
	    Fornitore nuovoFornitore = fornitoreService.saveOrUpdate(Fornitore);
	    return ResponseEntity.ok(nuovoFornitore);
	}
	
	@DeleteMapping(value = "/deleteFornitore/{id}")
	public ResponseEntity<Void> deleteFornitore(@PathVariable Long id) {
	    fornitoreService.deleteFornitore(id);
	    return ResponseEntity.noContent().build();
	}
}