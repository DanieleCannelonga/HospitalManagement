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

import com.app.hospital.model.Ambulanza;
import com.app.hospital.service.AmbulanzaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Ambulanza")
public class AmbulanzaController {
	
	@Autowired
	AmbulanzaService ambulanzaService;
	
	@GetMapping(value = "/listaAmbulanze", produces = "application/json")
		public String listaAmbulanze() throws JsonProcessingException {
			List<Ambulanza> listaAmbulanze = ambulanzaService.getAllAmbulanze();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaAmbulanzeJson = objectMapper.writeValueAsString(listaAmbulanze);
			return listaAmbulanzeJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String AmbulanzaById(@PathVariable Long id) throws JsonProcessingException {
		Ambulanza Ambulanza = ambulanzaService.getAmbulanzaById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String AmbulanzaJson = objectMapper.writeValueAsString(Ambulanza);
		return AmbulanzaJson;
	}	
	
	@PostMapping(value = "/addAmbulanza", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Ambulanza> addAmbulanza(@RequestBody Ambulanza Ambulanza) {
	    Ambulanza nuovoAmbulanza = ambulanzaService.saveOrUpdate(Ambulanza);
	    return ResponseEntity.ok(nuovoAmbulanza);
	}
	
	@PutMapping(value = "/editAmbulanza/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Ambulanza> editAmbulanza(@PathVariable Long id, @RequestBody Ambulanza Ambulanza) {
	    Ambulanza nuovoAmbulanza = ambulanzaService.saveOrUpdate(Ambulanza);
	    return ResponseEntity.ok(nuovoAmbulanza);
	}
	
	@DeleteMapping(value = "/deleteAmbulanza/{id}")
	public ResponseEntity<Void> deleteAmbulanza(@PathVariable Long id) {
	    ambulanzaService.deleteAmbulanza(id);
	    return ResponseEntity.noContent().build();
	}
}