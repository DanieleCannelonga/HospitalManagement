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

import com.app.hospital.model.Personale;
import com.app.hospital.service.PersonaleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Personale")
public class PersonaleController {
	
	@Autowired
	PersonaleService personaleService;
	
	@GetMapping(value = "/listaPersonale", produces = "application/json")
		public String listaPersonale() throws JsonProcessingException {
			List<Personale> listaPersonale = personaleService.getAllPersonale();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaPersonaleJson = objectMapper.writeValueAsString(listaPersonale);
			return listaPersonaleJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String PersonaleById(@PathVariable Long id) throws JsonProcessingException {
		Personale Personale = personaleService.getPersonaleById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String PersonaleJson = objectMapper.writeValueAsString(Personale);
		return PersonaleJson;
	}	
	
	@PostMapping(value = "/addPersonale", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Personale> addPersonale(@RequestBody Personale Personale) {
	    Personale nuovoPersonale = personaleService.saveOrUpdate(Personale);
	    return ResponseEntity.ok(nuovoPersonale);
	}
	
	@PutMapping(value = "/editPersonale/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Personale> editPersonale(@RequestBody Personale Personale) {
	    Personale nuovoPersonale = personaleService.saveOrUpdate(Personale);
	    return ResponseEntity.ok(nuovoPersonale);
	}
	
	@DeleteMapping(value = "/deletePersonale/{id}")
	public ResponseEntity<Void> deletePersonale(@PathVariable Long id) {
	    personaleService.deletePersonale(id);
	    return ResponseEntity.noContent().build();
	}
}