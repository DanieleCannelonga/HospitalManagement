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

import com.app.hospital.model.InterventoChirurgico;
import com.app.hospital.service.InterventoChirurgicoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/InterventoChirurgico")
public class InterventoChirurgicoController {
	
	@Autowired
	InterventoChirurgicoService interventoChirurgicoService;
	
	@GetMapping(value = "/listaInterventiChirurgici", produces = "application/json")
		public String listaInterventiChirurgici() throws JsonProcessingException {
			List<InterventoChirurgico> listaInterventiChirurgici = interventoChirurgicoService.getAllInterventiChirurgici();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaInterventiChirurgiciJson = objectMapper.writeValueAsString(listaInterventiChirurgici);
			return listaInterventiChirurgiciJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String InterventoChirurgicoById(@PathVariable Long id) throws JsonProcessingException {
		InterventoChirurgico InterventoChirurgico = interventoChirurgicoService.getInterventoChirurgicoById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String InterventoChirurgicoJson = objectMapper.writeValueAsString(InterventoChirurgico);
		return InterventoChirurgicoJson;
	}	
	
	@PostMapping(value = "/addInterventoChirurgico", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InterventoChirurgico> addInterventoChirurgico(@RequestBody InterventoChirurgico InterventoChirurgico) {
	    InterventoChirurgico nuovoInterventoChirurgico = interventoChirurgicoService.saveOrUpdate(InterventoChirurgico);
	    return ResponseEntity.ok(nuovoInterventoChirurgico);
	}
	
	@PutMapping(value = "/editInterventoChirurgico/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InterventoChirurgico> editInterventoChirurgico(@RequestBody InterventoChirurgico InterventoChirurgico) {
	    InterventoChirurgico nuovoInterventoChirurgico = interventoChirurgicoService.saveOrUpdate(InterventoChirurgico);
	    return ResponseEntity.ok(nuovoInterventoChirurgico);
	}
	
	@DeleteMapping(value = "/deleteInterventoChirurgico/{id}")
	public ResponseEntity<Void> deleteInterventoChirurgico(@PathVariable Long id) {
	    interventoChirurgicoService.deleteInterventoChirurgico(id);
	    return ResponseEntity.noContent().build();
	}
}