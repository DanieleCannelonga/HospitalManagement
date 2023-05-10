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

import com.app.hospital.model.SistemaSicurezza;
import com.app.hospital.service.SistemaSicurezzaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/SistemaSicurezza")
public class SistemaSicurezzaController {
	
	@Autowired
	SistemaSicurezzaService sistemaSicurezzaService;
	
	@GetMapping(value = "/listaSistemiSicurezza", produces = "application/json")
		public String listaSistemiSicurezza() throws JsonProcessingException {
			List<SistemaSicurezza> listaSistemiSicurezza = sistemaSicurezzaService.getAllSistemiSicurezza();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaSistemiSicurezzaJson = objectMapper.writeValueAsString(listaSistemiSicurezza);
			return listaSistemiSicurezzaJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String SistemaSicurezzaById(@PathVariable Long id) throws JsonProcessingException {
		SistemaSicurezza SistemaSicurezza = sistemaSicurezzaService.getSistemaSicurezzaById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String SistemaSicurezzaJson = objectMapper.writeValueAsString(SistemaSicurezza);
		return SistemaSicurezzaJson;
	}	
	
	@PostMapping(value = "/addSistemaSicurezza", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SistemaSicurezza> addSistemaSicurezza(@RequestBody SistemaSicurezza SistemaSicurezza) {
	    SistemaSicurezza nuovoSistemaSicurezza = sistemaSicurezzaService.saveOrUpdate(SistemaSicurezza);
	    return ResponseEntity.ok(nuovoSistemaSicurezza);
	}
	
	@PutMapping(value = "/editSistemaSicurezza/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SistemaSicurezza> editSistemaSicurezza(@RequestBody SistemaSicurezza SistemaSicurezza) {
	    SistemaSicurezza nuovoSistemaSicurezza = sistemaSicurezzaService.saveOrUpdate(SistemaSicurezza);
	    return ResponseEntity.ok(nuovoSistemaSicurezza);
	}
	
	@DeleteMapping(value = "/deleteSistemaSicurezza/{id}")
	public ResponseEntity<Void> deleteSistemaSicurezza(@PathVariable Long id) {
	    sistemaSicurezzaService.deleteSistemaSicurezza(id);
	    return ResponseEntity.noContent().build();
	}
}