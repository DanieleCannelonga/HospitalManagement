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

import com.app.hospital.model.SalaOperatoria;
import com.app.hospital.service.SalaOperatoriaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/SalaOperatoria")
public class SalaOperatoriaController {
	
	@Autowired
	SalaOperatoriaService salaOperatoriaService;
	
	@GetMapping(value = "/listaSaleOperatorie", produces = "application/json")
		public String listaSaleOperatorie() throws JsonProcessingException {
			List<SalaOperatoria> listaSaleOperatorie = salaOperatoriaService.getAllSaleOperatorie();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaSaleOperatorieJson = objectMapper.writeValueAsString(listaSaleOperatorie);
			return listaSaleOperatorieJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String SalaOperatoriaById(@PathVariable Long id) throws JsonProcessingException {
		SalaOperatoria SalaOperatoria = salaOperatoriaService.getSalaOperatoriaById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String SalaOperatoriaJson = objectMapper.writeValueAsString(SalaOperatoria);
		return SalaOperatoriaJson;
	}	
	
	@PostMapping(value = "/addSalaOperatoria", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SalaOperatoria> addSalaOperatoria(@RequestBody SalaOperatoria SalaOperatoria) {
	    SalaOperatoria nuovoSalaOperatoria = salaOperatoriaService.saveOrUpdate(SalaOperatoria);
	    return ResponseEntity.ok(nuovoSalaOperatoria);
	}
	
	@PutMapping(value = "/editSalaOperatoria/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SalaOperatoria> editSalaOperatoria(@RequestBody SalaOperatoria SalaOperatoria) {
	    SalaOperatoria nuovoSalaOperatoria = salaOperatoriaService.saveOrUpdate(SalaOperatoria);
	    return ResponseEntity.ok(nuovoSalaOperatoria);
	}
	
	@DeleteMapping(value = "/deleteSalaOperatoria/{id}")
	public ResponseEntity<Void> deleteSalaOperatoria(@PathVariable Long id) {
	    salaOperatoriaService.deleteSalaOperatoria(id);
	    return ResponseEntity.noContent().build();
	}
}